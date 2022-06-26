package com.fairy.common.utils;

/**
 * @author huanglulu
 * @version 1.0
 * @date 2022/4/18 16:52
 */
public class EncrptUtils {

    private static String defaultKey() {
        return "cdk_zstp";
    }

    public static String encryptST(String source) throws Exception {
        return encryptST(source, defaultKey());
    }

    public static String encryptST(String source, String key) throws Exception {
        return DES.encryptST(source, key);
    }

    public static String decryptST(String encryPasswod, String key) throws Exception {
        return DES.decryptST(encryPasswod.toUpperCase(), key);
    }

    /**
     * 解密
     *
     * @return java.lang.String
     * @date 2021/8/5 10:10
     * @Param encryPasswod 加密串
     */
    public static String decryptST(String encryPasswod) throws Exception {
        return decryptST(encryPasswod, defaultKey());
    }


}
