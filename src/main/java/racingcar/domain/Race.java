package racingcar.domain;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {

    public boolean decideMovement() {
        int randomNumber = Randoms.pickNumberInRange(0, 9);
        if (randomNumber >= 4) {
            return true;
        }
        return false;
    }
}
