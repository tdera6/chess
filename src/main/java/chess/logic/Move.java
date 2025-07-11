package chess.logic;

public class Move {
    private final Square from, to;

    public Move(Square from, Square to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String toString() {
        return from + " -> " + to;
    }

    public Square getFrom() {
        return from;
    }

    public Square getTo() {
        return to;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Move) {
            Move other = (Move) obj;
            return this.from.equals(other.from) && this.to.equals(other.to);
        }
        return false;
    }
}
