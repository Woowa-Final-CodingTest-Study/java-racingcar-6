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
