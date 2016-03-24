public class Menu {
    public static final String menu[] = new String[5];

    public static void showMenu() {
        for (int i= 0; i < menu.length; i++) {
            System.out.println(i+1 + ". " +  menu[i]);
        }
    }
}
