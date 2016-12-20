package com.kahramani.core.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by kahramani on 12/20/2016.
 */
public class FileUtils {

    /**
     * to read content of a file
     * @param filePath property file key which points the path of the file whose content wanted to read
     * @param readLineByLine read file line by line or char by char
     * @return a StringBuilder which has content of the file
     * @throws IOException if input/output stream operation exception occurs
     */
    public static StringBuilder readContent(String filePath, boolean readLineByLine) throws IOException {
        ArgumentUtils.hasText(filePath, "filePath cannot be null or empty");

        StringBuilder sb = null;
        BufferedReader br = null;
        InputStreamReader in = null;
        try {
            in = new InputStreamReader(FileUtils.class.getClassLoader().getResourceAsStream(filePath));
            br = new BufferedReader(in);
            int r;
            String str;
            sb = new StringBuilder("");
            if(readLineByLine) {
                while ((str = br.readLine()) != null) {
                    sb.append(str);
                }
            } else {
                while ((r = br.read()) != -1) {
                    sb.append((char) r);
                }
            }
        } finally {
            br.close();
            in.close();
        }
        return sb;
    }
}
