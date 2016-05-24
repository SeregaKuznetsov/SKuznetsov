public class Figure {

    protected static String numberTurn = "0";
    protected static String chessStartPoint;
    protected static String chessEndPoint;
    protected static int startI;
    protected static int startJ;
    protected static int endI;
    protected static int endJ;
    protected static int size;

    public Figure(int startI, int startJ, int endI, int endJ, int size) {
        this.startI = startI; this.startJ = startJ;
        this.endI = endI; this.endJ = endJ;
        this.size = size;
        chessStartPoint = (char)(startJ + 97) + Integer.toString(startI);
        chessEndPoint = (char)(endJ + 97) + Integer.toString(endI);
    }

    public String getPath(String[][] board) {
        return null;
    }

    public void getEnablePoint(String[][] table , String path) {
    }
}
