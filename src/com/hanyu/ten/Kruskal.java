package com.hanyu.ten;

import java.util.Arrays;
// 克鲁斯卡尔
public class Kruskal {
    private int edgeNum;// 边的个数
    private char[] vertexs;// 顶点数组
    private int[][] matrix; //邻接矩阵
    private static final int INF = Integer.MAX_VALUE;

    public Kruskal(char[] vertexs, int[][] matrix) {
        this.vertexs = vertexs;
        this.matrix = matrix;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                if (matrix[i][j] != 1000) {
                    edgeNum++;
                }
            }
        }
    }

    public void print() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // 边根据权值进行排序
    private void sortEdges(EData[] edges) {
        for (int i = 0; i < edges.length - 1; i++) {
            for (int j = 0; j < edges.length - 1 - i; j++) {
                if (edges[j].weight > edges[j + 1].weight) {
                    EData eData = edges[j];
                    edges[j] = edges[j + 1];
                    edges[j + 1] = eData;
                }


            }
        }
    }

    /**
     * @param ch 顶点的值，
     * @return 返回对应顶点的小标
     */
    private int getPosition(char ch) {
        for (int i = 0; i < vertexs.length; i++) {
            if (vertexs[i] == ch) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取图中的边，放到EData数组
     *
     * @return 返回数组
     */
    private EData[] getEdges() {
        int index = 0;
        EData[] edegs = new EData[edgeNum];
        for (int i = 0; i < vertexs.length; i++) {
            for (int j = i + 1; j < vertexs.length; j++) {
                if (matrix[i][j] != 1000) {
                    edegs[index++] = new EData(vertexs[i], vertexs[j], matrix[i][j]);
                }
            }
        }
        return edegs;
    }

    public static void main(String[] args) {
        char[] data = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] weight = {
                {1000, 12, 1000, 1000, 1000, 16, 14},
                {12, 1000, 10, 1000, 1000, 7, 1000},
                {1000, 10, 1000, 3, 5, 6, 1000},
                {1000, 1000, 3, 1000, 4, 1000, 1000},
                {1000, 1000, 5, 4, 1000, 2, 8},
                {16, 7, 6, 1000, 2, 1000, 9},
                {14, 1000, 1000, 1000, 8, 9, 1000}
        };
        Kruskal kruskal = new Kruskal(data, weight);
//        System.out.println("排序前结果：");
//        EData[] edges = kruskal.getEdges();
//        System.out.println(Arrays.toString(edges));
//        // 排序
//        System.out.println("排序后结果");
//        kruskal.sortEdges(edges);
//        System.out.println(Arrays.toString(edges));
        kruskal.kruskal();


    }

    /**
     * 获取下标为i的顶点的终点
     * 开始时ends为【0,0,0,,0,0,0, 0,0,0, 0,0,0】
     * @param ends 终点的数组
     * @param i    下标为i的顶点
     * @return 返回下标为i的顶点的终点，一会在说
     */
    private int getEnd(int[] ends, int i) {
        while (ends[i] != 0) {
            i = ends[i];
        }
        return i;
    }

    public void kruskal() {
        // 表示最后结果数组的索引
        int index = 0;
        // 用于保存“已有最小生成树”中的每个顶点在最小生成树的终点
        int[] ends = new int[edgeNum];
        // 创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgeNum];
        // 获取图中，所有的边的集合
        EData[] edges = getEdges();
        System.out.println("图的边的集合=" + Arrays.toString(edges) + "共" + edges.length);

        // 排序，按照边的全职进行排序
        sortEdges(edges);

        // 遍历edges数组，将边添加到最小生成树，并判断准备加入的边是否构成回路

        for (int i = 0; i < edgeNum; i++) {
            //获取第i条边的启动,终点
            int p1 = getPosition(edges[i].start);  // p1 = 4
            int p2 = getPosition(edges[i].end); // p2 =5

            // 获取两个顶点的在已有最小生成树的终点
            int m = getEnd(ends, p1); // m=4
            int n = getEnd(ends, p2); // n=5

            // 判断是否构成回路
            if (m != n) {
                // 设置m在最小生成树的终点为n
                ends[m] = n;
                // 有一条边加入rets数组
                rets[index++] = edges[i];
            }
        }

        // 统计并打印最小生成树
        System.out.println("最小生成树为："+Arrays.toString(rets));

    }


}

class EData {
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
