public class CountedInteger {
    private static int counter;
    private final int id = counter ++;
    @Override
    public String toString(){
        return Integer.toString(id);
    }
}
