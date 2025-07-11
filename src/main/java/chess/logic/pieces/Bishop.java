package chess.logic.pieces;

import chess.logic.Color;

public class Bishop extends SlidingPiece {
    public Bishop(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'B';
        } else {
            return 'b';
        }
    }

    @Override
    protected int[][] getDirections() {
        return new int[][]{{1, 1}, {-1, 1}, {1, -1}, {-1, -1}};
    }
}
