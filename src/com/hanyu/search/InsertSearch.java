package com.hanyu.search;

public class InsertSearch {
    public static void main(String[] args) {

        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        System.out.println(insertSearch(arr, 1, 0, arr.length-1));
    }

    public static int insertSearch(int[] arr,int value , int left, int right){
        if (left > right) {
            System.out.println("没有找到");
            return -1;
        }
        // 就是mid与二分查找时不同
        int mid = left + (right-left) * (value - arr[left]) / (arr[right] - arr[left]);
        int midValue = arr[mid];
        if (value > midValue) {
            // 向右递归
            return insertSearch(arr, value, mid + 1, right);
        } else if (value < midValue) {
            return insertSearch(arr, value, left, mid - 1);
        } else {
            return mid;
        }
    }
}
