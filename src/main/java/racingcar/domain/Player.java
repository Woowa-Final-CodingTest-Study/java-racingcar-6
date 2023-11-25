package racingcar.domain;

import java.util.HashMap;
import java.util.Map;

public class Player {

    private String name;
    private int score;
    private Map<String, Integer> player = new HashMap<>();

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
        this.player.put(name, score);
    }

    public Map<String, Integer> getPlayer() {
        return player;
    }

    public int getScore(String name) {
        return player.get(name);
    }

    public void increaseScore(String name) {
        player.put(name, player.get(name)+1);
    }
}
