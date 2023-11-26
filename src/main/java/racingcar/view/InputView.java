package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public List<String> readCarNames() {
        String input = Console.readLine();
        List<String> carNames = List.of(input.split(","));
        carNames = ignoreWhitespace(carNames);
        validateCarNames(carNames);
        return carNames;
    }

    private List<String> ignoreWhitespace(List<String> carNames) {
        return carNames.stream()
                .map(carName -> {
                    while (true) {
                        if (Character.isWhitespace(carName.charAt(0))) {
                            carName = carName.substring(1);
                            continue;
                        }
                        if (Character.isWhitespace(carName.charAt(carName.length() - 1))) {
                            carName = carName.substring(0, carName.length() - 1);
                            continue;
                        }
                        return carName;
                    }
                }).collect(Collectors.toList());
    }

    private void validateCarNames(List<String> carNames) {
        validateCarNamesNotEmpty(carNames);
        validateCarNameLengthWithinRange(carNames);
        validateCarNamesUnique(carNames);
    }

    private void validateCarNamesNotEmpty(List<String> carNames) {
        if (carNames.size() < 2)
            throw new IllegalArgumentException();
    }

    private void validateCarNameLengthWithinRange(List<String> carNames) {
        carNames.forEach(name -> {
            if (name.isEmpty() || name.length() > Car.NAME_MAX_LENGTH)
                throw new IllegalArgumentException();
        });
    }

    private void validateCarNamesUnique(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size())
            throw new IllegalArgumentException();
    }

    public int readRoundCount() {
        try {
            String input = Console.readLine();
            int roundCount = Integer.parseInt(input);
            validateRoundCount(roundCount);
            return roundCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRoundCount(int roundCount) {
        if (roundCount == 0)
            throw new IllegalArgumentException();
    }
}
