package ru.kpfu.itis.group11506.semestrovka;

public class Knight extends Figure {

    public final String icon = "N";
    String numberTurn = "1";


    public String getIcon() {
        return icon;
    }

    private String findPath(String[][] table, int endRow, int endJ) {
        String realPath = Character.toString((char)(endJ + 96)) + (table.length-1 - endRow);
        String fullPath = " " + realPath;
        for (int i = 0; (!numberTurn.equals("0")); i++) {

            if (((endRow-1 > -1) && (endJ-2 > 0)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow-1][endJ-2]) == 1))) {
                numberTurn = table[endRow-1][endJ-2];
                realPath = Character.toString((char)(endJ-2 + 96)) + (table.length-1 - (endRow-1));
            }

            if (((endRow-1 > -1) && (endJ+2 < 9)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow-1][endJ+2]) == 1))) {
                numberTurn = table[endRow-1][endJ+2];
                realPath = Character.toString((char)(endJ+2 + 96)) + (table.length-1 - (endRow-1));
            }

            if (((endRow+1 < 8) && (endJ-2 > 0)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow+1][endJ-2]) == 1))){
                numberTurn = table[endRow+1][endJ-2];
                realPath = Character.toString((char)(endJ-2 + 96)) + (table.length-1 - (endRow+1));		}

            if (((endRow+1 < 8) && (endJ+2 < 9)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow+1][endJ+2]) == 1))) {
                numberTurn = table[endRow+1][endJ+2];
                realPath = Character.toString((char)(endJ+2 + 96)) + (table.length-1 - (endRow+1));		}

            if (((endRow+2 < 8) && (endJ+1 < 9)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow+2][endJ+1]) == 1))) {
                numberTurn = table[endRow+2][endJ+1];
                realPath = Character.toString((char)(endJ+1 + 96)) + (table.length-1 - (endRow+2));		}

            if (((endRow+2 < 8) && (endJ-1 > 0)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow+2][endJ-1]) == 1))) {
                numberTurn = table[endRow+2][endJ-1];
                realPath = Character.toString((char)(endJ-1 + 96)) + (table.length-1 - (endRow+2));		}

            if (((endRow-2 > -1) && (endJ+1 < 9)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow-2][endJ+1]) == 1))){
                numberTurn = table[endRow-2][endJ+1];
                realPath = Character.toString((char)(endJ+1 + 96)) + (table.length-1 - (endRow-2));		}

            if (((endRow-2 > -1) && (endJ-1 > 0)) && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow-2][endJ-1]) == 1))){
                numberTurn = table[endRow-2][endJ-1];
                realPath = Character.toString((char)(endJ-1 + 96)) + (table.length-1 - (endRow-2));		}
            fullPath+= "<-" + realPath;		endRow = (table.length-1) - Character.getNumericValue(realPath.charAt(1));
            endJ = (int)(realPath.charAt(0))-97+1;

        }
        return fullPath;
    }

    private void getFirstPoint(String[][] table , int aKnightRow, int aKnightJ) {
        if ((aKnightRow-1 > -1) && (aKnightJ-2 > 0)) {
            table[aKnightRow-1][aKnightJ-2] = numberTurn;
        }

        if ((aKnightRow-1 > -1) && (aKnightJ+2 < 9)) {
            table[aKnightRow-1][aKnightJ+2] = numberTurn;
        }

        if ((aKnightRow+1 < 8) && (aKnightJ-2 > 0)) {
            table[aKnightRow+1][aKnightJ-2] = numberTurn;
        }

        if ((aKnightRow+1 < 8) && (aKnightJ+2 < 9)) {
            table[aKnightRow+1][aKnightJ+2] = numberTurn;
        }

        if ((aKnightRow+2 < 8) && (aKnightJ+1 < 9)) {
            table[aKnightRow+2][aKnightJ+1] = numberTurn;
        }

        if ((aKnightRow+2 < 8) && (aKnightJ-1 > 0)) {
            table[aKnightRow+2][aKnightJ-1] = numberTurn;
        }

        if ((aKnightRow-2 > -1) && (aKnightJ+1 < 9)) {
            table[aKnightRow-2][aKnightJ+1] = numberTurn;
        }

        if ((aKnightRow-2 > -1) && (aKnightJ-1 > 0)) {
            table[aKnightRow-2][aKnightJ-1] = numberTurn;
        }
    }

    public String getPath(String[][] table, String initalPoint, String endPoint) {
        String path = "short path - ";
        int aKnightRow = (table.length-1) - Character.getNumericValue(initalPoint.charAt(1));
        int aKnightJ = (int)(initalPoint.charAt(0))-97+1;
        int endRow = (table.length-1) - Character.getNumericValue(endPoint.charAt(1));
        int endJ = (int)(endPoint.charAt(0))-97+1;

        getFirstPoint(table, aKnightRow, aKnightJ);

        for (int i = 0; i < 6; i++) {

            int sub = Integer.valueOf(numberTurn);
            sub++;
            numberTurn = Integer.toString(sub);

            for (int row = 0; row < table.length-1; row++) {
                for (int j = 1; j < table.length; j++) {

                    if (table[row][j].equals(Integer.toString(Integer.valueOf(numberTurn)-1))) {

                        if (((row-1 > -1) && (j-2 > 0)) && ((table[row-1][j-2] == Board.empty) || (table[row-1][j-2].equals("*")))){
                            table[row-1][j-2] = numberTurn;
                        }

                        if (((row-1 > -1) && (j+2 < 9)) && ((table[row-1][j+2] == Board.empty) || (table[row-1][j+2].equals("*")))) {
                            table[row-1][j+2] = numberTurn;
                        }

                        if (((row+1 < 8) && (j-2 > 0)) && ((table[row+1][j-2] == Board.empty) || (table[row+1][j-2].equals("*")))){
                            table[row+1][j-2] = numberTurn;
                        }

                        if (((row+1 < 8) && (j+2 < 9)) && ((table[row+1][j+2] == Board.empty) || (table[row+1][j+2].equals("*")))) {
                            table[row+1][j+2] = numberTurn;
                        }

                        if (((row+2 < 8) && (j+1 < 9)) && ((table[row+2][j+1] == Board.empty) || (table[row+2][j+1].equals("*")))) {
                            table[row+2][j+1] = numberTurn;
                        }

                        if (((row+2 < 8) && (j-1 > 0)) && ((table[row+2][j-1] == Board.empty) || (table[row+2][j-1].equals("*")))) {
                            table[row+2][j-1] = numberTurn;
                        }

                        if (((row-2 > -1) && (j+1 < 9)) && ((table[row-2][j+1] == Board.empty) || (table[row-2][j+1].equals("*")))) {
                            table[row-2][j+1] = numberTurn;
                        }

                        if (((row-2 > -1) && (j-1 > 0)) && ((table[row-2][j-1] == Board.empty) || (table[row-2][j-1].equals("*")))) {
                            table[row-2][j-1] = numberTurn;
                        }
                    }
                }
            }
        }
        table[(table.length-1) - Character.getNumericValue(initalPoint.charAt(1))][(int)(initalPoint.charAt(0))-97+1] = "0";
        return path + findPath(table, endRow, endJ);
    }
}
