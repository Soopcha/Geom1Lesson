package amogus;

import java.awt.*;

public class CatCute {

    private int x;
    private int y;
    private int width;
    private int height;
    private Color color;

    public CatCute(final int x, final int y, final int width, final int height, final Color color) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    void draw(final Graphics gr) {
        Graphics2D g = (Graphics2D) gr;

        // tail
        g.setColor(this.color);
        g.fillOval((int)(this.x + 0.80 * this.width), (int)(this.y+0.2 * this.height), (int)(0.26 * this.width), (int)(0.28 * height));
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.x + 0.80 * this.width), (int)(this.y+0.2 * this.height), (int)(0.26 * this.width), (int)(0.28 * height));



        // body
        g.setColor(this.color);
        g.fillOval((int)(this.x + 0.10 * this.width), (int)(this.y+0.2 * this.height), (int)(0.9 * this.width), (int)(0.35 * height));
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.x + 0.10 * this.width), (int)(this.y+0.2 * this.height), (int)(0.9 * this.width), (int)(0.35 * height));


        //ears
        g.setColor(this.color);
        Polygon polygonEar1 = new Polygon();
        polygonEar1.addPoint((int)(this.x + 0.2 * this.width), (int)(this.y+0.15 * this.height));
        polygonEar1.addPoint((int)(this.x + 0.3 * this.width), (int)(this.y-0.15 * this.height));
        polygonEar1.addPoint((int)(this.x + 0.45 * this.width), this.y);
        g.fillPolygon(polygonEar1);
        g.setColor(Color.BLACK);
        g.drawPolygon(polygonEar1);

        g.setColor(this.color);
        Polygon polygonEar2 = new Polygon();
        polygonEar2.addPoint((int)(this.x + 0.60 * this.width), this.y);
        polygonEar2.addPoint((int)(this.x + 0.75 * this.width), (int)(this.y-0.15 * this.height));
        polygonEar2.addPoint((int)(this.x + 0.85 * this.width), (int)(this.y+0.15 * this.height));
        g.fillPolygon(polygonEar2);
        g.setColor(Color.BLACK);
        g.drawPolygon(polygonEar2);




        // head
        g.setColor(this.color);
        g.fillOval((int)(this.x + 0.2 * this.width), this.y, (int)(0.65 * this.width), (int)(0.33 * this.height));
        //g.fillOval(this.x, (int)(this.y + 0.25 * this.height), (int)(0.65 * this.width), (int)(0.33 * this.height));
//обводка если нужна но мб без нее красивее:
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.x + 0.2 * this.width), this.y, (int)(0.65 * this.width), (int)(0.33 * this.height));

        //g.drawOval(this.x, (int)(this.y + 0.25 * this.height), (int)(0.65 * this.width), (int)(0.33 * this.height));


        // legs
        g.setColor(this.color);
        g.fillOval((int)(this.x + 0.2 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.1 * this.height));
        g.fillOval((int)(this.x + 0.65 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.1 * this.height));
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.x + 0.2 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.1 * this.height));
        g.drawOval((int)(this.x + 0.65 * this.width), (int)(this.y + 0.5 * this.height),
                (int)(0.3 * this.width), (int)(0.1 * this.height));



        // eyes

        GradientPaint gradient = new
                GradientPaint((int)(this.x + 0.37 * this.width), (int)(this.y + 0.12 * this.height),
                new Color(14, 8, 131),
                (int)(this.x + 0.37 * this.width), (int)(this.y + 0.32 * this.height),
                new Color(255, 0, 59));


        g.setPaint(gradient);
        //g.setColor(new Color(253, 0, 0));
        g.fillOval((int)(this.x + 0.37 * this.width), (int)(this.y + 0.12 * this.height),
                (int)(0.15 * this.width), (int)(0.15 * this.height));
        g.fillOval((int)(this.x + 0.53 * this.width), (int)(this.y + 0.12 * this.height),
                (int)(0.15 * this.width), (int)(0.15 * this.height));
        g.setColor(Color.BLACK);
        g.drawOval((int)(this.x + 0.37 * this.width), (int)(this.y + 0.12 * this.height),
                (int)(0.15 * this.width), (int)(0.15 * this.height));
        g.drawOval((int)(this.x + 0.53 * this.width), (int)(this.y + 0.12 * this.height),
                (int)(0.15 * this.width), (int)(0.15 * this.height));


    }
}
