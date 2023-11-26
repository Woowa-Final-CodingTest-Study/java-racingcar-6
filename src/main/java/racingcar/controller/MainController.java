package racingcar.controller;

import racingcar.domain.Player;
import racingcar.domain.ScoreCalculator;
import racingcar.domain.Winner;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class MainController {

    ScoreCalculator scoreCalculator = new ScoreCalculator();
    Winner winner = new Winner();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        List<Player> players = getPlayerNames();
        int attemptCount = getAttemptNumber();

        outputView.printResult();
        while (attemptCount-- > 0) {
            scoreCalculator.startRacing(players);
            outputView.printPlayerScore(players);
        }
        outputView.printWinner(winner.chooseWinner(players));
    }

    public List<Player> getPlayerNames() {
        outputView.printInputPlayerName();
        String input = inputView.inputPlayerNames();
        List<Player> players = scoreCalculator.initializePlayerScore(input);
        return players;
    }

    public int getAttemptNumber() {
        outputView.printInputAttemptCount();
        return Integer.parseInt(inputView.inputAttemptCount());
    }

}
