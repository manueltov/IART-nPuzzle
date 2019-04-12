public class Board {

    private int[][] board;
    private int height;
    private int width;
    private int blankHeight;
    private int blankWidth;

    public Board(int height, int width) { //altura largura
        this.height = height;
        this.width = width;
        this.board = new int[height][width];
        getBlankPiece();
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getPiece(int y, int x) {
        return this.board[y][x];
    }

    public void addPiece(int piece, int y, int x) {
        this.board[y][x] = piece;
    }

    private int[][] getBoard() {
        return board;
    }

    private void setBoard(int[][] board) {
        this.board = board;
    }

    public boolean isSolution() {
        int k = 1;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i == (height - 1) && j == (width - 1) && getPiece(i, j) != 0) {
                    return false;
                } else if (getPiece(i, j) != k && k != 9) {
                    return false;
                }
                k++;
            }
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++)
                sb.append("+---");
            sb.append("+\n");
            for (int j = 0; j < width; j++) {
                sb.append("| " + this.board[i][j] + " ");
            }
            sb.append("|\n");
        }
        for (int j = 0; j < width; j++)
            sb.append("+---");
        sb.append("+\n");
        return sb.toString();
    }

    private void getBlankPiece() {
        for (int i = 0; i < height; i++)
            for (int j = 0; j < width; j++)
                if (this.board[i][j] == 0) {
                    this.blankHeight = i;
                    this.blankWidth = j;
                }
    }

    public boolean validMove(Moves move) {
        if (this.blankHeight == 0 && move == Moves.UP)
            return false;
        if (this.blankHeight == (this.height-1) && move == Moves.DOWN)
            return false;
        if (this.blankWidth == 0 && move == Moves.LEFT)
            return false;
        if (this.blankWidth == (this.width-1) && move == Moves.RIGHT)
            return false;
        return true;
    }

    public Board makeMove (Moves move){
        Board newBoard = new Board(this.height, this.width);
        if (!validMove(move))
            throw new IllegalStateException("Invalide move!");
        newBoard.setBoard(this.getBoard());
        switch (move){
            case UP:
                swapPieces(newBoard.blankHeight, newBoard.blankWidth, newBoard.blankHeight-1, newBoard.blankWidth);
                break;
            case DOWN:
                swapPieces(newBoard.blankHeight, newBoard.blankWidth, newBoard.blankHeight+1, newBoard.blankWidth);
                break;
            case LEFT:
                swapPieces(newBoard.blankHeight, newBoard.blankWidth, newBoard.blankHeight, newBoard.blankWidth-1);
                break;
            case RIGHT:
                swapPieces(newBoard.blankHeight, newBoard.blankWidth, newBoard.blankHeight, newBoard.blankWidth+1);
                break;
        }
        return newBoard;
    }

    private void swapPieces (int a1, int b1, int a2, int b2){
        int aux = this.board[a1][b1];
        this.board[a1][b1] = this.board[a2][b2];
        this.board[a2][b2] = aux;
    }
}
