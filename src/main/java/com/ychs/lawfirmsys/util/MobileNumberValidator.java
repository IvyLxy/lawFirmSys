package com.ychs.lawfirmsys.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 手机号正则校验
 *
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/26
 */
public class MobileNumberValidator {
    /**
     * @param mobileNumber 需要校验的手机号
     * @return true 是有效手机号
     */
    public static boolean validate(String mobileNumber) {
        // 匹配以1开头的11位数字手机号格式如：13185217412
        String regex = "^1[3-9]\\d{9}$|" +
                "^1[3-9]\\d{1}[-\\s]\\d{4}[-\\s]\\d{4}$|" +
                "^\\(1[3-9]\\d{1}\\)\\d{4}-\\d{4}$|" +
                "^(?:\\(\\+\\d{2}\\)|\\+\\d{2})(\\d{11})$|" +
                "^0\\d{3}-\\d{7}$|" +
                "^0\\d{2}-\\d{8}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(mobileNumber);
        return matcher.matches();
    }
    public static void main(String[] args) {
        String mobileNumber = "88888888888888";
        String m1 = "15488888888";
        boolean isValidMobileNumber = MobileNumberValidator.validate(mobileNumber);
        boolean isValidMobileNumber1 = MobileNumberValidator.validate(m1);
        System.out.println(mobileNumber + "是" + (isValidMobileNumber ? "有效":"无效") + "的手机号");
        System.out.println(m1 + "是" + (isValidMobileNumber1 ? "有效":"无效") + "的手机号");
    }
}


