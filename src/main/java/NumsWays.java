import org.junit.Test;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 00:11 2020/2/20
 * @Modified By:
 */
public class NumsWays {
    public int numsWays(int n) {
        return solutions1(n);
    }

    private int solutions1(int n) {
        int t1 = 1, t2 = 1;
        int tmp;
        for (int i = 1; i < n; i++) {
            tmp = t2;
            t2 = (t1 + t2) % 1000000007;
            t1 = tmp;
        }

        return t2;
    }

    private int solution2(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        return solution2(n - 1) + solution2(n - 2);
    }

    @Test
    public void testNumsWays() {
        System.out.println(numsWays(4));
    }
}
