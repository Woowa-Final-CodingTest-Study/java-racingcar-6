package racingcar.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

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

    public String getPlayerName() {
        Set<String> key = player.keySet();
        return key.iterator().next();
    }

    public int getScore() {
        String name = getPlayerName();
        return player.get(name);
    }

}
