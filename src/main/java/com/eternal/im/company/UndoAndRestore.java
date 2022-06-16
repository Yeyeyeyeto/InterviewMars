package com.eternal.im.company;

import java.util.Scanner;
import java.util.Stack;

/**
 * @Auther Eternal
 * @Date 2022/3/12
 *
 * 【2020】奇安信秋招Java方向试卷3
 * [编程题]撤销与恢复
 *
 * https://www.nowcoder.com/questionTerminal/46badc29891b4294a3b9cc235a96631a
 */
public class UndoAndRestore {
    public static void main(String[] args) throws InterruptedException {
        Stack<String> usefulWords = new Stack<>();
        Stack<String>  uselessWords = new Stack<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.print("请输入: ");
            String input = sc.nextLine();

            if (input == null || input.equals("")) {
                System.out.println("感谢使用， Bye");
                return;
            }

            String[] inputWords = input.split(" ");
            for (String inputWord : inputWords) {
                if ("undo".equals(inputWord)) {
                    if (!usefulWords.empty()) uselessWords.push(usefulWords.pop());
                } else if ("redo".equals(inputWord)) {
                    if (!uselessWords.empty()) usefulWords.push(uselessWords.pop());
                } else {
                    usefulWords.push(inputWord + " ");
                }
            }

            System.out.println("目前文章：");
            usefulWords.forEach(System.err::print);

            Thread.sleep(100);
            System.out.println();


        }
    }
}
