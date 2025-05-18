import java.util.Scanner;

public class Menu {

    Scanner scanner = new Scanner(System.in);
    Base currentBase = new Base();

    public void showMenu()
    {
        System.out.println("Инженерный калькулятор");
        System.out.println("Поддерживаемые системы счисления: 2, 8, 10, 16");
        System.out.println("Текущая система счисления: " + currentBase.getRadix());

        while (true)
        {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    enterRadix();
                    break;
                case "2":
                    // performCalculation();
                    break;
                case "3":
                    System.out.println("Выход из калькулятора.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }

        }
    }

    private void enterRadix()
    {
        while (true) {
            System.out.print("Введите систему счисления (2, 8, 10, 16): ");
            String input = scanner.nextLine().trim();

            try {
                int newRadix = Integer.parseInt(input);
                currentBase.setRadix(newRadix);
                System.out.println("Система счисления изменена на " + currentBase.getRadix());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }


    public void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Сменить систему счисления");
        System.out.println("2. Выполнить вычисления");
        System.out.println("3. Выход");
        System.out.println("Текущая система счисления: " + currentBase.getRadix());
        System.out.print("Выберите действие: ");
    }
}
