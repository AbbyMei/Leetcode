package sort;

public class InsertSort {
    public static void insertSort(int[] array){
        for(int i = 1; i < array.length; i++){
            for(int j = i; j > 0; j--){
                int temp = array[j];
                while (temp < array[j-1]){
                    array[j] = array[j-1];
                    j--;
                }
                array[j] = temp;
            }
        }
    }
}
