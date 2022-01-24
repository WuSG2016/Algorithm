package com.wusg.algorithm.easy20.day01;

import org.junit.Test;

import java.util.Arrays;

/**
 * @author WuSG
 * @date : 2021-11-17 22:11
 */
public class SolutionUnitTest {

    @Test
    public void searchUnitTest() {
        int[] arr = new int[]{-1, 0, 3, 5, 9, 12};
        int index = search(arr, 9);
        System.out.println(index);

    }

    @Test
    public void firstBadUnitTest() {


    }

    //注意左移优先级 >>优先级低于+
    //https://leetcode-cn.com/problems/search-insert-position/submissions/
    @Test
    public void searchInsertUnitTest() {

        int[] arr = new int[]{1, 3, 4, 5};
        int index = searchInsert(arr, 6);
        System.out.println(index);
        System.out.println(2 << 3);
    }

    @Test
    public void sortedSquaresUnitTest() {
        int[] arr = new int[]{-7, 1, 3, 4, 5};
        int[] ass = sortedSquares(arr);
        System.out.println(Arrays.toString(ass));

    }

    public int[] sortedSquares(int[] nums) {
        int l = 0, r = nums.length - 1;
        int[] arr = new int[nums.length];
        int i=r;
        while (l <= r) {
            if (nums[l] * nums[l] > nums[r] * nums[r]) {
                arr[i] = nums[l] * nums[l];
                l++;
            } else {
                arr[i] = nums[r] * nums[r];
                r--;

            }
            i--;

        }
        return arr;


    }


    // 不理解题意 先读题 https://leetcode-cn.com/problems/first-bad-version/
    public int firstBadVersion(int n) {
        int left = 0, r = n;

//        while (left <= r) {
//            int mid = left + (r - left) / 2;
//            if (isBadVersion(mid)) {
//                r = mid - 1;
//            } else {
//                left = mid + 1;
//            }
//        }

        return left;


    }

    public int searchInsert(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + ((r - l) >> 1);
            System.out.println("---mid:" + mid);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
                System.out.println("---r:" + r);

            } else {
                l = mid + 1;
                System.out.println("---l:" + l);
            }

        }
        return l;

    }

    //二分查找 https://leetcode-cn.com/problems/binary-search/solution/er-fen-cha-zhao-by-leetcode-solution-f0xw/
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while (l <= r) {
            //防止溢出
            mid = l + ((r - l) / 2);
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }

        }
        return -1;

    }


}
