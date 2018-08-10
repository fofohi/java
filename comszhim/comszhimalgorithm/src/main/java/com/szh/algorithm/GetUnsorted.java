package com.szh.algorithm;

import java.io.*;

/**
 * Created by alongsea2 on 2017/3/28.
 */
public class GetUnsorted {

    public static String file1 = "./largeFile.txt";

    public static String file2 = "./largeFile2.txt";



    public static int[] getFile1(){
        File file1 = new File(GetUnsorted.file1);
        try {
            FileInputStream fileInputStream = new FileInputStream(file1);

            System.out.println(fileInputStream.read());
            System.out.println(fileInputStream.read());

        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


    public static void main(String[] args) {
        GetUnsorted.getFile1();
    }
}
