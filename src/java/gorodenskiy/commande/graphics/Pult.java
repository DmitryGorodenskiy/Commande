package gorodenskiy.commande.graphics;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;


public class Pult extends JFrame {
    private String[] textFieldStrings;
    private int buttonsCount;
    private ArrayList<RoundButton> arrRoundButton;
    public Pult(String[] textFieldStrings, int buttonsCount) {
        this.textFieldStrings = textFieldStrings;
        this.buttonsCount = buttonsCount;
        arrRoundButton = new ArrayList<>();
    }
    public void myCreateAndShowAPI(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1580,850));
        frame.getContentPane().setLayout(new GridBagLayout());
        makePultContainer(frame);
        makePortContainer(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void makePortContainer(JFrame frame) {
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(250, 400));
        JLabel[] labels = new JLabel[buttonsCount];
        JPanel ports = new JPanel();
        ports.setBorder(BorderFactory.createTitledBorder("Состояние портов"));
        container.add(ports, BorderLayout.NORTH);
        for (int i = 0; i < buttonsCount; i++) {
            if (i < textFieldStrings.length) {
                labels[i] = new JLabel(textFieldStrings[i]);
            } else {
                labels[i] = new JLabel("");
            }
        }
        addLabelTextRows(labels, ports, true, arrRoundButton, frame);
        GridBagConstraints contc = new GridBagConstraints();
        contc.gridwidth = 3;
        contc.gridheight = 3;
        contc.weightx = 0.0;
        contc.weighty = 0.0;
        contc.insets = new Insets(10, 10, 10, 10);
        contc.gridx = 2;
        contc.gridy = 1;
        contc.anchor = GridBagConstraints.SOUTHWEST;
        frame.getContentPane().add(container, contc);
    }

    private void makePultContainer(JFrame frame) {
        JPanel container = new JPanel();
        container.setPreferredSize(new Dimension(250, 400));
        JLabel[] labels = new JLabel[buttonsCount];
        JPanel textControlsPane = new JPanel();
        textControlsPane.setBorder(BorderFactory.createTitledBorder("Упрощенный пульт управления"));
        for (int i = 0; i < buttonsCount; i++) {
            if (i < textFieldStrings.length) {
                labels[i] = new JLabel(textFieldStrings[i]);
            } else {
                labels[i] = new JLabel("");
            }
        }
        addLabelTextRows(labels, textControlsPane, false, arrRoundButton, frame);
        container.add(textControlsPane, BorderLayout.WEST);
        GridBagConstraints contc = new GridBagConstraints();
        contc.gridwidth = 3;
        contc.gridheight = 3;
        contc.gridx = 0;
        contc.gridy = 0;
        contc.weightx = 0.5;
        contc.weighty = 0.5;
        contc.anchor = GridBagConstraints.NORTHWEST;
        contc.insets = new Insets(10, 10, 10, 10);
        frame.getContentPane().add(container, contc);
    }
    private void addLabelTextRows(JLabel[] labels, Container pane, boolean circle, ArrayList<RoundButton> arrRoundButton, JFrame frame) {
        JButton button; MyActionListener myActionListener = new MyActionListener(arrRoundButton, frame);
        pane.setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        int numLabels = labels.length;
        for (int i = 0; i < numLabels; i++) {
            String nm = Integer.toString(i);
            if (circle) {
                button = new RoundButton("on" + Integer.toString(i));
                arrRoundButton.add((RoundButton) button);
            } else {
                button = new JButton("on");
                button.addActionListener(myActionListener);
                button.setActionCommand("on" + Integer.toString(i));
            }
            c.fill = GridBagConstraints.HORIZONTAL;
            c.gridx = 0;
            c.gridy = i;
            c.insets.left = 5;
            c.insets.right = 5;
            c.insets.top = 5;
            c.insets.bottom = 5;
            pane.add(labels[i], c);
            c.gridx = 1;
            pane.add(button, c);
            if (circle) {
                button = new RoundButton("off" + Integer.toString(i));
                arrRoundButton.add((RoundButton) button);
            } else {
                button = new JButton("off");
                button.addActionListener(myActionListener);
                button.setActionCommand("off" + Integer.toString(i));
            }
            c.gridx = 2;
            pane.add(button, c);
        }
        if (circle) {
            button = new RoundButton("on" + Integer.toString(numLabels));
            arrRoundButton.add((RoundButton) button);
        } else {
            button = new JButton("on");
            button.addActionListener(myActionListener);
            button.setActionCommand("on" + Integer.toString(numLabels));
        }
        c.gridx = 0;
        c.gridy = numLabels;
        pane.add(button, c);
        if (circle) {
            button = new RoundButton("off" + Integer.toString(numLabels)); arrRoundButton.add((RoundButton) button);
        } else {
            button = new JButton("off");
            button.addActionListener(myActionListener);
            button.setActionCommand("off" + Integer.toString(numLabels));
        }
        c.gridx = 1;
        c.gridwidth = 2;
        pane.add(button, c);
    }
}