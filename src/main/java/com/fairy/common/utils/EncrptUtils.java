package com.fairy.common.utils;

/**
 * @author huanglulu
 * @version 1.0
 * @createTime 2022/4/18 16:52
 */
public class EncrptUtils {

    private static String defaultKey(){
        return "cdk_zstp";
    }
    public static String encryptST(String source) throws Exception {
        return encryptST(source,defaultKey());
    }
    public static String encryptST(String source,String key) throws Exception {
        return DES.encryptST(source, key);
    }
    public static String decryptST(String encryPasswod,String key) throws Exception {
        return DES.decryptST(encryPasswod.toUpperCase(),key);
    }
    /**解密
     * @author wangyong
     * @Description
     * @createTime 2021/8/5 10:10
     * @Param [encryPasswod]
     * @return java.lang.String
     */
    public static String decryptST(String encryPasswod) throws Exception {
        return decryptST(encryPasswod,defaultKey());
    }

    public static void main(String[] args){
        try {
//            String encryPass=encryptST("root");
////            String encryPass="7b1bd3ecbfd5bee4c5f94e2cd29f9b0d77d01ff53372e216";
//            log.debug("encryPass="+encryPass);
//            String password=decryptST(encryPass);
//            log.debug("password="+password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
