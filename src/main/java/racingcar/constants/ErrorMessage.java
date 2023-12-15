package racingcar.constants;

public enum ErrorMessage {
    NOT_INTEGER_ERROR("올바른 숫자가 아닙니다."),
    INVALID_RANGE_ERROR("범위가 올바르지 않습니다."),
    NULL_ERROR("입력이 비어있습니다."),
    FORMAT_ERROR("형식이 올바르지 않습니다.");

    // 다른 에러 메시지 추가 가능

    private final String message;

    private ErrorMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return "[ERROR] " + message;
    }
    }
