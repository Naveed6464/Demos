package com.naveed.camel.demo;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class FromDirectDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                //from("file:C:/data/inbox?noop=true").to("file:C:/data/outbox");
                from("direct:start")
                        .process(new MyProccess())
                        //.bean(new MyBean())
                        //.transform(body().append(" Modified!!"))
                        .to("stream:out");
            }
        });
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        template.sendBody("direct:start", "This is a test message");
        Thread.sleep(10000);
        context.stop();
    }

//    static class MyBean {
//
//        public static String test(String custom) {
//            return custom + " Modified!";
//        }
//
//    }

    static class MyProccess implements Processor {

        @Override
        public void process(Exchange exchange) throws Exception {
            String custom = exchange.getIn().getBody(String.class);
            exchange.getIn().setBody(custom + " Modified!");
        }
    }
}
