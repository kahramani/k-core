package com.kahramani.core;

import java.util.Collection;
import java.util.Map;

/**
 * Created by kahramani on 11/18/2016.
 */
public class ArgumentUtils {

    /**
     * to check the given if has text
     * @param t wanted to check if has text
     * @param <T> any child class of CharSequence
     * @return a boolean which refers that the given value has text or not
     */
    public static <T extends CharSequence> boolean hasText(T t) {
        if(t == null || t.length() == 0) {
            return false;
        } else {
            for(int i = 0; i < t.length(); ++i) {
                if(!Character.isWhitespace(t.charAt(i)))
                    return true;
            }
            return false;
        }
    }

    /**
     * to check the given if has text
     * @param t wanted to check if has text
     * @param <T> any child class of CharSequence
     * @param message exception message
     */
    public static <T extends CharSequence> void hasText(T t, String message) {
        if(!hasText(t))
            throw new IllegalArgumentException(message);
    }

    /**
     * to check empty/null status of the given
     * @param t wanted to check empty/null
     * @param <T> any child class of Collection
     * @return a boolean which refers that the given value is empty/null or not
     */
    public static <T extends Collection> boolean isEmptyOrNull(T t) {
        return (t == null || t.isEmpty());
    }

    /**
     * to check empty/null status of the given
     * @param t wanted to check empty/null
     * @param <T> any child class of Collection
     * @param message exception message
     */
    public static <T extends Collection> void isEmptyOrNull(T t, String message) {
        if(isEmptyOrNull(t))
            throw new IllegalArgumentException(message);
    }

    /**
     * to check empty/null status of the given
     * @param t wanted to check empty/null
     * @param <T> any child class of Map
     * @return a boolean which refers that the given value is empty/null or not
     */
    public static <T extends Map> boolean isEmptyOrNull(T t) {
        return (t == null || t.isEmpty());
    }

    /**
     * to check empty/null status of the given
     * @param t wanted to check empty/null
     * @param <T> any child class of Map
     * @param message exception message
     */
    public static <T extends Map> void isEmptyOrNull(T t, String message) {
        if(isEmptyOrNull(t))
            throw new IllegalArgumentException(message);
    }

    /**
     * to check null status of the given Object
     * @param o wanted to check null
     * @return a boolean which refers that the given value is null or not
     */
    public static boolean isNull(Object o) {
        return o == null;
    }

    /**
     * to check null status of the given Object
     * @param o wanted to check null
     * @param message exception message
     */
    public static void isNull(Object o, String message) {
        if(isNull(o))
            throw new IllegalArgumentException(message);
    }

    /**
     * to check expression then to throw exception if needed
     * @param expression wanted to check
     * @param message exception message
     */
    public static void isTrue(boolean expression, String message) {
        if(expression)
            throw new IllegalArgumentException(message);
    }
}
