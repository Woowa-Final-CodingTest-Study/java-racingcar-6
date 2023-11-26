package racingcar.view;

import racingcar.domain.Player;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

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

        for (Player player : players) {
            score.append(makeResult(player)).append("\n");
        }
        System.out.println(score);
    }

    public String makeResult(Player player) {
        String result = player.getPlayerName() +
                SCORE_SEPARATOR.getMessage() +
                IntStream.range(0, player.getScore())
                        .mapToObj(i -> SCORE.getMessage())
                        .collect(Collectors.joining());

        return result;
    }

    public void printWinner(List<String> winnerNames) {
        String winner = WINNER_MESSAGE.getMessage() +
                winnerNames.stream()
                        .collect(Collectors.joining(WINNER_SEPARATOR.getMessage()));
        System.out.println(winner);
    }

}
