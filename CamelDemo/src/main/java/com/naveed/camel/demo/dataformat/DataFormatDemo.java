package com.naveed.camel.demo.dataformat;

import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.BindyType;

public class DataFormatDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                //from("file:C:/data/inbox?noop=true").to("file:C:/data/outbox");
                from("direct:start")
                        //.process(new MyProccess())
                        //.bean(new MyBean())
                        //.transform(body().append(" Modified!!"))
                        .marshal().bindy(BindyType.Csv, PurchaseOrder.class)
                        .marshal().custom("")
                        .to("stream:out");
            }
        });
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        //template.sendBody("direct:start", "This is a test message");
        template.sendBody("direct:start", new PurchaseOrder("Camel Demo", new BigDecimal(32.0), 1));
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
