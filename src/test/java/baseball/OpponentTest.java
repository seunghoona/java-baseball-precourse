package baseball;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

class OpponentTest {

    @Test
    @DisplayName("무작위 숫자를 세개를 뽑는지 확인")
    void randomSizeThree() {
        Set<String> baseBallNumbers = Opponent.createBaseBallNumbers();
        assertEquals(3, baseBallNumbers.size());
    }

}