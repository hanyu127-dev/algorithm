package com.hanyu.sort;

public class RadixSort {

    public static void main(String[] args) {
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            // 随机数为0-80000
            arr[i] = (int) (Math.random() * 8000000);
        }

        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为：" + start);
        radixSort(arr);

        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为：" + end);
        System.out.println("时间为：" + (end - start));


    }


    public static void radixSort(int[] arr) {

        // 1.得到最大位数
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        // 得到最大数是几位数
        int maxLength = ("" + max).length();


        // 针对每个元素的各位进行排序（第一轮）
        // 定义一个二维数组，表示10个桶，每个桶就是一个一维数组
        // 防止数据溢出，每个桶的大小定义为arr.length
        int[][] bucket = new int[10][arr.length];
        // 记录每个桶中的数据的个数
        int[] bucketElementCounts = new int[10];

        for (int j = 0, n = 1; j < maxLength; j++, n *= 10) {
            for (int i = 0; i < arr.length; i++) {
                // 取出每个元素的各位
                int digitOfElement = arr[i] / n % 10;
                // 放入对应的桶中
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
                // 指针位移
                bucketElementCounts[digitOfElement]++;
            }
            // 按照桶的顺序，取出数据
            int index = 0;
            for (int k = 0; k < bucket.length; k++) {
                // 如果桶中有数据，我们才放入原数组
                if (bucketElementCounts[k] != 0) {
                    // 有数据，循环
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        arr[index] = bucket[k][l];
                        index++;
                    }
                }
                // 第一轮处理后，将 bucketElementCounts[k]置零
                bucketElementCounts[k] = 0;
            }
        }


//        // 第一轮
//        for (int i = 0; i < arr.length; i++) {
//            // 取出每个元素的各位
//            int digitOfElement = arr[i]%10;
//
//            // 放入对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
//            // 指针位移
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        // 按照桶的顺序，取出数据
//        int index = 0;
//        for (int k = 0; k < bucket.length; k++) {
//            // 如果桶中有数据，我们才放入原数组
//            if (bucketElementCounts[k]!=0){
//                // 有数据，循环
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//
//            }
//
//            // 第一轮处理后，将 bucketElementCounts[k]置零
//            bucketElementCounts[k]=0;
//        }
//
//        //第一轮结果
//        System.out.println("第一轮对个位的排序结果"+ Arrays.toString(arr));
//
//
//
//        // 第二轮
//        for (int i = 0; i < arr.length; i++) {
//            // 取出每个元素的各位
//            int digitOfElement = arr[i]/10%10;
//
//            // 放入对应的桶中
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
//            // 指针位移
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        // 按照桶的顺序，取出数据
//        index = 0;
//        for (int k = 0; k < bucket.length; k++) {
//            // 如果桶中有数据，我们才放入原数组
//            if (bucketElementCounts[k]!=0){
//                // 有数据，循环
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//            bucketElementCounts[k]=0;
//        }
//
//        //第二轮结果
//        System.out.println("第二轮对个位的排序结果"+ Arrays.toString(arr));
//
//
//        // 第三轮
//        for (int i = 0; i < arr.length; i++) {
//            // 取出每个元素的各位
//            int digitOfElement = arr[i]/100%10;
//
//            // 放入对应的桶中,每轮都是从第一个放
//            bucket[digitOfElement][bucketElementCounts[digitOfElement]] = arr[i];
//            // 指针位移
//            bucketElementCounts[digitOfElement]++;
//        }
//
//        // 按照桶的顺序，取出数据
//        index = 0;
//        for (int k = 0; k < bucket.length; k++) {
//            // 如果桶中有数据，我们才放入原数组
//            if (bucketElementCounts[k]!=0){
//                // 有数据，循环
//                for (int l = 0; l < bucketElementCounts[k]; l++) {
//                    arr[index] = bucket[k][l];
//                    index++;
//                }
//            }
//
//            // 保证放数据时每轮都是放在桶的第一个位置
//            bucketElementCounts[k]=0;
//        }
//
//        //第三轮结果
//        System.out.println("第三轮对个位的排序结果"+ Arrays.toString(arr));
//
//        System.out.println(Arrays.toString(bucket[0]));
    }
}
