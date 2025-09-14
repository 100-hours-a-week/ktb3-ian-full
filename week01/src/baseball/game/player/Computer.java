package baseball.game.player;

import baseball.team.Team;

public class Computer extends GamePlayer {

    public Computer(Team team, int score) {
        super(team, score);
    }

    public int pitch() {
        return getTeam().getPitcher().pitch();
    }
}
