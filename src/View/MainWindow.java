package View;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Vector;

public class MainWindow extends JFrame {
    private AboutWindow aboutWindow;
    private JPanel mainPanel;
    private JMenuBar menu_bar;
    private JMenu home;
    private JMenuItem exit;
    private JMenu examples;
    private JMenuItem border_layout;
    private JMenuItem grid_layout;
    private JMenuItem flow_layout;
    private JMenuItem grid_bag_layout;
    private JMenuItem card_layout;
    private JMenu about;
    private GridLayout glayout;
    //Constructor
    public MainWindow(){
        //Initialize mainPanel
        mainPanel = new JPanel();
        //Seting JPanel
        this.setContentPane(mainPanel);
        //Create JMenuBar
        menu_bar = new JMenuBar();
        //Create JMenu home and added exit option
        home = new JMenu("Inicio");
        exit = new JMenuItem("Salir");
        home.add(exit);
        //Create JMenu examples and JMenuItem for each Layout and added to examples
        examples = new JMenu("Ejemplos");
        border_layout = new JMenuItem("BorderLayout");
        grid_layout = new JMenuItem("GridLayout");
        flow_layout = new JMenuItem("FlowLayout");
        grid_bag_layout = new JMenuItem("GridBabLayout");
        card_layout = new JMenuItem("CardLayout");
        examples.add(border_layout);
        examples.add(grid_layout);
        examples.add(flow_layout);
        examples.add(grid_bag_layout);
        examples.add(card_layout);
        //Create JMenu about
        about = new JMenu("Acerca de");
        //Add JMenu to the JMenuBar
        menu_bar.add(home);
        menu_bar.add(examples);
        menu_bar.add(about);
        //Set the JMenuBar to JFrame
        this.setJMenuBar(menu_bar);
        //Create listenners for JMenuItems
        createActionListeners();
        //Configurate Window
        this.setSize(new Dimension(400, 300));
        this.setTitle("Example Pack");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
    }

    private void createActionListeners() {
        border_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initBorderLayoutExample();
            }
        });
        grid_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initGridLayoutExample();
            }
        });
        flow_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initFlowLayoutExample();
            }
        });
        grid_bag_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initGridBagLayoutExample();
            }
        });
        card_layout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                initCardLayoutExample();
            }
        });
        about.addMenuListener(new MenuListener() {
            @Override
            public void menuSelected(MenuEvent e) {
                opensAbout();
            }

            @Override
            public void menuDeselected(MenuEvent e) {

            }

            @Override
            public void menuCanceled(MenuEvent e) {
                
            }
        });
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    private void initGridLayoutExample() {
        glayout = new GridLayout(3, 2, 15, 15);
        this.setLayout(glayout);
        JLabel name = new JLabel("Nombre:");
        JTextField txtName = new JTextField();
        String[] comboList = {"Rojo","Azul","Verde","Violeta","Negro"};
        JComboBox colorsComboBox = new JComboBox(comboList);
        JTextArea txtShow = new JTextArea();
        txtShow.setEditable(false);
        JButton show = new JButton("Mostrar");
        JButton erase = new JButton("Borrar");
        add(name);add(txtName);add(colorsComboBox);add(show);add(txtShow);add(erase);
        this.setSize(600, 400);
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
    }

    private void initFlowLayoutExample() {
        //Creo el TabbedPane
        JTabbedPane tabbedPane = new JTabbedPane();
        //Creo los paneles
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        //Agrego los paneles al tabbedPane
        tabbedPane.add("Personas", panel1);
        tabbedPane.add("Empresas", panel2);
        tabbedPane.add("Lugares", panel3);
        //Creo JList personas
        DefaultListModel<String> personasList = new DefaultListModel<>();
        personasList.addElement("Jorge Mora Sandoval"); personasList.addElement("Jaison Mora Víquez");
        personasList.addElement("Minor Vargas Viquez"); personasList.addElement("Carlos Azofeifa Brenes");
        JList<String> personas = new JList<>(personasList);
        //Creo JList empresas
        DefaultListModel<String> empresasList = new DefaultListModel<>();
        empresasList.addElement("MicroServices"); empresasList.addElement("IT Development Masters");
        empresasList.addElement("Proper Intelligence"); empresasList.addElement("JatBrains");
        JList<String> empresas = new JList<>(empresasList);
        //Creo JList lugares
        DefaultListModel<String> lugaresList = new DefaultListModel<>();
        lugaresList.addElement("Mexico"); lugaresList.addElement("Brazil");
        lugaresList.addElement("Alemania"); lugaresList.addElement("Holanda");
        JList<String> lugares = new JList<>(empresasList);
        //Agrego un boton
        JButton agregador = new JButton("Click me!");
        agregador.setBounds(450, 150, 100, 25);
        //Agrego las listas a los respectivos paneles y el boton
        panel1.add(personas);
        panel2.add(empresas);
        panel3.add(lugares);
        tabbedPane.setBounds(50, 50, 400, 200);
        setLayout(null);
        add(tabbedPane);
        add(agregador);
        setSize(new Dimension(600, 400));

        //Agrego un Listener al JButton
        agregador.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                chooseAction();
            }
        });
    }

    private void chooseAction() {
        JOptionPane optionPane =
    }

    private void initGridBagLayoutExample() {
        
    }

    private void initCardLayoutExample() {
        
    }

    private void initBorderLayoutExample() {

    }

    private void opensAbout() {
        aboutWindow = new AboutWindow(new JFrame());
    }

    //Initialize Window
    public void initWindow(){
        this.setVisible(true);
    }

    private int obtainRandomNumber(){
        return (int)Math.floor(Math.random()*10+1);
    }
}
