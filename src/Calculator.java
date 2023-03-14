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

        for (String part : arr) {
            equation.add(new Operator(part));
        }
    }

    public void resetEquation() {
        equation.clear();
    }
}
