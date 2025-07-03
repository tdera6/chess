package chess.logic.pieces;

import chess.logic.Color;

public class King extends Piece{
    public King(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'K';
        } else {
            return 'k';
        }
    }
}
