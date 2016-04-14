package ru.kpfu.itis.group11506.semestrovka;

public class Main {

    public static Figure figure;

    public static void main(String [] args) {
        setFigure(args);
        Board board = new Board(args[2], args[3]);
        System.out.println("\n" + figure.getPath(board.getTable(), args[2], args[3]));
        board.showTable();
    }

    public static Figure setFigure(String [] args) {
        if (args[0].equals("-f")) {
            if (args[1].equals("K")) {
                figure = new King();
            }
            else
            if (args[1].equals("Q")) {
                figure = new Qeen();
            }
            else
            if (args[1].equals("N")) {
                figure = new Knight();
            }
            else
            if (args[1].equals("R")) {
                figure = new Rook();
            }
        }
        return figure;
    }
}