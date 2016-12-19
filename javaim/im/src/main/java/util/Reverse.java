package util;

/**
 * Created by dell on 2016/12/16.
 */
public class Reverse {
    public static void main(String[] args) {
        String reverse = "the sky is blue";
        String[] s = reverse.split(" ");

        //String[] s = new String[]{"1","2","4","5","6"};
        int length = s.length - 1;
        int swapTime = (int) Math.floor(s.length / 2);
        String tmp;
        for(int i = 0; i < swapTime ; i++){
            tmp = s[i];
            s[i] = s[length];
            s[length] = tmp;
            length--;
        }
        for (String i : s) {
            System.out.println(i);
        }
    }
}
