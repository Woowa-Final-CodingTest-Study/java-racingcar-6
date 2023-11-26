package racingcar.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    void go_forward_with_4_or_greater(int value) {
        String name = "car";
        Car car = new Car(name);
        car.goForward(value);
        Assertions.assertThat(car.roundResult()).isEqualTo(name + " : " + "-");
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1,2,3})
    void stop_with_3_or_less(int value) {
        String name = "car";
        Car car = new Car(name);
        car.goForward(value);
        Assertions.assertThat(car.roundResult()).isEqualTo(name + " : ");
    }
}
