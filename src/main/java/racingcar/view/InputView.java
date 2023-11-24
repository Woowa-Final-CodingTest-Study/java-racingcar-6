package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
        List<String> carNames = List.of(input.split(",")); //TODO: 시간 되면 공백에 대한 처리도 구현
        validate(carNames);
        return carNames;
    }

    private void validate(List<String> carNames) {
        validateCarNamesNotEmpty(carNames);
        validateCarNameLengthWithinRange(carNames);
        validateCarNamesUnique(carNames);
    }

    private void validateCarNamesNotEmpty(List<String> carNames) {
        if (carNames.isEmpty())
            throw new IllegalArgumentException();
    }

    private void validateCarNameLengthWithinRange(List<String> carNames) { // TODO: 이름 길이도 변수로
        carNames.forEach(name -> {
            if (name.isEmpty() || name.length() > 5)
                throw new IllegalArgumentException();
        });
    }

    private void validateCarNamesUnique(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size())
            throw new IllegalArgumentException();
    }
}
