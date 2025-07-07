package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.ArrayList;
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
    public List<Move> generateMoves(Board board, Square currentSquare) {

        List<Move> moves = new ArrayList<>();

        int[][] directions = {{1, 2}, {-1, 2}, {2, 1}, {2, -1}, {1, -2}, {-1, -2}, {-2, -1}, {-2, 1}};

        for (int[] direction : directions) {
            int row = currentSquare.getRow() + direction[0];
            int column = currentSquare.getColumn() + direction[1];

            if (board.isValidSquare(row, column)) {
                if (board.getPiece(row, column) == null || board.getPiece(row, column).getColor() != color) {
                    moves.add(new Move(currentSquare, new Square(row, column)));
                }
            }
        }

        return moves;
    }
}
