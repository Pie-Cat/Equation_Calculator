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

    public double getAnswer() {
        return Double.parseDouble(getAnswer(equation));
    }

    private String getAnswer(StringBuilder str) {
        double num1 = 0.0, num2 = 0.0;
        int index = 0;

        if (str.indexOf("*") != -1) {
            index = str.indexOf("*");
            num1 = Double.parseDouble(str.substring(index - 1, index));
            num2 = Double.parseDouble(str.substring(index + 1, index + 2));

            str.replace(index - 1, index + 1, num1 * num2 + "");
        }

        return str.toString();
    }

    private String substitute (String[] str) {
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
