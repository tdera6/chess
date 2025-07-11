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

        int r = 8 - row;

        return String.valueOf(col) + r;
    }

    @Override
    public String toString() {
        return chessNotation();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Square) {
            Square other = (Square) obj;
            return this.row == other.row && this.column == other.column;
        }
        return false;
    }
}
