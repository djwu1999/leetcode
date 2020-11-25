import java.util.Arrays;

public class MergeSort {
    public static void mergeSort(int[] arr) {
        mergePart(arr, 0, arr.length - 1);
    }

    private static void mergePart(int[] arr, int l, int r) {
        /*if (l >= r)
            return;*/
        if (r - l <= 15) {
            InsertSort.insertSort(arr, l, r);
            return;
        }
        int mid = (l + r) / 2;
        mergePart(arr, l, mid);
        mergePart(arr, mid + 1, r);
        if (arr[mid] > arr[mid + 1])
            merge(arr, l, mid, r);
    }

    private static void merge(int[] arr, int l, int mid, int r) {
        int[] temp = Arrays.copyOfRange(arr, l, r + 1);
        int lIndex = 0, rIndex = mid - l + 1, index = l;
        while (index <= r) {
            if (lIndex > mid - l) {
                arr[index++] = temp[rIndex++];
            } else if (rIndex > r - l) {
                arr[index++] = temp[lIndex++];
            } else {
                if (temp[lIndex] < temp[rIndex])
                    arr[index++] = temp[lIndex++];
                else
                    arr[index++] = temp[rIndex++];
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.getSortedArray(10000000);
        long begin = System.currentTimeMillis();
        mergeSort(arr);
        long end = System.currentTimeMillis();
        System.out.println(Arrays.toString(arr));
        System.out.println(SortTestHelper.isSorted(arr));
        System.out.println(end - begin);
    }
}
