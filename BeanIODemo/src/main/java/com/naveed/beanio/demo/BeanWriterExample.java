/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.beanio.demo;

import java.io.File;
import java.util.Date;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;

/**
 *
 * @author nmrehman
 */
public class BeanWriterExample {

    public static void main(String[] args) throws Exception {
        // create a StreamFactory
        StreamFactory factory = StreamFactory.newInstance();
        // load the mapping file
        factory.load("mapping.xml");

        Employee employee = new Employee();
        employee.setFirstName("Jennifer");
        employee.setLastName("Jones");
        employee.setTitle("Marketing");
        employee.setSalary(60000);
        employee.setHireDate(new Date());

        // use a StreamFactory to create a BeanWriter
        BeanWriter out = factory.createWriter("employeeFile", new File("employee.csv"));
        // write an Employee object directly to the BeanWriter
        out.write(employee);
        out.flush();
        out.close();
    }
}
