package com.sds.file;

import java.io.*;

/**
 * TODO
 * Created by shu.ds on 2022/12/13
 **/
public class FileCreate {
    public static void main(String[] args) {

    }

    // 方式1 ： new File(String pathname)
    public void create01(){
        String filepath = "";
        File file = new File((filepath));

        try {
            file.createNewFile();
            System.out.println("文件创建成功");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
