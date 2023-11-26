package racingcar.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinnerTest {
    private Winner winner;

    @BeforeEach
    void setUp() {
        winner = new Winner();
    }

    @DisplayName("내림차순으로 자동차 점수 정렬 확인")
    @Test
    void checkSortedPlayersScore() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("pobi", 3));
        players.add(new Player("woni", 5));
        players.add(new Player("jun", 5));

        winner.sortPlayerScore(players);

        List<Player> answer = new ArrayList<>();
        answer.add(new Player("woni", 5));
        answer.add(new Player("jun", 5));
        answer.add(new Player("pobi", 3));

        assertThat(players).usingRecursiveComparison().isEqualTo(answer);
    }

    @DisplayName("우승자를 골라내는지 확인")
    @Test
    void checkFindWinner() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("woni", 5));
        players.add(new Player("jun", 5));
        players.add(new Player("pobi", 3));

        List<String> result = winner.findWinner(players);

        List<String> answer = new ArrayList<>();
        answer.add("woni");
        answer.add("jun");

        assertThat(result).isEqualTo(answer);
    }
}