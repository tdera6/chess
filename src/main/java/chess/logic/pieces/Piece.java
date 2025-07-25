package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.List;

public abstract class Piece {
    protected final Color color;

    public Piece(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public abstract char getSymbol();

    public List<Move> getLegalMoves(Board board, Square currentSquare) {
        List<Move> legalMoves = generateMoves(board, currentSquare);

        return legalMoves;
    }

    public abstract List<Move> generateMoves(Board board, Square square);
}
