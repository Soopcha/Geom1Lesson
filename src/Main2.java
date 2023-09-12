import javax.swing.*;
import java.awt.*;

class Window extends JFrame {
    public Window() {
        setSize(640, 480);
        setVisible(true);
        setTitle("Game");

        setDefaultCloseOperation(EXIT_ON_CLOSE); //метод для выключении проги при
        // закрытии окна
    }

    public void drawFish(Graphics g, int startX, int startY,
                         int bodyWidth,
                         int bodyHeight,
                         int tailWidth,
                         int tailHeight,
                         int eyeSize) {
        int centerY = (startY + bodyHeight) / 2;

        Polygon polygon = new Polygon();
        polygon.addPoint(startX, startY);
        polygon.addPoint(startX + bodyWidth, centerY - bodyHeight);
        polygon.addPoint(startX + bodyWidth, centerY);
        polygon.addPoint(startX + bodyWidth + tailWidth, centerY - tailHeight);
//        polygon.addPoint(580, 220);
        polygon.addPoint(startX + bodyWidth + tailWidth, centerY + tailHeight);
        polygon.addPoint(startX + bodyWidth, centerY);
        polygon.addPoint(startX + bodyWidth, centerY + bodyHeight);

//        g.setColor(new Color(112, 121, 255));
//        g.fillPolygon(polygon);

        GradientPaint gradient = new
                GradientPaint(startX + bodyWidth, centerY - bodyHeight,
                new Color(17, 5, 183),
                startX + bodyWidth, centerY + bodyHeight,
                new Color(248, 115, 162));

        Graphics2D g2 = (Graphics2D) g;

        g2.setPaint(gradient);
        g2.fillPolygon(polygon);

        g.setColor(new Color(2, 0, 0));
        g.fillOval(startX + 30, centerY + eyeSize + 5, eyeSize, eyeSize);

    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);

        //g.setColor(new Color(0xD3FF65CA, true));
        drawFish(g, 50, 240, 300, 150, 50, 50, 20);
        //g.draw3DRect(); // нарисовать фигуру


        g.fillRect(40, 45, 55, 33);//залитие фигуры


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


public class Main2 {
    public static void main(String[] args) {
        Window window = new Window();
    }
}
