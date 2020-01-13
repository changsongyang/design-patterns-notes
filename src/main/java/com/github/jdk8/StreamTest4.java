package com.github.jdk8;

import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamTest4 {

    public static void main(String[] args) {
//        Category category1=new Category(1,"","保养配件","燃油滤清器");
//        Category category2=new Category(2,"保养用品","保养配件","机油隔测试");
//        Category category3=new Category(3,"保养用品","添加剂/清洗剂/养护剂","燃油添加剂");
//        Category category4=new Category(4,"内饰","空气净化","炭包/吸附剂");
//
//        List<Category> list= Arrays.asList(category1,category2,category3,category4);
//       String str1= list.stream().filter(i->!i.getName1().isEmpty()).map(Category::getName1).distinct()
//                                  .collect(Collectors.joining(","));
//       System.out.println("一级类目："+str1);
//
//        String str2= list.stream().filter(i->!i.getName1().isEmpty()).map(Category::getName2).distinct()
//                .collect(Collectors.joining(","));
//
//        System.out.println("二级类目："+str2);
//
//      list.stream().map(s-> s.getName1()+" "+s.getName2()+" "+s.getName3()).distinct().collect(Collectors.toList()).forEach(System.out::println);


//        List<Map<String,Object>> list=new ArrayList<>();
//        for (int i = 0; i <5 ; i++) {
//            Map<String,Object> map=new HashMap<>(10);
//            map.put(i+"","name"+i);
//            list.add(map);
//        }
//        list.stream().forEach(s->s.put("666",6666));
//
//        list.forEach(System.out::println);

        // 把一个数组转换成流
        String[] myArray = new String[]{"1","2","3"};
        Arrays.stream(myArray)
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());

    }
    private List<Long> stringToLongList (String strArr){
        return Arrays.stream(strArr.split(","))
                .map(s -> Long.parseLong(s.trim()))
                .collect(Collectors.toList());
    }
    public  static  class Category{
        private  int id;
        private  String name1;
        private  String name2;
        private  String name3;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName1() {
            return name1;
        }

        public void setName1(String name1) {
            this.name1 = name1;
        }

        public String getName2() {
            return name2;
        }

        public void setName2(String name2) {
            this.name2 = name2;
        }

        public String getName3() {
            return name3;
        }

        public void setName3(String name3) {
            this.name3 = name3;
        }

        public Category(int id, String name1, String name2, String name3) {
            this.id = id;
            this.name1 = name1;
            this.name2 = name2;
            this.name3 = name3;
        }

        @Override
        public String toString() {
            return "Category{" +
                    "id=" + id +
                    ", name1='" + name1 + '\'' +
                    ", name2='" + name2 + '\'' +
                    ", name3='" + name3 + '\'' +
                    '}';
        }
    }
}

