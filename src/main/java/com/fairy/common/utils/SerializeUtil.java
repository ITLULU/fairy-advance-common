package com.fairy.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.*;

/**
 * @author huanglulu
 * @version 1.0
 * @date 2022/4/13 10:52
 */
@Slf4j
public class SerializeUtil {

    /**
     * 序列化
     * @param obj 序列化对象
     * @return byte[] 字节数组
     */
    public static byte[] serialize(Object obj) {
        ObjectOutputStream outputStream = null;
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            outputStream = new ObjectOutputStream(byteArrayOutputStream);
            byte[] bytes = byteArrayOutputStream.toByteArray();
            return bytes;

        } catch (Exception e) {
            log.error("异常信息:{}", e);
        } finally {
            try {
                if (byteArrayOutputStream != null) {
                    byteArrayOutputStream.close();

                }
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /***
     * 反序列化
     * @param bytes  字节数组
     * @return Object
     */
    public static Object descrialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {
            log.error("异常信息：{}", e);
        } finally {
            try {
                if (bais != null) {
                    bais.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }


}
