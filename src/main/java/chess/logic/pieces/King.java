package chess.logic.pieces;

import chess.logic.Board;
import chess.logic.Color;
import chess.logic.Move;
import chess.logic.Square;

import java.util.ArrayList;
import java.util.List;

public class King extends Piece {
    public King(Color color) {
        super(color);
    }

    @Override
    public char getSymbol() {
        if (color == Color.WHITE) {
            return 'K';
        } else {
            return 'k';
        }
    }

    @Override
    public List<Move> generateMoves(Board board, Square currentSquare) {
        int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

        List<Move> moves = new ArrayList<>();

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
