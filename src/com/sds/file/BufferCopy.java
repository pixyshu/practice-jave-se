package com.sds.file;

import java.io.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class BufferCopy {

    public static void main(String[] args) {
        String srcFilePath = "/opt/document/leetcode/LRUCahche.java";
        String destFilePath = "/Users/shudesheng/Downloads/LRUCahche.java";
        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            bufferedReader = new BufferedReader(new FileReader(srcFilePath));
            bufferedWriter = new BufferedWriter(new FileWriter(destFilePath));

            String  line = null;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(line);
                bufferedWriter.newLine();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                bufferedReader.close();
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
