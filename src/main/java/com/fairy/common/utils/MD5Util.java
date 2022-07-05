package com.fairy.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.codec.digest.Md5Crypt;

import java.util.LinkedHashSet;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * @author hll
 * @version 1.0
 * @date 2022/7/5 9:54
 */
@Slf4j
public class MD5Util {


    /**
     * 加密
     *
     * @param source
     * @return
     * @throws Exception
     */
    public static String EncryptST(String source) throws Exception {
        String password = DigestUtils.md5Hex(source);
        return password;
    }

    private final static Integer default_size =2;
    public static String MD5SaltEncryptSTSize(String data) {
        String pass = Md5Crypt.md5Crypt(data.getBytes(), createSalt(default_size));
        return pass;
    }
    /**
     * Md5Crypt md5加盐值
     *
     * @param data
     * @return 加密结果
     */
    public static String MD5SaltEncryptST(String data,Integer size) {
        String pass = Md5Crypt.md5Crypt(data.getBytes(), createSalt(size));
        return pass;
    }

    public static String MD5SaltEncryptST(String data) {
        String pass = Md5Crypt.md5Crypt(data.getBytes(),new Random());
        return pass;
    }
    private static final String salt_head = "$1$sal";

    /**
     * 生成盐值
     *
     * @param size 大小
     * @return
     */
    private static String createSalt(Integer size) {
        Random random = new Random();
        String chs = "1234567890qwertyuiopasdfghjklzxcvbnmQWERTYUIOPASDFGHJKLZXCVBNM";
        String salt = salt_head;
        for (int i = 0; i < size; i++) {
            int sub = random.nextInt(chs.length() - 1);
            salt += chs.indexOf(sub);
        }
        log.info("生成盐值：{}",salt);
        return salt;
    }

    public static void main(String[] args) throws Exception {
        log.info(MD5SaltEncryptST("11111"));
        log.info(MD5SaltEncryptST("11111"));

    }
}
