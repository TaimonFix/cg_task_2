package ru.vsu.btd;

import javax.swing.*;
import java.awt.*;

public class DrawPanel extends JPanel {

    int width;
    int height;

    Shape shape;
    Axes axes;
    DrawPanel(Shape shape) {
        this.width = 700;
        this.height = 700;
        this.axes = new Axes(this.getWidth(), this.getHeight());
        this.shape = shape;
    }


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        g2.setColor(Color.GRAY);
        g2.fillRect(0, 0, 900, 900);
        setSize(900, 900);
        drawAxes(g2);
        g2.setColor(Color.ORANGE);
        g2.fillPolygon(shape.getExtremesX(), shape.getExtremesY(), shape.getExtremes().length);
    }

    public void drawAxes(Graphics2D graphics2D) {
        graphics2D.setColor(Color.WHITE);
        graphics2D.drawLine(0, height / 2, width, height / 2);
        graphics2D.drawLine(width / 2, 0, width / 2, height);
    }

    public void setShape(Shape shape) {
        this.shape = shape;
    }

}
