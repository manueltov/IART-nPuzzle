import jdk.jshell.execution.Util;

public class RunGame {

    public static void main(String[] args) {

        System.out.println("Starting game 3 x 3");

        Board board = new Board(3,3);

        Utilities.loadLevel(1);

        //RANDOM
        board.addPiece(3,0,0);
        board.addPiece(6,0,1);
        board.addPiece(0,0,2);

        board.addPiece(2,1,0);
        board.addPiece(8,1,1);
        board.addPiece(4,1,2);

        board.addPiece(1,2,0);
        board.addPiece(5,2,1);
        board.addPiece(7,2,2);

/*        //SOLUTION
        board.addPiece(1,0,0);
        board.addPiece(2,0,1);
        board.addPiece(3,0,2);

        board.addPiece(4,1,0);
        board.addPiece(5,1,1);
        board.addPiece(6,1,2);

        board.addPiece(7,2,0);
        board.addPiece(8,2,1);
        board.addPiece(0,2,2);*/

        System.out.println(board.isSolution());
        System.out.println(board.toString());
    }
}
