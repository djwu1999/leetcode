import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {11, 6, 3, 8, 7, 2};
        Arrays.stream(bubbleSort(arr)).forEach(System.out::println);
    }

    public static int[] bubbleSort(int[] arr) {
        for (int i = arr.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if(arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
        return arr;
    }

    private static void swap(int[] arr, int from, int to) {
        int tmep = arr[from];
        arr[from] = arr[to];
        arr[to] = tmep;
    }
}
