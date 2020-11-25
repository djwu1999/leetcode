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
}
