import java.util.Scanner;

class  ChangeNumberSystem
{
    private static Scanner scanner = new Scanner(System.in);

    public static int changeNumberSystem(int currentBase) {
        System.out.println("\nТекущая система счисления: " + currentBase);
        System.out.print("Введите новую систему счисления (2, 8, 10, 16): ");
        String input = scanner.nextLine().trim();

        try {
            int newBase = Integer.parseInt(input);
            if (newBase == 2 || newBase == 8 || newBase == 10 || newBase == 16) {
                System.out.println("Система счисления изменена на " + newBase);
                return newBase;
            } else {
                System.out.println("Ошибка: поддерживаются только системы счисления 2, 8, 10, 16");
            }
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите число");
        }

        // Если что-то пошло не так, возвращаем старую систему счисления
        return currentBase;
    }

    private ChangeNumberSystem()
    {}
}