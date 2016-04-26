package CheckersFramework;

import static CheckersFramework.Color.*;
import java.util.Collection;
import java.util.LinkedList;

/**
 * A Checkers game with international rules.
 *
 * @author Hendrik
 */
public class Game {

    private final static int BOARD_SIZE = 10;
    private final Board board;
    private final MoveGetter input;
    private final LinkedList<View> views;
    private final Collection<Point> startingPoints;
    private Status status;
    private boolean canCapturePiece;
    
    public Game(MoveGetter input) {
        this.board = new Board(BOARD_SIZE);
        this.input = input;
        this.views = new LinkedList<>();
        this.startingPoints = new LinkedList<>();
        this.status = Status.TurnWhitePlayer;
        this.canCapturePiece = false;
    }

    public void start() {
        /* **** TODO **** */
        // inititalize board
        // manage game status
        // get moves - input.getMove()
        // validate moves - isValid(Move m)
        // execute moves
        // update views - updateViews()
    }

    private boolean isValid(Move m) {
        /* **** TODO **** */
        // check if piece at starting point of m is of right color - hasRightColor(Point p)
        // check if player can capture a piece
        // check if move does capture a piece
        // check if the endpoint is on the board
        // check if there's room at the endpoint
        return false;
    }

    private void calcStartingPoints() {
        startingPoints.clear();
        Point p;
        for (int x = 0; x < BOARD_SIZE; x++) {
            for (int y = 0; y < BOARD_SIZE; y++) {
                p = new Point(x, y);
                if (hasRightColor(p)) {
                    startingPoints.add(p);
                }
            }
        }
    }

    private boolean hasRightColor(Point p) {
        switch (status) {
            case TurnBlackPlayer:
                return board.getPiece(p).getColor() == Black;
            case TurnWhitePlayer:
                return board.getPiece(p).getColor() == White;
            default:
                return false;
        }
    }

    private void updateViews() {
        views.stream().forEach((v) -> {
            v.setBoard(board);
            v.setStatus(status);
            v.invalidate();
        });
    }
    
    private void initialize() {
        //set white pieces
        for (int y = 10; y <= 7; y--) {
            int x = 0;
            if (y % 2 == 0) {
                x = 0;
            } else {
                x = 1;
            }
            for (; x <= 10; x = x + 2) {
                board.setPiece(new Point(x,y), Piece.White);
            }
        }
        //set black pieces
        for (int y = 0; y <= 4; y++) {
            int x = 0;
            if (y % 2 == 0) {
                x = 1;
            } else {
                x = 0;
            }
            for (; x <= 10; x = x + 2) {
                board.setPiece(new Point(x,y), Piece.Black);
            }
        }
    }

}
