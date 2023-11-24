package racingcar.domain;

public class Car {
    String name;
    int location;

    public Car(String name) {
        this.name = name;
        this.location = 0;
    }

    public void goForward() {
        location++;
    }

    private String getLocationLetters() {
        return "-".repeat(location);
    }

    public String getResult() {
        return name + " : " + getLocationLetters();
    }

    public int getLocation() {
        return location;
    }

    public String getName() {
        return name;
    }
}
