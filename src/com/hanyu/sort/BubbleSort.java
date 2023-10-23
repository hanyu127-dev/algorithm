package com.hanyu.sort;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BubbleSort {
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

        // 排序
        bubbleSort(arr);

        // 排序后的时间
        date = new Date();
        String end = dateFormat.format(date);
        System.out.println("排序前的时间为："+end);


    }

    public static void bubbleSort(int[] arr){
        // 定义临时变量
        int temp ;
        boolean flag = false;
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) {
                if (arr[j]>arr[j+1]){
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1]=temp;
                }
            }
            // 一次都没有发生
            if (!flag){
                break;
            }else {
                // 重置,进行下一次判断
                flag =false;
            }
        }
    }

}
