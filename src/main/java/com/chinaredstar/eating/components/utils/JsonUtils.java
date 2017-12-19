package com.chinaredstar.eating.components.utils;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;


/**
 * @description
 * @author: fangjian<jian.fang@chinaredstar.com>
 * @date: Create in 10:41 2017/12/19
 * @modified by:
 */
public class JsonUtils {
    private static final Logger LOG = LoggerFactory.getLogger(JsonUtils.class);


    private static ObjectMapper getMapper() {
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return mapper;
    }


    /**
     * 将对象的大写转换为下划线加小写，例如：userName-->user_name
     *
     * @param object
     * @return
     */
    public static String toUnderlineJsonString(Object object) {
        ObjectMapper mapper = getMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        mapper.setSerializationInclusion(Include.NON_NULL);
        String reqJson = null;
        try {
            reqJson = mapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            LOG.error("toUnderlineJSONString error:[{}] ", e);
        }
        return reqJson;
    }

    /**
     * 将下划线转换为驼峰的形式，例如：user_name-->userName
     *
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T toSnakeBean(String json, Class<T> clazz) {
        ObjectMapper mapper = getMapper();
        mapper.setPropertyNamingStrategy(PropertyNamingStrategy.SNAKE_CASE);
        T reqJson = null;
        try {
            reqJson = mapper.readValue(json, clazz);
        } catch (IOException e) {
            LOG.error("toSnakeBean json error:[{},{}] ", e);
        }
        return reqJson;
    }

    /**
     * @param json
     * @param clazz
     * @return
     * @throws IOException
     */
    public static <T> T toBean(String json, Class<T> clazz) {
        ObjectMapper mapper = getMapper();
        T reqJson = null;
        try {
            reqJson = mapper.readValue(json, clazz);
        } catch (IOException e) {
            LOG.error("toBean json error:[{},{}] ", e);
        }
        return reqJson;
    }
}
