package racingcar.controller;

import java.util.List;
import racingcar.constants.GameMessage;
import racingcar.domain.Cars;
import racingcar.domain.Rounds;
import racingcar.domain.Service;
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
        Cars cars = registerCars();
        Rounds rounds = registerRounds();
        Service service = new Service();
        service.startGame(cars, rounds);
    }

    public Cars registerCars() {
        outputView.printMessage(GameMessage.ENTER_CAR_NAME_MESSAGE.getMessage());
        List<String> carNames = inputView.getCarNameInput();
        return new Cars(carNames);
    }

    public Rounds registerRounds() {
        outputView.printMessage(GameMessage.ENTER_ROUNDS_MESSAGE.getMessage());
        int rounds = inputView.getRoundsInput();
        return new Rounds(rounds);
    }
}
