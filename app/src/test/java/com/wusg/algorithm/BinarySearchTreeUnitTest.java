package com.wusg.algorithm;
// Copyright  © 2015-2018 Anker Innovations Technology Limited All Rights Reserved.
// The program and materials is not free. Without our permission, any use, including but not limited to reproduction, retransmission, communication, display, mirror, download, modification, is expressly prohibited. Otherwise, it will be pursued for legal liability.

import com.wusg.binary_tree.TreeNode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

/**
 * @author WuSG
 * @date : 4/20/21 10:20 AM
 */
public class BinarySearchTreeUnitTest {


    /**
     * 二叉搜索树中的第K个最小元素 https://leetcode-cn.com/problems/kth-smallest-element-in-a-bst/
     */
    int count = 0;
    int nes = -1;

    @Test
    public void kthSmallest() {
//        inorder(root, k);
//        return nes;
    }

    private void inorder(TreeNode root, int k) {
        if (root == null || count > k) {
            return;
        }
        inorder(root.leftNode, k);
        count++;
        if (count == k) {
            nes = root.value;
            return;
        }
        inorder(root.rightNode, k);
    }


    /**
     * 二叉搜索树变成累加树 https://leetcode-cn.com/problems/convert-bst-to-greater-tree/
     */
    @Test
    public void convertBST() {
        //先遍历右子树
        TreeNode root = getBST();
//        rightOrder(root);
        printTree(root);

    }

    /**
     * 获取二叉搜索树
     *
     * @return
     */
    private TreeNode getBST() {
        TreeNode treeNode8 = new TreeNode(8, null, null);
        TreeNode treeNode7 = new TreeNode(7, null, treeNode8);
        TreeNode treeNode5 = new TreeNode(5, null, null);
        TreeNode treeNode6 = new TreeNode(6, treeNode5, treeNode7);

        TreeNode treeNode3 = new TreeNode(3, null, null);
        TreeNode treeNode2 = new TreeNode(2, null, treeNode3);
        TreeNode treeNode0 = new TreeNode(0, null, null);
        TreeNode treeNode1 = new TreeNode(1, treeNode0, treeNode2);

        return new TreeNode(4, treeNode1, treeNode6);
    }


    int sum = 0;

    private void rightOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        rightOrder(root.rightNode);
        sum += root.value;
        root.value = sum;
        rightOrder(root.leftNode);
    }

    private void printTree(TreeNode treeNode) {
        Queue<TreeNode> queue = new ArrayDeque();
        if (treeNode == null) {
            return;
        }
        queue.add(treeNode);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                System.out.println(node.value);
            }
            if (node != null && node.leftNode != null) {
                queue.add(node.leftNode);
            }
            if (node != null && node.rightNode != null) {
                queue.add(node.rightNode);
            }
        }
    }

    private void printDfs(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        printTree(treeNode.leftNode);
        System.out.println(treeNode.value);
        printTree(treeNode.rightNode);
    }

    @Test
    public void tes() {
        TreeNode treeNode = getBST();
       System.out.println(isValidBST(treeNode));
    }

    /**
     * 验证是否是二叉搜索树 https://leetcode-cn.com/problems/validate-binary-search-tree/submissions/
     *
     * @param treeNode
     */
    private long pre = Long.MIN_VALUE;

    private boolean isValidBST(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        boolean l = isValidBST(treeNode.leftNode);
        if (!l) {
            return false;
        } else {
            if (pre >= treeNode.value) {
                return false;
            }
            pre = treeNode.value;
            return isValidBST(treeNode.rightNode);
        }
    }
}
