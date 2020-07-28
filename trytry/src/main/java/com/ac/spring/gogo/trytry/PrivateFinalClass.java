package com.ac.spring.gogo.trytry;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class PrivateFinalClass {
    //    private final List list = new ArrayList<>();
    private final CopyOnWriteArrayList list = new CopyOnWriteArrayList();

    /**
     * 公共的初始化方法,目的是修改list
     */
    public void init() {
        list.add(1);
        list.add(2);
//        list = null;
    }
}
