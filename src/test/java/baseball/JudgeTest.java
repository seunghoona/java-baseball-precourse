package baseball;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;

import java.util.LinkedHashSet;
import java.util.Set;

import static baseball.Opponent.createBaseBallNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mockStatic;

class JudgeTest extends NSTest {


    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    @DisplayName("생성된 숫자와 입력된 숫자가 동일하면 STRIKE")
    public void threeStrike() {
        createBaseBallNumbers();
        Set<String> createBaseBallNumbers = Opponent.getCreateBaseBallNumbers();
        String insertNumber = insertNumber(createBaseBallNumbers);

        Judge judge = new Judge();
        boolean isThreeStrike = judge.checkBall(insertNumber);
        assertThat(isThreeStrike).isTrue();
    }

    @Test
    @DisplayName("입력된 값에 따라 스트라이크, 볼 갯수가 맞는지 ")
    public void ball() {

        Set<String> resultSet = new LinkedHashSet<>();
        resultSet.add("1");
        resultSet.add("3");
        resultSet.add("5");

        try (final MockedStatic<Opponent> mockRandoms = mockStatic(Opponent.class)) {
            mockRandoms
                    .when(Opponent::createBaseBallNumbers)
                    .thenReturn(resultSet);
            mockRandoms
                    .when(Opponent::getCreateBaseBallNumbers)
                    .thenReturn(resultSet);
            Judge judge = new Judge();
            judge.checkBall("135");
            verify("3스트라이크");
        }
    }

    /**
     * @param createBaseBallNumbers
     * @return 랜덤한 숫자 3개를 문자열로 리턴
     */
    private String insertNumber(Set<String> createBaseBallNumbers) {
        StringBuilder insertNumber = new StringBuilder();
        for (String createBaseBallNumber : createBaseBallNumbers) {
            insertNumber.append(createBaseBallNumber);
        }
        return insertNumber.toString();
    }

    @Override
    public void runMain() {

    }
}