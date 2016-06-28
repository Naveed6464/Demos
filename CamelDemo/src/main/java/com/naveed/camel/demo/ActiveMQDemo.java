/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.camel.demo;

import org.apache.activemq.camel.component.ActiveMQComponent;
import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author nmrehman
 */
public class ActiveMQDemo {
    
    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addComponent("activemq", ActiveMQComponent.activeMQComponent("vm://localhost?broker.persistent=false"));
        //ConnectionFactory connectionFactory = new ActiveMQConnectionFactory("vm://localhost");
        //context.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {                
                from("activemq:queue:test.queue").to("stream:out");//to("file:C:/data/test")
            }
        });        
        ProducerTemplate template = context.createProducerTemplate();
        context.start();       
        template.sendBody("activemq:queue:test.queue", "Hello World");
        //Thread.sleep(10000);               
        //context.stop();
    }
    
}
