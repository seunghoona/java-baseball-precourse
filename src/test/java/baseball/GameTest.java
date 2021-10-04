package baseball;

import nextstep.test.NSTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest extends NSTest {

    @BeforeEach
    void beforeEach() {
        super.setUp();
    }

    @Test
    @DisplayName("게임종료 1,2 외 다른 번호 클릭시 메시지")
    void selectReplayTest() {
        Game game = new Game();
        run("3", "2");
        game.rePlayGame();
        verify(
                "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요"
                , "잘못된 값을 입력했습니다."
                , "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요");
    }

    @Override
    public void runMain() {
    }
}