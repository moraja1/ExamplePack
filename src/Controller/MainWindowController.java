package Controller;

import View.MainWindow;

public class MainWindowController {
    private MainWindow mainWindow;

    public void initializeWindow(){
        mainWindow = new MainWindow();
        mainWindow.initWindow();
    }
}
