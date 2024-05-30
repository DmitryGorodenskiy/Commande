package gorodenskiy.commande.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyActionListener implements ActionListener {
    private ArrayList<RoundButton> arrRoundButton;
    private JFrame frame;

    public MyActionListener(ArrayList<RoundButton> arrRoundButton, JFrame frame) {
        this.arrRoundButton = arrRoundButton;
        this.frame = frame;
    }

    public void actionPerformed(ActionEvent e) {
        //Код, который нужно выполнить при нажатии
        String lbl = e.getActionCommand();
        for (RoundButton rb : arrRoundButton) {
            if (rb.getText().equals(lbl)) {
                rb.setColor(new Color(0, 255, 0));
            } else {
                rb.setColor(new Color(193, 198, 196));
            }
        }
        JButton button = (JButton) e.getSource();
        frame.repaint();
    }
}