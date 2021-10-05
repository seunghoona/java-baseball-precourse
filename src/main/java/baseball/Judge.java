package baseball;

public class Judge implements Inning {

    private final static int ONE = 0;
    private final static int SUCCESS_STRIKE_NUMBER = 3;
    private StringBuilder resultMessage;

    private int strike;
    private int ball;

    public Judge() {
        init();
    }

    public void init() {
        this.resultMessage = new StringBuilder();
        this.strike = 0;
        this.ball = 0;
    }

    @Override
    public boolean checkBall(String insertNumber) {
        isStrikeAndBallAndNothing(insertNumber);
        createResultMessage();
        if (strike == SUCCESS_STRIKE_NUMBER) {
            resultMessage();
            return true;
        }
        resultMessage();
        return false;
    }

    private void isStrikeAndBallAndNothing(String insertNumbers) {
        int nowIndex = 0;
        for (String createBaseBallNumber : Opponent.getCreateBaseBallNumbers()) {
            countStrikeOrBall(getFindNumberIndex(insertNumbers, createBaseBallNumber), nowIndex);
            nowIndex++;
        }
    }

    private int getFindNumberIndex(String insertNumbers, String createBaseBallNumber) {
        return insertNumbers.indexOf(createBaseBallNumber);
    }

    private void countStrikeOrBall(int index, int nowIndex) {
        if (index < ONE) {
            return;
        }
        if (index == nowIndex) {
            strike++;
            return;
        }
        if (index >= ONE) {
            ball++;
            return;
        }
    }

    private void createResultMessage() {
        if (strike > ONE) {
            resultMessage.append(strike);
            resultMessage.append("스트라이크");
        }
        if (ball > ONE) {
            resultMessage.append(" ");
            resultMessage.append(ball);
            resultMessage.append("볼");
        }
        if (strike == ONE && ball == ONE) {
            resultMessage.append("낫싱");
        }
    }

    private void resultMessage() {
        System.out.println(resultMessage);
        init();
    }
}
