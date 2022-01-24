package com.wusg.algorithm.easy20.zcy.day01;

import org.junit.Test;

import java.security.PublicKey;

/**
 * @author WuSG
 * @date : 2021/12/9 21:33 堆得实现
 */
public class Day03_HeapAndHeapSort extends Day02_QSort {

    class Heap {

        private int[] heap;
        private int heapSize;
        private int limit;

        public Heap(int limit) {
            heap = new int[limit];
            this.limit = limit;
        }

        private void heapInsert(int[] arr, int index) {
            while (arr[((index - 1) / 2)] < arr[index]) {
                swap(arr, ((index - 1) / 2), index);
                index = ((index - 1) / 2);
            }

        }

        /**
         * 返回最大值
         */
        private int pop() {
            int max = heap[0];
            swap(heap, 0, --heapSize);
            heapify(heap, 0, heapSize);
            return max;

        }

        private void heapify(int[] arr, int index, int heapSize) {
            int left = (index * 2) + 1;
            while (left < heapSize) {
                int largest = left + 1 < heapSize && arr[left] < arr[left + 1] ? left + 1 : left;
                largest = arr[largest] > arr[index] ? largest : index;
                if (largest == index) {
                    break;
                }
                swap(arr, largest, index);
                index = largest;
                left = index * 2 + 1;
            }


        }

        /**
         * 堆排序
         */
        private void heapSort(int[] heap) {
            if (heap == null || heap.length == 0) {
                return;
            }
            //先变成大根堆
            for (int i = heap.length - 1; i >= 0; i--) {
                heapify(heap, i, heap.length);
            }
            println(heap);
            int h_Size = heap.length;
            swap(heap, 0, --h_Size);
            while (h_Size > 0) {
                heapify(heap, 0, h_Size);
                swap(heap, 0, --h_Size);
            }


        }

        public void push(int value) {
            if (heapSize == limit) {
                throw new RuntimeException("no push");
            }
            heap[heapSize++] = value;
            heapInsert(heap, heapSize - 1);

        }

    }

    @Test
    public void testHeapUnit() {
        Heap heap = new Heap(5);
        heap.push(3);
        heap.push(2);
        heap.push(5);
        heap.push(7);
        heap.push(2);

        println(heap.heap);
        heap.pop();
        heap.pop();
        println(heap.heap);

        int[] s = {1, 5, 4, 7, 3, 9, 0};
        heap.heapSort(s);
        println(s);


    }


}
