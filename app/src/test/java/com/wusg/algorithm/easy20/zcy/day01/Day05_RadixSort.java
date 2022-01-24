package com.wusg.algorithm.easy20.zcy.day01;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author WuSG
 * @date : 2021/12/20 23:23
 */
public class Day05_RadixSort {


    @Test
    public void radixUnit() {
        int[] arr = new int[]{1, 20, 4, 5, 230, 3, 6, 11, 114};
        System.out.println(getMaxDigit(arr));
        radixSort(arr, 0, arr.length - 1, getMaxDigit(arr));
        System.out.println(Arrays.toString(arr));


    }

    private int getMaxDigit(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max, arr[i]);
        }
        int count = 0;
        while (max != 0) {
            count++;
            max = max / 10;
        }
        return count;

    }

    public void radixSort(int[] arr, int l, int r, int digit) {

        int radix = 10;
        int i, j;
        int[] help = new int[r - l + 1];

        for (int d = 1; d <= digit; d++) {
            int[] count = new int[radix];
            for (i = l; i <= r; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }
            for (i = 1; i <= count.length - 1; i++) {
                count[i] = count[i] + count[i - 1];
            }
            for (i = r; i >= l; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (int k = 0; k < help.length; k++) {
                arr[k] = help[k];
            }

        }


    }


//    private int getDigit(int value, int d) {
//        return ((value / ((int) Math.pow(10, d - 1))) % 10);
//    }
    public  int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

}
