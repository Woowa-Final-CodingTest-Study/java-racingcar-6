package racingcar.view;

import racingcar.domain.Player;

import java.util.List;

import static racingcar.constant.MessageConstant.*;

public class OutputView {

    private final String LINE_SEPARATOR = System.lineSeparator();

    public void printInputPlayerName() {
        INPUT_CAR_NAME_MESSAGE.print();
    }

    public void printInputAttemptCount() {
        INPUT_ATTEMPT_COUNT_MESSAGE.print();
    }

    public void printResult() {
        EXECUTE_RESULT_MESSAGE.print(LINE_SEPARATOR);
    }

    public void printPlayerScore(List<Player> players) {
        StringBuilder score = new StringBuilder();

        for (int i = 0; i < players.size(); i++) {
            score.append(makeResult(players.get(i))).append("\n");
        }
        System.out.println(score);
    }

    public String makeResult(Player player) {
        StringBuilder result = new StringBuilder();

        String playerName = player.getPlayerName();
        int playerScore = player.getScore(playerName);

        result.append(playerName).append(SCORE_SEPARATOR.getMessage());
        for (int i = 0; i < playerScore; i++) {
            result.append(SCORE.getMessage());
        }
        return result.toString();
    }

    public void printWinner(List<String> winnerNames) {
        StringBuilder winner = new StringBuilder();
        winner.append(WINNER_MESSAGE.getMessage());
        for (int i = 0; i < winnerNames.size(); i++) {
            if (i == 0) {
                winner.append(winnerNames.get(i));
                continue;
            }
            winner.append(WINNER_SEPARATOR.getMessage() + winnerNames.get(i));
        }
        System.out.println(winner);
    }

}
