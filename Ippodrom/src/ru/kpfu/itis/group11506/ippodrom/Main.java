package ru.kpfu.itis.group11506.ippodrom;

public class Main {

    private String horseName;

    private static int currentIndex = 0;
    private static int number = 1;

    public Main(String threadName) {
        this.horseName = threadName;
    }

    public static void main(String[] args) {
        for (int index = 0 ; index < 10; index++) {
            final String horseName = "Horse " + index;
            new Thread(() -> new Main(horseName).run()).start();
        }
    }

    public void run() {
        while (currentIndex < 10) {
            currentIndex++;
        }
        System.out.println(horseName + " was finished by " + number);
        number++;
    }
}
