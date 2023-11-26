package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

import static racingcar.constant.RaceConstant.MINIMUM_NUMBER;
import static racingcar.constant.RaceConstant.MAXIMUM_NUMBER;
import static racingcar.constant.RaceConstant.MOVING_STANDARD;

public class Race {

    public boolean decideMovement() {
        int randomNumber = Randoms.pickNumberInRange(MINIMUM_NUMBER.getNumber(), MAXIMUM_NUMBER.getNumber());
        if (randomNumber >= MOVING_STANDARD.getNumber()) {
            return true;
        }
        return false;
    }

}
