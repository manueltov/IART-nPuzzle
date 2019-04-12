public class Board {

    private int[][] board;
    private int height;
    private int width;

    public Board(int height, int width) { //altura largura
        this.height = height;
        this.width = width;
        this.board = new int[height][width];
    }

    public int getPiece(int y, int x) {
        return this.board[y][x];
    }

    public void addPiece(int piece, int y, int x) {
        this.board[y][x] = piece;
    }

    public boolean isSolution (){
        int k = 1;
        for (int i = 0 ; i < height ; i++) {
            for (int j = 0; j < width; j++) {
                if (i==(height-1) && j==(width-1) && getPiece(i,j)!=0){
                    return false;
                } else if (getPiece(i, j) != k  && k!=9) {
                    return false;
                }
                k++;
            }
        }
        return true;
    }

    public String toString (){
        StringBuilder sb = new StringBuilder();
        for (int i = 0 ; i < height ; i ++){
            for (int j = 0; j < width ; j++)
                sb.append("+---");
            sb.append("+\n");
            for (int j = 0 ; j < width ; j++){
                sb.append("| " + this.board[i][j] + " ");
            }
            sb.append("|\n");
        }
        for (int j = 0; j < width ; j++)
            sb.append("+---");
        sb.append("+\n");
        return sb.toString();
    }

}
