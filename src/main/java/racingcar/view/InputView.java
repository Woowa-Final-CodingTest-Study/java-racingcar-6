package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;

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
        validateCarNames(carNames);
        return carNames;
    }

    private void validateCarNames(List<String> carNames) {
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
            if (name.isEmpty() || name.length() > 5) // TODO: 자동차가 1개일 때 레이싱을??
                throw new IllegalArgumentException();
        });
    }

    private void validateCarNamesUnique(List<String> carNames) {
        if (carNames.size() != new HashSet<>(carNames).size())
            throw new IllegalArgumentException();
    }

    public int readTryCount() { // TODO: try -> round로 통일
        try {
            String input = Console.readLine();
            int tryCount = Integer.parseInt(input);
            validateTryCount(tryCount);
            return tryCount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private void validateTryCount(int tryCount) {
        if (tryCount == 0)
            throw new IllegalArgumentException();
    }
}
