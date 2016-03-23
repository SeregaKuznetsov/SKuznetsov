import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu.menu[0] = "Roast beef";
        Menu.menu[1] = "Burger";
        Menu.menu[2] = "Cheescake";
        Menu.menu[3] = "Spagetti";
        Menu.menu[4] = "Beer";

        System.out.println("Welcome in own cafe!");
        System.out.println("What would you want to eat?");
        Menu.showMenu();
        try {
            takeOrder();
        }catch (UserInputException e) {

        }

        try {
            UserFactory.createUser();
        } catch(UserInputException e) {
            System.err.println("Ошибка пользовательского ввода: "
                    + e.getMessage());
            e.printStackTrace();
        }
    }

    private static String takeOrder(Scanner sc) {
            throws UserInputException {

            StringBuilder order = new StringBuilder();
            int choose = 1;
            System.out.println("Press 0, if you ready");
            while (choose != 0) {
                choose = sc.nextInt();
                if (choose > Menu.menu.length + 1 || choose < 0) {
                    throw new UserInputException("Не правильный ввод номера блюда");
                }
                order.append(choose);

            }
            String completedOrder = order.toString();
            return completedOrder;
        }
    }
}
