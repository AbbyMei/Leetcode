package sort;

import org.junit.Test;

import java.util.Arrays;

public class QuickSort {
    public static void quickSort(int[] array,int startIndex,int endIndex){
        if(startIndex >= endIndex){
            return;
        }
        int pivotIndex = partition(array,startIndex,endIndex);
        quickSort(array,startIndex,pivotIndex-1);
        quickSort(array,pivotIndex+1,endIndex);

    }

    private static int partition(int[] array, int startIndex, int endIndex) {
        int pivot = array[startIndex];
        int index = startIndex;
        int left = startIndex;
        int right = endIndex;
        while(left < right){
            while(array[right] > pivot){
                right--;
                if(left >= right){
                    break;
                }
            }
            array[index] = array[right];
            index = right;
            while(array[left] < pivot){
                left++;
                if(left >= right){
                    break;
                }
            }
            array[index] = array[left];
            index = left;
        }
        array[index] = pivot;
        return index;
    }

    @Test
    public void testQuickSort(){
        int[] array = new int[]{4,7,6,5,3,2,8,1};
        quickSort(array,0,array.length-1);
        System.out.println(Arrays.toString(array));
    }
}
