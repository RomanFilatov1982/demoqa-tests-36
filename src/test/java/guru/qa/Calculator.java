package guru.qa;

public class Calculator {
    int a = 6;
    int b = 24;
    int c = 12;
    double d = 85.6;

    float e = 3.40282350000000000000000000000000000000f;
    float f = 1.000000000000000000000000000000000003414f;
    int g = 2147483600;

    //применить несколько арифметических операций ( + , -, * , /) над двумя примитивами типа int
    public int getIntOperation() {
        int  calc1 = a + (b * a);
        return calc1;
    }
    //применить несколько арифметических операций над int и double в одном выражении
    public double getIntAndDouble() {
        double calc2 = (d / a) - c;
        return calc2;
    }


    //применить несколько логических операций ( < , >, >=, <= )
    public boolean getLogicOperation() {
        boolean calc3 = c < b;
        return calc3;
    }
    //прочитать про диапазоны типов данных для вещественных / чисел с плавающей точкой (какие максимальные и минимальные значения есть, как их получить) и переполнение
    public float getSumTwoFloat() {
        float calc4 = (e + f);
        return calc4;
    }
    //получить переполнение при арифметической операции
    public int getIntegerMore() {
        int calc5 = g * 2;
        return calc5;
    }
}