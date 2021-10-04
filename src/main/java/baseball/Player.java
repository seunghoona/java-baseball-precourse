package baseball;

import static nextstep.utils.Console.readLine;

public class Player {

    private final Inning inning;
    private final PlayerValidator playerValidator;

    public Player(Inning inning) {
        this.inning = inning;
        this.playerValidator = new PlayerValidator();
    }

    public Player() {
        this(new Judge());
    }

    public boolean throwByThreeBall() {
        try{
            String insertNumber = readLine();
            playerValidator.validation(insertNumber);
            return checkBall(insertNumber);
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    private boolean checkBall(String insertNumber) {
        return inning.checkBall(insertNumber);
    }

}
