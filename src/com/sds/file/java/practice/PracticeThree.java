package com.sds.file.java.practice;

import java.awt.*;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class PracticeThree {
    public static void main(String[] args) throws IOException {
        String filepath = "/Users/shudesheng/IdeaProjects/GitHubProjects/practice-java-se/src/com/sds/file/java/dog.properties";

        Properties properties = new Properties();
        properties.load(new FileInputStream(filepath));

    }
}
