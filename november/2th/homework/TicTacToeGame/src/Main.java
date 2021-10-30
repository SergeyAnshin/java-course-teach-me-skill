import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicTacToe ticTacToe = new TicTacToe();
        Message message  = new Message(ticTacToe);

        message.getEnterNameMessageForPlayer();
        String firstPlayerName = scanner.nextLine();
        ticTacToe.setFirstPlayerName(firstPlayerName);
        message.getEnterNameMessageForPlayer();
        String secondPlayerName = scanner.nextLine();
        ticTacToe.setSecondPlayerName(secondPlayerName);

        int fieldSize = 0;
        while (fieldSize < TicTacToe.MIN_FIELD_SIZE) {
            message.getEnterSizeMessage();
            if (scanner.hasNextInt()) {
                fieldSize = scanner.nextInt();
            } else {
                scanner.next();
            }
        }
        ticTacToe.setFieldSize(fieldSize);

        ticTacToe.createPlayingField();
        ticTacToe.displayPlayingField();

        int numberMoves = 0;
        while (numberMoves < ticTacToe.getMaximumNumberMoves()) {

            message.getPutMarkMessage();
            int row;
            message.getEnterRowColumnValueMessage();
            do {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                }
                row = scanner.nextInt();
            } while (row < 0 || row >= ticTacToe.getFieldSize());

            int column;
            message.getEnterRowColumnValueMessage();
            do {
                while (!scanner.hasNextInt()) {
                    scanner.next();
                }
                column = scanner.nextInt();
            } while (column < 0 || column >= ticTacToe.getFieldSize());

            if (ticTacToe.isEmptyPlace(row, column)) {
                ticTacToe.putMark(row, column);
                numberMoves++;
                boolean isWinner = ticTacToe.isWinningMove(row, column);
                if (isWinner) {
                    message.getWinnerName();
                    break;
                } else if (numberMoves == ticTacToe.getMaximumNumberMoves()) {
                    message.getDrawGameMessage();
                }
                ticTacToe.changeCurrentPlayerNumber();
            } else {
                message.getFieldFilledMessage();
            }
            ticTacToe.displayPlayingField();
        }
        scanner.close();

    }
}

