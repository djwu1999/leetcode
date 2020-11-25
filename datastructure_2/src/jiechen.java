public class jiechen {
    public static int gan(int n){
        if(n == 1)
            return 1;
        return gan(n - 1) * n;
    }

    public static void main(String[] args) {
        System.out.println(gan(5));
    }
}
