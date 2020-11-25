public class fifth {
    public static int ones (int n){
        if(n == 0)
            return 0;
        return ones(n / 2) + n % 2;
    }

    public static void main(String[] args) {
        System.out.println(ones(11));
        System.out.println(ones(8));
        System.out.println(ones(15));
        System.out.println(ones(31));
        System.out.println(ones(63));
    }
}
