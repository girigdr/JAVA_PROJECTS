package JAVA_PROJECTS;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class TicTacToe {
    public static void main(String[] args) throws InterruptedException {
        new TicTac();
    }
}
class TicTac implements ActionListener {
    JFrame frame = new JFrame("TIC_TAC");
    JPanel panel = new JPanel();
    Random random = new Random();
    JLabel label = new JLabel("lets Start");
    JPanel bPanel = new JPanel();
    JButton[] button = new JButton[10];
    Boolean play;

    TicTac() throws InterruptedException {

        frame.setSize(300, 300);
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        label.setHorizontalAlignment(JLabel.CENTER);
        label.setFont(new Font("Mv Boli", Font.BOLD, 30));
        label.setBackground(Color.black);
        label.setOpaque(true);
        label.setForeground(new Color(0x969869));
        frame.add(label, BorderLayout.NORTH);

        panel.setLayout(new GridLayout(3, 3));
        for (int i = 1; i < 10; i++) {
            button[i] = new JButton();
            panel.add(button[i]);
            button[i].setFont(new Font("Mv Boli", Font.BOLD, 20));
            button[i].setBackground(new Color(0));
            button[i].addActionListener(this);
            button[i].setFocusable(false);
        }
        frame.add(panel);
        hii();
    }

    public void Check() throws InterruptedException {
        if (button[1].getText() == "X" && button[2].getText() == "X" & button[3].getText() == "X") {
            xWins(1, 2, 3);
        }
        if (button[4].getText() == "X" && button[5].getText() == "X" && button[6].getText() == "X") {
            xWins(4, 5, 6);
        }
        if (button[7].getText() == "X" && button[8].getText() == "X" && button[9].getText() == "X") {
            xWins(7, 8, 9);
        }
        if (button[1].getText() == "X" && button[4].getText() == "X" & button[7].getText() == "X") {
            xWins(1, 4, 7);
        }
        if (button[2].getText() == "X" && button[5].getText() == "X" && button[8].getText() == "X") {
            xWins(2, 5, 8);
        }
        if (button[3].getText() == "X" && button[6].getText() == "X" && button[9].getText() == "X") {
            xWins(3, 6, 9);
        }
        if (button[1].getText() == "X" && button[5].getText() == "X" & button[9].getText() == "X") {
            xWins(1, 5, 9);
        }
        if (button[7].getText() == "X" && button[5].getText() == "X" && button[3].getText() == "X") {
            xWins(7, 5, 3);
        }
        if (button[1].getText() == "O" && button[2].getText() == "O" & button[3].getText() == "O") {
            yWins(1, 2, 3);
        }
        if (button[4].getText() == "O" && button[5].getText() == "O" && button[6].getText() == "O") {
            yWins(4, 5, 6);
        }
        if (button[7].getText() == "O" && button[8].getText() == "O" && button[9].getText() == "O") {
            yWins(7, 8, 9);
        }
        if (button[1].getText() == "O" && button[4].getText() == "O" & button[7].getText() == "O") {
            yWins(1, 4, 7);
        }
        if (button[2].getText() == "O" && button[5].getText() == "O" && button[8].getText() == "O") {
            yWins(2, 5, 8);
        }
        if (button[3].getText() == "O" && button[6].getText() == "O" && button[9].getText() == "O") {
            yWins(3, 6, 9);
        }
        if (button[1].getText() == "O" && button[5].getText() == "O" & button[9].getText() == "O") {
            yWins(1, 5, 9);
        }
        if (button[7].getText() == "O" && button[5].getText() == "O" && button[3].getText() == "O") {
            yWins(7, 5, 3);
        }
    }

    public void xWins(int a, int b, int c) {
        button[a].setBackground(new Color(0x72BAD0));
        button[b].setBackground(new Color(0x72BAD0));
        button[c].setBackground(new Color(0x72BAD0));
        for (int i = 1; i < 10; i++) {
            button[i].setEnabled(false);
        }
        label.setText("X Wins...");
    }

    public void yWins(int a, int b, int c) {
        button[a].setBackground(new Color(0x72BAD0));
        button[b].setBackground(new Color(0x72BAD0));
        button[c].setBackground(new Color(0x72BAD0));
        for (int i = 1; i < 10; i++) {
            button[i].setEnabled(false);
        }
        label.setText("O Wins...");
    }
    public void hii() throws InterruptedException {
        Thread.sleep(2000);
        if (random.nextInt(2) == 1) {
            play = true;
            label.setText("X Turns");
        } else {
            play = false;
            label.setText("O Turns");
        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {

        for (int i = 1; i < 10; i++) {
            if (e.getSource() == button[i]) {
                if (play) {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0xFF0000));
                        button[i].setText("X");
                        play = false;
                        label.setText("O turns");
                        try {
                            Check();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                } else {
                    if (button[i].getText() == "") {
                        button[i].setForeground(new Color(0x00FF34));
                        button[i].setText("O");
                        play = true;
                        label.setText("X turns");
                        try {
                            Check();
                        } catch (InterruptedException ex) {
                            throw new RuntimeException(ex);
                        }
                    }
                }
            }
        }
    }
}
