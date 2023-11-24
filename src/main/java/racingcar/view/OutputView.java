package racingcar.view;

import racingcar.constant.OutputMessage;

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

    public void notifyInputCarNames() {
        println(OutputMessage.NOTIFY_INPUT_CAR_NAMES);
    }

    private void println(String s) {
        System.out.println(s);
    }
}
