package chess.logic.pieces;

import chess.logic.Color;

public class Rook extends SlidingPiece {
    public Rook(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'R';
        } else {
            return 'r';
        }
    }

    @Override
    protected int[][] getDirections() {
        return new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    }
}
