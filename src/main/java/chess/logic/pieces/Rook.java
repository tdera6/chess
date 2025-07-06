package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<Move> getLegalMoves(Board board, Square currentSquare) {
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        int originalRow = currentSquare.getRow();
        int originalColumn = currentSquare.getColumn();

        List<Move> legalMoves = new ArrayList<>();

        for (int[] direction : directions) {
            int row = originalRow + direction[0];
            int column = originalColumn + direction[1];

            while (board.isValidSquare(row, column)) {
                legalMoves.add(new Move(currentSquare, new Square(row, column)));
                row += direction[0];
                column += direction[1];
            }
        }

        return legalMoves;
    }
}
