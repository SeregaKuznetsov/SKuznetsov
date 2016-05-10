public class King extends Figure {

    boolean onEndPoint = false;

    public static final int[] di = {1,-1,1,-1,1,-1,0,0};
    public static final int[] dj = {1,-1,-1,1,0,0,-1,1};

    public King(int startI, int startJ, int endI, int endJ, int size) {
        super(startI, startJ, endI, endJ, size);
    }

    private void checkEndPoint(String table[][], int endRow, int endJ) {
        if (!table[endRow][endJ].equals("+")) {
            onEndPoint = true;
        }
    }

    // Записываем кратчаший путь идя от обратного т.е. от конечной точки к начальной
    private String findPath(String[][] table, int endRow, int endJ) {
        String realPath = null;
        StringBuilder fullPath = new StringBuilder(Character.toString((char)(endJ + 97)) + (table.length - endRow));
        while (!numberTurn.equals("0")) {

            for (int e = 0; e < di.length; e++) {
                if ((endRow+di[e])>=0 && (endRow+di[e])<size && (endJ+dj[e])>=0
                        && (endJ+dj[e])<size && (!table[endRow+di[e]][endJ+dj[e]].equals("-")) && (!table[endRow+di[e]][endJ+dj[e]].equals("*"))
                        && ((Integer.valueOf(table[endRow][endJ]) - Integer.valueOf(table[endRow+di[e]][endJ+dj[e]]) == 1))) {
                    numberTurn = table[endRow+di[e]][endJ+dj[e]];
                    realPath = Character.toString((char)(endJ+dj[e] + 97)) + (table.length - (endRow+di[e]));
                }
            }

            fullPath.insert(0, realPath + "->") ;
            endRow = table.length - Character.getNumericValue(realPath.charAt(1));
            endJ = (int)(realPath.charAt(0))-97;
        }
        return fullPath.toString();
    }

    private static void clearTable(String [][] table) {
        for (int k = 0; k < table.length; k++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[k][j].equals("-") && !table[k][j].equals("+")) {
                    table[k][j] = "*";
                }
            }
        }
    }

    private int lookLastTurn(String [][] table) {
        int maxTurn = 0;
        for (int k = 0; k < table.length; k++) {
            for (int j = 0; j < table.length; j++) {
                if (!table[k][j].equals("-") && !table[k][j].equals("+") &&
                        !table[k][j].equals("K") && !table[k][j].equals("*")) {
                    if (Integer.valueOf(table[k][j]) > maxTurn) {
                        maxTurn = Integer.valueOf(table[k][j]);
                    }
                }
            }
        }
        return maxTurn;
    }

    private void checkDeadLock(String[][] table, int turnA, int turnB) {
        if (turnA == turnB) {
            System.out.println("\nDeadLock - Тупик");
            table[startI][startJ] = "K";
            Board.showTable(table);
            System.exit(0);
        }
    }

    public void getEnablePoint(String[][] table , String path) {

        String startPoint;
        String nextPoint = "";

        for (int i = 0; i < path.length()-4; i+=4) {
            startPoint = path.substring(i,i+2);
            nextPoint = path.substring(i + 4, i + 6);
            int aKingRow = table.length - Character.getNumericValue(startPoint.charAt(1));
            int aKingJ = (int)(startPoint.charAt(0))-97;
            clearTable(table);
            table[aKingRow][aKingJ] = "K";
            table[endI][endJ] = "+";

            for (int e = 0; e<di.length; e++){
                if ((aKingRow+di[e])>=0 && (aKingRow+di[e])<size && (aKingJ+dj[e])>=0
                        && (aKingJ+dj[e])<size && table[aKingRow+di[e]][aKingJ+dj[e]].equals("*")){
                    table[aKingRow+di[e]][aKingJ+dj[e]] = "1";
                }
            }
            table[table.length - Character.getNumericValue(nextPoint.charAt(1))][(int)(nextPoint.charAt(0))-97] = "!";
            Board.showTable(table);
        }
        clearTable(table);
        table[table.length - Character.getNumericValue(nextPoint.charAt(1))][(int)(nextPoint.charAt(0))-97] = "K";
        Board.showTable(table);
    }

    public String getPath(String[][] table) {
        table[startI][startJ] = "0";
        while (!onEndPoint) {

            int turn = lookLastTurn(table);
            int sub = Integer.valueOf(numberTurn);
            sub++;
            numberTurn = Integer.toString(sub);

            for (int row = 0; row < table.length; row++) {
                for (int j = 0; j < table.length; j++) {

                    if (table[row][j].equals(Integer.toString(Integer.valueOf(numberTurn)-1))) {

                        for (int e = 0; e<di.length; e++) {
                            if ((row+di[e])>=0 && (row+di[e])<size && (j+dj[e])>=0
                                    && (j+dj[e])<size && ((table[row+di[e]][j+dj[e]].equals("*")) || (table[row+di[e]][j+dj[e]].equals("+")))) {
                                table[row+di[e]][j+dj[e]] = numberTurn;
                            }
                        }
                    }
                }
            }
            checkEndPoint(table, endI, endJ);
            int lastTurn = lookLastTurn(table);
            checkDeadLock(table, turn, lastTurn);
        }
        return findPath(table, endI, endJ);
    }
}
