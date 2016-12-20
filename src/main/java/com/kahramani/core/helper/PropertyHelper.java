package com.kahramani.core.helper;

import com.kahramani.core.util.ArgumentUtils;
import com.kahramani.core.util.FileUtils;

import java.io.IOException;
import java.io.InputStream;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Properties;

/**
 * Created by kahramani on 11/18/2016.
 */
public class PropertyHelper {

    private Properties properties;

    /**
     * to load properties from resource file
     * @param resourceName resource file name
     * @return a Properties which contain resource file properties
     * @throws IOException if loading error occurs
     */
    public Properties loadProperties(String resourceName) throws IOException {
        ArgumentUtils.hasText(resourceName, "resource cannot be null or empty");

        InputStream is = PropertyHelper.class.getClassLoader().getResourceAsStream(resourceName);
        ArgumentUtils.isNull(is, "Unable to find the given properties file: " + resourceName);

        if(this.properties == null) {
            this.properties = new Properties();
        }
        this.properties.load(is);

        return this.properties;
    }

    /**
     * to get property value with key
     * @param key property key whose value wanted to get
     * @return a String which is the value of the given key
     */
    public String getString(String key) {
        ArgumentUtils.hasText(key, "Key cannot be null or empty");
        ArgumentUtils.isNull(this.properties, "Properties must be loaded first");
        return this.properties.getProperty(key);
    }

    /**
     * to get boolean value and to handle exceptions
     * @param key property key whose value wanted to get
     * @param defaultValue default value to set if in case that property can not be found
     * @return a boolean which is the property value of the given key
     */
    public boolean getBoolean(String key, boolean defaultValue) {
        String s = this.getString(key);
        if(ArgumentUtils.isNull(s))
            return defaultValue;

        return Boolean.parseBoolean(s.trim());
    }

    /**
     * to get int value and to handle exceptions
     * @param key property key whose value wanted to get
     * @param defaultValue default value to set if in case that property can not be found
     * @return an int which is the property value of the given key
     */
    public int getInt(String key, int defaultValue) {
        Number n;
        String prop = this.getString(key);
        try {
            n = this.parseNumber(prop);
        } catch (ParseException e) {
            return defaultValue;
        }
        if(ArgumentUtils.isNull(n))
            return defaultValue;

        return n.intValue();
    }

    /**
     * to get long value and to handle exceptions
     * @param key property key whose value wanted to get
     * @param defaultValue default value to set if in case that property can not be found
     * @return a long which is the property value of the given key
     */
    public long getLong(String key, long defaultValue) {
        Number n;
        String prop = this.getString(key);
        try {
            n = this.parseNumber(prop);
        } catch (ParseException e) {
            return defaultValue;
        }
        if(ArgumentUtils.isNull(n))
            return defaultValue;

        return n.longValue();
    }

    /**
     * to get double value and to handle exceptions
     * @param key property key whose value wanted to get
     * @param defaultValue default value to set if in case that property can not be found
     * @return a double which is the property value of the given key
     */
    public double getDouble(String key, double defaultValue) {
        Number n;
        String prop = this.getString(key);
        try {
            n = this.parseNumber(prop);
        } catch (ParseException e) {
            return defaultValue;
        }
        if(ArgumentUtils.isNull(n))
            return defaultValue;

        return n.doubleValue();
    }

    /**
     * to get float value and to handle exceptions
     * @param key property key whose value wanted to get
     * @param defaultValue default value to set if in case that property can not be found
     * @return a float which is the property value of the given key
     */
    public float getFloat(String key, float defaultValue) {
        Number n;
        String prop = this.getString(key);
        try {
            n = this.parseNumber(prop);
        } catch (ParseException e) {
            return defaultValue;
        }
        if(ArgumentUtils.isNull(n))
            return defaultValue;

        return n.floatValue();
    }

    /**
     * to read sql query from file
     * @param filePathKey property file key which points the path of the file whose content wanted to read
     * @param readLineByLine read file line by line or char by char
     * @return a StringBuilder which is the query
     */
    public StringBuilder getSqlQueryFromFile(String filePathKey, boolean readLineByLine) {
        StringBuilder sb;
        String filePath = this.getString(filePathKey);
        try {
            sb = FileUtils.readContent(filePath, readLineByLine);
        } catch (IOException e) {
            return null;
        }

        return sb;
    }

    /**
     * to parse number from property
     * @param value property value
     * @param <T> any child class of Number
     * @return a T type which is the parsed number from the given value
     * @throws ParseException if cannot parse the given value
     */
    private <T extends Number> T parseNumber(String value) throws ParseException {
        ArgumentUtils.isNull(value, "value cannot be null or empty");
        return (T) NumberFormat.getInstance().parse(value);
    }
}
