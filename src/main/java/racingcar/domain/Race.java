package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RaceConstant;

public class Race {

    public boolean decideMovement(int randomNumber) {
        return randomNumber >= RaceConstant.MOVING_STANDARD;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RaceConstant.MINIMUM_NUMBER, RaceConstant.MAXIMUM_NUMBER);
    }
}
