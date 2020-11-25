import org.omg.CORBA.Environment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

public class ListTest {
    public static void main(String[] args) {
        ArrayList<Integer> originList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            originList.add(i);
        }
        System.out.println(originList.toString());
        /*for (int i = 0; i < originList.size(); i++) {
            originList.set(i, originList.get(i) + 1);
        }
        System.out.println(originList.toString());*/
        ArrayList<Integer> tempList = new ArrayList<>();
        tempList = originList;
        for (int i = 0; i < tempList.size(); i++) {
            tempList.set(i, tempList.get(i) + 1);
        }
        System.out.println("originList : " + originList.toString());
        System.out.println("tempList : " + tempList.toString());
        System.out.println(originList == tempList);

        ArrayList<Integer> tempList1 = (ArrayList<Integer>) originList.clone();


    }
}
