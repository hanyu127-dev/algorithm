package com.hanyu.search;

import java.util.ArrayList;
import java.util.List;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        List<Integer> indexValue = binarySearch2(arr, 1000, 0, arr.length - 1);
        System.out.println(indexValue);

    }


    // 简单写法，只能得出value的一个位置
    public static int binarySearch(int[] arr, int value, int left, int right) {
        if (left > right) {
            System.out.println("没有找到");
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int midValue = arr[mid];
        if (value > midValue) {
            // 向右递归
            return binarySearch(arr, value, mid + 1, right);
        } else if (value < midValue) {
            return binarySearch(arr, value, left, mid - 1);
        } else {
            return mid;
        }
    }


    public static List<Integer> binarySearch2(int[] arr, int value, int left, int right) {

        if (left > right) {
            System.out.println("没有找到");
            return new ArrayList<Integer>();

        }
        int mid = (right - left) / 2 + left;
        int midValue = arr[mid];
        if (value > midValue) {
            // 向右递归
            return binarySearch2(arr, value, mid + 1, right);
        } else if (value < midValue) {
            return binarySearch2(arr, value, left, mid - 1);
        } else {

            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (temp >= 0 && arr[temp] == value) {
                list.add(temp);
                temp--;
            }
            list.add(mid);
            temp = mid+1;
            while (temp <= right && arr[temp] == value) {
                list.add(temp);
                temp++;
            }

            return list;
        }
    }
}
