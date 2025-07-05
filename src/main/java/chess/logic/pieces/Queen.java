package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.List;

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

    @Override
    public List<Move> getLegalMoves(Board board, Square currentSquare) {
        return null;
    }
}
