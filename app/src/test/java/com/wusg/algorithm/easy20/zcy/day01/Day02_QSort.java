package com.wusg.algorithm.easy20.zcy.day01;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author WuSG
 * @date : 2021/12/8 22:56 快排 3.0
 */
public class Day02_QSort extends Day01_NetherlandsFlag {

    public void qSortProcess(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }
        int num= (int) (Math.random() * (r - l+ 1));
        System.out.println("num:"+num);
        swap(arr, (int) (l + num ), r);
        int[] equalArea = partition(arr, l, r);
        qSortProcess(arr, l, equalArea[0] - 1);
        qSortProcess(arr, equalArea[1] + 1, r);


    }

    public int[] partition(int[] arr, int l, int r) {
        if (l > r) {
            return new int[]{-1, -1};
        }
        int i = 0, l_index = -1;
        int r_index = r;
        while (i < r_index) {
            if (arr[i] < arr[r]) {
                swap(arr, i++, ++l_index);
            } else if (arr[i] > arr[r]) {
                swap(arr, i, --r_index);
            } else {
                i++;
            }

        }
        swap(arr, r, r_index);
        return new int[]{l_index + 1, r_index};

    }


    @Test
    public void testSortUnit() {
        int[] arr = {1, 2, 6, 3, 7, 0, 2, 2};
//        int [] s=partition(arr,0,arr.length-1);
        qSortProcess(arr, 0, arr.length-1);
//        println(s);
        println(arr);


    }
}
