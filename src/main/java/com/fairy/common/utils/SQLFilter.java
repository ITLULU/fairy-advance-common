package com.fairy.common.utils;

import com.fairy.common.exception.CommonException;
import org.apache.commons.lang3.StringUtils;

/**
 * SQL语句过滤器
 *
 * @author 鹿少年
 * @version 1.0
 * @date 2022/3/20 21:29
 */
public class SQLFilter {

    /**
     * SQL注入过滤
     *
     * @param str 待验证的字符串
     */
    public static String sqlInject(String str) {
        if (StringUtils.isBlank(str)) {
            return null;
        }
        //去掉'|"|;|\字符
        str = StringUtils.replace(str, "'", "");
        str = StringUtils.replace(str, "\"", "");
        str = StringUtils.replace(str, ";", "");
        str = StringUtils.replace(str, "\\", "");

        //转换成小写
        str = str.toLowerCase();

        //非法字符
        String[] keywords = {"master", "truncate", "insert", "select", "delete", "update", "declare", "alter", "drop"};

        //判断是否包含非法字符
        for (String keyword : keywords) {
            if (str.indexOf(keyword) != -1) {
                throw CommonException.create("包含非法字符");
            }
        }
        return str;
    }
}
