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
}
