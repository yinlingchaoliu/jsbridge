package com.github.caliburn.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.util.TypeUtils;

/**
 * @author chentong
 */
public class JsonParser {

    static {
        TypeUtils.compatibleWithJavaBean = true;
    }

    public static <T> T json2Bean(String json, Class<T> clazz) {
        return JSON.parseObject(json, clazz);
    }

    public static String bean2Json(Object object) {
        return JSON.toJSONString(object, new SerializerFeature[] {
                                 SerializerFeature.WriteMapNullValue,
                                 SerializerFeature.DisableCircularReferenceDetect,
                                 SerializerFeature.WriteNonStringKeyAsString });
    }

}