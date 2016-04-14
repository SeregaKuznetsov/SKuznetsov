package ru.kpfu.itis.group11506.semestrovka;

public class Board {

    public static String [][] table = new String[9][9];
    public final static String empty = "0";
    public static String initalPoint;
    public static String endPoint;
    private int initalRow;
    private int initalJ;
    private int endRow;
    private int endJ;

    public Board(String initalPoint, String endPoint) {
        createTable();
        setInitalPoint(initalPoint);
        setEndPoint(endPoint);
        addPoint();
    }

    public String[][] getTable() {
        return table;
    }

    private void addPoint() {
        initalRow = (table.length-1) - Character.getNumericValue(initalPoint.charAt(1));
        initalJ = (int)(initalPoint.charAt(0))-97+1;
        endRow = (table.length-1) - Character.getNumericValue(endPoint.charAt(1));
        endJ = (int)(endPoint.charAt(0))-97+1;
        table[initalRow][initalJ] = Main.figure.getIcon();
        table[endRow][endJ] = "*";
    }

    public static void addPathPoint(String point, int number) {
        int pointRow = (table.length-1) - Character.getNumericValue(point.charAt(1));
        int pointJ = (int)(point.charAt(0))-97+1;
        table[pointRow][pointJ] = Integer.toString(number);
    }

    private void setInitalPoint(String initalPoint) {
        this.initalPoint = initalPoint;
    }

    private void setEndPoint(String endPoint) {
        this.endPoint = endPoint;
    }

    private void createTable() {
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                table[i][j] = empty;
                table[8][j] = String.valueOf(((char)(64+j)));
                table[i][0] = Integer.toString(table.length - (i+1));
            }
        }
        table[8][0] = " ";
    }

    public void showTable() {
        System.out.println();
        for (int i = 0; i < table.length; i++) {
            for (int j = 0; j < table.length; j++) {
                System.out.print(table[i][j]+" ");
            }
            System.out.println();
        }
    }
}