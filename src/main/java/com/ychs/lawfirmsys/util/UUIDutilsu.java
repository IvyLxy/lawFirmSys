package com.ychs.lawfirmsys.util;

/**
 * @author lixiaoya
 * @version 1.0
 * @date 2024/8/7
 */
public class UUIDutilsu {
    public static String getUUID() {
        String uuid = java.util.UUID.randomUUID().toString();
        return uuid.replaceAll("-", "");
    }
}


