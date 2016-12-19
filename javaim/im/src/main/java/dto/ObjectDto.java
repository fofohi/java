package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alongsea2 on 16/7/25.
 */
public class ObjectDto{

    public static void main(String[] args) throws InterruptedException {

        List<? extends Apple> list = new ArrayList<>();
        List<RedApple> list1 = new ArrayList<>();
        list1.add(new RedApple());
        list = list1;
        //System.out.println();
        int[] s =  {1,2,3,6,7,8,10,12};

        System.out.println(ObjectDto.findInBinary(12, s, 0, s.length));
    }

    public static int findInBinary(int searchInt,int[] sortedInt,int begin,int end){
        int findIndex = (begin + end) >> 1;
        System.out.println(1);
        if(searchInt == sortedInt[findIndex]){
            return findIndex;
        }
        if(searchInt < sortedInt[findIndex]){
            return findInBinary(searchInt,sortedInt,0,findIndex);
        }else{
            return findInBinary(searchInt,sortedInt,findIndex,end);
        }
    }
}


class Food{}

class Fruit extends Food{}

class Apple extends Fruit{
    final void redApple(){

    }
}

class RedApple extends Apple{

}


