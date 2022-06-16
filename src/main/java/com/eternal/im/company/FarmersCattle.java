package com.eternal.im.company;

/**
 * @Auther Eternal
 * @Date 2022/3/19
 *
 * [编程题]农场主牛牛
 *
 * https://www.nowcoder.com/questionTerminal/e2c8f6d0aa9443febc9412f8a2b23bf9?answerType=1&f=discussion
 *
 * 不太懂
 *
 */
public class FarmersCattle {

    public static void main(String[] args) {
        long[] res = func(4, 6);
        for (long i : res) {
            System.out.println(i);
        }
    }
    
    public static long[] func(int n, long m) {
        long[] res = new long[n];

        if (n == 1) {
            res[0] = m;
            return res;
        }

        long round = (m - 1) / (n - 1);
        long more = (m - 1) % (n - 1);

        res[0] = round == 1 ? 1: round / 2 + 1;
        res[n-1] = round % 2 == 0 ? round / 2 : round / 2 + 1;

        for (int i = 1; i < n - 1; i++) {
            res[i] = round % 2 == 0 ? (more <= i -1 ? round: round+1):(more >= n-i-1 ? round+1:round);
        }

        return res;
    }

}
