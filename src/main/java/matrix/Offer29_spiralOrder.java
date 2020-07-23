package matrix;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class Offer29_spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new int[0];
        }
        int tC = 0;
        int tR = 0;
        int bC = matrix.length - 1;
        int bR = matrix[0].length - 1;
        List<Integer> ret = new ArrayList<>();
        while (tC <= bC && tR <= bR) {
            printEdge(matrix, tC++, tR++, bC--, bR--, ret);
        }
        return ret.stream().mapToInt(k -> k).toArray();
    }

    private List<Integer> printEdge(int[][] matrix, int tC, int tR, int bC, int bR, List<Integer> ret) {
        int curC = tC;
        int curR = tR;
        if(curC == bC && curR == bR){
            ret.add(matrix[curC][curR]);
        }
        while(curR < bR){
            ret.add(matrix[curC][curR]);
            curR++;
        }
        while(curC < bC){
            ret.add(matrix[curC][curR]);
            curC++;
        }
        while(curR > tR){
            ret.add(matrix[curC][curR]);
            curR--;
        }
        while(curC > tC){
            ret.add(matrix[curC][curR]);
            curC--;
        }
        return ret;
    }

    @Test
    public void testSpiralOrder(){
        int matrix[][] = {{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(matrix));
    }
}
