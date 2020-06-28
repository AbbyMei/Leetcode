package sort;

import java.util.Arrays;

//给定一个数组arr和一个数num，请把小于num的数放在数组的左边，等于num的数放在数组的中间，大于num的数放在数组的右边。要求额外空间复杂度为O(1)，时间复杂度为O(N)
public class NetherLandFlag {
    public static int[] partition(int[] arr,int startIndex,int endIndex,int target){
        int less = startIndex - 1;
        int more = endIndex + 1;
        int cur = 0;
        while (cur < more){
            if(arr[cur] < target){
                swap(arr,++less,cur++);
            }else if(arr[cur] > target){
                swap(arr,cur,--more);
            }else{
                cur++;
            }
        }
        return arr;
    }

    public static void swap(int[] arr, int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{7,2,9,3,5,8,8,5,1,6,6,4};
        int[] res = partition(arr,0,arr.length-1,5);
        System.out.println(Arrays.toString(res));
    }
}
