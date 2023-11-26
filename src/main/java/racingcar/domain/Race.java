package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.constant.RaceConstant;

public class Race {

    public boolean decideMovement(int randomNumber) {
        if (randomNumber >= RaceConstant.MOVING_STANDARD) {
            return true;
        }
        return false;
    }

    public int generateRandomNumber() {
        return Randoms.pickNumberInRange(RaceConstant.MINIMUM_NUMBER, RaceConstant.MAXIMUM_NUMBER);
    }
}
