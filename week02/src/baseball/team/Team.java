package baseball.team;

import baseball.player.Hitter;
import baseball.player.Pitcher;

import java.util.List;

public class Team {

    private final String name;
    private final Pitcher pitcher;
    private final List<Hitter> hitters;

    public Team(String name, Pitcher pitcher, List<Hitter> hitters) {
        this.name = name;
        this.pitcher = pitcher;
        this.hitters = hitters;
    }

    public String getName() {
        return name;
    }

    public Pitcher getPitcher() {
        return pitcher;
    }

    public List<Hitter> getHitters() {
        return hitters;
    }
}
