package ExamplePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class GridBagLayoutView {

    private JFrame frame;
    private String[] comboList;
    private JComboBox colorsComboBox;
    private JButton borrar;
    private JButton mostrar;
    private JButton guardar;
    private DefaultListModel personasList;// = new DefaultListModel();
    private ArrayList personas;// = new ArrayList<>();
    private JList lista;
    private JTextField campoTexto;

    public GridBagLayoutView(JFrame frame)
    {
        this.frame = frame;
        frame.setLayout(new GridBagLayout());
        personasList = new DefaultListModel();
        personas = new ArrayList<>();
        
        GridBagConstraints constraints = new GridBagConstraints();

        lista = new JList();
        lista.setModel(personasList);
        constraints.gridx = 0; // El área de texto empieza en la columna cero.
        constraints.gridy = 0; // El área de texto empieza en la fila cero
        constraints.gridwidth = 2; // El área de texto ocupa dos columnas.
        constraints.gridheight = 2; // El área de texto ocupa 2 filas.
        constraints.fill = GridBagConstraints.BOTH;
        constraints.weighty = 1.0; // La fila 0 debe estirarse, le ponemos un 1.0
        frame.add(lista,constraints);
        constraints.weighty = 0.0; // Restauramos al valor por defecto, para no afectar a los siguientes componentes.

        comboList = new String[]{"Rojo", "Azul", "Verde", "Violeta", "Negro"};
        colorsComboBox = new JComboBox (comboList);
        constraints.gridx = 2;
        constraints.gridy = 0;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.NORTH;// El botón 1 debe ocupar la posición NORTH de su celda
        constraints.fill = GridBagConstraints.BOTH;
        frame.add (colorsComboBox, constraints);
        constraints.anchor = GridBagConstraints.CENTER;// Restauramos al valor por defecto, para no afectar a los siguientes componentes.
        constraints.weighty = 0.0;

        mostrar = new JButton ("Mostrar Lista");
        constraints.gridx = 2;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weighty = 1.0;
        constraints.anchor = GridBagConstraints.CENTER;
        constraints.fill = GridBagConstraints.NONE;
        frame.add (mostrar, constraints);
        constraints.anchor = GridBagConstraints.CENTER;// Restauramos valores por defecto.
        constraints.weighty = 0.0;


        borrar = new JButton ("Borrar");
        constraints.gridx = 0;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add (borrar, constraints);

        guardar = new JButton ("Guardar");
        constraints.gridx = 2;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        frame.add (guardar, constraints);

        campoTexto = new JTextField ("Escriba su Nombre");
        constraints.gridx = 1;
        constraints.gridy = 2;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.weightx = 1.0;// El campo de texto debe estirarse sólo en horizontal.
        constraints.fill = GridBagConstraints.HORIZONTAL;
        frame.add (campoTexto, constraints);

        frame.setSize(601, 401);

        initComponents();

    }
    private void initComponents() {
        colorsComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                switch ((String)colorsComboBox.getSelectedItem()){
                    case "Rojo":
                        lista.setForeground(Color.RED);
                        break;
                    case "Azul":
                        lista.setForeground(Color.BLUE);
                        break;
                    case "Verde":
                        lista.setForeground(Color.GREEN);
                        break;
                    case "Violeta":
                        lista.setForeground(Color.MAGENTA);
                        break;
                    case "Negro":
                        lista.setForeground(Color.BLACK);
                        break;
                }
            }
        });

        guardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                   personas.add(campoTexto.getText());
                   JOptionPane.showMessageDialog(null, "Nombre Guardado");
            }
        });
        mostrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                colorsComboBox.getActionListeners()[0].actionPerformed(e);
                personasList.removeAllElements();
                 for(int i = 0; i< personas.size();i++){
                     personasList.addElement(personas.get(i));
                 }
            }
        });
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                personasList.removeAllElements();
                lista.setModel(personasList);
                campoTexto.setText("");
                colorsComboBox.setSelectedIndex(4);
            }
        });

        frame.getContentPane().repaint();
    }

}
