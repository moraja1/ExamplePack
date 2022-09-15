package ExamplePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BorderLayoutView {

    private JFrame frame;
    private JButton northBtn;
    private JButton westBtn;

    public BorderLayoutView(JFrame frame){
        frame = new JFrame();
        frame.setLayout(new BorderLayout());
        northBtn = new JButton("North");
        westBtn = new JButton("West");
        JPanel p = new JPanel();
        p.setBackground(Color.GREEN);
        JLabel southLabel = new JLabel("Label located on the south part of the layout");

        frame.add(northBtn,BorderLayout.NORTH);
        frame.add(new JScrollBar(),BorderLayout.EAST);
        frame.add(westBtn,BorderLayout.WEST);
        frame.add(p,BorderLayout.CENTER);
        frame.add(southLabel,BorderLayout.SOUTH);

            initComponents();
        frame.setVisible(true);

    }

    private void initComponents() {

        northBtn.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseAction();
            }
        });

    }
    private void chooseAction() {
        int a = JOptionPane.showConfirmDialog(frame, "This button is located in the north parth of the layout");

    }


}
