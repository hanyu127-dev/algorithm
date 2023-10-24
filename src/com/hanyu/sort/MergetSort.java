package com.hanyu.sort;

public class MergetSort {
    public static void main(String[] args) {
//        int[] arr = {8,4,5,7,1,3,6,2};
        // 归并排序需要额外空间

        int[] arr = new int[80000];
        for (int i = 0; i < arr.length; i++) {
            // 随机数为0-80000
            arr[i] = (int) (Math.random() * 80000);
        }
        int[] temp = new int[arr.length];


        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为：" + start);

        mergeSort(arr,0,arr.length-1,temp);

        // 排序后的时间
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为：" + end);
        System.out.println("时间为：" + (end - start));

//        System.out.println(Arrays.toString(arr));
    }

    // 分+和的方法
    public static void mergeSort(int[] arr,int left, int right, int[] temp){
        if (left<right){
            int mid = (right-left)/2+left;
            // 向左递归分解
            mergeSort(arr,left,mid,temp);
            // 向右递归分解
            mergeSort(arr,mid+1,right,temp);

            // 到合并
            merge(arr,left,mid,right,temp);
        }
    }


    /**
     * 合并的方法
     * @param arr 排序的原始数组
     * @param left 左边有序序列的初始索引
     * @param mid 中间索引
     * @param right 右边索引
     * @param temp 做中转的数组
     */
    public static void merge(int[] arr,int left, int mid, int right, int[] temp){
        // i 左边有序序列的初始索引
        int i = left;
        // j 右边有序序列的初始索引
        int j = mid+1;
        int t = 0;
        // 代表temp数组的索引


        // 把左右数组的数组按照规则填充到temo数组
        // 直到左右数组有一边为空，
        while (i<=mid&&j<=right){
            if (arr[i]<=arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else{
                temp[t] = arr[j];
                t++;
                j++;
            }
        }

        // 把剩余的数据的一边的依次填充
        while ( i<=mid){
            temp[t] = arr[i];
            t++;
            i++;
        }

        while (j<=right){
            temp[t] = arr[j];
            t++;
            j++;
        }


        // 把temp的数组拷贝到原始数组
        // 并不是每次都拷贝索引
        t = 0;
        int tempLeft = left;
        while (tempLeft<=right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
