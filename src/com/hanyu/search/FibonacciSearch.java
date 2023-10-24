package com.hanyu.search;

import java.util.Arrays;

public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1, 8, 10, 89, 1000, 1000, 1234};
        int index = fibSearch(arr, 1000);
        System.out.println(index);

    }
    // 因为后面我们的mid = low+F(k-1)-1，需要使用到斐波那契数列，因此我们先获取一个斐波那契数列
    public static int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }

    // 编写斐波那契查找算法

    /**
     * @param arr 数组
     * @param key 要查找的值
     * @return 对应下标，没有，则返回-1
     */
    public static int fibSearch(int[] arr,int key){
        int low = 0;
        int high = arr.length-1;
        // 斐波那契分割数值的下标
        int k = 0 ;
        int mid =0;
        // 获取到斐波那契数列
        int[] F = fib();
        while (high>F[k]-1){
            k++;
        }
        // 因为F[k]值可能大于arr的长度,因此我们需要使用Arrays类，需要构造一个新的数组，并指向arr
        // 不足部分用最后一个值填充
        int[] temp = Arrays.copyOf(arr,F[k]);
        for (int i = high+1; i < temp.length ; i++) {
            temp[i] = arr[high];

        }

        // 使用while循环来处理，找到我们对应的key
        while (low<=high){
            mid = low+F[k-1]-1;
            if (key<temp[mid]){
                // 向数组左边查找
                high = mid-1;
                // 为什么是k--,
                // F[k-1] =F[k-2]+F[k-3]
                // 下次循环mid=F[k-1-1]-1;
                k--;
            }else if (key>temp[mid]){
                low = mid+1;
                // 为什么k-2;
                // F[k-1] =F[k-2]+F[k-3]
                k-=2;
            }else {
                if (mid<=high){
                    return mid;
                }else {
                    return high;
                }
            }
        }
        // 没有找到
        return -1;
    }
}
