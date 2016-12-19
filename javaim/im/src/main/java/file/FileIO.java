package file;

import java.io.*;

/**
 * Created by dell on 2016/12/19.
 */
public class FileIO {
    public static void main(String[] args) throws IOException {
        File file = new File(FileIO.class.getClassLoader().getResource("sql.txt").getFile());

        byte[] bt = new byte[1024];
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream(file));
        int readInt;
        while ((readInt = bufferedInputStream.read(bt,0,1024)) != -1) {
            for (byte b : bt) {
                System.out.println(Integer.toHexString(b & 0xFF));
            }
        }
    }
}
