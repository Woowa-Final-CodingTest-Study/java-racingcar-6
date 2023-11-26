package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import racingcar.constant.MessageConstant;
import racingcar.constant.RaceConstant;

public class InputView {
    private static final String DELETE_SEPARATOR_REGEX = "[0-9a-zA-Zㄱ-ㅎ가-힣,]";

    public String inputPlayerNames() {
        String input = getUserInput();
        validatePlayerNames(input);
        return input;
    }

    public String inputAttemptCount() {
        String input = getUserInput();
        validateAttemptCount(input);
        return input;
    }

    public String getUserInput() {
        String input = Console.readLine();
        validateInputIsEmpty(input);
        return input;
    }

    public void validatePlayerNames(String input) {
        validateInputCorrectSeparator(input);
        validatePlayerNameLength(input);
        validateDuplicateName(input);
    }

    public void validateAttemptCount(String input) {
        validateNumeric(input);
        validateNegativeOrZero(input);
        validateCountLimit(input);
    }

    public void validateInputIsEmpty(String input) {
        if (input.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputCorrectSeparator(String input) {
        String deleteSeparator = input.replaceAll(DELETE_SEPARATOR_REGEX, "");
        if (!deleteSeparator.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    public void validatePlayerNameLength(String input) {
        String[] names = input.split(MessageConstant.NAME_SPLIT_SEPARATOR);

        for (String name : names) {
            if (name.length() > RaceConstant.NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateDuplicateName(String input) {
        Set<String> set = Arrays.stream(input.split(MessageConstant.NAME_SPLIT_SEPARATOR))
                .map(String::toLowerCase)
                .collect(Collectors.toSet());

        if (set.size() != input.split(MessageConstant.NAME_SPLIT_SEPARATOR).length) {
            throw new IllegalArgumentException();
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
        if (Integer.parseInt(input) > RaceConstant.MAXIMUM_ATTEMPT_COUNT) {
            throw new IllegalArgumentException();
        }
    }

}
