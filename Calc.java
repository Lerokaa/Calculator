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
        String currentRadixResult;
        
        // Получаем представление результата в текущей системе счисления
        switch (currentRadix) {
            case 2:
                currentRadixResult = resultB;
                break;
            case 8:
                currentRadixResult = resultO;
                break;
            case 16:
                currentRadixResult = resultH;
                break;
            default: // Для 10-чной системы и других (если будут добавлены)
                currentRadixResult = resultD;
                break;
        }
        System.out.println("\nРезультат выполнения:");
        
        // Сначала выводим в текущей системе счисления
        System.out.println("В выбранной системе (" + currentRadix + "): " + currentRadixResult);
        
        // Затем выводим во всех остальных системах
        System.out.println("Bin: " + resultB);
        System.out.println("Oct: " + resultO);
        System.out.println("Dec: " + resultD);
        System.out.println("Hex: " + resultH);
    }


}

