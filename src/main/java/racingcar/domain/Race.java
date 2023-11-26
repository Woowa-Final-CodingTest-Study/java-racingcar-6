package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RaceConstant;

public class Race {

    public boolean decideMovement() {
        int randomNumber = Randoms.pickNumberInRange(RaceConstant.MINIMUM_NUMBER, RaceConstant.MAXIMUM_NUMBER);
        if (randomNumber >= RaceConstant.MOVING_STANDARD) {
            return true;
        }
        return false;
    }

}
