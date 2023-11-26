package racingcar.domain;

import java.util.ArrayList;
import java.util.List;
import racingcar.constant.MessageConstant;

public class ScoreCalculator {

    Race race = new Race();

    public List<Player> initializePlayerScore(String input) {
        String[] names = input.split(MessageConstant.NAME_SPLIT_SEPARATOR);

        List<Player> players = new ArrayList<>();

        for (String name : names) {
            players.add(new Player(name, 0));
        }
        return players;
    }

    public void startRacing(List<Player> players) {
        for (Player player : players) {
            moveOrStop(player);
        }
    }

    public void moveOrStop(Player player) {
        if (race.decideMovement()) {
            String playerName = player.getPlayerName();
            player.getPlayer().put(playerName, player.getScore() + 1);
        }
    }

}
