package com.szh.im.service;

//import com.szh.dubbo.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 * Created by alongsea2 on 2017/3/11.
 */
@Service
public class UtilService implements IUtilService{

//    @Autowired
//    private TestService testService;

    public UtilService() {

    }

    public void getProperty() {

       // testService.test();

    }

    public static void main(String[] args) {

//        List<Integer> list = new ArrayList<>();
//
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(4);
//        list.add(5);
//        list.add(6);
//
//        for (int i = 0 ; i < list.size();i++) {
//            System.out.println(list.size());
//            list.remove(i);
//        }
//
//        System.out.println(list);
        int x = 0;
        System.out.println(x++);
        System.out.println(x);
        System.out.println(++x);
    }

    static void quickSort(int[] sort,int begin,int end){
        if(begin == end) return;
        int middle = (begin + end) / 2;
        int middleEle = sort[middle];
    }
}