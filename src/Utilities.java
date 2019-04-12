import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Utilities {

    public static Board loadLevel(int levelnum) {
        String fileName = "level" + levelnum + ".txt";
        StringBuffer nums = fileToBuff(fileName);

        Board board = new Board(Character.getNumericValue(nums.charAt(0)),Character.getNumericValue(nums.charAt(2)));
        nums.delete(0,4);
        String[] vecStr = new String[(nums.length()/2)+1];
        vecStr = nums.toString().split(" ");
        int k = 0;
        for (int i = 0 ; i < board.getHeight() ; i++){
            for (int j = 0 ; j < board.getWidth() ; j++){
                String str = vecStr[k];
                int aux = Integer.parseInt(str);
                board.addPiece(aux, i, j);
                k++;
            }
        }
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

    public static int userInterface() {
        int level = 0;
        int maxLevel = 10;
        Scanner sc = new Scanner(System.in);
        while (level < 1 | level > maxLevel) {
            System.out.println("Chose a level between 1 and " + maxLevel + ":");
            String strlevel = sc.nextLine();
            level = Integer.parseInt(strlevel);
        }
        sc.close();
        return level;
    }
}
