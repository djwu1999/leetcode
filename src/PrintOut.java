public class PrintOut {
    private static void printOut(int num){
        int[] res;
        if(num >= 10){
            printOut(num / 10);
        }
        System.out.println(num % 10);
    }

    public static void main(String[] args) {
        printOut(548994);
    }
}
