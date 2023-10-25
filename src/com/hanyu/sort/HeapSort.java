package com.hanyu.sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {

        int[] arr = new int[10];
        for (int i = 0; i < arr.length; i++) {
            // 随机数为0-80000
            arr[i] = (int) (Math.random() * 80000);
        }

        long start = System.currentTimeMillis();
        System.out.println("排序前的时间为：" + start);

        heapSort(arr,arr.length);

        // 排序后的时间
        long end = System.currentTimeMillis();
        System.out.println("排序后的时间为：" + end);
        System.out.println("时间为：" + (end - start));

        System.out.println(Arrays.toString(arr));
    }

    // 编写一个堆排序的方法
    public static void heapSort(int[] arr, int length) {
        int temp;
        // 保证是个大顶堆
        for (int i = length/2-1; i >=0 ; i--) {
            adjustHeap(arr,i,length);
        }

        // 互换后除了根节点，其它非叶子节点都是大顶堆，所有从根节点开始遍历就行
        for (int j = length-1; j >0; j--) {
            temp = arr[j];
            arr[j] =arr[0];
            arr[0] =temp;
            adjustHeap(arr,0,j);
        }


    }

    // 将一个数组（二叉树），调整成一个大顶堆

    /**
     * 功能：完成，将以i 对应的非叶子节点的树，调整成大顶堆
     *
     * @param arr    待调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 对多少个元素进行调整，逐渐减少
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        // 待调整的非叶子节点的数值
        int temp = arr[i];
        // 开始调整
        // 说明
        // 1.k=2*i+1 k是i的左子节点
        for (int k = i * 2 + 1; k < length; k = k * 2 + 1) {
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                // i的左子节点的值小于右子节点的值
                // k指向右子节点
                k++;
            }
            if (arr[k] > temp) {
                // 如果子节点大于父节点
                // 把大的值，赋给当前节点
                arr[i] = arr[k];
                // i 指向k,继续循环
                i = k;
            } else {
                break;
            }
        }
        // 当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶上
        arr[i] = temp;
    }
}
