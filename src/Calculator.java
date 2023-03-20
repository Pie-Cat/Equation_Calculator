import java.util.ArrayList;
import java.util.Scanner;

public class Calculator {
    private final ArrayList<Operator> equation;

    public Calculator(String formula) {
        equation = new ArrayList<>();

        formatEquation(formula.split(""));
    }

    public void addEquation (String formula) {
        formatEquation(formula.split(""));
    }

    private void formatEquation (String[] formula) {
        Scanner scan;
        StringBuilder strb = new StringBuilder();
        int index = 0;

        for (int i = 0; i < formula.length; i++) {
            switch (formula[i]) {
                case "(", ")", "^", "*", "/", "+", "-" -> {
                    equation.add(new Operator(formula[i]));
                    formula[i] = " ";
                }
                default -> strb.append(formula[i]);
            }
        }

        while (strb.length() > 0) {
            System.out.println(strb);
            scan = new Scanner(strb.toString());
            equation.add(index, new Operator(scan.nextDouble()));

            if (strb.indexOf(" ") != -1)
                strb.delete(0, strb.indexOf(" ") + 2);
            else
                strb.delete(0, strb.length());

            index += 2;
        }
    }

    public void resetEquation () {
        equation.clear();
    }

    public String getAnswer () {
        return "\nThe answer is: " + getAnswer(equation) + "\n";
    }

    private double getAnswer (ArrayList<Operator> temp) {
        ArrayList<Operator> eq = new ArrayList<>(temp);

        int index = -1;

        if (eq.contains(new Operator("^"))) {
            index = eq.indexOf(new Operator("^"));
        } else if (eq.contains(new Operator("*"))) {
            index = eq.indexOf(new Operator("*"));
        } else if (eq.contains(new Operator("/"))) {
            index = eq.indexOf(new Operator("/"));
        } else if (eq.contains(new Operator("+"))) {
            index = eq.indexOf(new Operator("+"));
        } else if (eq.contains(new Operator("-"))) {
            index = eq.indexOf(new Operator("-"));
        }

        if (index != -1) {
            eq.set(index, new Operator(subVal(eq.get(index - 1), eq.get(index), eq.get(index + 1))));
            eq.remove(index + 1);
            eq.remove(index - 1);

            return getAnswer(eq);
        }

        return eq.get(0).getNum();
    }

    private double subVal (Operator... opr) {

        return switch (opr[1].toString()) {
            case "^" -> Math.pow(opr[0].getNum(), opr[2].getNum());
            case "*" -> opr[0].getNum() * opr[2].getNum();
            case "/" -> opr[0].getNum() / opr[2].getNum();
            case "+" -> opr[0].getNum() + opr[2].getNum();
            case "-" -> opr[0].getNum() - opr[2].getNum();
            default -> 0;
        };
    }

    public String toString() {
        StringBuilder str = new StringBuilder("\nThe current equation is:\n");

        for (Operator opr : equation)
            str.append(opr).append(" ");

        return str.toString();
    }
}
