package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class RaceTest {

    @DisplayName("랜덤수에 따른 전진 또는 정지 결정")
    @ParameterizedTest
    @CsvSource("1, false, 7, true")
    void decideGoForwardOrStop(int randomNumber, boolean answer) {
        Race race = new Race();
        boolean result = race.decideMovement(randomNumber);

        assertThat(result).isEqualTo(answer);
    }
}