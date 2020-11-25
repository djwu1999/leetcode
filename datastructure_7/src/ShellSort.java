public class ShellSort {
    public static void shellsort(int[] a){
        int j;

        for(int gap = a.length / 2; gap > 0; gap /= 2)
            for(int i = gap; i < a.length; i ++){
                int temp = a[i];
                for(j = i; j >= gap && temp < a[j - gap]; j -= gap)
                    a[j] = a[j - gap];
                a[j] = temp;
            }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 34, 2, 540};
        shellsort(a);
        System.out.println(a.toString());
        for (int i : a) {
            System.out.print(i + " ");
        }
    }
}
