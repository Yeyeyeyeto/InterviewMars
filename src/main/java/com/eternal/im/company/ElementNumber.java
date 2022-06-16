package com.eternal.im.company;

/**
 * @Auther Eternal
 * @Date 2022/5/20
 *
 * 输入任意一种物质，要求输出其每种元素的数量。
 * 比如
 * 输入 CaCO3，其组成分别为 Ca：1，C：1，O：3，输出 Ca1C1O3
 * 输入 Fe2(SO4)3，其组成分别为 Fe：2，S：3，O：12，输出 Fe2S3O12
 * （注意：元素名称首字母大写，剩余字母都小写；括号括起来表示括号中的结构作 * 为整体出现多少次）
 */
public class ElementNumber {

    public static void main(String[] args) {
        System.out.println(numberOfElement("CaCO3"));
//        System.out.println(numberOfElement("Fe2(SO4)3"));
    }

    public static String numberOfElement(String e) {
        int lengthE = e.length();
        int indexE = -1;
        StringBuilder result = new StringBuilder(e);

        while(indexE++ <= lengthE-3) {
            if (Character.isUpperCase(e.charAt(indexE))) {
                if (Character.isLowerCase(e.charAt(indexE+1))) {
                    indexE+=2;
                }
                if (Character.isDigit(e.charAt(indexE+1))) {
                    indexE++;
                    result.insert(indexE, e.charAt(indexE));
                }
                result.insert(indexE, '1');
            }
        }

        return result.toString();
    }

}
