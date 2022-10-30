package com.junxiao.gliders;

import org.junit.Test;

public class GliderTest {

    @Test
    public void test1() {
        String str = "gt12cty65mt1";
        System.out.println(solve(str));



    }

    public static int solve(String S) {
        int max = Integer.MIN_VALUE;
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        for(char ch: arr) {
            if(Character.isDigit(ch)){
                sb.append(ch);
                int cur = Integer.parseInt(sb.toString());
                max = Math.max(max, cur);
            }else {
                sb = new StringBuilder();
            }
        }

        return max;
    }


}
