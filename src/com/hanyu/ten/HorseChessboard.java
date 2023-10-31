package com.hanyu.ten;

import java.awt.*;
import java.util.ArrayList;
import java.util.Comparator;

// 马踏棋盘算法
public class HorseChessboard {
    // 棋盘的列数
    private static int X;
    // 棋盘的行数
    private static int Y;
    // 标记棋盘的位置是否被访问过了
    private static boolean[] visited;
    // 标记棋盘的所有位置都被访问了
    private static boolean finished;

    public static void main(String[] args) {
        // 测试
        X = 8;
        Y = 8;
        int row = 2;
        int column =4;
        // 创建棋盘
        int[][] chessboard = new int[X][Y];
        visited = new boolean[X*Y];
        long start = System.currentTimeMillis();
        traversalChessboard(chessboard,row-1,column-1,1);
        long end = System.currentTimeMillis();

        System.out.println("耗时为"+(end-start)+"ms");

        // 输出棋盘的情况
        for (int[] rows : chessboard) {
            for (int step : rows) {
                System.out.print(step+"\t");
            }
            System.out.println();
        }
    }

    // 马踏棋盘核心算法
    // x:column:列
    // y:row 行
    public static void traversalChessboard(int[][] chessboard, int row, int column, int step) {
        // 棋盘
        chessboard[row][column] = step;
        // row:行，
        // 标记棋盘的哪个位置已访问
        visited[row * X + column] = true;
        // 获取当前位置可以走的下一个位置的集合
        ArrayList<Point> next = next(new Point(column, row));
        sort(next);
        while (!next.isEmpty()) {
            // 取出下一个可以走的位置
            Point p = next.remove(0);
            // 判断该点是否已经被访问过
            if (!visited[p.y * X + p.x]) {
                // 还没有访问过，继续访问
                traversalChessboard(chessboard, p.y, p.x, step + 1);
            }
        }

        // 判断马是否完成，没有完成，则置0
        // step < X * Y 成立的情况分为两种
        // 1.棋盘到目前位置，仍然没有走完
        // 2.棋盘走完了，目前处于回溯过程
        if (step < X * Y && !finished) {
            chessboard[row][column] = 0;
            visited[row * X + column] = false;
        } else {
            finished = true;
        }
    }


    // 根据马的位置，得到马可以走那些位置
    public static ArrayList<Point> next(Point curPoint) {
        ArrayList<Point> points = new ArrayList<>();
        Point p1 = new Point();
        // 判断5位置是否可以走
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        // 判断6位置是否可以走
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        // 判断7位置是否可以走
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y - 2) >= 0) {
            points.add(new Point(p1));
        }
        // 判断0位置是否可以走
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y - 1) >= 0) {
            points.add(new Point(p1));
        }
        // 判断1位置是否可以走
        if ((p1.x = curPoint.x + 2) < X && (p1.y = curPoint.y + 1) < Y) {
            points.add(new Point(p1));
        }
        // 判断2位置是否可以走
        if ((p1.x = curPoint.x + 1) < X && (p1.y = curPoint.y + 2) < Y) {
            points.add(new Point(p1));
        }
        // 判断3位置是否可以走
        if ((p1.x = curPoint.x - 1) >= 0 && (p1.y = curPoint.y + 2) < Y) {
            points.add(new Point(p1));
        }
        if ((p1.x = curPoint.x - 2) >= 0 && (p1.y = curPoint.y + 1) < Y) {
            points.add(new Point(p1));
        }
        return points;
    }


    // 根据当前这一步的所有的下一步的选择位置，进行非递减排序
    public static void sort(ArrayList<Point> ps){
        ps.sort(new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                int count1 = next(o1).size();
                int count2 = next(o2).size();
                if (count1<count2){
                    return -1;
                }else if (count1==count2){
                    return 0;
                }else {
                    return 1;
                }
            }
        });
    }
}
