package com.hanyu.ten;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

// 贪心算法
public class Greedy {
    public static void main(String[] args) {
        // 创建广播电台，放入一个hashMap中保存
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();

        // 放入各个电台
        HashSet<String> k1 = new HashSet<>();
        k1.add("北京");
        k1.add("上海");
        k1.add("天津");
        HashSet<String> k2 = new HashSet<>();
        k2.add("广州");
        k2.add("北京");
        k2.add("深圳");
        HashSet<String> k3 = new HashSet<>();
        k3.add("成都");
        k3.add("上海");
        k3.add("杭州");
        HashSet<String> k4 = new HashSet<>();
        k4.add("上海");
        k4.add("天津");
        HashSet<String> k5 = new HashSet<>();
        k5.add("杭州");
        k5.add("大连");

        broadcasts.put("k1",k1);
        broadcasts.put("k2",k2);
        broadcasts.put("k3",k3);
        broadcasts.put("k4",k4);
        broadcasts.put("k5",k5);


        // 存放所有地区的set
        HashSet<String> allAreas = new HashSet<>();


        for (Map.Entry<String, HashSet<String>> entry: broadcasts.entrySet()){
            allAreas.addAll(entry.getValue());
        }

        // 打印所有的地区
//        System.out.println(allAreas);

        // 创建selectAreas,存放选择的电台集合
        ArrayList<String> selectAreas = new ArrayList<>();

        // 定义一个临时集合，在遍历的过程中，存放遍历过程中的电台覆盖地区和当时还没有覆盖的集合
        HashSet<String> tempSet = new HashSet<>();

        // 定义maxKey,key1
        String maxKey = null;

        // 循环遍历
        while (allAreas.size()!=0){
            // 遍历broadcasts,取出对应的地区
            // 将maxKey清空
            maxKey = null;
            for (String key: broadcasts.keySet()){
                // tempSet清空
                tempSet.clear();
                HashSet<String> areas = broadcasts.get(key);
                tempSet.addAll(areas);
                // tempSet 和 allAreas 集合的交集，交集会赋给tempSet
                // 每次选更好的
                // tempSet.size()>broadcasts.get(maxKey).size()
                tempSet.retainAll(allAreas);
                if (tempSet.size()>0 && (maxKey==null||tempSet.size()>broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }

            // 如果maxKey!=null的情况下，就将maxKey加入selectAreas
            if (maxKey!=null){
                selectAreas.add(maxKey);
                // 将maxkey指向的广播电台覆盖的地区，从allAreas中去掉
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println(selectAreas);
    }
}
