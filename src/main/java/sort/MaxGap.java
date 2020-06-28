package sort;

public class MaxGap {
    //给一个没有排序的数组，当排序后找出连续两个元素之间相差最大的数，并且输出这个数。
    public static int maxGap(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int len = arr.length;
        for (int i = 0; i < len; i++) {
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }
        if (max == min) {
            return 0;
        }
        boolean[] hasNumber = new boolean[len + 1];
        int[] minNumber = new int[len + 1];
        int[] maxNumber = new int[len + 1];
        for (int i = 0; i < len; i++) {
            int bucket = bucketIndex(arr[i], len, min, max);
            hasNumber[bucket] = true;
            minNumber[bucket] = arr[i] < minNumber[bucket] ? arr[i] : minNumber[bucket];
            maxNumber[bucket] = arr[i] > maxNumber[bucket] ? arr[i] : maxNumber[bucket];
        }

        int ret = 0;
        int lastMax = maxNumber[0];
        for (int i = 1; i <= len; i++) {
            if (hasNumber[i]) {
                ret = Math.max(ret, minNumber[i] - lastMax);
                lastMax = maxNumber[i];
            }
        }
        return ret;

    }

    ////每一个数该进哪个桶
    private static int bucketIndex(int num, int len, int min, int max) {
        return (num - min) * (len + 1) / (max - min);
    }

}
