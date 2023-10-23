package com.hanyu.sort;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {-9,0,0,23,-567,70};
        int[] arr = new int[8000000];
        for (int i = 0; i < arr.length; i++) {
            // 随机数为0-80000
            arr[i] = (int) (Math.random() * 80000);
        }
        //


        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为：" + start);

        quickSort(arr, 0, arr.length - 1);

        // 排序后的时间
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为：" + end);
        System.out.println("时间为：" + (end - start));
//        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr, int left, int right) {
        // 两个指针
        int l = left;
        int r = right;
        int pivot = arr[(right - left) / 2 + left];
        int temp;
        // while循环的目的是让比pivot值小的放到左边
        while (l < r) {
            // 在pivot左边找到大于pivot值，才退出
            while (arr[l] < pivot) {
                l++;
            }
            // 在pivot右边找到小于pivot值，才退出
            while (arr[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            if (arr[l]==pivot){
               l++;
            }
            if (arr[r]==pivot){
                r--;
            }
        }
        if (l == r) {
            l += 1;
            r -= 1;
        }
        // 向左递归
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (l < right) {
            quickSort(arr, l, right);
        }


    }
}
