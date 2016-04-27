package CheckersFramework;

/**
 *
 * @author Hendrik
 */
public class Board {

    private final Piece[][] board;

    /**
     * @param size the size of the board
     */
    public Board(int size) {
        this.board = new Piece[size][size];
    }

    /**
     * @param p the point to get the piece for
     * @return the piece at point p
     */
    public Piece getPiece(Point p) {
        return this.board[p.getX()][p.getY()];
    }

    /**
     * @param p the point to set the piece at
     * @param piece the piece to set
     */
    void setPiece(Point p, Piece piece) {
        this.board[p.getX()][p.getY()] = piece;
    }

    /**
     * Check whether a point lays within this board.
     *
     * @param p the point to check
     * @return whether the point lays within the board
     */
    public boolean contains(Point p) {
        return p.getX() >= 0
                && p.getX() < board.length
                && p.getY() >= 0
                && p.getY() < board.length;
    }

    /**
     * Check whether a point is empty.
     *
     * @param p the point to check
     * @return whether the point is empty
     */
    public boolean isEmpty(Point p) {
        return this.contains(p)
                && board[p.getX()][p.getY()] == null;
    }

}
