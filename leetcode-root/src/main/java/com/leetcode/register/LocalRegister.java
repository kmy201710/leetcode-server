package com.leetcode.register;

import java.util.HashMap;
import java.util.Map;


public class LocalRegister {

    private static Map<String, Class> map = new HashMap();

    public static void regist(String name, Class implClass) {
        map.put(name, implClass);
    }

    public static Class get(String name) {
       return map.get(name);
    }
}
