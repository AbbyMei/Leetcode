package sort;


import java.util.Arrays;

import static sort.NetherLandFlag.swap;

public class HeapSort {
    public static void heapSort(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            heapInsert(arr, i);
        }

        int size = arr.length;
        swap(arr, 0, --size);
        while (size > 0) {
            heapify(arr, 0, size);
            swap(arr, 0, --size);
        }
    }

    private static void heapify(int[] arr, int i, int size) {
        int left = 2 * i + 1;
        while (left < size) {
            int large = left + 1 < size && arr[left + 1] > arr[left] ? left + 1 : left;
            large = arr[i] > arr[large]? i: large;
            if(large == i){
                break;
            }
            swap(arr,i,large);
            i = large;
            left = 2 * i + 1;
        }
    }

    private static void heapInsert(int[] arr, int i) {
        while (arr[i] > arr[(i-1)/2]){
            swap(arr,i,(i-1)/2);
            i = (i-1)/2;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,2,9,3,5,8,8,5,1,6,6,4};
        heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
