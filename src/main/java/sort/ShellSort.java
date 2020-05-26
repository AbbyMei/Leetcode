package sort;

public class ShellSort {
    public static void shellSort(int[] array){
        int step = array.length;
        while(step > 1){
            step = step/2;
            for(int i = 0; i < step -1; i++){  //有几组数据，每一组数据进行插入排序
                for(int j = i + step; j < array.length; j = j + step){    //一组数据中有几个值进行比较
                    //插入排序
                    int temp = array[j];
                    while (temp < array[j + step]){
                        array[j] = array[j + step];
                        j--;
                    }
                    array[j] = temp;
                }
            }
        }
    }
}
