package com.wusg.algorithm.easy20.zcy.day01;

import org.junit.Test;

import java.util.Stack;

/**
 * @author WuSG
 * @date : 2021/12/27 22:58
 */
public class Day07_TreePrinter extends Day06_TreePrint {


    @Test
    public void printTree() {
//
//        NodeTree nodeTree = getTestNode();
//        valpr(nodeTree);
//        levelNodeTreeUnit2(nodeTree);
        sd(250,2);

    }

    public void pr(NodeTree nodeTree) {
        if (nodeTree == null) {
            return;
        }
        System.out.println(nodeTree.value);

        pr(nodeTree.left);
        pr(nodeTree.right);
    }

    public void valpr(NodeTree nodeTree) {
        if (nodeTree == null) {
            return;
        }
        swapTree(nodeTree);

        valpr(nodeTree.left);
        valpr(nodeTree.right);
    }

    public void sd(int n, int re) {
        Stack<Integer> stack = new Stack<>();

        while (n  > 0) {
            stack.push(n % re);
            n = n / re;
        }
        while (!stack.isEmpty()){
            System.out.print(stack.pop());
        }
        System.out.println(" ");

    }

    private void swapTree(NodeTree nodeTree) {
        NodeTree temp = nodeTree.left;
        nodeTree.left = nodeTree.right;
        nodeTree.right = temp;

    }


}
