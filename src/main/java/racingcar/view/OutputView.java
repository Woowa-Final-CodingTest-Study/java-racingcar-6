package racingcar.view;

import java.util.List;

public class OutputView {
    public static void printRequestCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public static void printRequestAttempts() {
        System.out.println("시도할 회수는 몇회인가요?");
    }

    public static void printResultTitle() {
        System.out.println("\n실행 결과");
    }

    public static void printResult(List<String> results) {
        for (String result : results) {
            System.out.println(result);
        }
        System.out.print("\n");
    }
}
