import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserFactory {

    public static final int MAX_TRY = 10;


    public static User createUser()
            throws UserInputException{
        Scanner scanner = new Scanner(System.in);

        int tryIndex = 0;
        boolean hasInputNumber = false;
        boolean hasInputAddress = false;
        boolean hasInputName = false;
        boolean hasInputCard = false;

        while (tryIndex<MAX_TRY && !hasInputAddress) {
            try {
                User.address = getAddress(scanner);
                hasInputAddress = true;
            } catch (UserInputException exception) {
                tryIndex++;
                exception.printStackTrace();
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            } finally {
                if (tryIndex == MAX_TRY) {
                    throw new UserInputException("Превышено количество "
                            + "попыток набора данных");
                }
            }
        }

        while (tryIndex<MAX_TRY && !hasInputName) {
            try {
                User.name = getName(scanner);
                hasInputName = true;
            } catch (UserInputException exception) {
                tryIndex++;
                exception.printStackTrace();
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            } finally {
                if (tryIndex == MAX_TRY) {
                    throw new UserInputException("Превышено количество "
                            + "попыток набора данных");
                }
            }
        }

        while (tryIndex<MAX_TRY && !hasInputCard) {
            try {
                User.card = getCard(scanner);
                hasInputCard = true;
            } catch (UserInputException exception) {
                tryIndex++;
                exception.printStackTrace();
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            } finally {
                if (tryIndex == MAX_TRY) {
                    throw new UserInputException("Превышено количество "
                            + "попыток набора данных");
                }
            }
        }

        while (tryIndex<MAX_TRY && !hasInputNumber) {
            try {
                User.phoneNumber = getPhoneNumber(scanner);
                hasInputNumber = true;
            } catch (UserInputException exception) {
                tryIndex++;
                exception.printStackTrace();
                System.err.println("Неправильный ввод данных: "
                        + exception.getMessage());
            } finally {
                if (tryIndex == MAX_TRY) {
                    throw new UserInputException("Превышено количество "
                            + "попыток набора данных");
                }
            }
        }

        return new User();
    }

    private static String getPhoneNumber(Scanner scanner)
            throws UserInputException {
        System.out.println("Please enter your number");
        String userInput = scanner.next();

        int inputSize = userInput.length();
        if (inputSize != 11 && inputSize != 7) {
            throw new UserInputException("Неправильная длина телефонного номера");
        }
        return userInput;
    }

    private static String getAddress(Scanner scanner)
            throws UserInputException {
        System.out.println("Enter your address");
        String address = scanner.nextLine();
        boolean hasTown = false;
        boolean hasStreet = false;
        boolean hasHouse = false;
        boolean hasFlat = false;


        if (address.length() > 9) {
            for (int i = 0; i < address.length()-4; i++) {
                if (address.substring(i, i + 5).equals("город"))
                    hasTown = true;
            }
            for (int i = 0; i < address.length()-4; i++) {
                if (address.substring(i, i + 5).equals("улица"))
                    hasStreet = true;
            }
            for (int i = 0; i < address.length()-2; i++) {
                if (address.substring(i, i + 3).equals("дом"))
                    hasHouse = true;
            }
            for (int i = 0; i < address.length()-7; i++) {
                if (address.substring(i, i + 8).equals("квартира"))
                    hasFlat = true;
            }
            for (int i = 0; i < address.length()-1; i++) {
                if (address.substring(i, i + 2).equals("г."))
                    hasTown = true;
            }
            for (int i = 0; i < address.length()-2; i++) {
                if (address.substring(i, i + 3).equals("ул."))
                    hasStreet = true;
            }
            for (int i = 0; i < address.length()-1; i++) {
                if (address.substring(i, i + 2).equals("д."))
                    hasHouse = true;
            }
            for (int i = 0; i < address.length()-2; i++) {
                if (address.substring(i, i + 3).equals("кв."))
                    hasFlat = true;
            }
        } else throw new UserInputException("Недопустимая минимальная длина адреса");
        if (!hasTown || !hasStreet || !hasHouse || !hasFlat) {
            System.out.println(" Town " + hasTown + " Street " + hasStreet + " hasHouse " + hasHouse + " Flat " + hasFlat);
            throw new UserInputException("Неправильный ввод адреса");
        }

        return address;
    }

    private static String getName(Scanner scanner)
            throws UserInputException {
        System.out.println("Enter your name and soname");
        String name = scanner.nextLine();
        if (name.length() > 1) {
            if(!name.matches("^\\D*$")){
                throw new UserInputException("Имя не должно содержать чесел");
            }
        }else throw new UserInputException("Длина имени не может быть короче 1 символа");

        return name;
    }

    private static String getCard(Scanner scanner)
            throws UserInputException {
        System.out.println("Enter number of your card");
        System.out.println("Example : 1233-1231-1233-1231-123");
        String card = scanner.nextLine();
        String patternForCardNumbers = "(([\\d]{4})-){4}[\\d]{3}";
        Pattern pattern = Pattern.compile(patternForCardNumbers);
        Matcher matcher = pattern.matcher(card);

        if (!matcher.matches()) {
            throw new UserInputException("Неправильный формат карточки");
        }
        return card;
    }




}
