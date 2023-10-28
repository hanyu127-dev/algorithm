package com.hanyu.ten;

public class BinarySearchNoRecur {
    public static void main(String[] args) {
        int[] arr = {1,3, 8, 10, 11, 67, 100};
        int i = binarySearch(arr, 2);
        System.out.println(i);
    }

    // 二分查找算法的非递归实现

    /**
     *
     * @param arr 待查找的数组,arr是升序排序
     * @param target 需要查找的树
     * @return 返回对应的下标，-1表示没有
     */
    public static int binarySearch(int[] arr, int target){
        int left=0;
        int right = arr.length-1;
        while (left<=right){
            int mid = (right-left)/2+left;
            if (arr[mid]==target){
                return mid;
            }else if (arr[mid]>target){
                right = mid-1;
            }else {
                left = mid+1;
            }
        }

        return -1;
    }
}
