import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

public class CalculatorPanel extends JPanel {

  private final String[] userOptions = {"New Equation", "Solve Equation", "Clear Calculator", "Help Page", "Edit Equation"};
  private final JButton[] buttons = new JButton[4];
  private final Dimension d = new Dimension(20,20);
  private final JLabel equationText = new JLabel("No Equation");
  private Calculator calc;

  public CalculatorPanel () {
    setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    setBackground(Color.WHITE);

    panelSetup();
    interfaceSetup();
  }

  private void panelSetup () {
    JPanel titlePanel = new JPanel();
    JLabel title = new JLabel("Pie-Cat's Calculator");
    title.setForeground(Color.BLACK);
    title.setFont(new Font("TNR", Font.BOLD,30));
    titlePanel.setPreferredSize(new Dimension(700,50));
    titlePanel.setBorder(new LineBorder(Color.BLACK,5));
    titlePanel.add(title, CENTER_ALIGNMENT);

    JPanel interfacePanel = new JPanel();
    interfacePanel.setLayout(new BoxLayout(interfacePanel, BoxLayout.X_AXIS));
    interfacePanel.setPreferredSize(new Dimension(700,500));
    interfacePanel.setBackground(Color.WHITE);

    JPanel separationPanel = new JPanel();
    separationPanel.setLayout(new BoxLayout(separationPanel, BoxLayout.Y_AXIS));
    separationPanel.setBackground(Color.WHITE);

    JPanel equationPanel = new JPanel();
    equationPanel.setPreferredSize(new Dimension(700,50));
    equationPanel.setBackground(Color.GRAY);
    equationText.setForeground(Color.BLACK);
    equationText.setFont(new Font("TNR", Font.PLAIN,20));
    equationPanel.add(equationText);


    JPanel buttonPanel = new JPanel(new GridLayout(2,2));
    buttonPanel.setPreferredSize(new Dimension(700,450));
    for (int i = 0; i < buttons.length; i++)
    {
      buttons[i] = new JButton(userOptions[i]);
      buttons[i].setFont(new Font("TNR", Font.PLAIN,30));
      buttons[i].setBackground(Color.YELLOW);
      buttonPanel.add(buttons[i]);
    }

    separationPanel.add(equationPanel);
    separationPanel.add(Box.createRigidArea(d));
    separationPanel.add(buttonPanel);

    interfacePanel.add(Box.createRigidArea(d));
    interfacePanel.add(separationPanel);
    interfacePanel.add(Box.createRigidArea(d));

    add(titlePanel);
    add(Box.createRigidArea(d));
    add(interfacePanel);
    add(Box.createRigidArea(d));
  }

  private void interfaceSetup () {
    calc = new Calculator();

    buttons[0].addActionListener(e -> {
      if (calc.eqCheck()) {
        calc = new Calculator(JOptionPane.showInputDialog(null,"Equation Edit", calc.getEq()));
        equationText.setText(calc.getEq());
      }
      else {
        calc = new Calculator(JOptionPane.showInputDialog("Please input the new equation below"));
        equationText.setText(calc.getEq());
        buttons[0].setText(userOptions[4]);
      }
    });
    buttons[1].addActionListener(e -> {
      int answer = -1;
      if (calc.eqCheck()) {
        answer = JOptionPane.showConfirmDialog(this, calc,"Solve this equation?\n" + calc.getEq(), JOptionPane.YES_NO_OPTION);
      }
      else {
        JOptionPane.showMessageDialog(this,"No equation to solve");
      }

      if (answer == 0)
        JOptionPane.showMessageDialog(this, calc.getAnswer());
    });
    buttons[2].addActionListener(e -> {
      if (calc.eqCheck()) {
        equationText.setText("No Equation");
        JOptionPane.showMessageDialog(this, calc.clearEq());
        buttons[0].setText(userOptions[0]);
      }
      else {
        JOptionPane.showMessageDialog(this,"No equation to clear");
      }
    });
    buttons[3].addActionListener(e -> JOptionPane.showMessageDialog(null, """

      New Equation - Asks for new equation
      Edit Equation - Edits current equation
      Solve Equation - Solves current equation
      Clear Calculator - Clears calculator
      Help Page - Opens the help page
      X - Stops the program""",
      "Help Page", JOptionPane.INFORMATION_MESSAGE));
  }
}