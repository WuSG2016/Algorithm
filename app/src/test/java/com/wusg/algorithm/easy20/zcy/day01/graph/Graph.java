package com.wusg.algorithm.easy20.zcy.day01.graph;

import com.wusg.algorithm.src.class17.Edge;
import com.wusg.algorithm.src.class17.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author WuSG
 * @date : 2022/1/19 22:08
 */
class Graph {
    public HashMap<Integer, Node> nodes;
    public HashSet<Edge> edges;

    public Graph() {
        nodes = new HashMap<>();
        edges = new HashSet<>();
    }

}
