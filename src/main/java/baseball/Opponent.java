package baseball;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Opponent {

    private final Set<Integer> baseballNumbers;

    private Opponent() {
        this.baseballNumbers = new LinkedHashSet<>(BaseBallGame.LIMIT);
    }

    public static Set<Integer> createBaseBallNumbers() {
        Opponent opponent = new Opponent();
        return opponent.getBaseballNumbers();
    }

    public Set<Integer> getBaseballNumbers() {
        do {
            baseballNumbers.add(Randoms.pickNumberInRange(BaseBallGame.START_NUMBER, BaseBallGame.END_NUMBER));
        } while (baseballNumbers.size() < BaseBallGame.LIMIT);

        return baseballNumbers;
    }

    static class BaseBallGame {
        public static final int START_NUMBER = 1;
        public static final int END_NUMBER = 9;
        public static final int LIMIT = 3;
    }


}
