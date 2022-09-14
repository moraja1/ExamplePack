package ExamplePack;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FlowLayoutView {
    private JFrame frame;
    private JTabbedPane tabbedPane;
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private DefaultListModel<String> personasList;
    private JList<String> personas;
    private DefaultListModel<String> empresasList;
    private JList<String> empresas;
    private DefaultListModel<String> lugaresList;
    private JList<String> lugares;
    private JButton agregador;
    public FlowLayoutView(JFrame frame){
        this.frame = frame;
        //Creo el TabbedPane
        tabbedPane = new JTabbedPane();
        //Creo los paneles
        panel1 = new JPanel();
        panel2 = new JPanel();
        panel3 = new JPanel();
        //Agrego los paneles al tabbedPane
        tabbedPane.add("Personas", panel1);
        tabbedPane.add("Empresas", panel2);
        tabbedPane.add("Lugares", panel3);
        //Creo JList personas
        personasList = new DefaultListModel<>();
        personasList.addElement("Jorge Mora Sandoval"); personasList.addElement("Jaison Mora Víquez");
        personasList.addElement("Minor Vargas Viquez"); personasList.addElement("Carlos Azofeifa Brenes");
        personas = new JList<>(personasList);
        //Creo JList empresas
        empresasList = new DefaultListModel<>();
        empresasList.addElement("MicroServices"); empresasList.addElement("IT Development Masters");
        empresasList.addElement("Proper Intelligence"); empresasList.addElement("JatBrains");
        empresas = new JList<>(empresasList);
        //Creo JList lugares
        lugaresList = new DefaultListModel<>();
        lugaresList.addElement("Mexico"); lugaresList.addElement("Brazil");
        lugaresList.addElement("Alemania"); lugaresList.addElement("Holanda");
        lugares = new JList<>(empresasList);
        //Agrego un boton
        agregador = new JButton("Click me!");
        agregador.setBounds(450, 150, 100, 25);
        //Agrego las listas a los respectivos paneles y el boton
        panel1.add(personas);
        panel2.add(empresas);
        panel3.add(lugares);
        tabbedPane.setBounds(50, 50, 400, 200);
        frame.setLayout(null);
        frame.add(tabbedPane);
        frame.add(agregador);
        frame.setSize(new Dimension(600, 400));

        initComponents();
    }

    private void initComponents() {
        agregador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseAction();
            }
        });
        frame.getContentPane().repaint();
    }
    private void chooseAction() {
        int a = JOptionPane.showConfirmDialog(frame, "Desea agregar un nuevo Botton?");
        if(a == JOptionPane.YES_OPTION){
            JButton newButton = new JButton("Nuevo");
            ((JPanel)tabbedPane.getSelectedComponent()).add(new JButton("Soy nuevo"));
            frame.getContentPane().repaint();
        }
    }
}
