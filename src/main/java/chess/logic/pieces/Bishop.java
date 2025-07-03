package chess.logic.pieces;

import chess.logic.Color;

public class Bishop extends Piece {
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
}
