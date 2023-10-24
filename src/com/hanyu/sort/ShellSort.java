package com.hanyu.sort;

/**
 * @author 李小帅
 */
public class ShellSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            // 随机数为0-80000
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为：" + start);

        shellSort(arr);

        // 排序后的时间
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为：" + end);
        System.out.println("时间为：" + (end - start));


    }

    public static void shellSort2(int[] arr) {
        // 增量gap,逐步缩小
        for (int gap = arr.length/2;gap>0;gap/=2){
            // 从
            for (int i = gap; i < arr.length; i++) {
                int j = i;
                int temp = arr[j];
                if (arr[j]<arr[j-gap]){
                    while (j-gap>=0&&temp<arr[j-gap]){
                        // 后移
                        arr[j] = arr[j-gap];
                        j -= gap;


                    }
                    if (temp!=arr[j]){
                        arr[j] =temp;
                    }
                }
            }
        }
    }

    public static void shellSort(int[] arr) {

        // 交换法
        int temp;
        for (int gap = arr.length/2;gap>0;gap/=2){

            for (int i = gap; i < arr.length; i++) {
                // 遍历各组中的元素（共gap组，每组有length/gap个元素）
                for (int j = i - gap; j >= 0; j -= gap) {
                    // 如果当前元素大于加上步长后的哪个元素，则需要交换
                    if (arr[j] > arr[j + gap]) {
                        temp = arr[j];
                        arr[j] = arr[j + gap];
                        arr[j + gap] = temp;
                    }
                }
            }
        }








        // 逐步推导
        // 希尔排序的第1轮排序
        // 将10个数据分为5组
        // i表示分组的数量
//        int temp;
//        for (int i = 5; i < arr.length; i++) {
//            // 共5组，每组两个元素
//            for (int j = i - 5; j >= 0; j -= 5) {
//                // 如果当前元素大于加上步长后的哪个元素，则需要交换
//                if (arr[j] > arr[j + 5]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 5];
//                    arr[j + 5] = temp;
//                }
//            }
//        }
//
//        System.out.println("第一轮元素处理完毕，数组为："+ Arrays.toString(arr));
//
//
//
//        for (int i = 2; i < arr.length; i++) {
//            // 共2组，每组5个元素
//            for (int j = i - 2; j >= 0; j -= 2) {
//                // 如果当前元素大于加上步长后的哪个元素，则需要交换
//                if (arr[j] > arr[j + 2]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 2];
//                    arr[j + 2] = temp;
//                }
//            }
//        }
//
//        System.out.println("第二轮元素处理完毕，数组为："+ Arrays.toString(arr));
//
//
//        for (int i = 1; i < arr.length; i++) {
//            // 共2组，每组5个元素
//            for (int j = i - 1; j >= 0; j -= 1) {
//                // 如果当前元素大于加上步长后的哪个元素，则需要交换
//                if (arr[j] > arr[j + 1]) {
//                    temp = arr[j];
//                    arr[j] = arr[j + 1];
//                    arr[j + 1] = temp;
//                }
//            }
//        }
//
//        System.out.println("第三轮元素处理完毕，数组为："+ Arrays.toString(arr));


    }

}
