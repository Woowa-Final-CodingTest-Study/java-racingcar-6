package racingcar.domain;

import java.util.*;

public class Winner {

    public List<String> chooseWinner(List<Player> players) {
        sortPlayerScore(players);
        List<String> winnerNames = new ArrayList<>();
        String winnerName = players.get(0).getPlayerName();
        int winnerScore = players.get(0).getScore(winnerName);
        winnerNames.add(winnerName);

        for (int i = 1; i < players.size(); i++) {
            Player player = players.get(i);
            if (winnerScore == player.getScore(player.getPlayerName())) {
                winnerNames.add(player.getPlayerName());
            }
        }
        return winnerNames;
    }

    public void sortPlayerScore(List<Player> players) {
        Collections.sort(players, (o1, o2) -> o2.getScore(o2.getPlayerName())
                - o1.getScore(o1.getPlayerName()));
    }

}
