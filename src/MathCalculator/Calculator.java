package MathCalculator;

import java.util.ArrayList;

public class Calculator {
    private ArrayList<Object> equation;

    public Calculator () {
        equation = new ArrayList<>();
    }

    public Calculator (String formula) {
        equation = new ArrayList<>();

        addEquation(formula);
    }

    public void addEquation (String formula) {
        String[] parts = formula.split(" ");

        for (String part : parts) {
            try {
                equation.add(Double.parseDouble(part));
            } catch (NumberFormatException e) {
                equation.add(part);
            }
        }
    }

    public void resetEquation () {
        equation.clear();
    }

    public double getAnswer () {
        double answer = (double) equation.get(0);

        for (int i = 1; i < equation.size(); i++) {
            switch (equation.get(i - 1).toString()) {
                case "+":
                    answer += (double) equation.get(i);
                    break;

                case "-":
                    answer -= (double) equation.get(i);
                    break;

                case "*":
                    answer *= (double) equation.get(i);
                    break;

                case "/":
                    answer /= (double) equation.get(i);
                    break;
            }
        }

        return answer;
    }
}
