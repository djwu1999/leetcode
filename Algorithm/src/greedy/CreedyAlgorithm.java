package greedy;

import java.util.*;

public class CreedyAlgorithm {
    public static void main(String[] args) {
        //创建广播电台，放入map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");

        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("上海");
        hashSet4.add("天津");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("K1", hashSet1);
        broadcasts.put("K2", hashSet2);
        broadcasts.put("K3", hashSet3);
        broadcasts.put("K4", hashSet4);
        broadcasts.put("K5", hashSet5);

        HashSet<String> allAreas = new HashSet<>();
        Collections.addAll(allAreas, "北京", "上海", "天津", "广州", "深圳", "成都", "杭州", "大连");
//        allAreas.forEach(System.out::println);

        ArrayList<String> selects = new ArrayList<>();

        //定义一个临时的集合，在遍历的过程中，存放遍历过程中的电台覆盖的城市和当前没有覆盖的地区的交集
        HashSet<String> tempSet = new HashSet<>();

        String maxKey = null;
        //定义给maxKey,保存在一次遍历过程中，能够覆盖最大未覆盖的地区对应的电台的key
        while(allAreas.size() != 0){//如果allAreas不为0，则表示还没覆盖到所有的地区

            //每进行一次while，需要
            maxKey = null;

            //遍历broadcasts，取出对应key
            for (String key : broadcasts.keySet()) {
                //每进行一次for
                tempSet.clear();
                //当前这个key能够覆盖的地区
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                //求出tempSet 和 allAreas 集合的交集, 交集会赋给tempSet
                tempSet.retainAll(allAreas);
                if(tempSet.size() > 0 && (maxKey == null || tempSet.size() > broadcasts.get(maxKey).size()))
                    maxKey = key;
            }
            if (maxKey != null) {
                selects.add(maxKey);
                //将maxKey指向的广播电台覆盖的地区，从allAreas去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("得到的选择结果是：" + selects);
    }
}
