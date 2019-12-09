package com.github.design.patterns.single.enums;

public class SingletinEnumTest {

    public static void main(String[] args) {

        SingletinEnum s1=SingletinEnum.INSTANCE;
        SingletinEnum s2=SingletinEnum.INSTANCE;

        System.out.println(s1==s2);
        System.out.println(s1.equals(s2));

        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
    }

}
