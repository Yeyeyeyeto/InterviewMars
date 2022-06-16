package com.eternal.im.company;

/**
 * @Auther Eternal
 * @Date 2022/5/20
 */
public class RegularMatching {
    public static void main(String[] args) {

    }

    public static boolean isRegularMatching(String rule, String str) {
        int lRule = rule.length();
        int lStr = str.length();
        int iRule = 0;
        int iStr = 0;
        while (iRule < lRule && iStr < lStr) {
            switch (rule.charAt(iRule)) {
                case '*': {
                    iRule += 1;
                    if (iRule >= lRule) {
                        return true;
                    } else {
                        for (int i = iStr; i < lStr; i++) {
                            if (i >= lStr) {
                                return true;
                            }
                        }
                    }
                    break;
                }
                case '$': {
                    if (lStr <= 0) {
                        return false;
                    }
                    while ((iStr < lStr) && (str.charAt(iStr) >= '0') && (str.charAt(iStr) <= '9')) {
                        iStr += 1;
                    }
                    iRule += 1;
                    break;
                }
                default: {
                    if (rule.charAt(iRule) != str.charAt(iStr)) {
                        return false;
                    }
                    iRule += 1;
                    iStr += 1;
                    break;
                }
            }
        }
        if (iRule < lRule && iStr >= lStr) {
            if (rule.charAt(iRule) == '*') {
                return true;
            }
        } else {
            return false;
        }
        return false;
    }

}
