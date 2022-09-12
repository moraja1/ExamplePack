package View;

import javax.swing.*;
import java.awt.*;

public class AboutWindow extends JDialog {
    private JPanel dialogPanel;
    public AboutWindow(JFrame owner){
        super(owner, "Nosotros",true);


        dialogPanel = new JPanel();
        JTextArea message = new JTextArea();
        message.setText("Este programa fué desarrollado en el curso de " +
                "\nprogramación 3 de la Universidad Nacional de " +
                "\nCosta Rica por: " +
                "\nJaison Mora Víquez" +
                "\nDaniel Sibaja Vindas" +
                "\nBrandon Alfaro Espinoza");
        this.setContentPane(dialogPanel);
        this.add(message);
        this.pack();
        this.setVisible(true);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
}
