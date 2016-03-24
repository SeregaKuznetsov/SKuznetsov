import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.menu[0] = "Roast beef";
        Menu.menu[1] = "Burger";
        Menu.menu[2] = "Cheesecake";
        Menu.menu[3] = "Spaghetti";
        Menu.menu[4] = "Beer";

        System.out.println("Welcome in own cafe!");
        System.out.println("What would you want to eat?");
        Menu.showMenu();
        try {
            User.order = takeOrder();
        }catch (UserInputException e) {
            System.err.println("Ошибка пользовательского ввода: "
                    + e.getMessage());
            e.printStackTrace();
        }

        try {
            UserFactory.createUser();
        } catch(UserInputException e) {
            System.err.println("Ошибка пользовательского ввода: "
                    + e.getMessage());
            e.printStackTrace();
        }
        Check.printCheck();
    }

    public static String takeOrder()
        throws UserInputException {

            Scanner sc = new Scanner(System.in);
            StringBuilder order = new StringBuilder();
            int choose = 1;
            System.out.println("Press 0, if you ready");
            while (choose != 0) {
                choose = sc.nextInt();
                if (choose < 6 && choose > 0) {
                    order.append(choose);
                    System.out.println(Menu.menu[choose - 1] + " has added");
                }
                if (choose > Menu.menu.length || choose < 0) {
                    throw new UserInputException("Не правильный ввод номера блюда");
                }
            }
            return order.toString();
        }
}
