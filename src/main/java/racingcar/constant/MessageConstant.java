package racingcar.constant;

public enum MessageConstant {
    INPUT_CAR_NAME_MESSAGE("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)"),
    INPUT_ATTEMPT_COUNT_MESSAGE("시도할 회수는 몇회인가요?"),
    EXECUTE_RESULT_MESSAGE("실행 결과"),
    WINNER_MESSAGE("최종 우승자 : "),
    NAME_SPLIT_SEPARATOR(","),
    SCORE_SEPARATOR(" : "),
    WINNER_SEPARATOR(", "),
    SCORE("-");

    private final String message;

    MessageConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void print() {
        System.out.println(message);
    }

    public void print(String lineSeparator) {
        System.out.println(lineSeparator + message);
    }

}
