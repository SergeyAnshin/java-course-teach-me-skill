public class Message {
    private TicTacToe ticTacToe;
    private int currentPlayerNumber;
    private final int COORDINATE_NUMBER_FOR_ROW = 1;
    private final int COORDINATE_NUMBER_FOR_COLUMN = 2;
    private int currentCoordinateNumber = COORDINATE_NUMBER_FOR_ROW;

    public Message(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
        currentPlayerNumber = TicTacToe.NUMBER_FIRST_PLAYER;
    }

    public void getEnterNameMessageForPlayer() {
        if (currentPlayerNumber == TicTacToe.NUMBER_FIRST_PLAYER) {
            System.out.print("Enter the name of the first player: ");
        } else {
            System.out.print("Enter the name of the second player: ");
        }
        changeCurrentPlayerNumber(currentPlayerNumber);
    }

    private void changeCurrentPlayerNumber(int currentPlayerNumber) {
        if (currentPlayerNumber == TicTacToe.NUMBER_FIRST_PLAYER) {
            this.currentPlayerNumber = TicTacToe.NUMBER_SECOND_PLAYER;
        } else {
            this.currentPlayerNumber = TicTacToe.NUMBER_FIRST_PLAYER;
        }
    }

    public void getEnterSizeMessage() {
        System.out.print("Enter the size of the playing field: ");
    }

    public void getEnterRowColumnValueMessage() {
        if(currentCoordinateNumber == COORDINATE_NUMBER_FOR_ROW) {
            System.out.print("Enter row number: ");
        } else {
            System.out.print("Enter column number: ");
        }
        changeCurrentCoordinateNumber();
    }

    private void changeCurrentCoordinateNumber() {
        if (currentCoordinateNumber == COORDINATE_NUMBER_FOR_ROW) {
            currentCoordinateNumber = COORDINATE_NUMBER_FOR_COLUMN;
        } else {
            currentCoordinateNumber = COORDINATE_NUMBER_FOR_ROW;
        }
    }

    public void getFieldFilledMessage() {
        System.out.println("This field is taken");
    }

    public void getPutMarkMessage() {
        String message = ", it's your turn to walk!";
        if (ticTacToe.isFirstPlayerTurn()) {
            System.out.println(ticTacToe.getFirstPlayerName().toUpperCase() + message);
        } else {
            System.out.println(ticTacToe.getSecondPlayerName().toUpperCase() + message);
        }
        changeCurrentPlayerNumber(currentPlayerNumber);
    }

    public void getWinnerName() {
        String message = ", YOU WON!!!";
        if (ticTacToe.isFirstPlayerTurn()) {
            System.out.println(ticTacToe.getFirstPlayerName().toUpperCase() +message);
        } else {
            System.out.println(ticTacToe.getSecondPlayerName().toUpperCase() +message);
        }
    }

    public void getDrawGameMessage() {
        System.out.println("You played a draw");
    }

    public void valueIsOutOfMessage(String next) {
        System.out.println(next + " - The value is out of bounds = " + (ticTacToe.getFieldSize() - 1));
    }
}
