package com.itheima.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class BALLUtils {
    public static List<String> getRed(){
        TreeSet<Integer> treeSet = new TreeSet<Integer>();
        while (treeSet.size()<6){
            int i = new Random().nextInt(33) + 1;
            treeSet.add(i);
        }
        List<String> reds = new ArrayList<String>();
        for (Integer i : treeSet) {

            reds.add(String.format("%02d", i));
        }
        return reds;
    }
    public static String getBlue(){
        int i = new Random().nextInt(16) + 1;
        return String.format("%02d",i);
    }
}
