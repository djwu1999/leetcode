import java.util.Arrays;

public class HeapSort {
    public static void heapSort(int[] arr) {
        for (int i = arr.length / 2 - 1; i >= 0; i--)
            shiftDown(arr, arr.length - 1, i);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, i, 0);
            shiftDown(arr, i - 1, 0);
        }
    }

    private static void shiftDown(int[] arr, int n, int k) {
        while (2 * k + 1 <= n){
            int j = 2 * k + 1;
            if (j + 1 <= n && arr[j] < arr[j + 1])
                j++;
            if (arr[k] < arr[j])
                swap(arr, k, j);
            k = j;
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray(10000, 0, 10000000);
        heapSort(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        System.out.println(Arrays.toString(arr));
    }
}
