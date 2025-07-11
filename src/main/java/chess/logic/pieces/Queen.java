package chess.logic.pieces;

import chess.logic.Color;

public class Queen extends SlidingPiece {
    public Queen(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'Q';
        } else {
            return 'q';
        }
    }

    protected int[][] getDirections() {
        return new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};
    }
}
