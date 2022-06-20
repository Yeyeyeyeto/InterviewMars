package com.eternal.other;

/**
 * @Auther Eternal
 * @Date 2022/6/20
 * 删除重复字符
 */
public class DeleteSameC {
    public static void main(String[] args) {
        System.out.println(deleteSame("AABBCCCCBBAB"));
    }

    public static char[] deleteSame(String s) {
        char[] chars = s.toCharArray();
        char[] chars2 = new char[chars.length];
        char cur = chars[0];
        int count = 0;
        chars2[count] = cur;
        count++;

        for (int i = 1; i < chars.length; i++) {
            if (Character.toString(cur).toUpperCase().equals(Character.toString(chars[i])) ||
                    Character.toString(cur).toLowerCase().equals(Character.toString(chars[i]))) {
                continue;
            } else {
                cur = chars[i];
            }
            chars2[count++] = cur;
        }

        return chars2;
    }
}
