package com.sds.file.java.practice;

import java.io.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class PracticeOne {
    public static void main(String[] args) throws IOException {
        String parentPath = "/Users/shudesheng/Downloads";
        String directoryName = "/mytemp";
        String directoryPath = parentPath + directoryName;


        File file = new File(directoryPath);
        if (file.isDirectory()) {
            System.out.println("文件夹已存在");
        }else {
            System.out.println("文件文件家不存在");
            file.mkdirs();
        }

        String fileName = "hello.txt";
        File hellofile = new File(file, fileName);
        if (hellofile.exists()) {
            System.out.println("文件已存在");

        } else {
            hellofile.createNewFile();
        }

    }
}
