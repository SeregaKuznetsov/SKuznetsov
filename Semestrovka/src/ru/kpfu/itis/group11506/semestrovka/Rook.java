package ru.kpfu.itis.group11506.semestrovka;

public class Rook extends Figure {

    public String getIcon() {
        return icon;
    }

    public String getPath(String[][] table, String initalPoint, String endPoint) {
        int numberTurn = 1;
        String path = "short path - " + initalPoint + "->";
        int initalRow = (table.length-1) - Character.getNumericValue(initalPoint.charAt(1));
        int initalJ = (int)(initalPoint.charAt(0))-97+1;
        int endRow = (table.length-1) - Character.getNumericValue(endPoint.charAt(1));
        int endJ = (int)(endPoint.charAt(0))-97+1;

        if (initalRow == endRow) {
            return path + endPoint;
        }
        else
        if (initalJ == endJ) {
            return path + endPoint;
        }
        else
        if ((initalRow != endRow) && (initalJ != endJ)) {
            Board.addPathPoint(initalPoint.substring(0,1) + endPoint.charAt(1),numberTurn);
            path+=initalPoint.substring(0,1) + endPoint.charAt(1) + "->";
        }
        return path + endPoint;
    }

    public final String icon = "R";
}
