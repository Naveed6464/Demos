/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.camel.demo.dataformat;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.beanio.BeanIODataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.BeanioDataFormat;

/**
 *
 * @author nmrehman
 */
public class BeanIODemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {

                BeanioDataFormat beanioDataFormat = new BeanioDataFormat();
                BeanIODataFormat format = new BeanIODataFormat();

                //DataFormat format = new BeanioDataFormat("C:/Users/nmrehman/Documents/Naveed-Dev/Files/mappings.xml","employeeFile");
                from("direct:start")
                        //.convertBodyTo(String.class).to("file://something")
                        .unmarshal().beanio("file:C:/Users/nmrehman/Documents/Naveed-Dev/Files/mapping.xml", "employeeFile")
                        .to("stream:out");
            }
        });
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        //template.sendBody("direct:start", "This is a test message");
        template.sendBody("direct:start", "Jennifer,Jones,Marketing,60000,02292016");//new Employee("Naveed", "Rahman", "Programmer", 1000, new Date())
        Thread.sleep(10000);
        context.stop();
    }

}
