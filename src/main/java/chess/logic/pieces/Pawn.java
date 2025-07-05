package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.ArrayList;
import java.util.List;

public class Pawn extends Piece {

    protected boolean firstMove = true;

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

    @Override
    public List<Move> getLegalMoves(Board board, Square currentSquare) {
        int currentColumn = currentSquare.getColumn();
        int currentRow = currentSquare.getRow();

        List<Move> legalMoves = new ArrayList<>();

        if (getColor() == Color.WHITE) {
            if(board.isValidSquare(currentRow - 1, currentColumn)) {
                legalMoves.add(new Move(currentSquare, new Square(currentRow - 1, currentColumn)));
                if(firstMove && board.isValidSquare(currentRow - 2, currentColumn)) {
                    legalMoves.add(new Move(currentSquare, new Square(currentRow - 2, currentColumn)));
                }
            }
        } else {
            if(board.isValidSquare(currentRow + 1, currentColumn)) {
                legalMoves.add(new Move(currentSquare, new Square(currentRow + 1, currentColumn)));
                if(firstMove && board.isValidSquare(currentRow + 2, currentColumn)) {
                    legalMoves.add(new Move(currentSquare, new Square(currentRow + 2, currentColumn)));
                }
            }
        }

        return legalMoves;
    }
}
