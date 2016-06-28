/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.DoubleStream;

/**
 *
 * @author nmrehman
 */
public class Foo {

     //Integer y = new Integer(0);
    static volatile Map<String, String> m ;
    Collection<? super Number> foo = new ArrayList<Number>();
    public void update(Integer y) {
        try {
            y = 20;
        } finally {
            y = 30;
        }
        foo.add(null);
        ArrayList<Double> doubles = new ArrayList<>();
        doubles.add(100.0);
        doubles.add(300.0);
        double sum = DoubleStream.of(110.0, 11.0).sum();
        Thread thread = new Thread();        
    }
    
    public void update(String k , Integer v) {
        if (m == null){
            m = new HashMap<>();
        }
        //m.getOrDefault(k, 0);
    }
    

    public void foo() {
        Integer y = new Integer(10);
        update(y);
        System.out.println(y);
    }

    public static void main(String[] args) {
        new Foo().foo();
    }

}
