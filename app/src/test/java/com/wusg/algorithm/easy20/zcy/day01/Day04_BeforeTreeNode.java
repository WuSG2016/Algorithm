package com.wusg.algorithm.easy20.zcy.day01;

/**
 * @author WuSG
 * @date : 2021/12/20 20:51
 * 前缀树
 */
class Day04_BeforeTreeNode {
    private final TreeNode root;

    class TreeNode {
        int pass;
        TreeNode[] next;
        int end;

        TreeNode() {
            next = new TreeNode[26];
        }
    }

    Day04_BeforeTreeNode() {
        root = new TreeNode();

    }

    public void insert(String value) {
        if (value == null) {
            throw new RuntimeException("value is null");
        }
        char[] insertValues = value.toCharArray();
        TreeNode node = root;
        node.pass++;
        for (char insertValue : insertValues) {
            int path = insertValue - 'a';
            if (node.next[path] == null) {
                node.next[path] = new TreeNode();
            }
            node = node.next[path];
            node.pass++;

        }
        node.end++;

    }

    //      这个单词加入过几次
    public int search(String value) {
        if (value == null) return 0;
        TreeNode node = root;
        char[] chs = value.toCharArray();
        for (char c : chs) {
            int index = c - 'a';
            if (node.next[index] == null) {
                return 0;
            }
            node = node.next[index];
        }
        return node.end;

    }

    //所有加入的字符串中，有几个是以pre字符串做前缀的

    public int preFixNumber(String pre) {
        if (pre == null) return 0;
        TreeNode node = root;
        char[] pres = pre.toCharArray();
        for (char c : pres) {
            int index = c - 'a';
            if (node.next[index] == null) return 0;
        }
        return node.pass;

    }

    //删除一个字符串
    public void delete(String value) {
        //判断是否加入过
        if (search(value) != 0) {
            char[] chars = value.toCharArray();
            TreeNode node = root;
            node.pass--;
            for (char c : chars) {
                int index = c - 'a';
                int pass = --node.next[index].pass;
                if (pass == 0) {
                    node.next[index] = null;
                    return;
                }
                node = node.next[index];
            }
            node.end--;

        }

    }


}
