package com.github.caliburn.util;

import android.support.annotation.Nullable;

/**
 * 文本处理相关的帮助方法
 * @author chentong
 */
public class StringUtil {

    /**
     * 判断是否为空字符串
     *
     * @param str
     * @return
     */
    public static boolean isEmpty(@Nullable CharSequence str) {
        if (str == null || str.toString().trim().length() == 0) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断字符串不为空
     *
     * @param str
     * @return
     */
    public static boolean isNotEmpty(@Nullable CharSequence str) {
        return !isEmpty(str);
    }

    /**
     * 清理字符串
     *
     * @param str
     * @return
     */
    public static String trim(@Nullable String str) {
        if (isEmpty(str)) {
            return "";
        }
        return str.trim();
    }

    /**
     * 字符串长度
     *
     * @param str
     * @return
     */
    public static int length(String str) {
        String destStr = trim(str);
        return destStr.length();
    }

    /**
     * 比较字符串 忽略大小
     *
     * @param str
     * @param compareStr
     * @return
     */
    public static boolean equalsIgnoreCase(String str, String compareStr) {
        String destStr = trim(str);
        String comStr = trim(compareStr);
        return destStr.equalsIgnoreCase(comStr);
    }

    /**
     * 比较字符串
     *
     * @param str
     * @param compareStr
     * @return
     */
    public static boolean equals(String str, String compareStr) {
        String destStr = trim(str);
        String comStr = trim(compareStr);
        return destStr.equals(comStr);
    }

    /**
     * 比较字符串不相等
     *
     * @param str
     * @param compareStr
     * @return
     */
    public static boolean isNotEquals(String str, String compareStr) {
        return !equals(str,compareStr);
    }

    /**
     * 是否以suffix结尾
     *
     * @param str    字符串
     * @param suffix 字符串后缀
     * @return
     */
    public static boolean endsWith(String str, String suffix) {
        String destStr = trim(str);
        String suffixStr = trim(suffix);
        return destStr.endsWith(suffixStr);
    }

    /**
     * 字符串是否以prefix开头
     *
     * @param str    字符串
     * @param prefix 字符串前缀
     * @return
     */
    public static boolean startsWith(String str, String prefix) {
        String destStr = trim(str);
        String prefixStr = trim(prefix);
        return destStr.startsWith(prefixStr);
    }

    /**
     * 是否包含该字符串
     *
     * @param str
     * @param s
     * @return
     */
    public static boolean contains(String str, String s) {
        String destStr = trim(str);
        String containStr = trim(s);
        return destStr.contains(containStr);
    }

    /**
     * @param str 字符串
     * @param ch  字符串位置
     * @return
     */
    public static int indexOf(String str, int ch) {
        String destStr = trim(str);
        return destStr.indexOf(ch);
    }

    /**
     * @param str 该字符串
     * @param s   搜索字符串
     * @return
     */
    public static int indexOf(String str, String s) {
        String destStr = trim(str);
        String indexStr = trim(s);
        return destStr.indexOf(indexStr);
    }

    /**
     * 字符串流化
     *
     * @param str
     * @return
     */
    public static String toString(String str) {
        String destStr = trim(str);
        return destStr.toString();
    }

    /**
     * @param str
     * @return
     */
    public static String toLowerCase(String str) {
        String destStr = trim(str);
        return destStr.toLowerCase();
    }

    public static String toUpperCase(String str) {
        String destStr = trim(str);
        return destStr.toUpperCase();
    }

}
