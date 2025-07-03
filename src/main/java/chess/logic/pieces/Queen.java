package chess.logic.pieces;

import chess.logic.Color;

public class Queen extends Piece {
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
}
