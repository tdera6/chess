package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.ArrayList;
import java.util.List;

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
