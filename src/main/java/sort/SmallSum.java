package sort;

//在一个数组中，每一个数左边比当前数小的数累加起来，叫做这个数组的小和。求一个数组的小和称为小和问题。
/*input: [2,4,5,1,7,3]
2 左侧比 2 小的数，没有；
4 左侧比 4 小的数，2；
5 左侧比 5 小的数，2,4；
1 左侧比 1 小的数，没有；
7 左侧比 7 小的数，2,4,5,1；
3 左侧比 3 小的数，2,1。
output: 2+2+4+2+4+5+1+2+1=23*/
public class SmallSum {
    public int smallSum(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        return mergeSort(arr, 0, arr.length - 1);
    }

    public static int mergeSort(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return 0;
        }
        int mid = startIndex + ((endIndex - startIndex) >> 1);
        int ret = mergeSort(arr, startIndex, mid) + mergeSort(arr, mid + 1, endIndex) + merge(arr, startIndex, mid, endIndex);
        return ret;
    }

    public static int merge(int[] arr, int startIndex, int mid, int endIndex) {
        int[] tmp = new int[endIndex - startIndex + 1];
        int left = startIndex;
        int right = mid + 1;
        int tmpIndex = 0;
        int ret = 0;
        while (left <= mid && right <= endIndex) {
            ret += arr[left] < arr[right] ? (endIndex - right + 1) * arr[left] : 0;
            tmp[tmpIndex++] = arr[left] < arr[right] ? left++ : right++;
        }
        while (left <= mid) {
            tmp[tmpIndex++] = arr[left++];
        }
        while (right <= endIndex) {
            tmp[tmpIndex] = arr[right++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[startIndex + i] = tmp[i];
        }
        return ret;
    }
}
