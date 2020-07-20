package examples;

import com.harium.ferry.matrix.iterable.MatrixIterable;
import com.harium.ferry.matrix.iterable.SpiralIterable;

public class MatrixSpiralExample {

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[3][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;
        matrix[2][0] = 7;
        matrix[2][1] = 8;
        matrix[2][2] = 9;

        MatrixIterable<Integer> iterable = new SpiralIterable<>(matrix);
        for (Integer i : iterable) {
            System.out.println(i);
        }
    }

}
