package baseball.game.player;

import baseball.team.Team;

public abstract class GamePlayer {

    private final Team team;
    private int score;

    public GamePlayer(Team team, int score) {
        this.team = team;
        this.score = score;
    }

    public void plusScore(int score) {
        this.score += score;
    }

    public Team getTeam() {
        return team;
    }

    public int getScore() {
        return score;
    }
}
