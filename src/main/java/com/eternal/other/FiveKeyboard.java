package com.eternal.other;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @Auther Eternal
 * @Date 2022/5/28
 */
public class FiveKeyboard {
    public static void main(String[] args) {

        StringBuilder result = new StringBuilder("");
        StringBuilder other = new StringBuilder("");


        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        // 是否全选
        int isSel = 0;

        ArrayList<Integer> codes = new ArrayList<>();

        for (String s : str.split(" ")) {
            codes.add(Integer.parseInt(s));
        }

        for (int i = 0; i < codes.size(); i++) {
            int code = codes.get(i);
            if (code == 1 && isSel == 1) {
                // 全选时输出a
                result = new StringBuilder("a");
                isSel = 0;
            } else if (code == 1) {
                // 输出a
                result.append('a');
            } else if (code == 2 && isSel == 1) {
                // 复制,需要选中
                other = new StringBuilder(result);
            } else if (code == 3 && isSel == 1) {
                // 剪切,需要选中
                other = new StringBuilder(result);
                result = new StringBuilder("");
                isSel = 0;
            } else if (code == 4 && isSel == 1) {
                // 选中并粘贴
                result = new StringBuilder(other);;
                isSel = 0;
            } else if (code == 4) {
                // 粘贴
                result.append(other);
                isSel = 0;
            } else if (code == 5) {
                // 全选
                isSel = 1;
            }
            System.out.print("操作数：" + code);
            System.out.println("    当前字符：" + result.toString());
        }


        System.out.println(result.length());

    }

}
