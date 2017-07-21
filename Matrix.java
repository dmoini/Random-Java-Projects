public class Matrix {

    public static final int[] DEFAULT_VALUES_ARRAY = {1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static final String MATRICES_SAME_DIMENSIONS = "Make sure both matrices are the same dimensions.";
    public static final Matrix ZERO_MATRIX = new Matrix();
    public static final Matrix TEST_MATRIX_ONE = new Matrix(3, 3, DEFAULT_VALUES_ARRAY);
    public static final int[] testValuesTwo = {1, 2, 3, 4};
    public static final Matrix TEST_MATRIX_TWO = new Matrix(2, 2, testValuesTwo);

    private int length;
    private int width;
    private int[] values;
    private int[][] matrix;

    //TODO: fix even spacing for printing out array

    public Matrix() {
        this.length = 3;
        this.width = 3;
        this.values = DEFAULT_VALUES_ARRAY;
        this.matrix = new int[this.length][this.width];
        int counter = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                this.matrix[i][j] = this.values[counter];
                counter++;
            }
        }
    }

    public Matrix(int l, int w) {
        this.length = l;
        this.width = w;
        this.values = new int[l * w];
        this.matrix = new int[l][w];
        int counter = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                this.matrix[i][j] = values[counter];
                counter++;
            }
        }

    }

    public Matrix(int l, int w, int[] v) {
        this.length = l;
        this.width = w;
        this.values = v;
        this.matrix = new int[l][w];
        int counter = 0;
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                this.matrix[i][j] = values[counter];
                counter++;
            }
        }
    }

    public int getLength() {
        return this.length;
    }

    public int getWidth() {
        return this.width;
    }

    public int getValue(int y, int x) {
        return this.matrix[y][x];
    }

    public void setValue(int y, int x, int v) {
        this.matrix[y][x] = v;
    }

    public void printString() {
        for (int i = 0; i < this.length; i++) {
            for (int j = 0; j < this.width; j++) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public int[] matrixToArray() {
        int[] array = new int[this.getLength() * this.getWidth()];
        int counter = 0;
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                array[counter] = this.getValue(i, j);
                counter++;
            }
        }
        return array;
    }

    public Matrix plus(Matrix addend) {
        try {
            if ((this.length != addend.length) && (this.width != addend.length)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(MATRICES_SAME_DIMENSIONS);
        }
        Matrix sum = new Matrix(this.length, this.width);
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                int num = this.getValue(i, j) + addend.getValue(i, j);
                sum.setValue(i, j, num);
            }
        }
        return sum;
    }

    public Matrix minus(Matrix subtrahend) {
        try {
            if ((this.length != subtrahend.length) && (this.width != subtrahend.length)) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println(MATRICES_SAME_DIMENSIONS);
        }
        Matrix diff = new Matrix(this.length, this.width);
        for (int i = 0; i < this.getLength(); i++) {
            for (int j = 0; j < this.getWidth(); j++) {
                int num = this.getValue(i, j) - subtrahend.getValue(i, j);
                diff.setValue(i, j, num);
            }
        }
        return diff;
    }

    public Matrix times(Matrix factor) {
        return new Matrix();
    }

    public Matrix divide(Matrix divisor) {
        return new Matrix();
    }

    public static void main(String[] args) {
        // if (args.length == 0) {
        //     System.out.println("Usage: java Matrix <height> <width> <values to fill matrix>, where all are non-negative integers.");
        // } else {
        //     int l = Integer.parseInt(args[0]);
        //     int w = Integer.parseInt(args[1]);
        //     int[] v = new int[l * w];
        //     for (int i = 0; i < v.length; i++) {
        //         v[i] = Integer.parseInt(args[i + 2]);
        //     }
        //     Matrix m = new Matrix(l, w, v);
        // }

        Matrix test = TEST_MATRIX_ONE.plus(TEST_MATRIX_TWO);
        test.printString();
    }
}
