package amogus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrawPanel extends JPanel implements ActionListener {

    private final int PANEL_WIDTH;
    private final int PANEL_HEIGHT;
    private final int TIMER_DELAY;
    private Timer timer;
    private int ticksFromStart = 0;

    private CatCute catCute;

    public DrawPanel(final int width, final int height, final int timerDelay) {
        this.PANEL_WIDTH = width;
        this.PANEL_HEIGHT = height;
        this.TIMER_DELAY = timerDelay;
        timer = new Timer(timerDelay, this);
        timer.start();

        Color color = new Color(246, 178, 178);
        this.catCute = new CatCute(ticksFromStart, 200, 200, 260, color);
    }
    public void drawView(final Graphics gr){ // рисовка вида (что сзади кота)
        Graphics2D g = (Graphics2D) gr;
        g.setColor(new Color(32, 51, 38));
        g.fillRect(0,0,1300,1300);

        GradientPaint gradient = new
                GradientPaint(0,0,
                new Color(1, 0, 16),
                0, 300,
                new Color(255, 0, 59));


        g.setPaint(gradient); //установили цвет
        g.fillRect(0,0,1300,300);// а теперь этим цветом красим

        String text = "THE CAT";


        g.setColor(new Color(185, 147, 147)); // установите цвет текста
        g.setFont(new Font("Verdana", Font.BOLD + Font.ITALIC, 44)); // настройте шрифт и размер текста
        g.drawString(text, 500, 500); // нарисуйте текст на указанных координатах

    }

    @Override
    public void paint(final Graphics gr) {
        super.paint(gr);
        drawView(gr);

        catCute.setX(ticksFromStart);
        catCute.draw(gr);
    }

    @Override
    public void actionPerformed(final ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }
}
