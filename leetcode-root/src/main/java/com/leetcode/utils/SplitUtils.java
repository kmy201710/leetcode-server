package com.leetcode.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java从字符串中提取数字 https://www.cnblogs.com/lxqiaoyixuan/p/8541530.html
 *
 * @Author hhe
 * @Date 2021/2/9 9:39
 * @Description
 */
public class SplitUtils {
    // 判断一个字符串是否都为数字
    public boolean isDigit(String strNum) {
        return strNum.matches("[0-9]{1,}");
    }

    // 判断一个字符串是否都为数字
    public boolean isDigit2(String strNum) {
        Pattern pattern = Pattern.compile("[0-9]{1,}");
        Matcher matcher = pattern.matcher((CharSequence) strNum);
        return matcher.matches();
    }

    //截取数字
    public static String getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    // 截取非数字
    public static String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    public static String splitNotBlank(String content) {
        if (content.length() > 1 && content.charAt(0) == ' ') {
            return content.trim();
        }
        return content;
    }
}