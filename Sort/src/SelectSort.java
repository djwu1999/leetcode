import java.util.Arrays;

public class SelectSort {
    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if(arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static void swap(int[] arr, int front, int behind) {
        int temp = arr[front];
        arr[front] = arr[behind];
        arr[behind] = temp;
    }

    public static void main(String[] args) {
        int[] arrTest = SortTestHelper.generateRandomArray(100000, 3, 1000000000);
        long begin = System.currentTimeMillis();
        selectSort(arrTest);
        long end = System.currentTimeMillis();
        Arrays.stream(arrTest).forEach(System.out::println);
        System.out.println("消耗时间为 : " + (end - begin) + "ms");
    }
}
