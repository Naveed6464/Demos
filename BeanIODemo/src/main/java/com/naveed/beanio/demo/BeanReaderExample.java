/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.beanio.demo;

import java.io.File;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;

/**
 *
 * @author nmrehman
 */
public class BeanReaderExample {

    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("mapping.xml");

        // use a StreamFactory to create a BeanReader
        BeanReader in = factory.createReader("employeeFile", new File("employee.csv"));
        Employee employee;
        while ((employee = (Employee) in.read()) != null) {
            // process the employee...
        }
        in.close();
    }
}
