public class Board {

    private static String[][] table;
    private static String inputBoard;
    private static int size;
    private static int startI;
    private static int startJ;
    private static int endI;
    private static int endJ;

    public Board(String inputBoard) {
        this.inputBoard = inputBoard;
        table = new String[size][size];
    }

    public static void setSize(int initSize) {
        size = initSize;
    }

    public String[][] getBoard() {
        return table;
    }

    public void createTable() {
        int symbol = 0;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                table[i][j] = inputBoard.substring(symbol, symbol+1);
                symbol++;
            }
            symbol+=2;
        }
    }

    public void setPoints() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (!table[i][j].equals("*") && !table[i][j].equals("-") && !table[i][j].equals("+")) {
                    startI = i;
                    startJ = j;
                }
                if (table[i][j].equals("+")) {
                    endI = i;
                    endJ = j;
                }
            }
        }
    }

    public static void showTable(String[][] board) {
        String empty = "         ";
        System.out.print("\n   -");
        for (int u = 0; u < size - 1; u++) {
            System.out.print("----------");
        }
        System.out.print("--------\n");
        boolean number = false;
        for (int i = 0; i < size; i++) {


            System.out.print("  ");
            for (int m = 0; m < size + 1; m++) {
                if (m < size) {
                    if (board[i][m] != null) {
                        try {
                            Integer.valueOf(board[i][m]);
                            number = true;
                        } catch (NumberFormatException ignored) {
                        }
                        if (board[i][m].equals("K")) {
                            System.out.print("|" + "\033[30m" + "   \\+/" + empty.substring(6) + "\033[0m");
                        } else if (board[i][m].equals("Q")) {
                            System.out.print("|" + "\033[30m" + "   \\^/" + empty.substring(6) + "\033[0m");
                        } else if (board[i][m].equals("R")) {
                            System.out.print("|" + "\033[30m" + "   (V)" + empty.substring(6) + "\033[0m");
                        } else if (board[i][m].equals("N")) {
                            System.out.print("|" + "\033[30m" + "   (\"\\" + empty.substring(6) + "\033[0m");
                        } else if (board[i][m].equals("B")) {
                            System.out.print("|" + "\033[30m" + "   [-]" + empty.substring(6) + "\033[0m");
                        } else if (board[i][m].equals("P")) {
                            System.out.print("|" + "\033[30m" + "    _" + empty.substring(5) + "\033[0m");
                        } else if (board[i][m].equals("!")) {
                            System.out.print("|" + "\033[42m" + empty + "\033[0m");
                        } else if (number) {
                            System.out.print("|" + "\033[40m" + empty + "\033[0m");
                        } else if (board[i][m].equals("+")) {
                            System.out.print("|" + "\033[33m" + "  o___" + empty.substring(6) + "\033[0m");
                        } else if (board[i][m].equals("-")) {
                            System.out.print("|" + "\033[31m" + "    _" + empty.substring(5) + "\033[0m");
                        } else if (board[i][m].equals("*")) {
                            System.out.print("|" + empty);
                        } else {
                            System.out.print("|" + empty);
                        }
                    } else {
                        System.out.print("|" + empty);
                    }
                }
                number = false;
            }
            System.out.println("|");


            System.out.print(size - i + " ");
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    try {
                        Integer.valueOf(board[i][j]);
                        number = true;
                    } catch (NumberFormatException ignored) {
                    }
                    if (board[i][j].equals("K")) {
                        System.out.print("|" + "\033[30m" + "   ) (" + empty.substring(6) + "\033[0m");
                    } else if (board[i][j].equals("Q")) {
                        System.out.print("|" + "\033[30m" + "   ) (" + empty.substring(6) + "\033[0m");
                    } else if (board[i][j].equals("R")) {
                        System.out.print("|" + "\033[30m" + "   ) (" + empty.substring(6) + "\033[0m");
                    } else if (board[i][j].equals("N")) {
                        System.out.print("|" + "\033[30m" + "   ) '" + empty.substring(6) + "\033[0m");
                    } else if (board[i][j].equals("B")) {
                        System.out.print("|" + "\033[30m" + "   | |" + empty.substring(6) + "\033[0m");
                    } else if (board[i][j].equals("P")) {
                        System.out.print("|" + "\033[30m" + "   ( )" + empty.substring(6) + "\033[0m");
                    } else if (board[i][j].equals("!")) {
                        System.out.print("|" + "\033[42m" + empty + "\033[0m");
                    } else if (number) {
                        System.out.print("|" + "\033[40m" + empty + "\033[0m");
                    } else if (board[i][j].equals("+")) {
                        System.out.print("|" + "\033[33m" + "  |___|" + empty.substring(7) + "\033[0m");
                    } else if (board[i][j].equals("-")) {
                        System.out.print("|" + "\033[31m" + "   ( )" + empty.substring(6) + "\033[0m");
                    } else if (board[i][j].equals("*")) {
                    System.out.print("|" + empty);
                    } else {
                        System.out.print("|" + empty);
                    }
                } else {
                    System.out.print("|" + empty);
                }
                number = false;
            }
            System.out.println("|");


            System.out.print("  ");
            for (int m = 0; m < size + 1; m++) {
                if (m < size) {
                    if (board[i][m] != null) {
                        try {
                            Integer.valueOf(board[i][m]);
                            number = true;
                        } catch (NumberFormatException ignored) {
                        }
                        if (board[i][m].equals("K")) {
                            System.out.print("|" + "\033[30m" + "  /___\\" + empty.substring(7) + "\033[0m");
                        } else if (board[i][m].equals("Q")) {
                            System.out.print("|" + "\033[30m" + "  /___\\" + empty.substring(7) + "\033[0m");
                        } else if (board[i][m].equals("R")) {
                            System.out.print("|" + "\033[30m" + "  /___\\" + empty.substring(7) + "\033[0m");
                        } else if (board[i][m].equals("N")) {
                            System.out.print("|" + "\033[30m" + "  /___\\" + empty.substring(7) + "\033[0m");
                        } else if (board[i][m].equals("B")) {
                            System.out.print("|" + "\033[30m" + "  /___\\" + empty.substring(7) + "\033[0m");
                        } else if (board[i][m].equals("P")) {
                            System.out.print("|" + "\033[30m" + "  /___\\" + empty.substring(7) + "\033[0m");
                        } else if (board[i][m].equals("!")) {
                            System.out.print("|" + "\033[42m" + empty + "\033[0m");
                        } else if (number) {
                            System.out.print("|" + "\033[40m" + empty + "\033[0m");
                        } else if (board[i][m].equals("+")) {
                            System.out.print("|" + "\033[33m" + "  |" + empty.substring(3) + "\033[0m");
                        } else if (board[i][m].equals("-")) {
                            System.out.print("|" + "\033[31m" + "  /___\\" + empty.substring(7) + "\033[0m");
                        } else if (board[i][m].equals("*")) {
                            System.out.print("|" + empty);
                        } else {
                            System.out.print("|" + empty);
                        }
                    } else {
                        System.out.print("|" + empty);
                    }
                }
                number = false;
            }
            System.out.println("|");


            System.out.print("   -");
            for (int d = 0; d < size - 1; d++) {
                System.out.print("----------");
            }
            System.out.print("--------\n");
        }
        for (int c = 0; c < size; c++) {
            System.out.print(empty.substring(1) + (char) (c + 65) + " ");
        }
        System.out.println("\n");
    }

    public static int getStartI() {
        return startI;
    }

    public static int getStartJ() {
        return startJ;
    }

    public static int getEndI() {
        return endI;
    }

    public static int getEndJ() {
        return endJ;
    }
}
