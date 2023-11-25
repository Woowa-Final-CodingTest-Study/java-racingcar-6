package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class ScoreCalculator {

    Race race = new Race();

    public List<Player> initializePlayerScore(String input) {
        validateInputCorrectSeparator(input);
        String[] names = input.split(",");
        validatePlayerNameLength(names);

        List<Player> players = new ArrayList<>();

        for (String name : names) {
            players.add(new Player(name, 0));
        }

        return players;
    }

    public void startRacing(List<Player> players) {
        for (int i = 0; i < players.size(); i++) {
            Player player = players.get(i);
            moveOrStop(player);
        }
    }

    public void moveOrStop(Player player) {
        if (race.decideMovement()) {
            String playerName = player.getPlayerName();
            player.getPlayer().put(playerName, player.getScore(playerName)+1);
        }
    }

    public void validateInputCorrectSeparator(String input) {
        String deleteSeparator = input.replaceAll("[0-9a-zA-Zㄱ-ㅎ가-힣,]", "");
        if (!deleteSeparator.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePlayerNameLength(String[] names) {
        for (String name : names) {
            if (name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
