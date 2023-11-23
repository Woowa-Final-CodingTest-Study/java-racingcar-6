package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<String> readCarName() {
        List<String> carName = new ArrayList<>();
        String[] splitedInput = Console.readLine().split(",");

        validateCarCount(splitedInput.length);

        for (String name : splitedInput) {
            validateNameLength(name);
            carName.add(name);
        }
        return carName;
    }

    public static int readAttempts() {
        String input = Console.readLine();
        int attempts = convertStringToInt(input);

        validateAttempts(attempts);
        return attempts;
    }

    public static int convertStringToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("입력값은 숫자여야합니다.");
        }
    }

    public static void validateAttempts(int attempts) {
        if (attempts < 1) {
            throw new IllegalArgumentException("시도횟수는 1보다 커야합니다.");
        }
    }

    public static void validateCarCount(int carCount) {
        if (carCount < 2) {
            throw new IllegalArgumentException("참여 자동차는 2대 이상이어야 합니다.");
        }
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }
    }
}
