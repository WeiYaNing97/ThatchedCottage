package com.thatchedcottage.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @program: thatchedcottage
 * @description: 判断内容是否符合IP特征
 * @author:
 * @create: 2023-10-09 16:52
 **/

public class IPAddressChecker {
    public static boolean containsIPAddress(String input) {
        String ipPattern = "(\\d{1,3}\\.){3}\\d{1,3}"; // IP地址的正则表达式
        Pattern pattern = Pattern.compile(ipPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static void main(String[] args) {
        String text = "0.0.0.0 Eth-Trunk20.2012 29.36.191.6 Init";
        boolean containsIP = containsIPAddress(text);
        System.out.println("Contains IP address: " + containsIP);
    }
}