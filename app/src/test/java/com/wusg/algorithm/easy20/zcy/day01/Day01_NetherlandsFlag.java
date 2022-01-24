package com.wusg.algorithm.easy20.zcy.day01;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author WuSG
 * @date : 2021/12/7 22:39
 * <p>
 * 荷兰国旗问题
 * 给定一个数组arr，和一个数num，请把小于num的数放在数组的左边，
 * 等于num的数放在数组的中间，大于num的数放在数组的右边。
 * 要求额外空间复杂度O(1)，时间复杂度O(N)
 */
public class Day01_NetherlandsFlag {


    public void NetherlandsFlagQ(int[] arr, int l, int r, int num) {
        if (arr.length <= 0) {
            return;
        }
        System.out.println(arr.length);
        int l_index = -1;
        int r_index = arr.length ;
        int i=0;
        while (i < r_index) {
            if (arr[i] < num) {
                swap(arr,i, l_index++);
                i++;
            }else if (arr[i] > num){
                swap(arr,i,--r_index);
            }else {
                i++;
            }
        }


    }

    @Test
    public void test(){
        int[] arr={1,2};
        NetherlandsFlagQ(arr,0,arr.length-1,0);
        System.out.println(Arrays.toString(arr));

    }




    protected void swap(int[] arr, int l, int r) {

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;

    }

    protected void println(int[] arr){
        System.out.println(Arrays.toString(arr));
    }



}
