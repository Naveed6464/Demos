package com.naveed.camel.demo.timer;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CXFDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        context.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                //from("direct:start")
                from("timer://myTimer?period=2000")
                        .setBody().simple("Current time is ${header.firedTime}")
                        .to("stream:out");
            }
        });
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        //template.sendBody("direct:start", "This is a test message");
        Thread.sleep(10000);
        context.stop();
    }
}
