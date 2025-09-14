package baseball.game.player;

import baseball.game.HitResult;
import baseball.team.Team;
import baseball.player.Hitter;

import java.util.Scanner;

import static baseball.util.InputUtil.selectZone;

public class User extends GamePlayer {

    private int order;

    public User(Team team, int score) {
        super(team, score);
    }

    public HitResult hit(Scanner scanner, int actualZone) {
        Hitter hitter = getTeam().getHitters().get(order);
        int expectedZone = selectZone(scanner);

        if (expectedZone == 0) {
            return hitter.doNotHit(actualZone);
        }

        return hitter.hit(expectedZone, actualZone);
    }

    public void next() {
        order = (order + 1) % 9;
    }

    public int getOrder() {
        return order;
    }
}
