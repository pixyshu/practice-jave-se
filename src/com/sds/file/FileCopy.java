package com.sds.file;

import java.io.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class FileCopy {
    public static void main(String[] args) {

        String srcFilepath = "/Users/shudesheng/Pictures/logo.png";
        String destFilepath = "/Users/shudesheng/Downloads/logo.png";

        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream(srcFilepath);
            outputStream = new FileOutputStream(destFilepath);

            byte[] readBytes = new byte[1024];
            int readLen = 0;
            while ((readLen = inputStream.read(readBytes)) != -1) {
                outputStream.write(readBytes, 0, readLen);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                inputStream.close();
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
