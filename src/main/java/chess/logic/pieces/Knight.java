package chess.logic.pieces;

import chess.logic.Color;

public class Knight extends Piece {
    public Knight(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'N';
        } else {
            return 'n';
        }
    }
}
