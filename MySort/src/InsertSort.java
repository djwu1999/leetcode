import java.util.Arrays;

public class InsertSort implements Sort {

    public void sort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j - 1])
                    swap(arr, j, j - 1);
                else
                    break;
            }
        }
    }

    public static void insertSort(int[] arr, int l, int r){
        for (int i = l + 1; i <= r; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > l && arr[j - 1] > temp; j--)
                arr[j] = arr[j - 1];
            arr[j] = temp;
        }
    }

    public static void insertSort1(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j;
            for (j = i; j > 0 && arr[j - 1] > temp; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = temp;
        }
    }

    private static void swap(int[] arr, int l, int r) {
        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
    }

    public static void main(String[] args) {
        int[] arr = SortTestHelper.generateRandomArray(10000, 0, 1000000);
        new InsertSort().sort(arr);
        System.out.println(SortTestHelper.isSorted(arr));
        System.out.println(Arrays.toString(arr));
    }
}
