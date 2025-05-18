

class Base
{
    private int radix = 10;

    public int getRadix()
    {
        return radix;
    }

    public void setRadix(int newRadix) {
        // Можно добавить проверку
        if (newRadix == 2 || newRadix == 8 || newRadix == 10 || newRadix == 16) {
            this.radix = newRadix;
        } else {
            System.out.println("Ошибка: поддерживаются только системы счисления 2, 8, 10, 16");
        }
    }


    public Base()
    {

    }
}