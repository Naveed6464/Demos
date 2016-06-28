package com.naveed.camel.demo.cxf;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.CxfEndpoint;
import org.apache.camel.impl.DefaultCamelContext;

public class CXFDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();

        CxfEndpoint cxfEndpoint = new CxfEndpoint();
        cxfEndpoint.setAddress("http://localhost:8088/interface");
        cxfEndpoint.setServiceClass(OrderEndpoint.class);
        cxfEndpoint.setCamelContext(context);
        context.addEndpoint("intg", cxfEndpoint);

        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                //from("direct:start")
                CxfEndpoint cxfEndpoint = new CxfEndpoint();
                cxfEndpoint.setAddress("http://localhost:8088/interface");
                cxfEndpoint.setServiceClass(OrderEndpoint.class);
                cxfEndpoint.setCamelContext(context);
                context.addEndpoint("intg", cxfEndpoint);
                from(cxfEndpoint).to("stream:out");
                
            }
        });
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        //template.sendBody("direct:start", "This is a test message");

        Thread.sleep(10000);
        context.stop();
    }
}
