/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.beanio.demo;

import java.io.PrintWriter;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.StreamBuilder;

/**
 *
 * @author nmrehman
 */
public class CSVDemo {
 
    public static void main(String[] args) {
        StreamFactory factory = StreamFactory.newInstance();
        StreamBuilder builder = new StreamBuilder("mapping")
                .format("csv")
                .parser(new DelimitedParserBuilder('|'))
                .addRecord(Student.class);
        factory.define(builder);
        PrintWriter writer = new PrintWriter(System.out);
        BeanWriter out = factory.createWriter("mapping", writer);
        Student student = new Student("Naveedur", "Rahman", 28);
        out.write(student);
        out.write(student);
        out.write(student);
        out.flush();
        out.close();
    }
}
