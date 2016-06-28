/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.camel.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author nmrehman
 */
public class TimerDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {                
                from("timer://myTimer?period=2000").setBody().simple("Hello World Camel fired at ${header.firedTime}").to("stream:out");
            }
        });        
        context.start();       
        Thread.sleep(10000);
        context.stop();
    }
}