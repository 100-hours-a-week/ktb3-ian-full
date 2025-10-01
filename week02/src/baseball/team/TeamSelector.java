package baseball.team;

import baseball.InputManager;
import baseball.util.PrintUtil;

import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

import static baseball.util.PrintUtil.*;

public class TeamSelector {

    private final TeamRepository teamRepository;

    public TeamSelector(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public Team select() {
        AtomicReference<Team> selected = new AtomicReference<>();

        while (selected.get() == null) {
            teamNames();
            String input = InputManager.readLine("원하는 팀을 선택해주세요: ");

            if (input == null || input.isEmpty()) {
                invalidInput();
                continue;
            }

            teamRepository.findByName(input)
                    .ifPresentOrElse(
                            (team) -> setTeam(selected, team),
                            PrintUtil::invalidInput
                    );
        }

        return selected.get();
    }

    public Team random() {
        List<String> teamNames = TeamData.getTeamNames();
        Random random = new Random();
        int idx = random.nextInt(teamNames.size());

        return teamRepository.findByName(teamNames.get(idx))
                .orElse(TeamData.getDefaultTeam());
    }

    private void setTeam(AtomicReference<Team> target, Team team) {
        printFormat(String.format("%s을(를) 선택하셨습니다.", team.getName()));
        target.set(team);
    }
}
