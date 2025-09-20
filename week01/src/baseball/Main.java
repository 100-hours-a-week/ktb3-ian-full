package baseball;

import baseball.game.*;
import baseball.game.player.*;
import baseball.game.process.*;
import baseball.level.LevelSelector;
import baseball.team.TeamRepository;
import baseball.team.TeamSelector;

import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static baseball.game.HitResult.*;
import static baseball.game.HitResult.DOUBLE;
import static baseball.game.HitResult.FOUL;
import static baseball.game.HitResult.HOMERUN;
import static baseball.game.HitResult.SINGLE;
import static baseball.game.HitResult.TRIPLE;
import static baseball.util.PrintUtil.invalidInput;

public class Main {

    private static final int NUM_THREAD = 3;
    private static final int USER_INIT_SCORE = 0;

    public static void main(String[] args) {
        try (ExecutorService executor = Executors.newFixedThreadPool(NUM_THREAD)) {
            TeamRepository teamRepository = new TeamRepository();
            TeamSelector teamSelector = new TeamSelector(teamRepository);
            LevelSelector levelSelector = new LevelSelector();
            UserHitInput userHitInput = new UserHitInput(executor, new HitInputTask(), new TimerTask());

            System.out.println("===== KTB 프로야구 게임에 오신걸 환영합니다! =====\n");

            while (true) {
                System.out.println("""
                    - 게임 시작: 1
                    - 게임 종료: 2
                    """);

                String input = InputManager.readLine("원하는 키를 선택해주세요: ");

                switch (input) {
                    case "1" -> {
                        System.out.println("게임을 시작합니다.");
                        GameService gameService = setUp(teamSelector, levelSelector, userHitInput);
                        gameService.start();
                    }
                    case "2" -> {
                        System.out.println("게임을 종료합니다.");
                        return;
                    }
                    default -> invalidInput();
                }
            }
        }
    }

    private static GameService setUp(TeamSelector teamSelector, LevelSelector levelSelector, UserHitInput userHitInput) {
        CountManager countManager = new CountManager();
        BaseManager baseManager = new BaseManager();
        User user = new User(teamSelector.select(), USER_INIT_SCORE);
        Computer computer = new Computer(teamSelector.random(), levelSelector.select());
        Map<HitResult, GameProcess> hitResultToGameProcess = Map.of(
                BALL, new BallProcess(user, baseManager, countManager),
                STRIKE, new StrikeProcess(user, countManager),
                MISS, new MissProcess(user, countManager),
                SINGLE, new SingleProcess(user, baseManager, countManager),
                DOUBLE, new DoubleProcess(user, baseManager, countManager),
                TRIPLE, new TripleProcess(user, baseManager, countManager),
                HOMERUN, new HomeRunProcess(user, baseManager, countManager),
                FOUL, new FoulProcess(countManager)
        );
        GameManager gameManager = new GameManager(user, computer, baseManager, countManager, userHitInput, hitResultToGameProcess);
        return new GameService(gameManager);
    }
}

