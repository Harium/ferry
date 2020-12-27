package examples;

import com.harium.ferry.matrix.iterator.MatrixIndexIterator;
import com.harium.ferry.matrix.iterator.diagonal.TopRightDiagonalIndexIterator;

public class DiagonalIndexIteratorExample {

    public static void main(String[] args) {
        int width = 10;
        int height = 10;

        MatrixIndexIterator iterator = new TopRightDiagonalIndexIterator(width,height);
        iterator.setStartX(9);
        while (iterator.hasNext()) {
            int i = iterator.next();
            int x = i % width;
            int y = i / width;
            System.out.println("(" + x + ", " + y + ")");
        }
    }

}
