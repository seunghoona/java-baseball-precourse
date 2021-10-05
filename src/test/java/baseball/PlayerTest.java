package baseball;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.Mockito;

import java.util.stream.Stream;

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

    @ParameterizedTest
    @DisplayName("사용자 입력 validation 문제시 IllegalArgumentException 발생 검증")
    @MethodSource("validationParamter")
    void numberLimitThree(String insertNumbers, String resultMessage) {
        PlayerValidator playerValidator = new PlayerValidator();
        assertThatExceptionOfType(IllegalArgumentException.class).isThrownBy(() ->
                        playerValidator.validation(insertNumbers))
                .withMessageStartingWith("[ERROR]")
                .withMessageContaining(resultMessage);
    }

    private static Stream<Arguments> validationParamter() {
        return Stream.of(
                Arguments.of("111", "중복된 숫자가 있습니다."),
                Arguments.of("asdf", "숫자만 입력가능합니다."),
                Arguments.of("1234", "숫자는 3자리를 입력해야합니다.")
        );
    }

    @Override
    public void runMain() {
    }
}