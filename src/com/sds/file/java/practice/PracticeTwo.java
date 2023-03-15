package com.sds.file.java.practice;

import java.io.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class PracticeTwo {
    public static void main(String[] args) throws IOException {
        String filePath = "/Users/shudesheng/Downloads/LRUCahche.java";

        BufferedReader br = new BufferedReader(new FileReader(filePath));
        PrintStream ps = new PrintStream(System.out);

        String line = "";
        int i = 1;
        while ((line = br.readLine()) != null) {
            ps.println(i++ + " " + line );
        }

        br.close();
        ps.close();
    }
}
