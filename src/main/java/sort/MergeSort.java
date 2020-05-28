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
    
    public static void mergeSort(int[] array, int startIndex, int endIndex){
        int mid = (startIndex + endIndex)/2;
        if(startIndex == endIndex){
            return;
        }
        mergeSort(array,startIndex,mid);
        mergeSort(array,mid+1,endIndex);
        merge(array,startIndex,mid+1,endIndex);
    }

    private static void merge(int[] array, int startIndex, int i, int endIndex) {
        int length = endIndex-startIndex+1;
        int[] tempArray = new int[length];
        while (startIndex <)
    }


    @Test
    public void testMergeSort(){
        int a[] = {};
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

}
