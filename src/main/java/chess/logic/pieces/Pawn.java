package chess.logic.pieces;

import chess.logic.Color;

public class Pawn extends Piece {
    public Pawn(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'P';
        } else {
            return 'p';
        }
    }
}
