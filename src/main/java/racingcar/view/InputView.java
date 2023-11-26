package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import static racingcar.constant.MessageConstant.NAME_SPLIT_SEPARATOR;
import static racingcar.constant.RaceConstant.NAME_LENGTH_LIMIT;

public class InputView {

    public String inputPlayerNames() {
        String input = getUserInput();
        validateInputCorrectSeparator(input);
        validatePlayerNameLength(input);
        return input;
    }

    public String inputAttemptCount() {
        String input = getUserInput();
        validateNumeric(input);
        validateNegativeOrZero(input);
        validateCountLimit(input);
        return input;
    }

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

    public void validateInputCorrectSeparator(String input) {
        String deleteSeparator = input.replaceAll("[0-9a-zA-Zㄱ-ㅎ가-힣,]", "");
        if (!deleteSeparator.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePlayerNameLength(String input) {
        String[] names = input.split(NAME_SPLIT_SEPARATOR.getMessage());

        for (String name : names) {
            if (name.length() > NAME_LENGTH_LIMIT.getNumber()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateNumeric(String input) {
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            throw new IllegalArgumentException();
        }
    }

    public void validateNegativeOrZero(String input) {
        if (Integer.parseInt(input) <= 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateCountLimit(String input) {
        if (Integer.parseInt(input) > 120) {
            throw new IllegalArgumentException();
        }
    }

}
