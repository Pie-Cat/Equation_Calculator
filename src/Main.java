import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        String[] userOptions = {"New Equation", "Solve Equation", "Show Equation", "Edit Equation", "Clear Calculator",
                "Help Page", "Quit"};
        String response;
        boolean done = false;
        int opt = 5;

        Calculator calc = new Calculator();

        while (!done) {
            response = (String) JOptionPane.showInputDialog(null, "What do you want to do?",
                    "Calculator Menu", JOptionPane.QUESTION_MESSAGE, null, userOptions, userOptions[opt]);

            if (response == null) {
              response = "Quit";
            }

            switch (response) {
                case "New Equation" -> {
                    opt = 1;

                    calc = new Calculator(JOptionPane.showInputDialog(null,
                        "Please input the equation to be calculated", "Calculator",
                        JOptionPane.QUESTION_MESSAGE));
                }
                case "Solve Equation" -> {
                    opt = 3;

                    if (calc.eqCheck()) {
                        calc = new Calculator(JOptionPane.showInputDialog(null,
                            "Please input the equation to be calculated","Calculator",
                            JOptionPane.QUESTION_MESSAGE));
                    }

                    JOptionPane.showMessageDialog(null, calc.getAnswer(),"Calculator",
                        JOptionPane.INFORMATION_MESSAGE);
                }
                case "Show Equation" -> {
                    opt = 1;

                    JOptionPane.showMessageDialog(null, calc,"Calculator",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case "Edit Equation" -> {
                    opt = 1;

                    calc = new Calculator(JOptionPane.showInputDialog(null,"Equation Edit",
                        calc.getEq()));
                }
                case "Clear Calculator" -> {
                    opt = 0;

                    JOptionPane.showMessageDialog(null, calc.clearEq(),"Calculator",
                            JOptionPane.INFORMATION_MESSAGE);
                }
                case "Help Page" -> {
                    opt = 0;

                    JOptionPane.showMessageDialog(null, """
                    
                        New Equation - Asks for new equation
                        Solve Equation - Solves given equation
                        Show Equation - Returns given equation
                        Clear Calculator - Clears calculator
                        Help Page - Opens the help page
                        Quit/Cancel - Stops the calculator""",
                        "Help Page", JOptionPane.INFORMATION_MESSAGE);
                }
                default -> {
                    JOptionPane.showMessageDialog(null,"Have a nice day!","Calculator",
                        JOptionPane.INFORMATION_MESSAGE);

                    done = true;
                }
            }
        }
    }
}