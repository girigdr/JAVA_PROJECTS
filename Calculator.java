package JAVA_PROJECTS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator implements ActionListener {

    JTextField field;
    JButton[] num_Button = new JButton[10];
    JButton addB, subB, mulB, divB, decB, clrB, delB, negB, eqB;
    JButton[] fun_Button = new JButton[9];
    JPanel panel;
    double num_1 = 0, num_2 = 1, result = 0;
    char oper;
    Font mine = new Font("MV Boli", Font.BOLD, 15);

    public static void main(String[] args) {
        new Calculator();
    }

    Calculator() {
        JFrame frame = new JFrame("CALCULATOR");
        frame.setSize(320, 420);
        frame.setResizable(false);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);
        field = new JTextField();
        field.setBounds(20, 20, 260, 40);
        field.setEditable(false);
        field.setFont(new Font("MV Boli", Font.BOLD, 30));

        addB = new JButton("+");
        subB = new JButton("-");
        mulB = new JButton("*");
        divB = new JButton("/");
        decB = new JButton(".");
        delB = new JButton("DELETE");
        clrB = new JButton("CLEAR");
        negB = new JButton("(-)");
        eqB = new JButton("=");

        fun_Button[0] = addB;
        fun_Button[1] = subB;
        fun_Button[2] = mulB;
        fun_Button[3] = divB;
        fun_Button[4] = decB;
        fun_Button[5] = eqB;
        fun_Button[6] = clrB;
        fun_Button[7] = delB;
        fun_Button[8] = negB;

        for (int j = 0; j < 9; j++) {

            fun_Button[j].addActionListener(this);
            fun_Button[j].setFont(mine);
            fun_Button[j].setFocusable(false);

        }

        for (int i = 0; i < 10; i++) {
            num_Button[i] = new JButton(String.valueOf(i));
            num_Button[i].addActionListener(this);
            num_Button[i].setFont(mine);
            num_Button[i].setFocusable(false);

        }

        panel = new JPanel();
        // panel.setBackground(Color.black);
        panel.setLayout(new GridLayout(4, 4, 10, 10));
        panel.setBounds(20, 70, 260, 260);

        panel.add(num_Button[1]);
        panel.add(num_Button[2]);
        panel.add(num_Button[3]);
        panel.add(addB);
        panel.add(num_Button[4]);
        panel.add(num_Button[5]);
        panel.add(num_Button[6]);
        panel.add(subB);
        panel.add(num_Button[7]);
        panel.add(num_Button[8]);
        panel.add(num_Button[9]);
        panel.add(mulB);
        panel.add(decB);
        panel.add(num_Button[0]);
        panel.add(eqB);
        panel.add(divB);

        negB.setBounds(20, 340, 60, 30);
        clrB.setBounds(77, 340, 105, 30);
        delB.setBounds(180, 340, 100, 30);

        frame.add(clrB);
        frame.add(delB);
        frame.add(negB);
        frame.add(field);
        frame.add(panel);

        frame.setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < 10; i++) {
            if (e.getSource() == num_Button[i]) {
                field.setText(field.getText().concat(String.valueOf(i)));
            }
        }
        if (e.getSource() == delB) {
            String name = field.getText();
            field.setText("");
            for (int i = 0; i < name.length() - 1; i++) {
                field.setText(field.getText() + name.charAt(i));
            }
        }
        if (e.getSource() == clrB) {
            field.setText("");

        }

        if (e.getSource() == negB) {
            Double temp = Double.parseDouble(field.getText());
            temp *= -1;
            field.setText(String.valueOf(temp));

        }

        if (e.getSource() == addB) {
            num_1 = Double.parseDouble(field.getText());
            oper = '+';
            field.setText("");
        }
        if (e.getSource() == mulB) {
            num_1 = Double.parseDouble(field.getText());
            oper = '*';
            field.setText("");
        }
        if (e.getSource() == subB) {
            num_1 = Double.parseDouble(field.getText());
            oper = '-';
            field.setText("");
        }
        if (e.getSource() == divB) {
            num_1 = Double.parseDouble(field.getText());
            oper = '/';
            field.setText("");
        }

        if (e.getSource() == eqB) {
            num_2 = Double.parseDouble(field.getText());
            switch (oper) {
                case '+':
                    result = num_1 + num_2;
                    break;
                case '-':
                    result = num_1 - num_2;
                    break;
                case '*':
                    result = num_1 * num_2;
                    break;
                case '/':
                    result = num_1 / num_2;
                    break;
            }
            field.setText(String.valueOf(result));
            num_1 = result;
        }
        if (e.getSource() == decB) {
            field.setText(field.getText().concat("."));
        }
    }
}
