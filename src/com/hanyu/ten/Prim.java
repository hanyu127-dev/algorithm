package com.hanyu.ten;

import java.util.Arrays;

// 普里姆算法
public class Prim {
    public static void main(String[] args) {
        // 测试图是否创建成功
        char[] data = new char[]{'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int verxs = data.length;
        // 邻接矩阵的关系使用二维数组表示
        int[][] weight = new int[][]{
                {10000, 5, 7, 10000, 10000, 10000, 2},
                {5, 10000, 10000, 9, 10000, 10000, 3},
                {7, 10000, 10000, 10000, 8, 10000, 10000},
                {10000, 9, 10000, 10000, 10000, 4, 10000},
                {10000, 10000, 8, 10000, 10000, 5, 4},
                {10000, 10000, 10000, 4, 5, 10000, 6},
                {2, 3, 10000, 10000, 4, 6, 10000}
        };

        // 创建MGraph对象
        MGraph graph = new MGraph(verxs);

        // 生成一个minTree对象
        MinTree minTree = new MinTree();
        minTree.createGraph(graph, verxs, data, weight);
        minTree.showGraph(graph);
        minTree.prim(graph,5);

    }
}

// 创建最小生成树 -> 村庄的图
class MinTree {
    // 创建图的邻接矩阵

    /**
     * @param graph  图对象
     * @param verxs  图对应的顶点个数
     * @param data   图的各个顶点的值
     * @param weight 图是邻接矩阵
     */
    public void createGraph(MGraph graph, int verxs, char data[], int[][] weight) {
        int i, j;
        for (i = 0; i < verxs; i++) {
            graph.data[i] = data[i];
            for (j = 0; j < verxs; j++) {
                graph.wieight[i][j] = weight[i][j];
            }
        }


    }


    // 显示图的方法
    public void showGraph(MGraph graph) {
        for (int i = 0; i < graph.verxs; i++) {
            System.out.println(Arrays.toString(graph.wieight[i]));
        }
    }

    // 编写Prim算法，得到最小生成树

    /**
     * @param graph 图
     * @param v     表示从图的哪个顶点开始生成
     */
    public void prim(MGraph graph, int v) {
        // visited标记结点是否被访问过，默认为0，表示没有被访问过
        int[] visited = new int[graph.verxs];

        // 把当前结点标记为已访问
        visited[v] = 1;
        // 记录两个顶点的下标
        int h1 = -1;
        int h2 = -1;
        int minWeight = 10000;
        for (int k = 1; k < graph.verxs; k++) {
            // n个顶点会生成n-1条边

            // 确定每一次生成的子图，和哪个结点的距离最近
            for (int i = 0; i < graph.verxs; i++) {
                // i表示已经访问的结点，j表示未被访问的结点
                for (int j = 0; j < graph.verxs; j++) {
                    if (visited[i] == 1 && visited[j] == 0 && graph.wieight[i][j] < minWeight) {
                        // 当前已经被访问的点，当前点能访问到的为被访问的点
                        minWeight = graph.wieight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }
            // 找到一条边最小
            System.out.println("边<"+graph.data[h1]+","+graph.data[h2]+"> 权值："+minWeight );
            // 将当前找到的结点标记为已访问
            visited[h2] = 1;
            // 重置minWeight
            minWeight = 10000;
        }

    }
}

class MGraph {
    int verxs; // 表示图的结点个数
    char[] data; // 存放结点数据
    int[][] wieight; // 存放边，及邻接矩阵

    public MGraph(int verxs) {
        this.verxs = verxs;
        data = new char[verxs];
        wieight = new int[verxs][verxs];
    }
}

