package com.hanyu.search;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1234};
        int indexValue = binarySearch(arr, -1, 0, arr.length-1);
        System.out.println(indexValue);

    }

    public static int binarySearch(int[] arr, int value, int left, int right) {
        if (left > right) {
            System.out.println("没有找到");
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int midValue = arr[mid];
        if (value>midValue) {
            // 向右递归
            return binarySearch(arr, value, mid+1, right);
        }else if (value<midValue){
            return binarySearch(arr,value,left,mid-1);
        }else {
            return mid;
        }
    }
}
