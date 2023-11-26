package racingcar.controller;

import java.util.List;
import racingcar.domain.Player;
import racingcar.domain.Players;
import racingcar.domain.ScoreCalculator;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class MainController {

    ScoreCalculator scoreCalculator = new ScoreCalculator();
    Winner winner = new Winner();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        List<Player> players = setPlayers().getPlayers();
        int attemptCount = getAttemptNumber();

        outputView.printResult();
        while (attemptCount-- > 0) {
            scoreCalculator.startRacing(players);
            outputView.printPlayerScore(players);
        }
        outputView.printWinner(winner.chooseWinner(players));
    }

    public Players setPlayers() {
        outputView.printInputPlayerName();
        String input = inputView.inputPlayerNames();
        Players players = new Players(scoreCalculator.initializePlayerScore(input));
        return players;
    }

    public int getAttemptNumber() {
        outputView.printInputAttemptCount();
        return Integer.parseInt(inputView.inputAttemptCount());
    }

}
