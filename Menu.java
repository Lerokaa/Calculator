import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private Base currentBase;
    private Calc calc;

    public Menu() {
        this.scanner = new Scanner(System.in);
        this.currentBase = new Base(scanner);
        this.calc = new Calc(scanner, currentBase);
    }

    public void showMenu()
    {
        System.out.println("Калькулятор");
        System.out.println("Поддерживаемые системы счисления: 2, 8, 10, 16");
        System.out.println("Текущая система счисления: " + currentBase.getRadix());

        while (true)
        {
            printMenu();
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    currentBase.enterRadix();
                    break;
                case "2":
                    try {
                        calc.getResult();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                    break;
                case "3":
                    System.out.println("Выход из калькулятора.");
                    return;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
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
