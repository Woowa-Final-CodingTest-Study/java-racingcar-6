package racingcar.controller;

import java.util.List;
import racingcar.constants.GameMessage;
import racingcar.domain.Cars;
import racingcar.view.InputView;
import racingcar.view.OutputView;

public class Controller {
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {

    }

    public Cars registerCars() {
        outputView.printMessage(GameMessage.ENTER_CAR_NAME_MESSAGE.getMessage());
        List<String> carNames = inputView.getCarNameInput();
        return new Cars(carNames);
    }
}
