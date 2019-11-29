package juc;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LambdaTest {

    public static void main(String[] args) {
        //DateUtil ---> Hutool工具包
//        list.sort((a,b) ->DateUtil.parse(a.get("creTime").toString()).getTime() - DateUtil.parse(b.get("creTime").toString()).getTime() >= 0 ? -1 : 1);


        List<String> list=new ArrayList<>();
        for (int i = 0; i <40 ; i++) {
                list.add(i+"");
        }
        System.out.println(list.size());
        List<String> lsit2=list.stream().limit(10000).collect(Collectors.toList());
        System.out.println(lsit2.size());
    }

    /**
     * 将Long类型的时间戳转换成String 类型的时间格式，时间格式为：yyyy-MM-dd HH:mm:ss
     */
    public static String convertTimeToString(Long time){
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return ftf.format(LocalDateTime.ofInstant(Instant.ofEpochMilli(time),ZoneId.systemDefault()));
    }

    /**
     * 将字符串转日期成Long类型的时间戳，格式为：yyyy-MM-dd HH:mm:ss
     */
    public static Long convertTimeToLong(String time) {
        DateTimeFormatter ftf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime parse = LocalDateTime.parse(time, ftf);
        return LocalDateTime.from(parse).atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
    }
}
