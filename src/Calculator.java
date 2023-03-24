import java.util.ArrayList;

public class Calculator {
    private final ArrayList<Operator> equation;

    public Calculator () {
        equation = new ArrayList<>();
    }

    public Calculator (String formula) {
        equation = new ArrayList<>();

        formatEquation(formula);
    }

    private void formatEquation (String formula) {
        Operator[] opr = {new Operator(""), new Operator(""), new Operator("")};
        StringBuilder strb = new StringBuilder();

        for (String str : formula.split("")) {
            opr[0] = new Operator(str);

            if (!str.equals(" ")) {
                try {
                    opr[1] = equation.get(equation.size() - 1);
                } catch (IndexOutOfBoundsException e) {
                    opr[1] = new Operator(" ");
                }

                try {
                    opr[2] = equation.get(equation.size() - 2);
                } catch (IndexOutOfBoundsException e) {
                    opr[2] = new Operator(" ");
                }

                if (opr[2].strCheck() && opr[1].getStr().equals("-")) {
                    strb.append(opr[1].getStr()).append(opr[0].getStr());
                    equation.set(equation.size() - 1, new Operator(strb));
                    strb.delete(0, strb.length());
                }
                else if (!opr[1].strCheck() && (!opr[0].strCheck() || opr[0].getStr().equals("."))) {
                    strb.append(opr[1].getStr()).append(opr[0].getStr());
                    equation.set(equation.size() - 1, new Operator(strb));
                    strb.delete(0, strb.length());
                }
                else {
                    equation.add(opr[0]);
                }
            }
        }
    }

    public boolean eqCheck () {
        return equation.isEmpty();
    }

    public String getAnswer () {
        return "\nThe answer is:\n" + getAnswer(equation);
    }

    private double getAnswer (ArrayList<Operator> temp) {
        ArrayList<Operator> eq = new ArrayList<>(temp), equ = new ArrayList<>();
        Operator[] PEMDAS = {new Operator("("), new Operator(")"), new Operator("^"), new Operator("*"),
                new Operator("x"), new Operator("/"), new Operator("+"), new Operator("-")};

        int index = -1;

        if (eq.contains(PEMDAS[0]) && eq.contains(PEMDAS[1])) {
            index = eq.indexOf(PEMDAS[0]);
        }
        else if (eq.contains(PEMDAS[2])) {
            index = eq.indexOf(PEMDAS[2]);
        }
        else if (eq.contains(PEMDAS[3])) {
            index = eq.indexOf(PEMDAS[3]);
        }
        else if (eq.contains(PEMDAS[4])) {
            index = eq.indexOf(PEMDAS[4]);
        }
        else if (eq.contains(PEMDAS[5])) {
            index = eq.indexOf(PEMDAS[5]);
        }
        else if (eq.contains(PEMDAS[6])) {
            index = eq.indexOf(PEMDAS[6]);
        }
        else if (eq.contains(PEMDAS[7])) {
            index = eq.indexOf(PEMDAS[7]);
        }

        if (index != -1) {
            if (eq.get(index).equals(PEMDAS[0])) {
                int i = index + 1;
                while (i <= eq.indexOf(PEMDAS[1])) {
                    equ.add(eq.get(i));
                    eq.remove(i);
                }

                eq.set(index, new Operator(getAnswer(equ)));
            }
            else {
                eq.set(index, new Operator(subVal(eq.get(index - 1), eq.get(index), eq.get(index + 1))));
                eq.remove(index + 1);
                eq.remove(index - 1);
            }

            return getAnswer(eq);
        }

        return eq.get(0).getNum();
    }

    public void clearEq () {
        equation.clear();
    }

    public String toString() {
        StringBuilder str;

        if (eqCheck())  {
            str = new StringBuilder("\nNo equation given");
        }
        else {
            str = new StringBuilder("\nThe current equation is:\n");

            for (Operator opr : equation)
                str.append(opr).append(" ");
        }
        return str.toString();
    }

    private double subVal (Operator... opr) {

        return switch (opr[1].toString()) {
            case "^" -> Math.pow(opr[0].getNum(), opr[2].getNum());
            case "*", "x" -> opr[0].getNum() * opr[2].getNum();
            case "/" -> opr[0].getNum() / opr[2].getNum();
            case "+" -> opr[0].getNum() + opr[2].getNum();
            case "-" -> opr[0].getNum() - opr[2].getNum();
            default -> 0;
        };
    }
}
