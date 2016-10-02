package dto;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dell on 2016/7/26.
 */
public class ParamDto {
    public static void main(String[] args) {
        List<Fruit> test = new ArrayList<Fruit>();
        test.add(new RedApple());
        test.add(new Apple());

        List<? extends Food> list = new ArrayList<Apple>();

        list = test;

        System.out.println(list.get(1));

        //list.add(new Apple());

       /* RedApple food = (RedApple) list.get(0);
        System.out.println(food.getS());
*/
    }
}
