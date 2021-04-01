package com.wusg.binary_tree;
// Copyright  © 2015-2018 Anker Innovations Technology Limited All Rights Reserved.
// The program and materials is not free. Without our permission, any use, including but not limited to reproduction, retransmission, communication, display, mirror, download, modification, is expressly prohibited. Otherwise, it will be pursued for legal liability.

/**
 * @author WuSG
 * @date : 4/1/21 1:42 PM
 */
public class Node {
    public int value;
    public Node leftNode;
    public Node rightNode;

    public Node(int value, Node leftNode, Node rightNode) {
        this.value = value;
        this.leftNode = leftNode;
        this.rightNode = rightNode;
    }
}
