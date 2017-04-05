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
            BufferedReader reader = new BufferedReader(new FileReader(file1));
            reader.readLine();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return null;
    }


}
