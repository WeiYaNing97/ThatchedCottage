package com.thatchedcottage.common.file;

import org.yaml.snakeyaml.Yaml;
import java.io.*;
import java.util.Map;

public class CustomConfigurationUtil {

    public static void main(String[] args) {
        CustomConfigurationUtil customConfigurationUtil = new CustomConfigurationUtil();
        Map<String, Object> stringObjectMap = customConfigurationUtil.ObtainAllConfigurationFileParameters();
        Integer value = (Integer) customConfigurationUtil.getValue("rabbitmq.listener.simple.prefetch", stringObjectMap);
        System.err.println(value);
    }

    public Map<String, Object> ObtainAllConfigurationFileParameters() {
        String path3 = "/customconfiguration.yml";
        InputStream inputStream = this.getClass().getResourceAsStream(path3);
        Yaml yaml = new Yaml();
        Map<String, Object> map = yaml.load(inputStream);
        try {
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }

    public Object getValue(String key, Map<String, Object> map) {
        String[] keys = key.split("\\.");
        if (keys.length == 1) {
            return map.get(keys[0]);
        } else {
            String subKey = key.substring(keys[0].length() + 1);
            Object subMap = map.get(keys[0]);
            if (subMap instanceof Map) {
                return getValue(subKey, (Map<String, Object>) subMap);
            } else {
                return null;
            }
        }
    }
}
