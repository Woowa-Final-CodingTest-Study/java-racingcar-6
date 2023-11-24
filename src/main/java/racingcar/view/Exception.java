package racingcar.view;

import static racingcar.utils.constants.NUMBER_ATTEMPTS_MIN;
import static racingcar.utils.constants.NUMBER_CARNAME_MAX;
import static racingcar.utils.constants.NUMBER_PARTICIPANTS_MIN;

public class Exception {
    public static void validateAttempts(int attempts) {
        if (attempts < NUMBER_ATTEMPTS_MIN) {
            throw new IllegalArgumentException("시도횟수는 " + NUMBER_ATTEMPTS_MIN + "보다 커야합니다.");
        }
    }

    public static void validateCarCount(int carCount) {
        if (carCount < NUMBER_PARTICIPANTS_MIN) {
            throw new IllegalArgumentException("참여 자동차는 " + NUMBER_PARTICIPANTS_MIN + "대 이상이어야 합니다.");
        }
    }

    public static void validateNameLength(String carName) {
        if (carName.length() > NUMBER_CARNAME_MAX) {
            throw new IllegalArgumentException("자동차 이름은 " + NUMBER_CARNAME_MAX + "자 이하여야 합니다.");
        }
    }
}
