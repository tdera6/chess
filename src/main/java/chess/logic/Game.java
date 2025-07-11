package chess.logic;

import java.util.Scanner;

public class Game {
    private Board board;
    private Color currentPlayer;
    private boolean gameOver;

    public Game() {
        board = new Board();
        currentPlayer = Color.WHITE;
        gameOver = false;
    }

    public void Run() {

        Scanner scanner = new Scanner(System.in);
        while (!gameOver) {
            System.out.println("Current player: " + currentPlayer);
            board.printBoard();
            board.printLegalMoves(currentPlayer);
            String moveAsString = scanner.next();
            currentPlayer = currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
        }
    }

    private Square[] ParseMove(String move) {
        int firstRow = 8 - Integer.parseInt(move.substring(1));
        int firstColumn = move.charAt(0) - 'a';

        int secondRow = 8 - Integer.parseInt(move.substring(3));
        int secondColumn = move.charAt(2) - 'a';

        Square firstSquare = new Square(firstRow, firstColumn);
        Square secondSquare = new Square(secondRow, secondColumn);

        Square[] squares = {firstSquare, secondSquare};

        return squares;
    }
}
