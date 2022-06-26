package com.fairy.common.utils;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 * @author huanglulu
 * @version 1.0
 * @date  2022/4/18 16:54
 */
public class DES {

    public static String KEY = "Q*E&A1a9";

    /**
     * 加密
     * @param source 字符串
     * @param key 秘钥
     * @return  String
     * @throws Exception 异常
     */
    public static String encryptST(String source, String key) throws Exception {
        try {
            Cipher cipher = null;
            DESKeySpec desKeySpec = null;
            SecretKeyFactory keyFactory = null;
            SecretKey secretKey = null;
            IvParameterSpec iv = null;

            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

            desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

            keyFactory = SecretKeyFactory.getInstance("DES");
            secretKey = keyFactory.generateSecret(desKeySpec);
            iv = new IvParameterSpec(key.getBytes("UTF-8"));

            cipher.init(Cipher.ENCRYPT_MODE, secretKey, iv);

            //return bytesToHexString(cipher.doFinal(source.getBytes("UTF-8")));
            //由于中文编码随环境而不同，SCNCC为GBK
            return bytesToHexString(cipher.doFinal(source.getBytes()));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 解密
     * @param source 加密字符串
     * @param key 秘钥
     * @return String
     * @throws Exception 异常
     */
    public static String decryptST(String source, String key) throws Exception {
        try {
            Cipher cipher = null;

            DESKeySpec desKeySpec = null;

            SecretKeyFactory keyFactory = null;
            SecretKey secretKey = null;
            IvParameterSpec iv = null;

            cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");

            desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));

            keyFactory = SecretKeyFactory.getInstance("DES");
            secretKey = keyFactory.generateSecret(desKeySpec);
            iv = new IvParameterSpec(key.getBytes("UTF-8"));
            cipher.init(Cipher.DECRYPT_MODE, secretKey, iv);
            return new String(cipher.doFinal(hexStringToByte(source)));
        } catch (Exception e) {
            throw e;
        }
    }

    /**
     * 把16进制字符串转换成字节数组
     *
     * @param hex
     * @return
     */
    public static byte[] hexStringToByte(String hex) {
        int len = (hex.length() / 2);
        byte[] result = new byte[len];
        char[] achar = hex.toCharArray();
        for (int i = 0; i < len; i++) {
            int pos = i * 2;
            result[i] = (byte) (toByte(achar[pos]) << 4 | toByte(achar[pos + 1]));
        }
        return result;
    }

    /**
     * 把字节数组转换成16进制字符串
     *
     * @param bArray
     * @return
     */
    public static final String bytesToHexString(byte[] bArray) {
        StringBuffer sb = new StringBuffer(bArray.length);
        String sTemp;
        for (int i = 0; i < bArray.length; i++) {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2) {
                sb.append(0);
            }
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }

    private static byte toByte(char c) {
        byte b = (byte) "0123456789ABCDEF".indexOf(c);
        return b;
    }
}
