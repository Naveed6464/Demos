/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.camel.demo.bean;

import org.apache.camel.Exchange;
import org.apache.camel.Header;
import org.apache.camel.TypeConverter;
import org.apache.camel.builder.SimpleBuilder;

/**
 *
 * @author nmrehman
 */
public class HelloWorld {

    public String hello(String hello) {
        return "Hello " + hello + "!";
    }

    public String echo(String echo, TypeConverter converter,
            @Header("foo") Integer foo, Exchange exchange) {

        SimpleBuilder simple = new SimpleBuilder("Hello ${body}");
        String s = simple.evaluate(exchange, String.class);
        System.out.println(s);
        return echo + " " + echo + "!";
    }

    public void test(String test) {
        System.out.println("test>>>>>>>>>>>>> " + test);
    }

}
