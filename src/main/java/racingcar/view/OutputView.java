package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import racingcar.constant.MessageConstant;
import racingcar.domain.Player;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    public void printInputPlayerName() {
        System.out.println(MessageConstant.INPUT_CAR_NAME);
    }

    public void printInputAttemptCount() {
        System.out.println(MessageConstant.INPUT_ATTEMPT_COUNT);
    }

    public void printResult() {
        System.out.println(MessageConstant.EXECUTE_RESULT + LINE_SEPARATOR);
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
                MessageConstant.SCORE_SEPARATOR +
                IntStream.range(0, player.getScore())
                        .mapToObj(i -> MessageConstant.SCORE)
                        .collect(Collectors.joining());

        return result;
    }

    public void printWinner(List<String> winnerNames) {
        String winner = MessageConstant.WINNER +
                winnerNames.stream()
                        .collect(Collectors.joining(MessageConstant.WINNER_SEPARATOR));
        System.out.println(winner);
    }

}
