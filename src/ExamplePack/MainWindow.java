package ExamplePack;

import javax.swing.*;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

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
        eraseElements();
        GridLayoutView glview = new GridLayoutView(this);
    }

    private void initFlowLayoutExample() {
        eraseElements();
        FlowLayoutView flview = new FlowLayoutView(this);
    }


    private void initGridBagLayoutExample() {
        eraseElements();
        GridBagLayoutView grdview = new GridBagLayoutView(this);
    }

    private void initCardLayoutExample() {
        eraseElements();
        CardLayoutView clview = new CardLayoutView();
    }

    private void initBorderLayoutExample() {
        eraseElements();
        BorderLayoutView bdrview = new BorderLayoutView(this);
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
    private void eraseElements() {
        this.getContentPane().removeAll();
        this.repaint();
        this.getContentPane().repaint();
    }
}
