package com.sds.file;

import java.io.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class BufferStreamCopy {
    public static void main(String[] args) {
        String srcFilepath = "/Users/shudesheng/Pictures/logo.png";
        String destFilepath = "/Users/shudesheng/Downloads/logo2.png";

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            bis = new BufferedInputStream(new FileInputStream(srcFilepath));
            bos = new BufferedOutputStream(new FileOutputStream(destFilepath));

            byte[] readData = new byte[1024];
            int readlen = 0;
            while ((readlen = bis.read(readData)) != -1) {
                bos.write(readData, 0, readlen);

            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bis.close();
                bos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
