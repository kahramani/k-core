package com.kahramani.core;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by kahramani on 11/18/2016.
 */
public class PropertyHelper {

    /**
     * to load properties from resource file
     * @param resourceName resource file name
     * @return a Properties which contain resource file properties
     * @throws IOException if loading error occurs
     */
    public static Properties loadProperties(String resourceName) throws IOException {
        ArgumentUtils.hasText(resourceName, "resource cannot be null or empty");

        InputStream is = PropertyHelper.class.getClassLoader().getResourceAsStream(resourceName);
        ArgumentUtils.isNull(is, "Unable to find the given properties file: " + resourceName);

        Properties p = new Properties();
        p.load(is);

        return p;
    }
}
