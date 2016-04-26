package CheckersFramework;

/**
 *
 * @author Hendrik
 */
public class Move {

    private final Point start;
    private final Direction direction;
    private final int scalar;

    /**
     * @param start the starting point of the move
     * @param direction the direction of the move
     * @param length the length of the move (scalar)
     */
    public Move(Point start, Direction direction, int length) {
        this.start = start;
        this.direction = direction;
        this.scalar = length;
    }

    /**
     * @return the delta on the x-axis
     */
    public int getDeltaX() {
        return this.direction.getDeltaX() * scalar;
    }

    /**
     * @return the delta on the y-axis
     */
    public int getDeltaY() {
        return this.direction.getDeltaY() * scalar;
    }

    /**
     * @return the starting point
     */
    public Point getStart() {
        return start;
    }

    /**
     * @return the endpoint of the move 
     */
    public Point getEndpoint() {
        return new Point(this.getStart().getX()+this.getDeltaX(), this.getStart().getY()+this.getDeltaY());
    }
    
    /**
     * @return the scalar
     */
    public int getScalar() {
        return scalar;
    }

}
