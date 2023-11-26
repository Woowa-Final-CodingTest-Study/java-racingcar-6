package racingcar.view;

import racingcar.model.Cars;

import static racingcar.constant.OutputMessage.*;

public class OutputView {
    private static OutputView outputView;

    private OutputView() {
    }

    public static OutputView getInstance() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private void println() {
        System.out.println();
    }

    private void println(String s) {
        System.out.println(s);
    }

    public void notifyInputCarNames() {
        println(NOTIFY_INPUT_CAR_NAMES);
    }

    public void notifyInputRoundCount() {
        println(NOTIFY_INPUT_ROUND_COUNT);
    }

    public void printStartRacing() {
        println(RACING_RESULT);
    }

    public void printRoundResult(Cars cars) {
        cars.roundResult().forEach(this::println);
        println();
    }

    public void printWinner(Cars cars) {
        println(WINNER + cars.winnerNames());
    }
}
