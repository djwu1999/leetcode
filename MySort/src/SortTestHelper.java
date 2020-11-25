import java.util.Arrays;
import java.util.Random;

public class SortTestHelper {
    public static int[] generateRandomArray(int n, int rangeL, int rangeR) {
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            Random random = new Random();
            arr[i] = random.nextInt((rangeR - rangeL));
        }
        return arr;
    }

    public static int[] getSortedArray(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            arr[i] = i;
        }
        return arr;
    }

    public static boolean isSorted(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if(arr[i] > arr[i + 1])
                return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(generateRandomArray(100000, 0, 12000)));
    }
}
