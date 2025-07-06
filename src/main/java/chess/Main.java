package chess;

import chess.logic.Board;
import chess.logic.Color;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        board.printToConsole();
        board.printLegalMoves(Color.WHITE);
    }
}
