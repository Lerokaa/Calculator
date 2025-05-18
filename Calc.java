import java.util.Scanner;

public class Calc {
    int number1;
    int number2;
    char sign;
    int result;

    private InputHandler ih;
    private Base cBase;

    public Calc(Scanner scanner, Base base) {
        this.ih = new InputHandler(scanner);
        this.cBase = base;
    }

    private void getStatement(){
        System.out.println("Введите 2 числа");
        this.number1 = ih.getNumber(cBase.getRadix());
        this.sign = ih.getOperation();
        this.number2 = ih.getNumber(cBase.getRadix());
    }

    private int Solve() throws Exception{
        this.getStatement();

        switch (this.sign){
            case '+':{
                return (number1 + number2);
            }
            case '-':{
                return number1 - number2;
            }
            case '*':{
                return number1 * number2;
            }
            case '/':{
                if(number2!=0){
                    return number1 / number2;
                }
                else{
                    throw new Exception("Деление на 0");
                }
            }
        }
        return 0;
    }

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
            catch (Exception e) {
            System.out.println("Ошибка при выполнении операции: " + e.getMessage());
        }
    }
}

