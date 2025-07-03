package chess.logic.pieces;

import chess.logic.Color;

public class Rook extends Piece {
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
}
