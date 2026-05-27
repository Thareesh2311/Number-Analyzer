import javax.swing.*;
import java.awt.event.*;

public class NumberAnalyzer extends JFrame implements ActionListener {

    JLabel titleLabel;
    JLabel numberLabel;
    JTextField numberField;

    JButton analyzeButton;
    JButton clearButton;
    JButton exitButton;

    JTextArea resultArea;

    NumberAnalyzer() {

        setTitle("Number Analyzer");
        setSize(500, 450);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titleLabel = new JLabel("NUMBER ANALYZER");
        titleLabel.setBounds(170, 20, 200, 30);
        add(titleLabel);

        numberLabel = new JLabel("Enter Number:");
        numberLabel.setBounds(50, 80, 120, 30);
        add(numberLabel);

        numberField = new JTextField();
        numberField.setBounds(170, 80, 200, 30);
        add(numberField);

        analyzeButton = new JButton("Analyze");
        analyzeButton.setBounds(50, 140, 100, 35);
        add(analyzeButton);

        clearButton = new JButton("Clear");
        clearButton.setBounds(180, 140, 100, 35);
        add(clearButton);

        exitButton = new JButton("Exit");
        exitButton.setBounds(310, 140, 100, 35);
        add(exitButton);

        resultArea = new JTextArea();
        resultArea.setBounds(50, 210, 360, 150);
        resultArea.setEditable(false);
        add(resultArea);

        analyzeButton.addActionListener(this);
        clearButton.addActionListener(this);
        exitButton.addActionListener(this);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == analyzeButton) {

            int num = Integer.parseInt(numberField.getText());

            int original = num;
            int reverse = 0;
            int sum = 0;
            int armstrong = 0;

            while (num > 0) {

                int digit = num % 10;

                // Sum of digits
                sum = sum + digit;

                // Reverse number
                reverse = reverse * 10 + digit;

                // Armstrong calculation
                armstrong = armstrong + (digit * digit * digit);

                num = num / 10;
            }

            String result = "";

            result += "===== NUMBER ANALYSIS =====\n\n";

            result += "Sum of Digits: " + sum + "\n";

            result += "Reverse Number: " + reverse + "\n";

            if (original == reverse) {
                result += "Palindrome Number\n";
            } else {
                result += "Not a Palindrome Number\n";
            }

            if (original == armstrong) {
                result += "Armstrong Number\n";
            } else {
                result += "Not an Armstrong Number\n";
            }

            resultArea.setText(result);
        }

        else if (e.getSource() == clearButton) {

            numberField.setText("");
            resultArea.setText("");
        }

        else if (e.getSource() == exitButton) {

            JOptionPane.showMessageDialog(
                    this,
                    "Thank You!"
            );

            System.exit(0);
        }
    }

    public static void main(String[] args) {

        new NumberAnalyzer();
    }
}