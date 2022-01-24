package com.wusg.algorithm.easy20.zcy.day01;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author WuSG
 * @date : 2022/1/23 22:08
 */
public class Day11_StringSub {


    @Test
    public void testStringSubUnit() {

        String str = "abc";
        final ArrayList<String> result = new ArrayList<>();
        process(str.toCharArray(), 0, result);
        for (String s : result) {
            System.out.println(s);
        }


    }

    private void process(char[] str, int i, ArrayList<String> result) {
        if (i == str.length) {
            result.add(String.valueOf(str));
        }
        for (int j = i; j < str.length; j++) {
            swapStringByIndex(str, i, j);
            process(str, i+1, result);
            swapStringByIndex(str, i, j);
        }


    }

    private void swapStringByIndex(char[] str, int i, int i1) {
        char temp = str[i];
        str[i] = str[i1];
        str[i1] = temp;
    }

}
