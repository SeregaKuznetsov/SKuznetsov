import java.io.*;
import java.util.Scanner;

public class Main {

    private static int size;
    private static String input;
    private static String inputBoard;
    private static Figure figure;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Хотите ли вы самостоятельно заполнить доску? (1 - Да, иначе - использовать готовую доску)");
        int choice = sc.nextInt();
        if (choice == 1) {
            writeFile(); //записываем
        }
        readFile(); //читаем файл
        writeSize(); //считываем размер доски
        inputBoard = input.substring(5); //берем только саму доску
        Board board = new Board(inputBoard); //создаем доску
        board.createTable(); //записываем символы в массив String
        board.setPoints(); //записываем начало и конец
        writeFigure(); //считываем фигуру
        String path = (figure.getPath(board.getBoard())); //пишем маршрут
        figure.getEnablePoint(board.getBoard(), path);
        System.out.println("Short path - " + path);
    }

    private static void writeFile() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size:");
        size = sc.nextInt();
        Board.setSize(size);
        String[][] startTable = new String[size][size];
        int numberEnters = 0;
        String oneInput = "";
        String boardStr = "";
        boolean auto = false;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (j % size == 0) {
                    String lineSeparator = System.getProperty("line.separator"); //для переноса строки во время записи
                    boardStr += lineSeparator;
                    numberEnters++;
                }
                if (!auto) {
                    System.out.println("Enter board: (1 - '*', 2 - '-', 3 - '+' and Figure - K, N; 4 - Exit)");
                    oneInput = sc.next();
                }
                if (!oneInput.substring(0, 1).equals("4")) {
                    if (oneInput.equals("1")) {
                        boardStr += "*";
                        startTable[i][j] = "*";
                    } else if (oneInput.equals("2")) {
                        boardStr += "-";
                        startTable[i][j] = "-";
                    } else if (oneInput.equals("3")) {
                        boardStr += "+";
                        startTable[i][j] = "+";
                    } else if (!oneInput.equals("1") && !oneInput.equals("2") && !oneInput.equals("3")) {
                        boardStr += oneInput;
                        startTable[i][j] = oneInput;
                    }
                    Board.showTable(startTable);
                } else {
                    auto = true;
                    if (boardStr.length() < size * size + numberEnters * 2) {
                        boardStr += "*";
                        startTable[i][j] = "*";
                    }
                }
            }
        }
        Board.showTable(startTable);
        String lineSeparator = System.getProperty("line.separator");
        String output = Integer.toString(size) + lineSeparator + boardStr;
        try (DataOutputStream dos = new DataOutputStream((new FileOutputStream(new File(".\\src\\in.txt"))))) {
            dos.write(output.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readFile() {
        byte[] buffer = new byte[6 * 100];
        try (DataInputStream dis = new DataInputStream(new FileInputStream(new File(".\\src\\in.txt")))) {
            dis.read(buffer);
            input = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void writeSize() {
        try {
            size = Integer.valueOf(input.substring(0, 1));
        } catch (NumberFormatException e) {
            System.err.println("Неверный формат строки!");
        }
        Board.setSize(size); //запоминаем размер доски
    }

    private static void writeFigure() {
        System.out.println();
        for (int i = 0; i < inputBoard.length(); i++) {
            if (inputBoard.substring(i, i+1).equals("N")) {
                figure = new Knight(Board.getStartI(), Board.getStartJ(), Board.getEndI(), Board.getEndJ(), size);
                System.out.println("N - Knight");
                break;
            }
            if (inputBoard.substring(i, i+1).equals("K")) {
                figure = new King(Board.getStartI(), Board.getStartJ(), Board.getEndI(), Board.getEndJ(), size);
                System.out.println("K - King");
                break;
            }
            if (inputBoard.substring(i, i+1).equals("Q")) {
                figure = new Queen(Board.getStartI(), Board.getStartJ(), Board.getEndI(), Board.getEndJ(), size);
                System.out.println("Q - Queen");
                break;
            }
            if (inputBoard.substring(i, i+1).equals("R")) {
                System.out.println("R - Rook");
                figure = new Rook(Board.getStartI(), Board.getStartJ(), Board.getEndI(), Board.getEndJ(), size);
                break;
            }
            if (inputBoard.substring(i, i+1).equals("B")) {
                System.out.println("B - Bishop");
                figure = new Bishop(Board.getStartI(), Board.getStartJ(), Board.getEndI(), Board.getEndJ(), size);
                break;
            }
            if (inputBoard.substring(i, i+1).equals("P")) {
                System.out.println("P - Pawn");
                figure = new Pawn(Board.getStartI(), Board.getStartJ(), Board.getEndI(), Board.getEndJ(), size);
                break;
            }
        }
    }
}
