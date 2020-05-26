package sort;

public class BubbleSort {
    public static void bubbleSort1(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            for(int j = 0; j < array.length - 1 - i; j++){
                if(array[j] > array[j+1]){
                    int temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    /*加入标识，如果排列已经有序，则不需要再排序*/
    public static void bubbleSort(int[] array){
        int temp = 0;
        for(int i = 0; i < array.length - 1; i++){
            boolean isSorted = true;
            for(int j = 0; j < array.length - i - 1; j++){
                if(array[j] > array[j+1]){
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                    isSorted = false;
                }
            }
            if(isSorted){
                break;
            }
        }
    }
}
