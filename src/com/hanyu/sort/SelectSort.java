package com.hanyu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SelectSort {
    public static void main(String[] args) {
        // 测试冒泡排序的速度O(n^2)，给80000个数据
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            // 随机数为0-80000
            arr[i] =(int) (Math.random()*80000);
        }


        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String start = dateFormat.format(date);
        System.out.println("排序前的时间为："+start);

        // 选择排序时间复杂度为O(n^2)
        selectSort(arr);

        // 排序后的时间
        date = new Date();
        String end = dateFormat.format(date);
        System.out.println("排序前的时间为："+end);
    }

    public static void selectSort(int[] arr) {
        // 最小值的索引
        int minIndex;
        // 最小值
        int min;
        for (int i = 0; i < arr.length - 1; i++) {
            minIndex = i;
            min = arr[minIndex];
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minIndex = j;
                }
            }
            // 性能优化
            if (minIndex != i) {
                arr[minIndex] = arr[i];
                arr[i] = min;
            }
        }


    }
}
