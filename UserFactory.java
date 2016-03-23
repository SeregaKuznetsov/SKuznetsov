import java.util.Scanner;

public class UserFactory {

    public static int MAX_TRY = 10;


    public static User createUser()
            throws UserInputException{
        Scanner scanner = new Scanner(System.in);

        boolean hasInputNumber = false;
        boolean hasInputAdress = false;
        String inputNumber = null;
        String inputAdress = null;

        for (int tryIndex = 0; tryIndex<MAX_TRY && !hasInputNumber; tryIndex++) {
            try {

                inputNumber = getPhoneNumber(scanner);
                hasInputNumber = true;
                inputAdress = getAdress(scanner);
                hasInputAdress = true;
            }
            catch(UserInputException exception) {
                exception.printStackTrace();
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            }
        }
        if (inputNumber == null || inputAdress == null) {
            throw new UserInputException("Превышено количество "
                    + "попыток набора номера");
        }
        return new User();
    }

    private static String getPhoneNumber(Scanner scanner)
            throws UserInputException {
        String userInput = scanner.next();

        int inputSize = userInput.length();
        if (inputSize != 11 && inputSize != 7) {
            throw new UserInputException("Неправильная длина телефонного номера");
        }
        return userInput;
    }

    private static String getAdress(Scanner scanner)
            throws UserInputException {
        String userInput = scanner.next();

        for (int i = 0; i < userInput.length(); i++) {
            if (userInput.substring(i,i+2).equals("г.") || userInput.substring(i,i+5).equals("город")) {
                System.out.println(i);
                if (userInput.substring(i,i+3).equals("ул.") || userInput.substring(i,i+5).equals("улица")) {
                    System.out.println(i);
                    if (userInput.substring(i,i+3).equals("д.") || userInput.substring(i,i+3).equals("дом")) {
                        System.out.println(i);
                        if (userInput.substring(i,i+3).equals("кв.") || userInput.substring(i,i+8).equals("квартира")) {

                        }else throw new UserInputException("Отсутвует номер квартиры");
                    }else throw new UserInputException("Отсутвует номер дома");
                }else throw new UserInputException("Отсутвует название улицы");
            }else throw new UserInputException("Отсутвует название города");
        }
        return userInput;
    }

}