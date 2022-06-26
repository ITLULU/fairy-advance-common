package com.fairy.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * @author huanglulu
 * @version 1.0
 * @createTime 2022/4/13 10:52
 */
@Slf4j
public class SerializeUtils {

    /**
     * 序列号
     *
     * @param obj
     * @return
     */
    public static byte[] serialize(Object obj) {
        ObjectOutputStream oos = null;
        ByteArrayOutputStream baoos = null;
        try {
            baoos = new ByteArrayOutputStream();
            oos = new ObjectOutputStream(baoos);
            byte[] bytes = baoos.toByteArray();
            return bytes;

        } catch (Exception e) {
            log.error("异常信息:{}", e.getMessage());
        }
        return null;
    }

    public static Object descrialize(byte[] bytes) {
        ByteArrayInputStream bais = null;
        try {
            bais = new ByteArrayInputStream(bytes);
            ObjectInputStream ois = new ObjectInputStream(bais);
            return ois.readObject();
        } catch (Exception e) {

        }
        return null;
    }


}
