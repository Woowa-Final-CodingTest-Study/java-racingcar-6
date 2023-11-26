package racingcar.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Winner {

    public List<String> chooseWinner(List<Player> players) {
        sortPlayerScore(players);
        return findWinner(players);
    }

    public List<String> findWinner(List<Player> players) {
        if (players.isEmpty()) {
            return List.of();
        }

        int winnerScore = players.get(0).getScore();

        return players.stream()
                .filter(player -> player.getScore() == winnerScore)
                .map(Player::getName)
                .collect(Collectors.toList());
    }

    public void sortPlayerScore(List<Player> players) {
        players.sort((o1, o2) -> o2.getScore()
                - o1.getScore());
    }

}
