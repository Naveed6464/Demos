/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.beanio.demo;

import java.io.PrintWriter;
import java.util.HashMap;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.FieldBuilder;
import org.beanio.builder.RecordBuilder;
import org.beanio.builder.StreamBuilder;

/**
 *
 * @author nmrehman
 */
public class XMLDemo {

    public static void main(String[] args) {
        StreamFactory factory = StreamFactory.newInstance();
        StreamBuilder builder = new StreamBuilder("stu")
                .format("xml")
                //.parser(new DelimitedParserBuilder('|'))
                .addRecord(new RecordBuilder("student").xmlName("student")
                        .type(HashMap.class)
                        .minOccurs(1)
                        .addField(new FieldBuilder("firstName").xmlName("firstName"))
                        .addField(new FieldBuilder("lastName").xmlName("lastNane"))
                        .addField(new FieldBuilder("age").xmlName("age"))
                );
        factory.define(builder);
        PrintWriter writer = new PrintWriter(System.out);
        BeanWriter out = factory.createWriter("stu", writer);
        HashMap<String, String> obj = new HashMap<>();
        obj.put("firstName", "Naveedur");
        obj.put("lastName", "Rahman");
        obj.put("age", "10");

        out.write(obj);
        out.write(obj);

        out.flush();
        out.close();
    }
}
