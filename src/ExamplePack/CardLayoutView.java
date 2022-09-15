package ExamplePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;


public class CardLayoutView extends JFrame {

     private CardLayout card;
    private JButton btn1, btn2, btn3;

    private Container container;

     public CardLayoutView(){
         container = getContentPane();

         card=new CardLayout(40,30);

         container.setLayout(card);

         btn1 = new JButton("House");
         btn2 = new JButton("Person");
         btn3 = new JButton("Key");

         btn1.addActionListener((ActionListener) this);
         btn2.addActionListener((ActionListener) this);
         btn3.addActionListener((ActionListener) this);

         container.add("a",btn1);
         container.add("b",btn2);
         container.add("c",btn3);

         initComponents();

     }

    private void initComponents() {
         card.next(container);
    }


}