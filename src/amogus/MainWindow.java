package amogus;

import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame {
    private final DrawPanel panel;

    public MainWindow() throws HeadlessException {
        panel = new DrawPanel(this.getWidth(), this.getHeight(), 100);
        //полотно DrawingPanel теперь является не самим
        //окошком, а виджетом на нем, что позволит легко докидывать кнопочки, меню и
        //другие элементы в будущем
        this.add(panel);
    }
}

