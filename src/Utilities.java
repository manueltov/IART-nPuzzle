import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Utilities {

    public static Board loadLevel(int levelnum) {
        String fileName = "level" + levelnum + ".txt";
        StringBuffer nums = fileToBuff(fileName);

        Board board = new Board(Character.getNumericValue(nums.charAt(0)),Character.getNumericValue(nums.charAt(2)));
        nums.delete(0,3);
        /*for (int i = 8; i < nums.length ; i++){
            Point onePoint = new Point(nums[i],nums[++i]);
            Point twoPoint = new Point(nums[++i], nums[++i]);
            Piece piece = new Piece(onePoint, twoPoint);
            board.insertPieceBoard(piece);
        }*/
        return board;
    }

    /**
     * Metodo auxiliar que recebe um ficheiro com as coordenadas das
     * peças e devolve um vetor com as peças
     * @param fileName - nome do ficheiro que vai ser lido
     * @return vector de interios proveniente do ficheiro
     */
    private static StringBuffer fileToBuff (String fileName){
        StringBuffer sbuf = new StringBuffer();
        try{
            Scanner sc = new Scanner(new File(fileName));
            while (sc.hasNextLine())
                sbuf.append(sc.nextLine()+" ");
            sc.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return sbuf;
    }

}
