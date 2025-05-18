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
    
    public void getResult() {
            try {
                InputHandler handler = new InputHandler(scanner);
                System.out.print("Введите систему счисления (2/8/10/16): ");
                int radix = Integer.parseInt(scanner.nextLine());
        
                int a = handler.getNumber(radix, "Введите первое число: ");
                String sign = handler.getSign("Введите знак операции (+ - * /): ");
                int b = handler.getNumber(radix, "Введите второе число: ");
        
                int result = solve(a, b, sign);
        
                System.out.println("Результат:");
                System.out.println("2: " + Integer.toBinaryString(result));
                System.out.println("8: " + Integer.toOctalString(result));
                System.out.println("10: " + result);
                System.out.println("16: " + Integer.toHexString(result));
            } 
            catch (Exception e) 
            {
                System.out.println("Ошибка при выполнении операции: " + e.getMessage());
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
        while (true) {
            System.out.print("Введите знак операции (+, -, *, /): ");
            String input = scanner.nextLine().trim(); // Изменили на nextLine()

            if (input.length() == 1) {
                char operator = input.charAt(0);
                if (operator == '+' || operator == '-' || operator == '*' || operator == '/') {
                    return operator;
                }
            }
            System.out.println("Ошибка: введите один из допустимых знаков (+, -, *, /)");
        }
    }

     /**
     * Закрывает Scanner (вызывать при завершении работы)
     */
    public void close() {
        scanner.close();
    }
}
