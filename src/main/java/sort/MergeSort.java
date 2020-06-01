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
        merge(array,startIndex,mid,mid+1,endIndex);
    }

    private static void merge(int[] array, int startIndex1, int endIndex1,int startIndex2, int endIndex2) {
        int length = endIndex2-startIndex1+1;
        int[] tempArray = new int[length];
        int l1 = startIndex1;
        int l2 = startIndex2;
        int i = 0;
        while (l1 <= endIndex1  && l2 <= endIndex2){
            if(array[l1] < array[l2]){
                tempArray[i] = array[l1];
                i++;
                l1++;
            }else{
                tempArray[i] = array[l2];
                i++;
                l2++;
            }
        }
        while (l1 <= endIndex1){
            tempArray[i] = array[l1];
            i++;
            l1++;
        }

        while (l2 <= endIndex2){
            tempArray[i] = array[l2];
            i++;
            l2++;
        }

        for(int j = 0; j < tempArray.length; j++){
            array[j+startIndex1] = tempArray[j];
        }
    }


    @Test
    public void testMergeSort(){
        int a[] = {2,4,5,1,9,7,11,8,0};
        mergeSort(a, 0, a.length - 1);
        System.out.println("排序结果：" + Arrays.toString(a));
    }

}
