package com.wusg.algorithm.easy20.zcy.day01.graph;

/**
 * @author WuSG
 * @date : 2022/1/19 22:07
 */
class Edge {
    int wight;
    Node to;
    Node from;

    public Edge(int wight, Node to, Node from) {
        this.wight = wight;
        this.to = to;
        this.from = from;
    }
}
