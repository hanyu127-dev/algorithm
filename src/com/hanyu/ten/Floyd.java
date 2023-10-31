package com.hanyu.ten;

import java.util.Arrays;

// 弗洛伊德算法
public class Floyd {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        // N代表不可连接
        final int N = 65535;
        matrix[0] = new int[]{0, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, 0, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, 0, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, 0, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, 0, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, 0, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, 0};
        FGraph fGraph = new FGraph(vertex.length,matrix,vertex);
        fGraph.floyd();
        fGraph.show();
    }

}

class FGraph{
    // 存放顶点的数组
    private char[] vertex;
    // 保存结果
    private int[][] dis;
    // 保存前驱结点
    private int[][] pre;

    public FGraph(int len,int[][] matrix,char[] vertex) {
        this.dis = matrix;
        this.vertex = vertex;
        pre = new int[len][len];
        for (int i = 0; i < len; i++) {
            Arrays.fill(pre[i],i);
        }

    }

    public void show(){
        System.out.println("=========");
        for (int i = 0; i < vertex.length; i++) {
            System.out.println(Arrays.toString(pre[i]));

        }
        System.out.println("=========");
        for (int i = 0; i < vertex.length; i++) {
            System.out.println(Arrays.toString(dis[i]));

        }
    }

    public void floyd(){
        int len = 0;
        // 对中间结点的遍历
        for (int k = 0; k < vertex.length; k++) {
            // 对出发结点的边路
            for (int i = 0; i < vertex.length; i++) {
                // 对终点的遍历
                for (int j = 0; j < vertex.length; j++) {
                    len = dis[i][k]+dis[k][j];
                    if (len<dis[i][j]){
                        // 更新距离
                        dis[i][j] = len;
                        // 更新前驱结点
                        pre[i][j] = pre[k][j];
                    }
                }
            }
        }
    }
}
