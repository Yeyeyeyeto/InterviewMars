package com.eternal.im.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Auther Eternal
 * @Date 2022/3/11
 *
 * 小红书2020校招测试开发&后端笔试题卷三
 * [编程题]笔记草稿
 *
 * https://www.nowcoder.com/questionTerminal/0823ca800ee04706a7e2dafc837dc236
 */
public class NotesDraft {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer = new StringBuffer(sc.nextLine());
        List<Integer> k = new ArrayList<>();

        for (int i = 0; i < stringBuffer.length();) {
            if (stringBuffer.charAt(i) == '(') {
                k.add(i);
                i++;
            }
            else if (stringBuffer.charAt(i) == '<' && k.size() == 0) {
                stringBuffer.delete(i - 1, i + 1);
                i = i - 1;
            }
            else if (stringBuffer.charAt(i) == ')') {
                stringBuffer.delete(k.get(k.size() - 1), i + 1);
                i = k.get(k.size() - 1);
                k.remove(k.size() - 1);
            }
            else {
                i++;
            }

            System.out.println(stringBuffer);

        }

    }

}
