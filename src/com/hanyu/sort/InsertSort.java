package com.hanyu.sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            // 随机数为0-80000
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为：" + start);

        insertSort(arr);

        // 排序后的时间
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为：" + end);
        System.out.println("时间为：" + (end - start));


    }

    public static void insertSort(int[] arr) {
        // 使用逐步推导的方式来讲解，方便理解
        // 第1轮 {101,34,119,1} -> {34,101,119,1}


        // {101,34,119,1} -> {101,101,119,1}
        // 定义待插入的数
//        int insertValue = arr[1];
//        int insertIndex = 0;
//
//        // 给insertValue 找到插入的位置
//        // 说明
//        // 1.insertIndex>=0 保在给insertVal 找插入位置，不越界
//        // 2. insertValue<arr[insertIndex] 待插入的数，还没有找到插入的位置
//        // 3. 就需要将arr[insertIndex]后移
//        while (insertIndex>=0 && insertValue<arr[insertIndex]){
//            arr[insertIndex+1] =arr[insertIndex];
//            insertIndex --;
//        }
//
//        // 当退出while循环时，说明插入的位置找到，insertIndex+1
//        arr[insertIndex+1] = insertValue;
//        // 第一轮插入后的数组
//        System.out.println("第1轮插入");
//        System.out.println(Arrays.toString(arr));
//
//        // 第二轮
//        insertValue = arr[2];
//        insertIndex = 2-1;
//
//        while (insertIndex>=0 && insertValue<arr[insertIndex]){
//            arr[insertIndex+1] =arr[insertIndex];
//            insertIndex --;
//        }
//
//        // 当退出while循环时，说明插入的位置找到，insertIndex+1
//        arr[insertIndex+1] = insertValue;
//        // 第一轮插入后的数组
//        System.out.println("第2轮插入");
//        System.out.println(Arrays.toString(arr));
//
//        insertValue = arr[3];
//        insertIndex = 3-1;
//
//        while (insertIndex>=0 && insertValue<arr[insertIndex]){
//            arr[insertIndex+1] =arr[insertIndex];
//            insertIndex --;
//        }
//
//        // 当退出while循环时，说明插入的位置找到，insertIndex+1
//        arr[insertIndex+1] = insertValue;
//        // 第一轮插入后的数组
//        System.out.println("第2轮插入");
//        System.out.println(Arrays.toString(arr));

        int insertValue;
        int insertIndex;
        for (int i = 1; i < arr.length; i++) {
            insertValue = arr[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertValue < arr[insertIndex]) {
                // 如果当前数比前一个小，则前一个数后移
                arr[insertIndex + 1] = arr[insertIndex];
                insertIndex--;
            }
            // 判断是否需要插入,优化
            if (insertIndex + 1 != i) {
                arr[insertIndex + 1] = insertValue;
            }
            // 当退出while循环时，说明插入的位置找到，insertIndex+1

        }
    }
}
