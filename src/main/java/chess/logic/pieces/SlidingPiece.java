package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.ArrayList;
import java.util.List;

public abstract class SlidingPiece extends Piece{

    public SlidingPiece(Color color) {
        super(color);
    }

    @Override
    public List<Move> generateMoves(Board board, Square currentSquare) {
        List<Move> moves = new ArrayList<>();
        int[][] directions = getDirections();

        int originalRow = currentSquare.getRow();
        int originalColumn = currentSquare.getColumn();

        List<Move> legalMoves = new ArrayList<>();

        for (int[] direction : directions) {
            int row = originalRow + direction[0];
            int column = originalColumn + direction[1];

            while (board.isValidSquare(row, column)) {
                if (board.getPiece(row, column) != null) {
                    if (board.getPiece(row, column).getColor() != color) {
                        legalMoves.add(new Move(currentSquare, new Square(row, column)));
                    }
                    break;
                }
                legalMoves.add(new Move(currentSquare, new Square(row, column)));
                row += direction[0];
                column += direction[1];
            }
        }

        return legalMoves;
    }

    protected abstract int[][] getDirections();
}
