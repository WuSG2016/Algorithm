package com.wusg.algorithm.easy20.zcy.day01;

import org.junit.Test;

import java.util.List;

/**
 * @author WuSG
 * @date : 2022/1/18 22:58
 */
public class Day09_Hanoi {


    @Test
    public void HanoiUnitTest() {

        hanoiUnit(3, "from", "to", "other");


    }

    private void hanoiUnit(int n, String f, String t, String o) {
        if (n == 1) {
            System.out.println("Move 1 " + f + "---" + t);
            return;
        }
        //n-1 from - other
        hanoiUnit(n - 1, f, o, t);
        System.out.println("Move " + n + "" + f + "---" + t);
        //n-1
        hanoiUnit(n - 1, o, t, f);
    }

    private void hanoiUnit(List<Integer> a, List<Integer> b, List<Integer> c) {
        hanoiUnit2(a.size(), a, b, c);
        System.out.println();
    }

    private void hanoiUnit2(int size, List<Integer> a, List<Integer> b, List<Integer> c) {

        if (size == 1) {
            c.add(a.remove(a.size() - 1));
        }
        hanoiUnit2(size-1,a,c,b);
        c.add(a.remove(a.size()-1));
        hanoiUnit2(size-1,b,a,c);
    }


}
