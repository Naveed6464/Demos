package com.naveed.camel.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class Main {
    
    public static void main(String[] args) throws Exception {
        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                from("file:C:/data/inbox?noop=true").to("file:C:/data/outbox");
            }
        });
        camelContext.start();
        Thread.sleep(10000);
        camelContext.stop();
    }
}
