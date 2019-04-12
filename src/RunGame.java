public class RunGame {

    public static void main(String[] args) {

        int level = Utilities.userInterface();

        Board board = Utilities.loadLevel(level);

        System.out.println("Is this board a solution?");
        System.out.println(board.isSolution());

        System.out.println("Print it!");
        System.out.println(board.toString());
    }
}
