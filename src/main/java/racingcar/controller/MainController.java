package racingcar.controller;

import racingcar.domain.Player;
import racingcar.domain.ScoreCalculator;
import racingcar.view.InputView;

import java.util.List;

public class MainController {

    ScoreCalculator scoreCalculator = new ScoreCalculator();
    InputView inputView = new InputView();

    public void inputPlayerNames() {
        String input = inputView.getUserInput();
        List<Player> players = scoreCalculator.initializePlayerScore(input);

    }


}
