import java.util.Iterator;
import java.util.List;

public class first {
    public static <E> void printLots(List<E> L, List<Integer> P){
        Iterator<E> iterL = L.iterator();
        Iterator<Integer> iterP = P.iterator();

        E itemL = null;
        Integer itemP = 0;
        int start = 0;

        while(iterL.hasNext() && iterP.hasNext()){
            itemP = iterP.next();

            while(start < itemP && iterL.hasNext()){
                start ++;
                itemL = iterL.next();
            }
            System.out.println(itemL);
        }
    }

    public static void main(String[] args) {

    }
}
