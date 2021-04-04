package com.kkh.codinginterview.ch09.sub01_array_string;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class Practice {
    public Practice() {
        Hashtable ht = new Hashtable();
        ht.put("key","BBB");
        ht.put("key","CCC");
        System.out.println("Hashtable : "+ht.get("key")+" , get Defult 100 : "+ht.getOrDefault("ABC",500));
        HashMap hm = new HashMap();
        TreeMap tm = new TreeMap();
        LinkedHashMap lh = new LinkedHashMap();
        ConcurrentHashMap ch = new ConcurrentHashMap();
        ch.put("key",200);
        ch.putIfAbsent("key",100);
        System.out.println("concurrent hashmap : "+ch.get("key")+" , get Defult 100 : "+ch.getOrDefault("ABC",500));
    }

    public static void main(String args[]) {
        new Practice();
    }


}
