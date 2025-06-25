package guru.qa.JavaTest;

public class Main {
    public static void main(String[] args) {

        Calculator Calc = new Calculator();
        int res1 = Calc.getIntOperation();
        double res2 = Calc.getIntAndDouble();
        boolean res3 = Calc.getLogicOperation();
        float res4 = Calc.getSumTwoFloat();
        int res5 = Calc.getIntegerMore();
        System.out.print("Экономические расчеты:\n");
        System.out.println("a + (b * a) = " + res1);
        System.out.println("(d / a) - c = " + res2);
        System.out.println("c < b = " + res3);
        System.out.println("e + f = " + res4);
        System.out.println("g * 2 = " + res5);

    }
}



