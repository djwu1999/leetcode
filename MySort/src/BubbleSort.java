import java.util.Arrays;

public class BubbleSort implements Sort {

    public void sort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray(10000, 1, 1000000);
        new BubbleSort().sort(arr);
        System.out.println(isSorted(arr));
        System.out.println(Arrays.toString(arr));
    }
}
