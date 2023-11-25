package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String getUserInput() {
        String input = Console.readLine();
        validateInputIsEmpty(input);
        return input;
    }

    public void validateInputIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }
}
