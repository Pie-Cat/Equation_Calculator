import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        boolean done = false;

        Calculator calc = new Calculator();

        System.out.println("Welcome to Nic's Calculator");

        while (!done) {
            System.out.println("\nWhat would you like to do?\nFor commands type in 'Help'");

            switch (input.nextLine()) {
                case "Calculator" -> {
                    System.out.println("\nPlease input the equation to be calculated");
                    calc = new Calculator(input.nextLine());
                }
                case "Calculate" -> {
                    if (calc.eqCheck()) {
                        System.out.println("\nPlease input the equation to be calculated");
                        calc = new Calculator(input.nextLine());
                    }

                    System.out.println(calc.getAnswer());
                }
                case "Equation" -> System.out.println(calc);
                case "Reset", "Clear" -> {
                    calc.clearEq();
                    System.out.println("Calculator cleared");
                }
                case "Help" -> System.out.println("""

                        Help Page
                        Calculator - Asks for equation
                        Calculate - Solves given equation
                        Equation - Returns given equation
                        Reset/Clear - Clears calculator
                        Help - Opens the help page
                        Quit - Stops the calculator""");
                case "Quit" -> {
                    System.out.println("\nHave a nice day!");
                    done = true;
                }
            }
        }
    }
}