package com.ac.spring.gogo.trytry;

import java.util.ArrayList;
import java.util.List;

public class MyApplicationContext {

    private List<Object> goes;


    public void add(Object object) {
        goes.add(object);
    }

    public MyApplicationContext() {
        this(new ArrayList<>(16));
    }

    public MyApplicationContext(List<Object> goes) {
        this.goes = goes;
    }

    public Object get(Integer index) {
        return goes.get(index);
    }
}
