package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    OutputView outputView = new OutputView();

    public List<String> getCarNameInput() {
        try {
            String input = Console.readLine();
            validateCarName(input);
            List<String> inputs = parseToList(input);
            return inputs;
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getCarNameInput();
        }
    }

    public int getRoundsInput() {
        try {
            String input = Console.readLine();
            validateNull(input);
            validateInteger(input);
            int rounds = Integer.parseInt(input);
            validateRoundsRange(rounds);
            return rounds;
        } catch (IllegalArgumentException e) {
            outputView.printMessage(e.getMessage());
            return getRoundsInput();
        }
    }

    public void validateInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException();
        }
    }

    public void validateRoundsRange(int rounds) {
        if (rounds > 100 || rounds < 1) {
            throw new IllegalArgumentException();
        }
    }

    private List<String> parseToList(String input) {
        String[] names = input.split(",");
        List<String> carNames = new ArrayList<>();
        for (String name : names) {
            carNames.add(name.trim());
        }
        return carNames;
    }

    public void validateCarName(String input) {
        validateNull(input);
        validateCarNameFormat(input);
        validateCarNameLength(input);
    }

    private void validateNull(String input) {
        if (input.isEmpty() || input == null) {
            throw new IllegalArgumentException();
        }
    }

    private void validateCarNameFormat(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.trim().isEmpty()) {
                throw new IllegalArgumentException();
            }
        }
    }

    private void validateCarNameLength(String input) {
        String[] names = input.split(",");
        for (String name : names) {
            if (name.length() < 1 || name.length() > 5) {
                throw new IllegalArgumentException();
            }
        }
    }
}
