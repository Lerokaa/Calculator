public class Calc {
    Menu menu;
    int system;
    int number1;
    int number2;
    char sign;
    int result;


    public Calc() {
        menu = new Menu();
    }

    public void  showMenu() throws Exception{
        System.out.println("Выберите систему счисления ");
        this.setSystem(menu.showMenu());
    }

    private void setSystem(int system){
        this.system = system;
    }

    private void getStatement(){
        System.out.println("Введите 2 числа");
        this.number1 = menu.getNumber(system);
        this.sign = menu.getSign();
        this.number2 = menu.getNumber(system);
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

    public void getResult () throws Exception{
        result = this.Solve();
        String resultB = Integer.toBinaryString(result);
        String resultO = Integer.toOctalString(result);
        String resultH = Integer.toHexString(result);

        System.out.println("Bin: " + resultB + "  Oct: "+resultO + "  Dec: " + result + "  Hex: " + resultH);
    }





}
