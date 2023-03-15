import java.util.ArrayList;

public class Calculator {
    private ArrayList<Operator> equation;

    public Calculator() {
        equation = new ArrayList<>();
    }

    public Calculator(String formula) {
        equation = new ArrayList<>();

        addEquation(formula);
    }

    public void addEquation(String formula) {
        String[] arr = formula.split(" ");

        for (String part : arr)
            equation.add(new Operator(part));
    }

    public void resetEquation() {
        equation.clear();
    }

    public double getAnswer () {
        return getAnswer(equation);
    }

    private double getAnswer (ArrayList<Operator> eq) {
        int index = -1;

        System.out.println(eq.indexOf(new Operator("+")));

        if (eq.contains("^")) {
            index = eq.indexOf("^");
            System.out.println(index + " | ^");
        } else if (eq.contains("*")) {
            index = eq.indexOf("*");
            System.out.println(index + " | *");
        } else if (eq.contains("/")) {
            index = eq.indexOf("/");
            System.out.println(index + " | /");
        } else if (eq.contains("+")) {
            index = eq.indexOf("+");
            System.out.println(index + " | +");
        } else if (eq.contains("-")) {
            index = eq.indexOf("-");
            System.out.println(index + " | -");
        }

        System.out.println(index);

        if (index != -1) {
            subVal(eq.get(index - 1), eq.get(index), eq.get(index + 1));

            for (int i = index - 1; i < index + 2; i++)
                System.out.println(eq.get(i));
        }

        return 0.0;
    }

    private double subVal (Operator... opr) {
        double num = 0;

        switch (opr[1].toString()) {
            case "^":
                num = Math.pow(opr[0].getNum(), (Double) opr[2].getNum());
                break;
            case "*":
                num = opr[0].getNum() * opr[2].getNum();
                break;
            case "/":
                num = opr[0].getNum() / opr[2].getNum();
                break;
            case "+":
                num = opr[0].getNum() + opr[2].getNum();
                break;
            case "-":
                num = opr[0].getNum() - opr[2].getNum();
                break;
        }

        return num;
    }

    public String toString() {
        StringBuilder str = new StringBuilder("The current equation is:\n");

        for (Operator opr : equation)
            str.append(opr + " ");

        return str.toString();
    }
}
