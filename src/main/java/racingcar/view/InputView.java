package racingcar.view;

import static racingcar.view.Exception.validateAttempts;
import static racingcar.view.Exception.validateCarCount;
import static racingcar.view.Exception.validateNameLength;

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
            throw new IllegalArgumentException("입력값은 정수여야합니다.");
        }
    }
}
