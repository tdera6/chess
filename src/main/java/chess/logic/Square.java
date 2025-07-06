package chess.logic;

public class Square {
    private final int row, column;

    public Square(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    private String chessNotation() {

        char col = switch (column) {
            case 0 -> 'a';
            case 1 -> 'b';
            case 2 -> 'c';
            case 3 -> 'd';
            case 4 -> 'e';
            case 5 -> 'f';
            case 6 -> 'g';
            case 7 -> 'h';
            default -> ' ';
        };

        return String.valueOf(col) + (row + 1);
    }

    @Override
    public String toString() {
        return chessNotation();
    }
}
