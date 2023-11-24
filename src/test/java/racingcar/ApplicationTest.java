package racingcar;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 전부_한칸씩_전진() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,choco,white", "1");
                    assertThat(output()).contains("pobi : -", "woni : -", "choco : -", "white : -",
                            "최종 우승자 : pobi, woni, choco, white");
                },
                MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    void 전부_전진_못할때() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,woni,choco,white", "1");
                    assertThat(output()).contains("pobi : ", "woni : ", "choco : ", "white : ",
                            "최종 우승자 : pobi, woni, choco, white");
                },
                STOP, STOP, STOP, STOP
        );
    }

    @Test
    void 이름이_다섯자_초과할때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 참여자동차가_없을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 참여자동차가_한개일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가_0일때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello,world", "0"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시도횟수가_정수가_아닐때_작을때_예외처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("hello,world", "1.1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
