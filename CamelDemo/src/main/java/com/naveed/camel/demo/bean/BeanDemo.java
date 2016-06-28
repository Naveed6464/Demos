package com.naveed.camel.demo.bean;

import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class BeanDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                //from("file:C:/data/inbox?noop=true").to("file:C:/data/outbox");
                from("direct:hello")
                        //.setHeader("foo", simple("10"))
                        .bean(new HelloWorld(), "echo")
                        .bean(new HelloWorld(), "echo")
                        
                        //.to("stream:out")
                        //.process(new MyProccess())
                        //.bean(new MyBean())
                        //.transform(body().append(" Modified!!"))                        
                        .to("stream:out")
                        .choice().when(header("test").isEqualTo("20")).bean(new HelloWorld(), "test");
            }
        });
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        //template.sendBody("direct:hello", "This is a test message");
        template.sendBodyAndHeader("direct:hello", "This is a test message", "foo", "20");
        template.sendBodyAndHeader("direct:hello", "This is a test message", "test", "20");
        Thread.sleep(10000);
        context.stop();
    }

    static class MyProccess implements Processor {

        @Override
        public void process(Exchange exchange) throws Exception {
            String custom = exchange.getIn().getBody(String.class);
            exchange.getIn().setBody(custom + " Modified!");
        }
    }
}
