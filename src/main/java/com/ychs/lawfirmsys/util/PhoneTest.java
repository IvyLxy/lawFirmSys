package com.ychs.lawfirmsys.util;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/7/26
 */
public class PhoneTest {
    public static void main(String[] args) {
        System.out.println(PhoneTest.getLastSixDigits("18103422043"));
    }
    public static String getLastSixDigits(String phoneNumber) {
        // 确保手机号长度至少为6位
        if (phoneNumber == null || phoneNumber.length() < 6) {
            return "";
        }
        // 提取最后六位
        return phoneNumber.substring(phoneNumber.length() - 6);
    }
}


