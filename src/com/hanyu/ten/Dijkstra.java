package com.hanyu.ten;

import java.util.Arrays;

// 迪杰斯特拉算法 - 最短路径
// 三个动态更新数组
public class Dijkstra {
    public static void main(String[] args) {
        char[] vertex = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        int[][] matrix = new int[vertex.length][vertex.length];
        // N代表不可连接
        final int N = 65535;
        matrix[0] = new int[]{N, 5, 7, N, N, N, 2};
        matrix[1] = new int[]{5, N, N, 9, N, N, 3};
        matrix[2] = new int[]{7, N, N, N, 8, N, N};
        matrix[3] = new int[]{N, 9, N, N, N, 4, N};
        matrix[4] = new int[]{N, N, 8, N, N, 5, 4};
        matrix[5] = new int[]{N, N, N, 4, 5, N, 6};
        matrix[6] = new int[]{2, 3, N, N, 4, 6, N};

        // 创建图
        Graph graph = new Graph(vertex, matrix);
        System.out.println();

        graph.dsj(6);

    }
}

//已访问顶点集合
class Visited_vertex {
    //记录各个顶点是否访问过  1表示访问过,0未访问,会动态更新
    public int[] already_arr;
    //每个下标对应的值为前一个顶点下标, 会动态更新
    public int[] pre_visited;
    //记录出发顶点到其他所有顶点的距离,比如G为出发顶点，就会记录G到其它顶点的距离，会动态更新，求的最短距离就会存放到dis
    public int[] dis;
    // 构造器

    /**
     *
     * @param length 表示顶点的个数
     * @param index 表示出发顶点的下标
     */
    public Visited_vertex(int length,int index) {
        this.already_arr = new int[length];
        this.pre_visited = new int[length];
        this.dis = new int[length];
        // 初始化dis数组
        Arrays.fill(dis,65535);
        // 设置出发顶点到自己的访问距离为0
        this.dis[index] = 0;
        this.already_arr[index] =1;
    }

    /**
     * 功能：判断index顶点是否被访问过
     * @param index 顶点下标
     * @return 如果访问过，就返回true
     */
    public boolean in(int index){
        return already_arr[index] ==1;
    }

    /**
     * 功能：更新出发顶点到index顶点的距离
     * @param index 目标顶点
     * @param len 距离
     */
    public void updateDis(int index, int len){
        dis[index] = len;
    }

    /**
     * 功能：更新pre这个结点的前驱结点是index
     * @param pre 顶点
     * @param index 前驱结点
     */
    public void updatePre(int pre,int index){
        pre_visited[pre] = index;
    }

    /**
     * 功能：返回出发结点到顶点的距离
     * @param index 目标结点
     * @return 返回出发到目标顶点的距离
     */
    public int getDis(int index){
        return  dis[index];
    }

    // 继续选择并返回新的访问顶点
    public int updateArr(){
        int min =65535, index =0 ;
        for (int i = 0; i < already_arr.length; i++) {
            if (already_arr[i]==0&&dis[i]<min){
                min = dis[i];
                index = i;
            }
        }
        // 更新index结点被访问过
        already_arr[index] =1;

        return index;
    }

    // 显示最后的结果
    public void show(){
        System.out.println("================");
        System.out.println(Arrays.toString(already_arr));
        System.out.println("================");
        System.out.println(Arrays.toString(pre_visited));
        System.out.println("================");
        System.out.println(Arrays.toString(dis));
    }
}

class Graph {
    // 顶点数组
    private char[] vertex;
    // 邻接矩阵
    private int[][] matrix;
    private Visited_vertex vv;

    public Graph(char[] vertex, int[][] matrix) {
        this.vertex = vertex;
        this.matrix = matrix;
    }

    // 显示图
    public void showGraph() {
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    // 迪杰斯特拉算法实现

    /**
     *
     * @param index 出发结点定义的下标
     */
    public void dsj(int index){
         this.vv = new Visited_vertex(vertex.length, index);
         update(index);
        for (int i = 1; i <vertex.length ; i++) {
            index = vv.updateArr();
            update(index);
        }
        vv.show();
    }

    // 更新index下标顶点到周围顶点的距离和周围顶点的前驱顶点
    private void update(int index){
        int len = 0;
        // 根据遍历邻接矩阵
        for (int i = 0; i < matrix[index].length; i++) {
            // len 含义: 出发顶点到index顶点的距离
            len = vv.getDis(index)+ matrix[index][i];
            if (!vv.in(i) && len<vv.getDis(i)){
                // 跟新i的前驱为index
                vv.updatePre(i,index);
                // 跟新出发结点到i的距离
                vv.updateDis(i,len);
            }
        }
    }
}