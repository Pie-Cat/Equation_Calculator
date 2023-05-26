import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Rectangle rect = new Rectangle(700,600);
        JFrame frame = new JFrame("Pie-Cat's Calculator");

        JPanel panel = new CalculatorPanel();
        frame.add(panel);

        frame.setSize(rect.getSize());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);
    }
}