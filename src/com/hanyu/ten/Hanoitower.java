package com.hanyu.ten;

// 分治算法解决汉诺塔问题
public class Hanoitower {
    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
    }

    // 汉诺塔移动的方法
    public static void hanoiTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println("第1个盘从"+a+"->"+c);
        }else {
            //两个盘及以上。 可以看作是最下 1.最下边的一个盘2.和上面的所有盘
            // 1. 先把最上面的所有盘从A - B,移动过程种使用到c
            hanoiTower(num-1,a,c,b);

            // 2.把最下面的盘从A-C
            System.out.println("第"+num+"个盘从"+a+"->"+c);

            // 3.把B塔的所有盘从B到C
            hanoiTower(num-1,b,a,c);
        }
    }
}
