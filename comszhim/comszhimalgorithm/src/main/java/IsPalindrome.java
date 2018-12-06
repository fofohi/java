public class IsPalindrome {

    public static boolean isPalindrome(int x) {
        if(x <= 0)return true;
        if(x < 10){
            return true;
        }
        int a = 1;
        while (x / 10 != 0){
            x /= 10;
            a++;
        }

        //几位数
        int numberOfX = a;
        boolean isQorO = a / 2d == 0;

        if(!isQorO){
            int mid = numberOfX / 2;
            while (a != 0){
                x /= 10 * a ;
                a--;
            }
        }














        return true;
    }

    public static void main(String[] args) {
        System.out.println((int) (5 / 2d));
    }
}
