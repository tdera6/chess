package chess.logic;

import chess.logic.pieces.Piece;

import java.util.List;
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
            List<Move> allLegalMoves = board.getAllLegalMoves(currentPlayer);
            System.out.println(allLegalMoves.size());

            Square[] squares = {};

            String moveAsString = scanner.next();

            try {
                squares = ParseMove(moveAsString);
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
                System.out.println("Incorrect move. Try again");
                continue;
            }


            Move move = new Move(squares[0], squares[1]);

            System.out.println(move);
            System.out.println("=============");
            for (Move legalMove : allLegalMoves) {
                System.out.println(legalMove);
            }

            if (allLegalMoves.contains(move)) {
                makeMove(move);
            } else {
                System.out.println("Error: This move is not legal");
                System.out.println("Try again");
                continue;
            }
            currentPlayer = currentPlayer == Color.WHITE ? Color.BLACK : Color.WHITE;
        }
    }

    private Square[] ParseMove(String move) {

        if (move.length() != 4) throw new IllegalArgumentException("Incorrect input length");

        int firstRow = 8 - Integer.parseInt(move.substring(1, 2));
        int firstColumn = move.charAt(0) - 'a';

        int secondRow = 8 - Integer.parseInt(move.substring(3, 4));
        int secondColumn = move.charAt(2) - 'a';

        if (firstRow < 0 || firstRow > 7 || firstColumn < 0 || firstColumn > 7 || secondRow < 0 || secondRow > 7 || secondColumn < 0 || secondColumn > 7) {
            throw new IllegalArgumentException("There is no such square");
        }

        Square firstSquare = new Square(firstRow, firstColumn);
        Square secondSquare = new Square(secondRow, secondColumn);

        return new Square[]{firstSquare, secondSquare};
    }

    public void makeMove(Move move) {
        Square startingSquare = move.getFrom();
        Square endingSquare = move.getTo();

        Piece piece = board.getPiece(startingSquare.getRow(), startingSquare.getColumn());
        board.setPiece(startingSquare.getRow(), startingSquare.getColumn(), null);
        board.setPiece(endingSquare.getRow(), endingSquare.getColumn(), piece);

    }
}
