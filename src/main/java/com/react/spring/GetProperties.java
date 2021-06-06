package com.react.spring;

import org.json.JSONObject;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Properties;

public class GetProperties {

    JSONObject result = new JSONObject();
        InputStream inputStream;

        public JSONObject getPropValues() throws IOException {

            try {
                Properties prop = new Properties();
                String propFileName = "config.properties";

                inputStream = getClass().getClassLoader().getResourceAsStream(propFileName);

                if (inputStream != null) {
                    prop.load(inputStream);
                } else {
                    throw new FileNotFoundException("property file '" + propFileName + "' not found in the classpath");
                }

                Date time = new Date(System.currentTimeMillis());

                result = new JSONObject();

                result.put("time",time);
                result.put("fakeAPIKey",prop.getProperty("apiKey"));

             return result;

            } catch (Exception e) {
                System.out.println("Exception: " + e);
            } finally {
                inputStream.close();
            }
            return result;
        }

}
