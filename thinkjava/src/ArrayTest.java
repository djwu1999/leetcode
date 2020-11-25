import java.util.Arrays;

public class ArrayTest {
    public static void main(String[] args) {
        int[] origin = new int[10];
        for (int i = 0; i < 10; i++) {
            origin[i] = i;
        }
        System.out.println(Arrays.toString(origin));
        int[] temp = origin;
        for (int i = 0; i < 10; i++) {
            temp[i] ++;
        }
        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(temp));

        int[] temp1 = origin.clone();
        for (int i = 0; i < temp1.length; i++) {
            temp1[i] ++;
        }
        System.out.println(Arrays.toString(origin));
        System.out.println(Arrays.toString(temp));
        System.out.println(Arrays.toString(temp1));
        System.out.println(origin == temp);
        System.out.println(origin == temp1);

    }
}
