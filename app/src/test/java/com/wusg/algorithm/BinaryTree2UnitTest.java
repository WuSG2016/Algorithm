package com.wusg.algorithm;
// Copyright  © 2015-2018 Anker Innovations Technology Limited All Rights Reserved.
// The program and materials is not free. Without our permission, any use, including but not limited to reproduction, retransmission, communication, display, mirror, download, modification, is expressly prohibited. Otherwise, it will be pursued for legal liability.

import com.wusg.binary_tree.TreeNode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * @author WuSG
 * @date : 4/12/21 10:13 AM
 */
public class BinaryTree2UnitTest {
    /**
     * 构造最大二叉树 https://leetcode-cn.com/problems/maximum-binary-tree/submissions/
     */
    @Test
    public void constructMaximumBinaryTreeTest() {

        int[] tressArr = {3, 2, 1, 6, 0, 5};

        TreeNode r = constructMaximumBinaryTree(tressArr,0,tressArr.length-1);
        printTree(r);

    }

    private TreeNode constructMaximumBinaryTree(int[] tressArr, int lo, int hi) {
        if (lo > hi) {
            return null;
        }
        int temp = Integer.MIN_VALUE;
        int j = 0;
        for (int i = lo; i <= hi; i++) {
            if (temp < tressArr[i]) {
                temp = tressArr[i];
                j = i;
            }
        }
        TreeNode node = new TreeNode(temp);
        node.leftNode = constructMaximumBinaryTree(tressArr,lo,j-1);
        node.rightNode = constructMaximumBinaryTree(tressArr,j+1,hi);
        return node;
    }

    /**
     * 打印二叉树 广度优先遍历
     *
     * @param root
     */
    public void printTree(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> nodes = new ArrayDeque<>();
        nodes.add(root);
        while (!nodes.isEmpty()) {
            TreeNode node = nodes.poll();
            if (node == null) {
                break;
            }
            System.out.print(node.value + " ");
            if (node.leftNode != null) {
                nodes.add(node.leftNode);
            }
            if (node.rightNode != null) {
                nodes.add(node.rightNode);
            }
            if (node.next == null) {
                System.out.print("# ");
            }
        }

    }

}
