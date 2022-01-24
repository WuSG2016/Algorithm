package com.wusg.algorithm.easy20.zcy.day01;

import com.wusg.algorithm.src.class16.Edge;
import com.wusg.algorithm.src.class16.Graph;
import com.wusg.algorithm.src.class16.Node;

import org.junit.Test;

import java.util.Comparator;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.Stack;

/**
 * @author WuSG
 * @date : 2022/1/19 21:46
 */
public class Day10_Graph_Prim {

    @Test
    public void reverseStackUnit() {

        Stack<Integer> integers = new Stack<>();
        integers.push(3);
        integers.push(2);
        integers.push(1);
        System.out.println(integers);
        reverseStack(integers);
        System.out.println(integers);
    }

    private void reverseStack(Stack<Integer> integers) {

        if (integers.isEmpty()) {
            return;
        }
        int last = getLastStackNumber(integers);
        reverseStack(integers);
        integers.push(last);

    }

    private int getLastStackNumber(Stack<Integer> integers) {
        int num = integers.pop();
        if (integers.isEmpty()) {
            return num;
        } else {
            int last = getLastStackNumber(integers);
            integers.push(num);
            return last;
        }
    }

    public static class EdgeComparator implements Comparator<Edge> {
        @Override
        public int compare(Edge edge, Edge t1) {
            return edge.weight - t1.weight;
        }
    }

    public static Set<Edge> primMST(Graph graph) {

        HashSet<Node> nodeHashSet=new HashSet<>();
        PriorityQueue<Edge> edgePriorityQueue=new PriorityQueue<>(new EdgeComparator());
        HashSet<Edge> result=new HashSet<>();
        HashSet<Edge> edgesRecord=new HashSet<>();
        for (Node node:graph.nodes.values()){

            if (!nodeHashSet.contains(node)){
                nodeHashSet.add(node);
                for (Edge edge:node.edges){
                    if (!edgesRecord.contains(edge)){
                        edgePriorityQueue.add(edge);
                        edgesRecord.add(edge);
                    }
                }
                while (!edgePriorityQueue.isEmpty()){
                    Edge edge2 = edgePriorityQueue.poll();
                    Node node1 = edge2.to;
                    if (!nodeHashSet.contains(node1)) {
                        nodeHashSet.add(node1);
                        result.add(edge2);
                        for (Edge edge : node1.edges) {
                            if (!edgesRecord.contains(edge)) {
                                edgePriorityQueue.add(edge);
                                edgesRecord.add(edge);
                            }
                        }
                    }


                }
            }

        }
        return result;

    }


}
