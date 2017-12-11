package com.demo.api.config;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by darjandjamtovski on 11/30/17.
 */
public class ApiConfig {

    public static final String API_TOKEN_KEY = "api.token.key";
    public static final String API_TOKEN = "api.token";
    public static final String API_BASE_ENDPOINT = "api.base.endpoint";

    public String getProperty(String propertyKey){
        Properties properties = new Properties();
        InputStream inputStream = null;
        String result = null;

        try{
            ClassLoader classLoader = getClass().getClassLoader();
            String configPath = String.format("config%sapi.properties", File.separator);
            File file = new File(classLoader.getResource(configPath).getFile());

            inputStream = new FileInputStream(file);
            properties.load(inputStream);
            result = properties.getProperty(propertyKey);
        }catch (IOException e){
            return null;
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return result;
    }
}
