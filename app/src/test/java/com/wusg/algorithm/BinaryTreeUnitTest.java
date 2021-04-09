package com.wusg.algorithm;
// Copyright  © 2015-2018 Anker Innovations Technology Limited All Rights Reserved.
// The program and materials is not free. Without our permission, any use, including but not limited to reproduction, retransmission, communication, display, mirror, download, modification, is expressly prohibited. Otherwise, it will be pursued for legal liability.

import com.wusg.binary_tree.TreeNode;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

/**
 * 二叉树测试
 *
 * @author WuSG
 * @date : 4/1/21 1:55 PM
 */

public class BinaryTreeUnitTest {

    /**
     * 二叉树的反转
     */
    @Test
    public void invertTreeTest() {
        TreeNode root = getTreeNode();
        TreeNode newRoot = invertTree(root);
        printTree(newRoot);
    }

    private TreeNode getTreeNode() {
        TreeNode Node4 = new TreeNode(4, null, null);
        TreeNode Node5 = new TreeNode(5, null, null);
        TreeNode Node6 = new TreeNode(6, null, null);
        TreeNode Node7 = new TreeNode(7, null, null);
        TreeNode left = new TreeNode(2, Node4, Node5);
        TreeNode right = new TreeNode(3, Node6, Node7);
        return new TreeNode(1, left, right);
    }

    /**
     * 前序遍历 https://leetcode-cn.com/problems/binary-tree-preorder-traversal/
     */
    @Test
    public void preOrderTraversalTest() {
        TreeNode node = getTreeNode();
        List<Integer> list = new ArrayList<>();
        preOrderTraversal(node, list);
        System.out.println(list.toString());


    }

    /**
     * 二叉树转成列表 https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list/
     */
    @Test
    public void flattenTest() {
       //TODO

    }

    private void flatten(TreeNode node) {

    }

    private List<Integer> preOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return list;
        }
        list.add(node.value);
        preOrderTraversal(node.leftNode, list);
        preOrderTraversal(node.rightNode, list);
        return list;
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

    @Test
    public void connectTreeNodeTest1() {
        TreeNode node = connectTreeNode(getTreeNode());
        printTree(node);
    }

    @Test
    public void connectTreeNodeTest2() {
        TreeNode treeNode = getTreeNode();
        connectTreeNode2(treeNode.leftNode, treeNode.rightNode);
        printTree(treeNode);
    }

    public void connectTreeNode2(TreeNode node1, TreeNode node2) {
        if (node1 == null || node2 == null) {
            return;
        }
        node1.next = node2;
        connectTreeNode2(node1.leftNode, node1.rightNode);
        connectTreeNode2(node2.leftNode, node2.rightNode);
        connectTreeNode2(node1.rightNode, node2.leftNode);
    }

    /**
     * 连接二叉树 https://leetcode-cn.com/problems/populating-next-right-pointers-in-each-node/
     */
    public TreeNode connectTreeNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node1 = queue.poll();
                if (node1 == null) {
                    return null;
                }
                if (i < size - 1) {
                    node1.next = queue.peek();
                }
                if (node1.leftNode != null) {
                    queue.add(node1.leftNode);
                }
                if (node1.rightNode != null) {
                    queue.add(node1.rightNode);
                }

            }
        }
        return node;
    }

    private TreeNode invertTree(TreeNode node) {
        if (node == null) {
            return null;
        }
        TreeNode temp = node.leftNode;
        node.leftNode = node.rightNode;
        node.rightNode = temp;

        invertTree(node.leftNode);
        invertTree(node.rightNode);

        return node;
    }


}
