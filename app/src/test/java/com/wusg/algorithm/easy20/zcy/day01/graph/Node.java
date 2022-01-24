package com.wusg.algorithm.easy20.zcy.day01.graph;


import java.util.ArrayList;

/**
 * @author WuSG
 * @date : 2022/1/19 22:06
 */
class Node {
    public int value;
    public int in;
    public int out;
    public ArrayList<Node> nexts;
    public ArrayList<Edge> edges;

    public Node(int value) {
        this.value = value;
        in = 0;
        out = 0;
        nexts = new ArrayList<>();
        edges = new ArrayList<>();
    }

}
