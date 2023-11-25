package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ScoreCalculatorTest {

    private ScoreCalculator scoreCalculator;

    @BeforeEach
    void setUp() {
        scoreCalculator = new ScoreCalculator();
    }

    @DisplayName("입력한 자동차들의 점수 초기 설정이 됐는지 확인")
    @Test
    void checkInitializePlayerScore() {

        String input = "pobi,woni,jun";
        List<Player> result = scoreCalculator.initializePlayerScore(input);
        List<Player> answer = new ArrayList<>();

        answer.add(new Player("pobi", 0));
        answer.add(new Player("woni", 0));
        answer.add(new Player("jun", 0));

        assertThat(result).usingRecursiveComparison().isEqualTo(answer);
    }

}