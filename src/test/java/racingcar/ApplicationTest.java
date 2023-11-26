package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni", "1");
                    assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
                },
                MOVING_FORWARD, STOP
        );
    }

    @Test
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @ValueSource(strings = {"car1, car2, car3     ", " car1 , car2 ,    car33     "})
    void 이름_앞뒤의_공백을_성공적으로_무시(String input) {
        assertSimpleTest(() -> Assertions.assertThatNoException().isThrownBy(() -> runException(input, "1")));
    }


    @ParameterizedTest
    @ValueSource(strings = {"car", ""})
    void 자동차가_개수가_잘못된_경우(String input) {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(input, "1"))
                .isInstanceOf(IllegalArgumentException.class));
    }


    @ParameterizedTest
    @ValueSource(strings = {"abc,    ", "abc, rsdlssfdf"})
    void 이름이_범위를_벗어난_경우(String input) {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(input, "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @ParameterizedTest
    @ValueSource(strings = {"car1, car2, car2", "car1, car2, car1"})
    void 이름이_중복된_경우(String input) {
        assertSimpleTest(() -> assertThatThrownBy(() -> runException(input, "1"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
