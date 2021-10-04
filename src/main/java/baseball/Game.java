package baseball;

import nextstep.utils.Console;
import java.util.LinkedHashSet;
import java.util.Set;

public class Game {

    enum GameState {
        START("1", "start"),
        FINISH("2", "finish");

        private final String code;
        private final String value;

        GameState(String code, String value) {
            this.code = code;
            this.value = value;
        }

        private String getCode() {
            return code;
        }

        public static Boolean findGameState(String selectNumber) throws IllegalArgumentException {
            if (GameState.START.getCode().equals(selectNumber)) {
                return true;
            }

            if (GameState.FINISH.getCode().equals(selectNumber)) {
                return false;
            }
            throw new IllegalArgumentException();
        }
    }

    private static final String REPLAY_FINISH_ANSWER = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요";
    private static final String SUCCESS_FINISH = "3개의 숫자를 모두 맞히셨습니다! 게임끝";
    private static final String INSERT_NUMBER = "숫자를 입력해주세요";
    private Set<Integer> createdBalls;
    private final Player player;

    public Game() {
        player = new Player();
        createdBalls = new LinkedHashSet<>(3);
    }

    public void start() {
        createdBalls = Opponent.createBaseBallNumbers();
    }

    public void play() {
        System.out.println(INSERT_NUMBER);
        while (player.throwByThreeBall()) {
            finish();
            break;
        }
    }

    public void finish() {
        System.out.println(SUCCESS_FINISH);
        rePlayGame();
    }

    public void rePlayGame() {
        try {

            System.out.println(REPLAY_FINISH_ANSWER);
            String selectNumber = Console.readLine();

            if (GameState.findGameState(selectNumber)) {
                play();
            }

        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 값을 입력했습니다.");
            rePlayGame();
        }
    }
}
