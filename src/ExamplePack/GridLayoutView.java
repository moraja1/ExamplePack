package ExamplePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GridLayoutView {
    private JFrame frame;
    private JLabel name;
    private JTextField txtName;
    private String[] comboList;
    private JComboBox colorsComboBox;
    private JTextArea txtShow;
    JButton show;
    JButton erase;

    public GridLayoutView(JFrame frame){
        this.frame = frame;
        frame.setLayout(new GridLayout(3, 2, 15, 15));
        name = new JLabel("Nombre:");
        txtName = new JTextField();
        comboList = new String[]{"Rojo", "Azul", "Verde", "Violeta", "Negro"};
        colorsComboBox = new JComboBox(comboList);
        txtShow = new JTextArea();
        txtShow.setEditable(false);
        show = new JButton("Mostrar");
        erase = new JButton("Borrar");
        frame.add(name);
        frame.add(txtName);
        frame.add(colorsComboBox);
        frame.add(show);frame.add(txtShow);
        frame.add(erase);
        frame.repaint();
        frame.setSize(600, 400);

        initComponents();
    }
    private void initComponents() {
        colorsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)colorsComboBox.getSelectedItem()){
                    case "Rojo":
                        txtShow.setForeground(Color.RED);
                        break;
                    case "Azul":
                        txtShow.setForeground(Color.BLUE);
                        break;
                    case "Verde":
                        txtShow.setForeground(Color.GREEN);
                        break;
                    case "Violeta":
                        txtShow.setForeground(Color.MAGENTA);
                        break;
                    case "Negro":
                        txtShow.setForeground(Color.BLACK);
                        break;
                }
            }
        });
        show.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorsComboBox.getActionListeners()[0].actionPerformed(e);
                txtShow.setText(txtName.getText());
            }
        });
        erase.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtShow.setText("");
                txtName.setText("");
                colorsComboBox.setSelectedIndex(0);
            }
        });

        frame.getContentPane().repaint();
    }
}
