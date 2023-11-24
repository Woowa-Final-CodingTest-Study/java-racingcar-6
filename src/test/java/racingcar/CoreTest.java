package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import racingcar.domain.Racing;

public class CoreTest {

    @ValueSource(strings = {"hello", "cindy"})
    @ParameterizedTest
    void 두번전진_출력(String input) {
        Car car = new Car(input);
        car.goForward();
        car.goForward();

        String result = car.getResult();
        assertThat(result).isEqualTo(input + " : " + "--");
    }

    @Test
    void 위치_하이픈으로_변환() {
        Car car = new Car("hello");
        car.goForward();
        car.goForward();
        car.goForward();
        car.goForward();
        car.goForward();
        assertThat(car.getResult()).contains("-----");
        assertThat(car.getResult()).doesNotContain("------");

        car.goForward();
        car.goForward();
        assertThat(car.getResult()).contains("-------");
        assertThat(car.getResult()).doesNotContain("---------");
    }

    @Test
    void 랜덤값에_따른_두명_공동우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Racing racing = new Racing(List.of("a", "b", "c"));
                    racing.execute();
                    racing.execute();
                    Assertions.assertThat(racing.getWinner()).containsExactly("a", "c");
                },
                3, 3, 4, 4, 3, 3
        );
    }

    @Test
    void 랜덤값에_따른_세명_공동우승_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    Racing racing = new Racing(List.of("a", "b", "c"));
                    racing.execute();
                    racing.execute();
                    Assertions.assertThat(racing.getWinner()).containsExactly("a", "b", "c");
                },
                4, 5, 7, 2, 3, 3
        );
    }


}
