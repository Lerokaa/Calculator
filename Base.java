import java.util.Scanner;

class Base
{
    private int radix = 10;
    private Scanner scanner;


    public int getRadix()
    {
        return radix;
    }

    public void setRadix(int newRadix) throws IllegalArgumentException {
        if (newRadix == 2 || newRadix == 8 || newRadix == 10 || newRadix == 16) {
            this.radix = newRadix;
        } else {
            throw new IllegalArgumentException("Ошибка: поддерживаются только системы счисления 2, 8, 10, 16");
        }
    }

    public Base(Scanner scanner) {
        this.scanner = scanner;
    }

    public void enterRadix()
    {
        while (true) {
            System.out.print("Введите систему счисления (2, 8, 10, 16): ");
            String input = scanner.nextLine().trim();

            try {
                int newRadix = Integer.parseInt(input);
                setRadix(newRadix);
                System.out.println("Система счисления изменена на " + getRadix());
                break;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введите целое число");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}