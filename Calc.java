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

    public void getResult() throws Exception {
        result = this.Solve();

        // Получаем представления результата в разных системах счисления
        String resultB = Integer.toBinaryString(result);
        String resultO = Integer.toOctalString(result);
        String resultH = Integer.toHexString(result);
        String resultD = Integer.toString(result);

        // Определяем текущую систему счисления
        int currentRadix = cBase.getRadix();

        System.out.println("\nРезультат выполнения:");

        // Выводим результат в текущей системе счисления
        switch (currentRadix) {
            case 2:
                System.out.println("Bin (2): " + resultB);
                System.out.println("Oct (8): " + resultO);
                System.out.println("Dec (10): " + resultD);
                System.out.println("Hex (16): " + resultH);
                break;
            case 8:
                System.out.println("Oct (8): " + resultO);
                System.out.println("Bin (2): " + resultB);
                System.out.println("Dec (10): " + resultD);
                System.out.println("Hex (16): " + resultH);
                break;
            case 16:
                System.out.println("Hex (16): " + resultH);
                System.out.println("Bin (2): " + resultB);
                System.out.println("Oct (8): " + resultO);
                System.out.println("Dec (10): " + resultD);
                break;
            default: // Для 10-чной системы
                System.out.println("Dec (10): " + resultD);
                System.out.println("Bin (2): " + resultB);
                System.out.println("Oct (8): " + resultO);
                System.out.println("Hex (16): " + resultH);
        }
    }
}

