package racingcar.view;

public class Exception {
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
