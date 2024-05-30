package gorodenskiy.commande.graphics;

import gorodenskiy.commande.Supervisor;

import javax.swing.*;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import java.awt.*;
import java.util. ArrayList;


public class Pult extends JFrame {
    private String[] textFieldStrings;
    private int buttonsCount;
    private String textOut;
    private ArrayList<RoundButton> arrRoundButton;
    private JTextPane pane;
    private Supervisor supervisor;

    public Pult(String[] textFieldStrings, int buttonsCount, Supervisor supervisor) {
        this.textFieldStrings = textFieldStrings;
        this.buttonsCount = buttonsCount;
        arrRoundButton = new ArrayList<>();
        pane = new JTextPane();
        this.supervisor = supervisor;
    }

    public void myCreateAndShowAPI(JFrame frame) {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setPreferredSize(new Dimension(1580,850));
        frame.getContentPane().setLayout(new GridBagLayout());
        makePultContainer(frame);
        makePortContainer(frame);
        makeMessagesPanel(frame);
        frame.pack();
        frame.setVisible(true);
    }

    private void makeMessagesPanel(JFrame frame) {
        SimpleAttributeSet attributeSet = new SimpleAttributeSet();
        StyleConstants.setFontSize(attributeSet, 16);
        StyleConstants.setForeground(attributeSet, Color.black);
        pane.setCharacterAttributes(attributeSet, true);
        pane.setText(textOut);
        GridBagConstraints contr = new GridBagConstraints();
        contr.fill = GridBagConstraints.BOTH;
        contr.gridx = 3;
        contr.gridy = 0;
        contr.anchor = GridBagConstraints.WEST;
        contr.weightx = 19.9;
        contr.weighty = 1.0;
        contr.insets = new Insets(10, 0, 10, 10);
        contr.gridwidth = 4;
        contr.gridheight = 4;//GridBagConstraints.REMAINDER;//
        frame.add(pane, contr);
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
        addLabelTextRows(labels, ports, true, arrRoundButton, frame, supervisor);
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
        addLabelTextRows(labels, textControlsPane, false, arrRoundButton, frame, supervisor);
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
    private void addLabelTextRows(JLabel[] labels, Container pane, boolean circle, ArrayList<RoundButton> arrRoundButton, JFrame frame, Supervisor supervisor) {
        JButton button;
        MyActionListener myActionListener = new MyActionListener(arrRoundButton, frame, supervisor);
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

    public void setTextOut(String textOut) {
        this.textOut = textOut;
        String intext = pane.getText();
        pane.setText(intext +"\n" + textOut);
    }
}