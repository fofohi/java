//package util;
//
//import java.io.*;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.*;
//
///**
// * Created by xianyu on 2016/4/1.
// */
//public class ToolUtil {
//    public static void main(String[] args) throws IOException {
//
//        System.out.println(ToolUtil.getWeek());
//        double i = 220.7;
//        long j = (long) i;
//        System.out.println(j);
//
//
//        /*File file = new File("src/main/resource/sql.txt");
//
//        File s = new File(file.getAbsolutePath());
//
//        FileInputStream fis = new FileInputStream(s);
//        int n;
//        while(( n = fis.read()) != -1){
//            System.out.println((char) n );
//        }*/
//        /*File file = new File("F:\\im\\src\\main\\java\\imtest\\sql.txt");
//        FileInputStream streamFile = new FileInputStream(file);
//        BufferedInputStream bufferedInputStream = new BufferedInputStream(streamFile);
//        int n;
//        byte[] b =new byte[1024*1024];
//        String s = "";
//
//        while ( (n = bufferedInputStream.read(b)) != -1){
//            s += new String(b,0,n);
//        }
//        List<String> strList = new ArrayList<String>();
//        String[] t = s.split("\r\n");
//        String sql = "update MM_ADD_UUID set is_callback = 1 ,finishi_time = 1459950031000,action_type= \"WL\" where id in (select id from MM_ADD_UUID WHERE channel = \"youqian\" and action_type = \"M\" and uuid IN (";
//        StringBuffer buffer = new StringBuffer();
//        buffer.append(sql);
//        for (int i=0;i<t.length;i++) {
//           buffer.append("\""+t[i]+"\",");
//        }
//        String new_sql = buffer.toString();
//        String out_sql = "";
//        out_sql = new_sql.substring(0,new_sql.length()-1);
//        out_sql += ")";
//        System.out.println(out_sql);*/
//    }
//
//    public static Object getWeek(){
//
//        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("Asia/Shanghai"),Locale.SIMPLIFIED_CHINESE);
//        calendar.setFirstDayOfWeek(Calendar.MONDAY);
//
//        long now = System.currentTimeMillis();
//
//
//        calendar.setTimeInMillis(now);
//        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK) - 1;
//        if(dayOfWeek == 0){
//            dayOfWeek = 7;
//        }
//
//        long before = now - (dayOfWeek - 1)* 86400000;
//
//        long after = now + ( 7 - dayOfWeek + 1)*86400000;
//
//        return after + ":" + before;
//    }
//
//    public int erfenchazhao(List<Integer> list,int target,int size){
//        int findBeginIndex = size >> 1;
//
//        if(list.get(findBeginIndex) == target){
//            return findBeginIndex;
//        }
//
//        int leftBegin = 0;
//        int leftEnd = findBeginIndex;
//        int leftSize= leftEnd - leftBegin;
//
//
//        erfenchazhao(list,target,leftSize);
//
//
//
//
//        erfenchazhao(list,target,1);
//
//
//    }
//
//}
