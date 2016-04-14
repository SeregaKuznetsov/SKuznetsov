package ru.kpfu.itis.group11506.semestrovka;

public class King extends Figure {

    public String getPath(String[][] table, String initalPoint, String endPoint) {
        int numberTurn = 1;
        String position = initalPoint;
        String path = "short path - " + initalPoint;
        int positionRow = (table.length-1) - Character.getNumericValue(initalPoint.charAt(1));
        int positionJ = (int)(initalPoint.charAt(0))-97+1;
        int endRow = (table.length-1) - Character.getNumericValue(endPoint.charAt(1));
        int endJ = (int)(endPoint.charAt(0))-97+1;

        if ((positionRow != endRow) && (positionJ != endJ)) {
            while (positionJ != endJ) {
                if (endJ > positionJ) {
                    positionJ++;
                }
                else {
                    positionJ--;
                }
                position = Character.toString((char)(positionJ + 96)) + position.charAt(1);
                path+= "->" + position;
                Board.addPathPoint(position, numberTurn);
                numberTurn++;
            }
        }

        if (positionRow == endRow) {
            while (positionJ != endJ) {
                if (endJ > positionJ) {
                    positionJ++;
                }
                else {
                    positionJ--;
                }
                position = Character.toString((char)(positionJ + 96)) + endPoint.charAt(1);
                path+= "->" + position;
                Board.addPathPoint(position, numberTurn);
                numberTurn++;
            }
        }
        if (positionJ == endJ) {
            while (positionRow != endRow) {
                if (endRow > positionRow) {
                    positionRow++;
                }
                else {
                    positionRow--;
                }
                position = position.charAt(0) + Integer.toString(table.length-1 - positionRow);
                path+= "->" + position;
                Board.addPathPoint(position, numberTurn);
                numberTurn++;
            }
        }

        return path;
    }

    public String getIcon() {
        return icon;
    }

    public final String icon = "K";
}