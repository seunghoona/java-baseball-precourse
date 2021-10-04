package baseball;

import static nextstep.utils.Console.readLine;

public class Player {

    private Inning inning;
    private final PlayerValidator playerValidator;

    public Player(Inning inning) {
        this.inning = inning;
        this.playerValidator = new PlayerValidator();
    }

    public Player() {
        this.playerValidator = new PlayerValidator();
    }

    public boolean throwByThreeBall() {
        String insertNumber = readLine();
        playerValidator.validation(insertNumber);
        return checkBall(insertNumber);
    }

    private boolean checkBall(String insertNumber) {
        return inning.checkBall(insertNumber);
    }

}
