import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class Window2 extends JFrame implements ActionListener {
    /*
    Здесь речь идет уже не о наследовании, а о реализации интерфейса - класса, который не
может иметь своих экземляров и нужен лишь для того, чтобы определить в коде
возможное поведение. С точки зрения теории у интерфейса нет полей, нет реализации методов.
В нашем случае он нужен для того, чтобы указать, что DrawingPanel будет иметь метод actionPerformed().
     */
    private final int BACKGROUND_WIDTH = 800;
    private final int BACKGROUND_HEIGHT = 800;

    private final int TIMER_DELAY = 1000;
    private final Timer timer = new Timer(TIMER_DELAY, this);
    private int ticksFromStart = 0;

    public Window2() {
        setSize(640, 480);
        setVisible(true);
        setTitle("Game");

        setDefaultCloseOperation(EXIT_ON_CLOSE); //метод для выключении проги при
        // закрытии окна
        timer.start () ;

    }

    public void drawCat(Graphics g, int startX, int startY,
                        int bodyWidth,
                        int bodyHeight,
                        int tailWidth,
                        int tailHeight,
                        int eyeSize) {
        int centerY = (startY + bodyHeight) / 2;

        /*Polygon polygon = new Polygon();
        polygon.addPoint(startX, startY);
        polygon.addPoint(startX + bodyWidth, centerY - bodyHeight);
        polygon.addPoint(startX + bodyWidth, centerY);
        polygon.addPoint(startX + bodyWidth + tailWidth, centerY - tailHeight);
//        polygon.addPoint(580, 220);
        polygon.addPoint(startX + bodyWidth + tailWidth, centerY + tailHeight);
        polygon.addPoint(startX + bodyWidth, centerY);
        polygon.addPoint(startX + bodyWidth, centerY + bodyHeight);

         */

        Graphics2D g2Cat = (Graphics2D) g;
        g2Cat.setColor(new Color(153, 69, 255));
        g2Cat.fillOval(100,centerY,200,100);
        Polygon catPolygon = new Polygon();
        //catPolygon.addPoint(startX, startY);


//        g.setColor(new Color(112, 121, 255));
//        g.fillPolygon(polygon);

        GradientPaint gradient = new
                GradientPaint(startX + bodyWidth, centerY - bodyHeight,
                new Color(17, 5, 183),
                startX + bodyWidth, centerY + bodyHeight,
                new Color(248, 115, 162));

        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(gradient);
        g2.fillPolygon(catPolygon);

        g.setColor(new Color(255, 255, 255));
        g.fillOval(startX + 120, centerY + eyeSize - 30, eyeSize, eyeSize);
        g.fillOval(startX + 160, centerY + eyeSize - 30  , eyeSize, eyeSize);

        g.setColor(new Color(0, 22, 129));
        g.fillOval(startX + 135, centerY + eyeSize - 25, eyeSize-30, eyeSize-2);
        g.fillOval(startX + 175, centerY + eyeSize - 25  , eyeSize-30, eyeSize-2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == timer) {
            repaint();
            ++ticksFromStart;
        }
    }

    @Override    //переопределение сработает и без таких подписей, аннотация улучшит читаемость
    public void paint(Graphics g) {
        super.paint(g);

        //g.setColor(new Color(0xD3FF65CA, true));
        drawCat(g, 50, 240, 300, 150, 50, 50, 50);
        //g.draw3DRect(); // нарисовать фигуру


        g.fillRect(40, 45, 55, 33);//залитие фигуры

        Graphics2D g2d = (Graphics2D) g;
        g2d.setColor(Color.BLACK);
        g2d.drawOval(ticksFromStart, BACKGROUND_HEIGHT / 2, BACKGROUND_WIDTH / 10, BACKGROUND_WIDTH / 10);
        g2d.setColor(Color.GREEN);
        g2d.fillOval(ticksFromStart, BACKGROUND_HEIGHT / 2, BACKGROUND_WIDTH / 10, BACKGROUND_WIDTH / 10);

//        Polygon polygon = new Polygon();
//        polygon.addPoint(30,240);
//        polygon.addPoint(500,210);
//        polygon.addPoint(500,250);
//        polygon.addPoint(500,220);
//        polygon.addPoint(580,260);
//        polygon.addPoint(500,250);
//        polygon.addPoint(500,280);
//
//        g.fillPolygon(polygon);
    }
}


public class Cat {
    public static void main(String[] args) {
        Window2 window = new Window2();
    }
}
