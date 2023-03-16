import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please input the equation to be calculated");

        Calculator calc = new Calculator(input.nextLine());

        System.out.println(calc);

        System.out.println(calc.getAnswer());

        System.out.println(calc);
    }
}