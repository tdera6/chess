package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.List;

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

    @Override
    public List<Move> getLegalMoves(Board board, Square currentSquare) {
        return null;
    }
}
