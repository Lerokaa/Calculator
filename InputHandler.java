import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Класс для обработки пользовательского ввода (чисел и операций)
 */
public class InputHandler {
    private Scanner scanner;

    public InputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    /**
     * Получает число от пользователя в указанной системе счисления
     * param radix система счисления (2, 8, 10, 16)
     * return введенное число
     */
    public int getNumber(int radix) {
        while (true) {
            System.out.print("Введите число: ");
            String input = scanner.next();

            try {
                // Проверяем допустимость символов для текущей системы счисления
                if (isValidForRadix(input, radix)) {
                    return Integer.parseInt(input, radix);
                } else {
                    System.out.println("Ошибка: число содержит недопустимые символы для " + radix + "-ной системы!");
                }
            } catch (NumberFormatException ex) {
                System.out.println("Ошибка: введите корректное число!");
            }
        }
    }

    private boolean isValidForRadix(String number, int radix) {
        String validChars;

        switch (radix) {
            case 2:
                validChars = "01";
                break;
            case 8:
                validChars = "01234567";
                break;
            case 10:
                validChars = "0123456789";
                break;
            case 16:
                validChars = "0123456789ABCDEFabcdef";
                break;
            default:
                return false;
        }

        for (char c : number.toCharArray()) {
            if (validChars.indexOf(c) == -1) {
                return false;
            }
        }
        return true;
    }

    /**
     * Получает арифметическую операцию от пользователя
     * return символ операции (+, -, *, /)
     */
    public char getOperation() {
        System.out.print("Введите знак операции (+, -, *, /): ");

        while (true) {
            String input = scanner.next();
            if (input.length() == 1) {
                char operator = input.charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    return operator;
                }
            }
            System.out.println("Ошибка: введите один из допустимых знаков (+, -, *, /)");
            System.out.print("Попробуйте снова: ");
        }
    }

     /**
     * Закрывает Scanner (вызывать при завершении работы)
     */
    public void close() {
        scanner.close();
    }
}
