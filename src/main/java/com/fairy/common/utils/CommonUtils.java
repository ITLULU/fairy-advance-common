package com.fairy.common.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.jexl3.*;

/**
 * @author huanglulu
 * @version 1.0
 * @createTime 2022/4/2 20:50
 */
@Slf4j
public class CommonUtils {
    public static boolean convert(String jexlExp) {
        // 创建或检索引擎
        JexlEngine engine = new JexlBuilder().create();
        // 创建一个表达式
        JexlExpression e = engine.createExpression(jexlExp);
        // 创建上下文并添加数据
        JexlContext jc = new ObjectContext<String>(engine, null);
        // 得到结果
        final Object result = e.evaluate(jc);
        return (Boolean) result;
    }
}
