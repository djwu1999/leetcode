import java.util.ArrayList;
import java.util.List;

public class quickSort {
    public static void sort(List<Integer> items){
        if(items.size() > 1){
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            Integer chosenItem = items.get(items.size() / 2);

            for (Integer item : items) {
                if(item < chosenItem)
                    smaller.add(item);
                else if(item > chosenItem)
                    larger.add(item);
                else
                    same.add(item);
            }

            sort(smaller);
            sort(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 34, 4, 2, 12, 540};
        List<Integer> list = new ArrayList<>();
        for (int i : a) {
            list.add(i);
        }

        sort(list);

        for (Integer i : list) {
            System.out.println(i + "  ");
        }
    }
}
