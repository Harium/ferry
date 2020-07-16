package examples;

import com.harium.ferry.matrix.iterable.MatrixIterable;
import com.harium.ferry.matrix.iterable.TopLeftToBottomRightIterable;
import com.harium.ferry.matrix.iterable.TopRightToBottomLeftIterable;

public class MatrixIndexExample {

    public static void main(String[] args) {
        Integer[][] matrix = new Integer[2][3];
        matrix[0][0] = 1;
        matrix[0][1] = 2;
        matrix[0][2] = 3;
        matrix[1][0] = 4;
        matrix[1][1] = 5;
        matrix[1][2] = 6;

        MatrixIterable<Integer> iterable = new TopLeftToBottomRightIterable<>(matrix);
        System.out.println("Left to Right");
        for (Integer i : iterable) {
            System.out.println(i);
        }

        iterable = new TopRightToBottomLeftIterable<>(matrix);
        System.out.println("Right to Left");
        for (Integer i : iterable) {
            System.out.println(i);
        }
    }

}
