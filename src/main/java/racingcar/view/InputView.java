package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static List<String> readCarName() {
        List<String> carName = new ArrayList<>();
        String[] splitedInput = Console.readLine().split(",");

//        validateCarCount(splitedInput.length);

        for (String name : splitedInput) {
//            validateNameLength(name.length());
            carName.add(name);
        }

        return carName;
    }
}
