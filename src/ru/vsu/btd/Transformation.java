package ru.vsu.btd;

public class Transformation {

    Shape shape;

    double[][] matrixA;

    public Transformation(Shape shape) {
        this.shape = shape;
        this.matrixA = getA();
    }

    public Shape getShape() {
        return shape;
    }

    private double[][] getA() {
        this.matrixA = new double[shape.getExtremes().length][];
        for (int i = 0; i < matrixA.length; i++) {
            Point p = shape.getExtremes()[i];
            this.matrixA[i] = new double[]{p.getX(), p.getY(), 1};
        }
        return this.matrixA;
    }

    private void multiplyMatrix(double[][] B) {
        double[][] A = getA();
        double[][] res = new double[A.length][B[0].length];
        for (int i = 0; i < A.length; i++) {
            for (int j = 0; j < res[0].length; j++) {
                for (int k = 0; k < B.length; k++) {
                    res[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        shape.setExtremes(res);
    }

    public void multiplyMatrix1(double[][] B) {
        double[][] A = getA();
        double[][] point = new double[A.length][B[0].length];
        for (int row = 0; row < A.length; row++) {
            for (int col = 0; col < B[0].length; col++) {
                double cell = 0;
                for (int i = 0; i < B.length; i++) {
                    cell += (A[row][i] - A[0][i]) * B[i][col];
                }
                point[row][col] = (int)Math.round(cell + A[0][col]);
            }
        }
        shape.setExtremes(point);
    }

    public void scalingShape(double a, double b) {
        multiplyMatrix1(new double[][]{
                {a, 0, 0},
                {0, b, 0},
                {0, 0, 1}
        });
    }

    public void movingShape(double a, double b) {
        multiplyMatrix(new double[][]{
                {1, 0, 0},
                {0, 1, 0},
                {a, b, 1}
        });
    }

    public void rotateShape(double alpha){
        alpha = -(alpha * Math.PI / 180);
        multiplyMatrix1(new double[][] {
                {Math.cos(alpha), Math.sin(alpha), 0},
                {-Math.sin(alpha), Math.cos(alpha), 0},
                {0, 0, 1},
        });
    }
}
