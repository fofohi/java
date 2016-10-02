package dto;


import com.sun.org.apache.regexp.internal.RE;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alongsea2 on 16/7/25.
 */
public class ObjectDto{

    public static void main(String[] args) {

        List<?> list = new ArrayList<>();

        List<Apple> list2 = new ArrayList<Apple>();

        list = list2;

        //list.add(new RedApple());

    }
}


class Food{}

class Fruit extends Food{}

class Apple extends Fruit{}

class RedApple extends Apple{}


