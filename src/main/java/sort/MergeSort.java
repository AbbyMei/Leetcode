package sort;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: MLY
 * @Description:
 * @Date: Created in 09:49 2020/2/18
 * @Modified By:
 */
public class MergeSort {

    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2){
            return;
        }
        mergeSort(arr,0,arr.length - 1);
    }

    public static void mergeSort(int[] arr, int startIndex, int endIndex) {
        if(startIndex == endIndex){
            return;
        }
        int mid = startIndex + ((endIndex - startIndex) >> 1);
        mergeSort(arr,startIndex,mid);
        mergeSort(arr,mid+1,endIndex);
        merge(arr,startIndex,mid,endIndex);
    }

    //外排
    public static void merge(int[] arr, int l, int m, int r) {
        int[] tmp = new int[r-l+1];
        int left = l;
        int right = m+1;
        int tmpIndex = 0;
        while(left <= m && right <= r){
            tmp[tmpIndex++] = arr[left] < arr[right]?arr[left++]:arr[right++];
        }
        while(left <= m){
            tmp[tmpIndex++] = arr[left];
        }
        while (right <= r){
            tmp[tmpIndex] = arr[right++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[l + i] = tmp[i];
        }
    }


    @Test
    public void testMergeSort(){
        int a[] = {2,4,5,1,9,7,11,8,0};
        mergeSort(a);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

}
