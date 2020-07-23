package matrix;

import java.util.ArrayList;
import java.util.List;

public class Offer29_spiralOrder {
    public int[] spiralOrder(int[][] matrix) {
        int tC = 0;
        int tR = 0;
        int bC = matrix.length;
        int bR = matrix[0].length;
        List<Integer> ret = new ArrayList<>();
        while (tC < bC && tR < bR) {
            printEdge(matrix, tC++, tR++, bC--, bR--, ret);
        }
        return ret.stream().mapToInt(k -> k).toArray();
    }

    private List<Integer> printEdge(int[][] matrix, int tC, int tR, int bC, int bR, List<Integer> ret) {
        int curC = tC;
        int curR = tR;
        while(curR < bR){
            ret.add(curC,curR);
            curR++;
        }
        while(curC < bC){
            ret.add(curC,curR);
            curC++;
        }
        while(curR > tR){
            ret.add(curC,curR);
            curR--;
        }
        while(curC > tC){
            ret.add(curC,curR);
            curC--;
        }
    }
}
