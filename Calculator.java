import java.util.Scanner;

public class Calculator {

    private static int currentBase = 10;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)
    {
        System.out.println("Инженерный калькулятор");
        System.out.println("Поддерживаемые системы счисления: 2, 8, 10, 16");
        System.out.println("Текущая система счисления: " + currentBase);

        while (true)
        {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    currentBase = ChangeNumberSystem.changeNumberSystem(currentBase);
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




    private static void printMenu() {
        System.out.println("\nМеню:");
        System.out.println("1. Сменить систему счисления");
        System.out.println("2. Выполнить вычисления");
        System.out.println("3. Выход");
        System.out.println("Текущая система счисления: " + currentBase);
        System.out.print("Выберите действие: ");
    }

}
