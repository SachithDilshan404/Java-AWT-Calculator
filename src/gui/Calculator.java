package gui;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class close extends WindowAdapter {

    public void windowClosing(WindowEvent we) {
        System.exit(0);
    }
}

class Cal implements ActionListener {

    TextField tf;
    Button b1, b2, b3, b4, b5, b6, b7, b8, b9, b10, b11, b12, b13, b14, b15, b16, b17, b18, b19, b20, b21, b22, b23, b24;
    double num1, num2, result;
    String operator;

    Cal() {
        Frame f = new Frame();
        Color forColor = new Color(31, 27, 36);
        Color bgColor = new Color(18, 18, 18);
        Color btnTextColor = Color.WHITE;
        Color btnColor = Color.BLUE;

        f.addWindowListener(new close());
        f.setBackground(Color.BLACK);
        f.setTitle("My Calculator");
        f.setResizable(false);
        f.setSize(400, 600);
        f.setLocationRelativeTo(null);

        Font f1 = new Font("Montserrat", Font.BOLD, 30);
        Font f2 = new Font("Quicksand", Font.BOLD, 30);
        Font f3 = new Font("Quicksand", Font.BOLD, 40);

        MenuBar mb = new MenuBar();
        Menu m1 = new Menu("View");
        MenuItem mi = new MenuItem("Standard");
        m1.add(mi);
        mb.add(m1);

        f.setMenuBar(mb);

        Panel p1 = new Panel();
        Panel p2 = new Panel();
        GridLayout g1 = new GridLayout(6, 4, 4, 4);
        p2.setLayout(g1);
        p2.setBackground(bgColor);

        tf = new TextField(15);
        tf.setFont(f3);
        tf.setEditable(true);
        tf.setForeground(Color.WHITE);
        tf.setBackground(forColor);
        tf.setText("0");

        p1.add(tf);

        b1 = createStyledButton("%", forColor, btnTextColor, f1);
        b2 = createStyledButton("CE", forColor, btnTextColor, f1);
        b3 = createStyledButton("C", forColor, btnTextColor, f1);
        b4 = createStyledButton("<=", forColor, btnTextColor, f1);
        b5 = createStyledButton("1∕x", forColor, btnTextColor, f1);
        b6 = createStyledButton("x²", forColor, btnTextColor, f1);
        b7 = createStyledButton("²√", forColor, btnTextColor, f1);
        b8 = createStyledButton("÷", forColor, btnTextColor, f1);
        b9 = createStyledButton("7", forColor, btnTextColor, f1);
        b10 = createStyledButton("8", forColor, btnTextColor, f1);
        b11 = createStyledButton("9", forColor, btnTextColor, f1);
        b12 = createStyledButton("x", forColor, btnTextColor, f1);
        b13 = createStyledButton("4", forColor, btnTextColor, f1);
        b14 = createStyledButton("5", forColor, btnTextColor, f1);
        b15 = createStyledButton("6", forColor, btnTextColor, f1);
        b16 = createStyledButton("-", forColor, btnTextColor, f1);
        b17 = createStyledButton("1", forColor, btnTextColor, f1);
        b18 = createStyledButton("2", forColor, btnTextColor, f1);
        b19 = createStyledButton("3", forColor, btnTextColor, f1);
        b20 = createStyledButton("+", forColor, btnTextColor, f1);
        b21 = createStyledButton("±", forColor, btnTextColor, f1);
        b22 = createStyledButton("0", forColor, btnTextColor, f1);
        b23 = createStyledButton(".", forColor, btnTextColor, f1);
        b24 = createStyledButton("=", btnColor, btnTextColor, f1);

        p2.add(b1);
        p2.add(b2);
        p2.add(b3);
        p2.add(b4);
        p2.add(b5);
        p2.add(b6);
        p2.add(b7);
        p2.add(b8);
        p2.add(b9);
        p2.add(b10);
        p2.add(b11);
        p2.add(b12);
        p2.add(b13);
        p2.add(b14);
        p2.add(b15);
        p2.add(b16);
        p2.add(b17);
        p2.add(b18);
        p2.add(b19);
        p2.add(b20);
        p2.add(b21);
        p2.add(b22);
        p2.add(b23);
        p2.add(b24);

        f.add(p1, BorderLayout.NORTH);
        f.add(p2, BorderLayout.SOUTH);
        f.setVisible(true);
    }

    private Button createStyledButton(String text, Color bgColor, Color textColor, Font font) {
        Button button = new Button(text);
        button.setBackground(bgColor);
        button.setForeground(textColor);
        button.setFont(font);
        button.addActionListener(this);
        return button;
    }

    @Override
    public void actionPerformed(ActionEvent d) {
        Object o = d.getSource();
        String text = tf.getText();

        if (o instanceof Button) {
            String label = ((Button) o).getLabel();

            if ("0123456789".contains(label)) {
                if (text.equals("0")) {
                    tf.setText(label);
                } else {
                    tf.setText(text + label);
                }
            } else if (label.equals(".")) {
                if (!text.contains(".")) {
                    tf.setText(text + label);
                }
            } else if (label.equals("C")) {
                tf.setText("0");
                num1 = num2 = result = 0;
                operator = "";
            } else if (label.equals("CE")) {
                tf.setText("0");
            } else if (label.equals("<=")) {
                tf.setText(text.length() > 1 ? text.substring(0, text.length() - 1) : "0");
            } else if ("+-x÷".contains(label)) {
                num1 = Double.parseDouble(text);
                operator = label;
                tf.setText("0");
            } else if (label.equals("=")) {
                num2 = Double.parseDouble(text);
                result = calculate(num1, num2, operator);
                tf.setText(String.valueOf(result));
                num1 = result;
            } else if (label.equals("±")) {
                tf.setText(String.valueOf(-1 * Double.parseDouble(text)));
            } else if (label.equals("%")) {
                num1 = Double.parseDouble(text) / 100;
                tf.setText(String.valueOf(num1));
            } else if (label.equals("1∕x")) {
                num1 = 1 / Double.parseDouble(text);
                tf.setText(String.valueOf(num1));
            } else if (label.equals("x²")) {
                num1 = Math.pow(Double.parseDouble(text), 2);
                tf.setText(String.valueOf(num1));
            } else if (label.equals("²√")) {
                num1 = Math.sqrt(Double.parseDouble(text));
                tf.setText(String.valueOf(num1));
            }
        }
    }

    private double calculate(double num1, double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "x":
                return num1 * num2;
            case "÷":
                if (num2 != 0) {
                    return num1 / num2;
                } else {
                    tf.setText("Error");
                    return 0;
                }
            default:
                return 0;
        }
    }
}

public class Calculator {

    public static void main(String[] args) {
        new Cal();
    }
}
