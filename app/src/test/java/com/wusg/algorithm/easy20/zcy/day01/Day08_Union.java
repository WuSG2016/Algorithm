package com.wusg.algorithm.easy20.zcy.day01;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * @author WuSG
 * @date : 2022/1/12 21:59
 */
class Day08_Union {

    public class UnionNode<V> {

        private V value;

        public UnionNode(V value) {
            this.value = value;
        }

    }


    public class UnionSet<V> {

        private final HashMap<UnionNode<V>, UnionNode<V>> parentMap = new HashMap<>();

        private final HashMap<V, UnionNode<V>> nodesMap = new HashMap<>();

        private final HashMap<UnionNode<V>, Integer> sizeMap = new HashMap<>();

        public UnionSet(List<V> values) {

            for (V v : values) {
                UnionNode<V> node = new UnionNode<V>(v);
                parentMap.put(node, node);
                sizeMap.put(node, 1);
                nodesMap.put(v, node);
            }

        }

        public boolean isSam(V a, V b) {
            if (!nodesMap.containsKey(a) || !nodesMap.containsKey(b)) {
                return false;

            }
            return findFather(nodesMap.get(a)) == findFather(nodesMap.get(b));
        }

        private UnionNode<V> findFather(UnionNode<V> b) {
            final Stack<UnionNode<V>> stack = new Stack<>();
            while (parentMap.get(b) != b) {
                stack.push(b);
                b = parentMap.get(b);
            }
            while (!stack.isEmpty()) {
                parentMap.put(stack.pop(), b);
            }
            return b;

        }

        /**
         * 合并两个集合
         *
         * @param a
         * @param b
         */
        private void union(V a, V b) {

            if (!nodesMap.containsKey(a) || !nodesMap.containsKey(b)) {
                return;
            }

            UnionNode<V> aFather = findFather(nodesMap.get(a));
            UnionNode<V> bFather = findFather(nodesMap.get(b));
            if (aFather != bFather) {
                int aSize = sizeMap.get(aFather);
                int bSize = sizeMap.get(aFather);
                if (aSize > bSize) {
                    parentMap.put(bFather, aFather);
                    sizeMap.put(aFather, aSize + bSize);
                    sizeMap.remove(bFather);
                } else {
                    parentMap.put(aFather, bFather);
                    sizeMap.put(bFather, aSize + bSize);
                    sizeMap.remove(aFather);
                }

            }


        }


    }


}
