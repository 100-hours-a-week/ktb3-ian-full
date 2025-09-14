package baseball.team;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

import static baseball.util.InputUtil.inputSelect;
import static baseball.util.PrintUtil.*;

public class TeamSelector {

    private final Scanner scanner;
    private final TeamRepository teamRepository;

    public TeamSelector(Scanner scanner, TeamRepository teamRepository) {
        this.scanner = scanner;
        this.teamRepository = teamRepository;
    }

    public Team select() {
        while (true) {
            teamNames();
            String input = inputSelect(scanner, "원하는 팀을 선택해주세요: ");

            if (input == null || input.isEmpty()) {
                invalidInput();
                continue;
            }

            Team team = teamRepository.findByName(input)
                    .orElse(null);

            if (team == null) {
                invalidInput();
                continue;
            }

            printFormat(String.format("%s을(를) 선택하셨습니다.", team.getName()));
            return team;
        }
    }

    public Team random() {
        List<String> teamNames = TeamData.getTeamNames();
        Random random = new Random();
        int idx = random.nextInt(teamNames.size());

        return teamRepository.findByName(teamNames.get(idx))
                .orElse(null);
    }
}
