package baseball.team;

import java.util.Map;
import java.util.Optional;

import static baseball.team.TeamData.*;

public class TeamRepository {

    private final Map<String, Team> data = Map.of(
            "LG", LG_TWINS(),
            "한화", HANHWA_EAGLES(),
            "SSG", SSG_LANDERS(),
            "KT", KT_WIZ(),
            "롯데", LOTTE_GIANTS(),
            "삼성", SAMSUNG_LIONS(),
            "NC", NC_DINOS(),
            "KIA", KIA_TIGERS(),
            "두산", DOOSAN_BEARS(),
            "키움", KIWOOM_HEROES()
    );

    public Optional<Team> findByName(String name) {
        return Optional.ofNullable(data.get(name));
    }
}
