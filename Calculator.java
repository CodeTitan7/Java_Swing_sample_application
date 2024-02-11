import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

class Calculator extends JFrame implements ActionListener {
    static JFrame frame;
    static JTextField displayField;
    String num1, op, num2;

    Calculator() {
        num1 = op = num2 = "";
    }

    public static void main(String args[]) {
        frame = new JFrame("Calculator");

        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        Calculator calculator = new Calculator();
        displayField = new JTextField(16);
        displayField.setEditable(false);

        JButton btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, 
        btnAdd, btnSubtract, btnDivide,btnMultiply, btnDot, btnClear, btnEquals;

        btn0 = new JButton("0");
        btn1 = new JButton("1");
        btn2 = new JButton("2");
        btn3 = new JButton("3");
        btn4 = new JButton("4");
        btn5 = new JButton("5");
        btn6 = new JButton("6");
        btn7 = new JButton("7");
        btn8 = new JButton("8");
        btn9 = new JButton("9");

        btnEquals = new JButton("=");
        btnAdd = new JButton("+");
        btnSubtract = new JButton("-");
        btnDivide = new JButton("/");
        btnMultiply = new JButton("*");
        btnClear = new JButton("C");
        btnDot = new JButton(".");

        JPanel panel = new JPanel();

        btnMultiply.addActionListener(calculator);
        btnDivide.addActionListener(calculator);
        btnSubtract.addActionListener(calculator);
        btnAdd.addActionListener(calculator);
        btn9.addActionListener(calculator);
        btn8.addActionListener(calculator);
        btn7.addActionListener(calculator);
        btn6.addActionListener(calculator);
        btn5.addActionListener(calculator);
        btn4.addActionListener(calculator);
        btn3.addActionListener(calculator);
        btn2.addActionListener(calculator);
        btn1.addActionListener(calculator);
        btn0.addActionListener(calculator);
        btnDot.addActionListener(calculator);
        btnClear.addActionListener(calculator);
        btnEquals.addActionListener(calculator);

        panel.add(displayField);
        panel.add(btnAdd);
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btnSubtract);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        panel.add(btnMultiply);
        panel.add(btn7);
        panel.add(btn8);
        panel.add(btn9);
        panel.add(btnDivide);
        panel.add(btnDot);
        panel.add(btn0);
        panel.add(btnClear);
        panel.add(btnEquals);

        panel.setBackground(Color.cyan);

        frame.add(panel);

        frame.setSize(200, 220);
        frame.show();
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();

        if ((action.charAt(0) >= '0' && action.charAt(0) <= '9') || action.charAt(0) == '.') {
            if (!op.equals(""))
                num2 = num2 + action;
            else
                num1 = num1 + action;
            displayField.setText(num1 + op + num2);
        } else if (action.charAt(0) == 'C') {
            num1 = op = num2 = "";
            displayField.setText(num1 + op + num2);
        } else if (action.charAt(0) == '=') {
            double result;
            if (op.equals("+"))
                result = (Double.parseDouble(num1) + Double.parseDouble(num2));
            else if (op.equals("-"))
                result = (Double.parseDouble(num1) - Double.parseDouble(num2));
            else if (op.equals("/"))
                result = (Double.parseDouble(num1) / Double.parseDouble(num2));
            else
                result = (Double.parseDouble(num1) * Double.parseDouble(num2));
            displayField.setText(num1 + op + num2 + "=" + result);
            num1 = Double.toString(result);
            op = num2 = "";
        } else {
            if (op.equals("") || num2.equals(""))
                op = action;
            else {
                double result;
                if (op.equals("+"))
                    result = (Double.parseDouble(num1) + Double.parseDouble(num2));
                else if (op.equals("-"))
                    result = (Double.parseDouble(num1) - Double.parseDouble(num2));
                else if (op.equals("/"))
                    result = (Double.parseDouble(num1) / Double.parseDouble(num2));
                else
                    result = (Double.parseDouble(num1) * Double.parseDouble(num2));
                num1 = Double.toString(result);
                op = action;
                num2 = "";
            }
            displayField.setText(num1 + op + num2);
        }
    }
}
