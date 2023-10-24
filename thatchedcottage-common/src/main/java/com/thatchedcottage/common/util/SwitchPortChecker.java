package com.thatchedcottage.common.util;

/**
 * @program: thatchedcottage
 * @description: 判断内容是否符合交换机端口号特征
 * @author:
 * @create: 2023-10-10 09:11
 **/
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class SwitchPortChecker {
    public static boolean containsSwitchPort(String input) {
        String portPattern = "(?i)\\b\\d{1,2}/\\d{1,2}/\\d{1,2}\\b"; // 交换机端口号的正则表达式
        Pattern pattern = Pattern.compile(portPattern);
        Matcher matcher = pattern.matcher(input);
        return matcher.find();
    }
    public static void main(String[] args) {
        String text = "This is a sample text with switch port 1/2/3";
        boolean containsSwitchPort = containsSwitchPort(text);
        System.out.println("Contains switch port: " + containsSwitchPort);
    }
}