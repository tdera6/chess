package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.ArrayList;
import java.util.List;

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
