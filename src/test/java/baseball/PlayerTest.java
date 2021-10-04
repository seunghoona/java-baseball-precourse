package baseball;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

class PlayerTest extends NSTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    @DisplayName("입력된 정보가 숫자이며 서로다른 숫자인경우 inning을 호출한다.")
    public void diffNumberAndOnlyNumber() {
        Inning inningMock = mock(Inning.class);
        Player player = new Player(inningMock);
        run("132");
        player.throwByThreeBall();
        Mockito.verify(inningMock, times(1));
    }


    @Test
    @DisplayName("숫자를 3자 이상 입력시 IllegalArgumentException")
    void numberLimitThree() {
        PlayerValidator playerValidator = new PlayerValidator();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                        playerValidator.validation("1234"))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("숫자는 3자리를 입력해야합니다.");
    }

    @Test
    @DisplayName("숫자가 아닌 문자 입력시 IllegalArgumentException")
    void NotNumberTest() {
        PlayerValidator playerValidator = new PlayerValidator();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                        playerValidator.validation("asdf"))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("숫자만 입력가능합니다.");
    }

    @Test
    @DisplayName("입력된 정보가 중복된 숫자인경우 IllegalArgumentException")
    public void duplicateNumberTest() {
        PlayerValidator playerValidator = new PlayerValidator();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                        playerValidator.validation("111"))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining("중복된 숫자가 있습니다.");
    }

    @Override
    public void runMain() {
    }
}