package com.sds.file;

import java.io.*;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class InputStreamTest {
    public static void main(String[] args) throws IOException {
        String filepath = "/Users/shudesheng/Downloads/hello";

        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath));
        BufferedReader br = new BufferedReader(isr);
        try {
            String s = br.readLine();
            System.out.println("读取内容" + s);

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            isr.close();
            br.close();
        }

        HashSet<Object> objects = new HashSet<>();

    }

}
