import java.util.ArrayList;

public class Calculator {
    private ArrayList<Operator> equation;

    public Calculator() {
        equation = new ArrayList<>();
    }

    public Calculator(String formula) {
        equation = new ArrayList<>();

        addEquation(formula.split(" "));
    }

    public void addEquation(String[] formula) {
        for (String value : formula)
            equation.add(new Operator(value));

        /*
        String temp = "";

        for (String part : arr) {
            try {
                Double.parseDouble(part);
                temp += part;
            } catch (NumberFormatException e) {
                if (temp != "") {
                    equation.add(new Operator(temp));
                    temp = "";
                } else if (part != " ") {
                    equation.add(new Operator(part));
                }
            }
        }
        */
    }

    public void resetEquation() {
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
        double num = 0;

        switch (opr[1].toString()) {
            case "^":
                num = Math.pow(opr[0].getNum(), opr[2].getNum());
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
        StringBuilder str = new StringBuilder("\nThe current equation is:\n");

        for (Operator opr : equation)
            str.append(opr + " ");

        return str.toString();
    }
}
