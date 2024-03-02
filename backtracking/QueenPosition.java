package backtracking;
class QueenPosition {
    int row;
    int col;

    public QueenPosition(int row, int col) {
        this.row = row;
        this.col = col;
    }

    @Override
    public String toString() {
        return "(" + row +
                "," + col +
                ')';
    }
}
