package chess.logic;

import chess.logic.pieces.*;

public class Board {

    private final Piece[][] board = new Piece[8][8];

    public Board() {
        setupDefaultPieces();
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

    public void printToConsole() {
        System.out.println("  a b c d e f g h");
        for (int i = 0; i < 8; i++) {
            System.out.print(i + 1);
            for (int j = 0; j < 8; j++) {
                System.out.print(" " + (board[i][j] == null ? " " : board[i][j].getSymbol()));
            }
            System.out.println(" " + (i + 1));
        }
        System.out.println("  a b c d e f g h");
    }
}
