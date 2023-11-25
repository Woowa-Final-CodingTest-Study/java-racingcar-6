package racingcar.controller;

import racingcar.domain.Player;
import racingcar.domain.ScoreCalculator;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.List;

public class MainController {

    ScoreCalculator scoreCalculator = new ScoreCalculator();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    public void run() {
        List<Player> players = inputPlayerNames();
        int attemptCount = inputAttemptNumber();
    }

    public List<Player> inputPlayerNames() {
        outputView.printInputPlayerName();
        String input = inputView.getUserInput();
        List<Player> players = scoreCalculator.initializePlayerScore(input);
        return players;
    }

    public int inputAttemptNumber() {
        outputView.printInputAttemptCount();
        return Integer.parseInt(inputView.getUserInput());
    }


}
