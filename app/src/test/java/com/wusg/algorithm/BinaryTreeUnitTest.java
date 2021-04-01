package com.wusg.algorithm;
// Copyright  © 2015-2018 Anker Innovations Technology Limited All Rights Reserved.
// The program and materials is not free. Without our permission, any use, including but not limited to reproduction, retransmission, communication, display, mirror, download, modification, is expressly prohibited. Otherwise, it will be pursued for legal liability.

import com.wusg.binary_tree.Node;

import org.junit.Test;

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
        Node Node4 = new Node(4, null, null);
        Node Node5 = new Node(5, null, null);
        Node Node6 = new Node(6, null, null);
        Node Node7 = new Node(7, null, null);
        Node left = new Node(2, Node4, Node5);
        Node right = new Node(3, Node6, Node7);
        Node root = new Node(1, left, right);
        Node newRoot = invertTree(root);
    }

    private Node invertTree(Node node) {
        if (node == null) {
            return null;
        }
        Node temp = node.leftNode;
        node.leftNode = node.rightNode;
        node.rightNode = temp;

        invertTree(node.leftNode);
        invertTree(node.rightNode);

        return node;
    }


}
