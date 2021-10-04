package baseball;

import nextstep.utils.Randoms;

import java.util.LinkedHashSet;
import java.util.Set;

public class Opponent {

    private static Set<String> baseballNumbers;

    public Opponent() {
        baseballNumbers = new LinkedHashSet<>(BaseBallGame.LIMIT);
    }

    public static Set<String> createBaseBallNumbers() {
        Opponent opponent = new Opponent();
        return opponent.getBaseballNumbers();
    }

    public Set<String> getBaseballNumbers() {
        do {
            baseballNumbers.add(String.valueOf(Randoms.pickNumberInRange(BaseBallGame.START_NUMBER, BaseBallGame.END_NUMBER)));
        } while (baseballNumbers.size() < BaseBallGame.LIMIT);

        return baseballNumbers;
    }

    public static Set<String> getCreateBaseBallNumbers() {
        return baseballNumbers;
    }

    static class BaseBallGame {
        public static final int START_NUMBER = 1;
        public static final int END_NUMBER = 9;
        public static final int LIMIT = 3;
    }

}
