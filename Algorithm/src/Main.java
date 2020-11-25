import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int res = 0;
        while(in.hasNextInt()){
            int a = in.nextInt();
            int b = in.nextInt();
            res = a + b;
            System.out.println(res);
        }
    }
}