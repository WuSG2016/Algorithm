package com.wusg.algorithm.easy20.zcy.day01;

import com.wusg.algorithm.src.class10.Code03_UnRecursiveTraversalBT;

import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

/**
 * @author WuSG
 * @date : 2021/12/27 21:41
 */
public class Day06_TreePrint {

    public static class NodeTree {

        public NodeTree left;
        public NodeTree right;
        public int value;

        public NodeTree(int value) {
            this.value = value;
        }
    }

    @Test
    public void preNodeTreeUnit() {
        NodeTree head = getTestNode();
        if (head != null) {
            final Stack<NodeTree> stack = new Stack<>();
            stack.push(head);
            while (!stack.isEmpty()) {
                head = stack.pop();
                System.out.print(head.value + " ");
                if (head.right != null) {
                    stack.push(head.right);
                }
                if (head.left != null) {
                    stack.push(head.left);
                }
            }
        }


    }

    //两个栈
    @Test
    public void pos2NodeTreeUnit() {
        NodeTree head = getTestNode();
        if (head != null) {
            final Stack<NodeTree> stack1 = new Stack<>();
            final Stack<NodeTree> stack2 = new Stack<>();
            stack1.push(head);
            while (!stack1.isEmpty()) {
                head = stack1.pop();
                stack2.push(head);
                if (head.left != null) {
                    stack1.push(head.left);
                }
                if (head.right != null) {
                    stack1.push(head.right);
                }

            }
            while (!stack2.isEmpty()) {
                System.out.print(stack2.pop().value + " ");
            }
        }

    }

    //1个栈
    @Test
    public void pos1NodeTreeUnit() {
        NodeTree head = getTestNode();
        if (head != null) {
            Stack<NodeTree> stack = new Stack<>();
            NodeTree c;
            NodeTree h = head;
            stack.push(head);
            while (!stack.isEmpty()) {
                c = stack.peek();
                if (c.left != null && h != c.left && c.right != h) {
                    stack.push(c.left);
                } else if (c.right != null && h != c.right) {
                    stack.push(c.right);
                } else {
                    System.out.println(stack.pop().value + " ");
                    h = c;
                }
            }
        }


    }


    @Test
    public void inNodeTreeUnit() {
        NodeTree head = getTestNode();
        if (head != null) {
            final Stack<NodeTree> stack1 = new Stack<>();
            while (!stack1.isEmpty() || head != null) {
                if (head != null) {
                    stack1.push(head);
                    head = head.left;
                } else {
                    head = stack1.pop();
                    System.out.print(head.value + " ");
                    head = head.right;
                }
            }

        }

    }

    @Test
    public void levelNodeTreeUnit() {
        NodeTree head = getTestNode();
        if (head != null) {
            final Queue<NodeTree> queue = new ArrayDeque();
            queue.add(head);
            while (!queue.isEmpty()) {
                NodeTree c = queue.poll();
                System.out.print(c.value + " ");
                if (c.left != null) {
                    queue.offer(c.left);
                }
                if (c.right != null) {
                    queue.offer(c.right);
                }

            }

        }

    }
    public void levelNodeTreeUnit2(NodeTree head) {
        if (head != null) {
            final Queue<NodeTree> queue = new ArrayDeque();
            queue.add(head);
            while (!queue.isEmpty()) {
                NodeTree c = queue.poll();
                System.out.print(c.value + " ");
                if (c.left != null) {
                    queue.offer(c.left);
                }
                if (c.right != null) {
                    queue.offer(c.right);
                }

            }

        }

    }



    public NodeTree getTestNode() {
        NodeTree head = new NodeTree(1);
        head.left = new NodeTree(2);
        head.right = new NodeTree(3);
        head.left.left = new NodeTree(4);
        head.left.right = new NodeTree(5);
        head.right.left = new NodeTree(6);
        head.right.right = new NodeTree(7);

        return head;
    }


}
