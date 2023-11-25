package racingcar.view;

import racingcar.domain.Player;
import java.util.List;

public class OutputView {
    public void printInputPlayerName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printInputAttemptCount() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public void printResult() {
        System.out.println();
        System.out.println("실행 결과");
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

        result.append(playerName).append(" : ");
        for (int i = 0; i < playerScore; i++) {
            result.append("-");
        }
        return result.toString();
    }

}
