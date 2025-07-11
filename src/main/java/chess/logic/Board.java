package chess.logic;

import chess.logic.pieces.*;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private final Piece[][] board = new Piece[8][8];

    public Board() {
        loadFEN("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w KQkq - 0 1");
    }

    private void setupDefaultPieces() {

        board[7][0] = new Rook(Color.WHITE);
        board[7][1] = new Knight(Color.WHITE);
        board[7][2] = new Bishop(Color.WHITE);
        board[7][3] = new Queen(Color.WHITE);
        board[7][4] = new King(Color.WHITE);
        board[7][5] = new Bishop(Color.WHITE);
        board[7][6] = new Knight(Color.WHITE);
        board[7][7] = new Rook(Color.WHITE);

        board[0][0] = new Rook(Color.BLACK);
        board[0][1] = new Knight(Color.BLACK);
        board[0][2] = new Bishop(Color.BLACK);
        board[0][3] = new Queen(Color.BLACK);
        board[0][4] = new King(Color.BLACK);
        board[0][5] = new Bishop(Color.BLACK);
        board[0][6] = new Knight(Color.BLACK);
        board[0][7] = new Rook(Color.BLACK);

        for(int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(Color.WHITE);
            board[1][i] = new Pawn(Color.BLACK);
        }
    }

    public void printBoard() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print(8 - i);
            for (int j = 0; j < 8; j++) {
                System.out.print(" " + (board[i][j] == null ? " " : board[i][j].getSymbol()));
            }
            System.out.println(" " + (8 - i));
        }
        System.out.println("  a b c d e f g h");
    }

    public void printLegalMoves(Color color) {

        List<Move> allLegalMoves = getAllLegalMoves(color);

        for (Move move : allLegalMoves) {
            System.out.println(move);
        }
    }

    public List<Move> getAllLegalMoves(Color color) {
        List<Move> allLegalMoves = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] != null && board[i][j].getColor() == color) {
                    List<Move> moves = board[i][j].generateMoves(this, new Square(i, j));
                    if (moves != null) {
                        allLegalMoves.addAll(moves);
                    }
                }
            }
        }

        return allLegalMoves;
    }

    public void loadFEN(String fen) {
        String[] fenRows = fen.split("/");
        String[] fenInformation = fenRows[7].split(" ");
        fenRows[7] = fenInformation[0];

        for (int i = 0; i < 8; i++) {
            String row = fenRows[i];
            int column = 0;

            for (char c : row.toCharArray()) {
                if (Character.isDigit(c)) {
                    column += Character.getNumericValue(c);
                } else {
                    setPiece(i, column++, loadPiece(c));
                }
            }
        }
    }

    public void loadFEN() {
        setupDefaultPieces();
    }

    private Piece loadPiece(char c) {
        return switch (c) {
            case 'P' -> new Pawn(Color.WHITE);
            case 'p' -> new Pawn(Color.BLACK);
            case 'R' -> new Rook(Color.WHITE);
            case 'r' -> new Rook(Color.BLACK);
            case 'N' -> new Knight(Color.WHITE);
            case 'n' -> new Knight(Color.BLACK);
            case 'B' -> new Bishop(Color.WHITE);
            case 'b' -> new Bishop(Color.BLACK);
            case 'Q' -> new Queen(Color.WHITE);
            case 'q' -> new Queen(Color.BLACK);
            case 'K' -> new King(Color.WHITE);
            case 'k' -> new King(Color.BLACK);
            default -> null;
        };
    }

    public boolean isValidSquare(int row, int col) {
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }

    public Piece getPiece(int row, int col) {
        return board[row][col];
    }

    public void setPiece(int row, int col, Piece piece) {
        board[row][col] = piece;
    }
}
