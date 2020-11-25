public class insertionSort {
    public static void insertionSort(int[] a){
        int j;

        for (int i = 0; i < a.length; i++) {
            int temp = a[i];

            for(j = i; j > 0 && temp < a[j - 1]; j --)
                a[j] = a[j - 1];
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 34, 2, 540};
        insertionSort(a);
        System.out.println(a);
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
