import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Calculator calc = new Calculator();

        boolean done = false;

        System.out.println("Welcome to Nic's Calculator");

        while (!done) {
            System.out.println("\nWhat would you like to do?\nFor commands type in 'Help'");

            switch (input.nextLine().toLowerCase()) {
                case "calculator", "1" -> {
                    System.out.println("\nPlease input the equation to be calculated");
                    calc = new Calculator(input.nextLine());
                }
                case "calculate", "2" -> {
                    if (calc.eqCheck()) {
                        System.out.println("\nPlease input the equation to be calculated");
                        calc = new Calculator(input.nextLine());
                    }

                    System.out.println(calc.getAnswer());
                }
                case "equation", "3" -> System.out.println(calc);
                case "reset", "clear", "4" -> {
                    calc.clearEq();
                    System.out.println("\nCalculator cleared");
                }
                case "help", "5" -> System.out.println("""

                        Help Page
                        1 - Calculator - Asks for equation
                        2 - Calculate - Solves given equation
                        3 - Equation - Returns given equation
                        4 - Reset/Clear - Clears calculator
                        5 - Help - Opens the help page
                        6 - Quit - Stops the calculator""");
                case "quit", "6" -> {
                    System.out.println("\nHave a nice day!");
                    done = true;
                }
                default -> System.out.println("\nSorry, invalid input");
            }
        }
    }
}