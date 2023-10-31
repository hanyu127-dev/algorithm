package com.hanyu.ten;

import java.util.Arrays;
// KMP算法
public class KMP {
    public static void main(String[] args) {
        // 测试暴力匹配算法
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";
        long start = System.currentTimeMillis();
//        System.out.println(violenceMatch(str1, str2));

        int[] kmpNext = kmpNext(str2);
        int kmp = kmp(str1, str2, kmpNext);
        System.out.println(kmp);
        long end = System.currentTimeMillis();
        System.out.println("暴力匹配字符串花费的时间为" + (end - start) + "ms");
    }


    // 暴力匹配算法的实现
    public static int violenceMatch(String str1, String str2) {
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        // i索引指向s1, j索引指向s2
        int i = 0;
        int j = 0;
        // 保证匹配时不越界
        while (i < s1Len && j < s2Len) {
            if (s1[i] == s2[j]) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }
        if (j == s2Len) {
            return i - j;
        } else {
            return -1;
        }
    }

    // 根据字串创建部分匹配表
    public static int[] kmpNext(String dest) {
        // 创建next数组，保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;
        for (int i = 1, j = 0; i < dest.length(); i++) {
            // 当dest.charAt(i)!=dest.charAt(j)，我们需要从next[j-1]获取新的j
            // 直到我们发现等于才出来
            while (j > 0 && dest.charAt(i) != dest.charAt(j)) {
                j = next[j - 1];
            }
            if (dest.charAt(i) == dest.charAt(j)) {
                j++;
            }
            next[i] = j;
        }

        System.out.println(Arrays.toString(next));
        return next;
    }

    // kmp搜索算法
    public static int kmp(String str1, String str2, int[] next) {
//        char[] s1 = str1.toCharArray();
//        char[] s2 = str2.toCharArray();
//
//        int s1len = s1.length;
//        int s2len = s2.length;
//
//        int i = 0;
//        int j = 0;
//
//        while (i<s1len&&j<s2len){
//            if (s1[i]==s2[j]){
//                i++;
//                j++;
//            }else {
//                if (j>1){
//                    i = i -next[j-1];
//                    j = 0;
//                }else {
//                    i ++;
//                    j = 0;
//                }
//
//            }
//        }
//
//        if (j==s2len){
//            return i-j;
//        }else {
//            return -1;
//        }


        for (int i = 0, j = 0; i < str1.length(); i++) {
            while (j>0&&str1.charAt(i)!=str2.charAt(j)){
                j = next[j-1];
            }
            if (str1.charAt(i)==str2.charAt(j)){
                j++;
            }
            if (j==str2.length()){
                return i-j+1;
            }
        }
        return -1;

    }
}
