package ExamplePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class CardLayoutView {

    private JFrame frame;
    private CardLayout card;
    private JButton btn1, btn2, btn3;
    private Container container;

     public CardLayoutView(JFrame frame){
         this.frame = frame;
         container = frame.getContentPane();

         card=new CardLayout(40,30);
         container.setLayout(card);

         btn1 = new JButton("House");
         btn2 = new JButton("Person");
         btn3 = new JButton("Key");

         container.add(btn1);
         container.add(btn2);
         container.add(btn3);

         initComponents();

         frame.setSize(new Dimension(600, 500));

     }

    private void nextPane() {
        card.next(container);
    }

    private void initComponents() {
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPane();
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPane();
            }
        });
        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nextPane();
            }
        });
    }
}