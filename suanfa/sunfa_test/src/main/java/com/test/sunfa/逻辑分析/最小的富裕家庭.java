package com.test.sunfa.逻辑分析;

import java.util.HashMap;
import java.util.Scanner;

//        在一颗树中，每个节点代表一个家庭成员，节点的数字表示其个人的财富值，一个节点及其直接相连的子节点被定义为个小家庭。
//        现给你一颗树，请计算出最富裕的小家庭的财富和。
//        输入描述
//        第一行为一个数 N，表示成员总数，成员编号 1~N。1< N 1000
//
//        第二行为 N 个空格分隔的数，表示编号 1~N 的成员的财富值。0 <=财富值<=  1000000.
//
//        接下来 N-1 行，每行两个空格分隔的整数 (N1,N2) ，表示 N1 是 N2 的父节点
//        输出描述
//        最富裕的小家庭的财富和
//
//        示例1：
//
//        输入：
//
//        4
//        100 200 300 500
//        1 2
//        1 3
//        2 4
//        输出
//        700
//        说明
//        成员1，2，3 组成的小家庭财富值为600成员
//
//        2，4 组成的小家庭财富值为700
public class 最小的富裕家庭 {


    public static void main(String[] args) {
        test1();
    }


    private static void test1() {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] money = new int[count];
        for (int i = 0; i < count; i++) {
            money[i] = scanner.nextInt();
        }
        HashMap<Integer, Integer> hashMap = new HashMap();
        for (int k = 0; k < count - 1; k++) {
            int one = scanner.nextInt() - 1;
            int two = scanner.nextInt() - 1;
            if (hashMap.get(one) != null) {
                hashMap.put(one, money[two] + hashMap.get(one));
            } else {
                hashMap.put(one, money[two] + money[one]);
            }
        }
        System.out.println(hashMap);

        int temp = 0;
        for (int m = 0; m < hashMap.size(); m++) {
            temp = Math.max(temp, hashMap.get(m));
        }
        System.out.println(temp);
    }

}
