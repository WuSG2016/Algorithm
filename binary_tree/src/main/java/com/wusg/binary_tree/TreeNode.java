package com.wusg.binary_tree;
// Copyright  © 2015-2018 Anker Innovations Technology Limited All Rights Reserved.
// The program and materials is not free. Without our permission, any use, including but not limited to reproduction, retransmission, communication, display, mirror, download, modification, is expressly prohibited. Otherwise, it will be pursued for legal liability.

/**
 * @author WuSG
 * @date : 4/1/21 1:42 PM
 */
public class TreeNode {
    public int value;
    public TreeNode leftNode;
    public TreeNode rightNode;
    public TreeNode next;

    public TreeNode(int value, TreeNode leftNode, TreeNode rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
