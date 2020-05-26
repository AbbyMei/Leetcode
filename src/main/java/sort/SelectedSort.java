package sort;

public class SelectedSort {
    public static void selectedSort(int[] array){
        for(int i = 0; i < array.length; i++){
            int min = Integer.MIN_VALUE;
            int minIndex = 0;
            for(int j = i; j < array.length; j++){
                if(array[j] < min){
                    min = array[j];
                    minIndex = j;
                }
            }
            int temp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = temp;
        }
    }
}
