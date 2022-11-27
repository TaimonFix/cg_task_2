package ru.vsu.btd;

public class Shape {

    Point[] extreme;

    public Shape(Point[] Extremes) {
        this.extreme = Extremes;
    }

    public void setExtremes(double[][] points) {
        for (int i = 0; i < points.length; i++) {
            extreme[i].setX(points[i][0]);
            extreme[i].setY(points[i][1]);
        }
    }
    public Point[] getExtremes() {
        return extreme;
    }

    public int[] getExtremesX() {
        int[] peaksX = new int[extreme.length];
        for (int i = 0; i < peaksX.length; i++) {
            peaksX[i] = (int) extreme[i].getX();
        }
        return peaksX;
    }

    public int[] getExtremesY() {
        int[] peaksY = new int[extreme.length];
        for (int i = 0; i < peaksY.length; i++) {
            peaksY[i] = (int) extreme[i].getY();
        }
        return peaksY;
    }
}
