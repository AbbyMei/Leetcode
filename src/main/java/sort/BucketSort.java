package sort;

import java.util.Arrays;

public class BucketSort {
    public static void bucketSort(int[] arr){
        if(arr == null || arr.length < 2){
            return;
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
        }
        int[] bucket = new int[max+1];

        for (int i = 0; i < arr.length; i++) {
            bucket[arr[i]]++;
        }

        int j = 0;
        for (int i = 0; i < bucket.length; i++) {
            while(bucket[i]-->0){
                arr[j++] = i;
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,2,9,3,5,8,8,5,1,6,6,4};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
