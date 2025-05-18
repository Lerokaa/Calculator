import java.util.Scanner;
import java.util.InputMismatchException;

/**
 * Класс для обработки пользовательского ввода (чисел и операций)
 */
public class InputHandler {
    private Scanner scanner;

    public InputHandler() {
        this.scanner = new Scanner(System.in);
    }

    /**
     * Получает число от пользователя в указанной системе счисления
     * @param radix система счисления (2, 8, 10, 16)
     * @return введенное число
     */
    public int getNumber(int radix) {
        while (true) {
            try {
                System.out.print("Введите число: ");
                return scanner.nextInt(radix);
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка: введите корректное число для системы счисления " + radix);
                scanner.nextLine(); // Очистка буфера сканера
            }
        }
    }

    /**
     * Получает арифметическую операцию от пользователя
     * @return символ операции (+, -, *, /)
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