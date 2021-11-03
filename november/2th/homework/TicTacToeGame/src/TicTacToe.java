import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.IntStream;

public class TicTacToe {
    public static final int NUMBER_FIRST_PLAYER = 1;
    public static final int NUMBER_SECOND_PLAYER = 2;
    public static final int MIN_FIELD_SIZE = 3;
    private String[][] playingField;
    private int fieldSize;
    private String firstPlayerName;
    private String secondPlayerName;
    private int maximumNumberMoves;
    private int currentPlayerNumber;

    {
        currentPlayerNumber = NUMBER_FIRST_PLAYER;
    }

    public void setFieldSize(int fieldSize) {
        this.fieldSize = fieldSize;
    }

    public String getFirstPlayerName() {
        return firstPlayerName;
    }

    public void setFirstPlayerName(String firstPlayerName) {
        this.firstPlayerName = firstPlayerName;
    }

    public String getSecondPlayerName() {
        return secondPlayerName;
    }

    public void setSecondPlayerName(String secondPlayerName) {
        this.secondPlayerName = secondPlayerName;
    }

    public int getMaximumNumberMoves() {
        return maximumNumberMoves;
    }

    public int getFieldSize() {
        return fieldSize;
    }

    public void createPlayingField() {
        playingField = new String[fieldSize][fieldSize];
        fillPlayingField(playingField);
        setMaximumNumberMoves(fieldSize);
    }

    public void displayPlayingField() {
        IntStream.range(0, fieldSize).forEach(value -> System.out.print("  " + value));
        System.out.println();
        for (int i = 0; i < fieldSize; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < fieldSize; j++) {
                if ( j == 0 ) {
                    System.out.print(playingField[i][j]);
                } else {
                    System.out.print("  " + playingField[i][j]);
                }

            }
            System.out.println();
        }
    }

    private void fillPlayingField(String[][] playingField) {
        for (int i = 0; i < fieldSize; i++) {
            for (int j = 0; j < fieldSize; j++) {
                playingField[i][j] = "";
            }
        }
    }

    private void setMaximumNumberMoves(int fieldSize) {
        maximumNumberMoves = fieldSize * fieldSize;
    }

    public void putMark(int row, int column) {
        if (isFirstPlayerTurn()) {
            playingField[row][column] = "x";
        } else {
            playingField[row][column] = "o";
        }
    }

    public boolean isFirstPlayerTurn() {
        return currentPlayerNumber == NUMBER_FIRST_PLAYER;
    }

    public void changeCurrentPlayerNumber() {
        if (isFirstPlayerTurn()) {
            currentPlayerNumber = NUMBER_SECOND_PLAYER;
        } else {
            currentPlayerNumber = NUMBER_FIRST_PLAYER;
        }
    }

    public boolean isEmptyPlace(int row, int column) {
        return playingField[row][column].isEmpty();
    }

    public boolean isWinningMove(int row, int column) {
        boolean result;
        if (row == column) {
            result = checkVerticalAndHorizontal(row,column) || checkMainDiagonal();
        } else if (row == (fieldSize - 1 - column)) {
            result = checkVerticalAndHorizontal(row,column) || checkSecondaryDiagonal();
        } else {
            result = checkVerticalAndHorizontal(row,column);
        }
        return result;
    }

    private boolean checkVerticalAndHorizontal(int x, int y) {
        return checkVertical(y) || checkHorizontal(x);
    }

    private boolean checkVertical(int y) {
        boolean isWinner = true;
        for (int i = 0; i < fieldSize - 1; i++) {
            if (playingField[i][y] != playingField[i + 1][y]) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean checkHorizontal(int x) {
        boolean isWinner = true;
        for (int i = 0; i < fieldSize - 1; i++) {
           if (playingField[x][i] != playingField[x][i + 1]) {
               isWinner = false;
               break;
           }
        }
        return isWinner;
    }

    private boolean checkMainDiagonal() {
        boolean isWinner = true;
        for (int i = 0; i < fieldSize - 1; i++) {
            if (playingField[i][i] != playingField[i + 1][i + 1]) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }

    private boolean checkSecondaryDiagonal() {
        boolean isWinner = true;
        for (int i = 0; i < playingField.length - 1; i++) {
            if (playingField[i][playingField.length - 1 - i] != playingField[i + 1][playingField.length - 1 - i - 1]) {
                isWinner = false;
                break;
            }
        }
        return isWinner;
    }
}
