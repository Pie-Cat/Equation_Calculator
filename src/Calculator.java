public class Calculator {
    private StringBuilder equation;

    public Calculator() {
        equation = new StringBuilder();
    }

    public Calculator(String formula) {
        equation = new StringBuilder();

        addEquation(formula);
    }

    public void addEquation(String formula) {
        String[] arr = formula.split(" ");

        for (String part : arr)
            equation.append(part);
    }

    public void resetEquation() {
        equation.delete(0, equation.length() - 1);
    }

    public String getAnswer() {
        return getAnswer(equation);
    }

    /*
    public double getAnswer() {
        return Double.parseDouble(getAnswer(equation));
    }
    */

    private String getAnswer(StringBuilder str) {
        String operator = "";
        boolean done = false;
        int index = 0;

        while (!done) {
            System.out.println(str.toString());

            if (str.indexOf("^") != -1) {
                index = str.indexOf("^");

                str.replace(index - 1, index + 2, substitute(str.substring(index - 1, index), "^", str.substring(index + 1, index + 2)));
            } else if (str.indexOf("*") != -1) {
                index = str.indexOf("*");

                str.replace(index - 1, index + 2, substitute(str.substring(index - 1, index), "*", str.substring(index + 1, index + 2)));
            } else if (str.indexOf("/") != -1) {
                index = str.indexOf("/");

                str.replace(index - 1, index + 2, substitute(str.substring(index - 1, index), "/", str.substring(index + 1, index + 2)));
            } else if (str.indexOf("+") != -1) {
                index = str.indexOf("+");

                str.replace(index - 1, index + 2, substitute(str.substring(index - 1, index), "+", str.substring(index + 1, index + 2)));
            } else if (str.indexOf("-") != -1) {
                index = str.indexOf("-");

                str.replace(index - 1, index + 2, substitute(str.substring(index - 1, index), "-", str.substring(index + 1, index + 2)));
            } else {
                done = true;
            }
        }

        return str.toString();
    }

    private String substitute (String... str) {
        StringBuilder substitution = new StringBuilder();

        double num1 = Double.parseDouble(str[0]), num2 = Double.parseDouble(str[2]);

        switch (str[1]) {
            case "^":
                substitution.append(Math.pow(num1, num2));
                break;
            case "*":
                substitution.append(num1 * num2);
                break;
            case "/":
                substitution.append(num1 / num2);
                break;
            case "+":
                substitution.append(num1 + num2);
                break;
            case "-":
                substitution.append(num1 - num2);
                break;
        }

        return substitution.toString();
    }
}
