package com.github.jdk8;

import java.util.*;

public class ListTest {

    public static void main(String[] args) {

        List<Map<String,Object>>  list=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("id",i);
            map.put("name",i+"name");
            list.add(map);
        }


        List<Map<String,Object>>  list2=new ArrayList<>();
        for (int i = 0; i <3 ; i++) {
            Map<String,Object> map=new HashMap<>();
            map.put("id",i);
            map.put("age",i);
            list2.add(map);
        }


//        for (int i = 0; i <list.size() ; i++) {
//            Map<String,Object> map=list.get(i);
//            for (int j = 0; j <list2.size() ; j++) {
//                Map<String,Object> map2=list2.get(j);
//                if(map.get("id").toString().equals(map2.get("id").toString())){
//                    map.putAll(map2);
//                    list2.remove(map2);
////                }
//            }
//        }

//        System.out.println(list.toString());


    }
}
