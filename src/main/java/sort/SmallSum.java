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
    public static int smallSum(int[] arr) {
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
        return mergeSort(arr, startIndex, mid) + mergeSort(arr, mid + 1, endIndex) + merge(arr, startIndex, mid, endIndex);
    }

    public static int merge(int[] arr, int startIndex, int mid, int endIndex) {
        int[] tmp = new int[endIndex - startIndex + 1];
        int left = startIndex;
        int right = mid + 1;
        int tmpIndex = 0;
        int ret = 0;
        while (left <= mid && right <= endIndex) {
            ret += arr[left] < arr[right] ? (endIndex - right + 1) * arr[left] : 0;
            tmp[tmpIndex++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }
        while (left <= mid) {
            tmp[tmpIndex++] = arr[left++];
        }
        while (right <= endIndex) {
            tmp[tmpIndex++] = arr[right++];
        }
        for (int i = 0; i < tmp.length; i++) {
            arr[startIndex + i] = tmp[i];
        }
        return ret;
    }
    // for test
    public static int comparator(int[] arr) {
        if (arr == null || arr.length < 2) {
            return 0;
        }
        int res = 0;
        for (int i = 1; i < arr.length; i++) {
            for (int j = 0; j < i; j++) {
                res += arr[j] < arr[i] ? arr[j] : 0;
            }
        }
        return res;
    }

    // for test
    public static int[] generateRandomArray(int maxSize, int maxValue) {
        int[] arr = new int[(int) ((maxSize + 1) * Math.random())];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) ((maxValue + 1) * Math.random()) - (int) (maxValue * Math.random());
        }
        return arr;
    }

    // for test
    public static int[] copyArray(int[] arr) {
        if (arr == null) {
            return null;
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    // for test
    public static boolean isEqual(int[] arr1, int[] arr2) {
        if ((arr1 == null && arr2 != null) || (arr1 != null && arr2 == null)) {
            return false;
        }
        if (arr1 == null && arr2 == null) {
            return true;
        }
        if (arr1.length != arr2.length) {
            return false;
        }
        for (int i = 0; i < arr1.length; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    // for test
    public static void printArray(int[] arr) {
        if (arr == null) {
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    // for test
    public static void main(String[] args) {
        int testTime = 500000;
        int maxSize = 100;
        int maxValue = 100;
        boolean succeed = true;
        for (int i = 0; i < testTime; i++) {
            int[] arr1 = generateRandomArray(maxSize, maxValue);
            int[] arr2 = copyArray(arr1);
            if (smallSum(arr1) != comparator(arr2)) {
                succeed = false;
                printArray(arr1);
                printArray(arr2);
                break;
            }
        }
        System.out.println(succeed ? "Nice!" : "Fucking fucked!");
    }
}
