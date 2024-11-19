package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class KalkulatorPanel extends JPanel {
    private final JTextField textField;
    private final String[] operator = {""};
    private final double[] num1 = {0};
    private final boolean[] isNewInput = {true};

    public KalkulatorPanel() {
        setLayout(null);
        setOpaque(false);

        textField = new JTextField();
        textField.setBounds(30, 40, 340, 50);
        textField.setEditable(false);
        textField.setFont(new Font("Arial", Font.BOLD, 24));
        add(textField);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBounds(30, 110, 340, 300);
        buttonPanel.setLayout(new GridLayout(4, 4, 10, 10));
        buttonPanel.setOpaque(false);

        String[] buttons = {
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+"
        };

        for (String text : buttons) {
            JButton button = new JButton(text);
            button.setFont(new Font("Arial", Font.BOLD, 20));
            buttonPanel.add(button);

            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    handleButtonClick(e.getActionCommand());
                }
            });
        }

        add(buttonPanel);
    }

    private void handleButtonClick(String command) {
        if (command.matches("\\d")) {
            if (isNewInput[0]) {
                textField.setText(command);
                isNewInput[0] = false;
            } else {
                textField.setText(textField.getText() + command);
            }
        } else if (command.equals("C")) {
            textField.setText("");
            operator[0] = "";
            num1[0] = 0;
            isNewInput[0] = true;
        } else if (command.equals("=")) {
            double num2 = Double.parseDouble(textField.getText());
            double result = 0;
            switch (operator[0]) {
                case "+" -> result = num1[0] + num2;
                case "-" -> result = num1[0] - num2;
                case "*" -> result = num1[0] * num2;
                case "/" -> result = num1[0] / num2;
            }
            textField.setText(String.valueOf(result));
            isNewInput[0] = true;
        } else {
            operator[0] = command;
            num1[0] = Double.parseDouble(textField.getText());
            isNewInput[0] = true;
        }
    }
}
