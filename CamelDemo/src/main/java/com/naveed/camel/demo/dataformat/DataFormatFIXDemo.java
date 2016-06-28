package com.naveed.camel.demo.dataformat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Message;
import org.apache.camel.Processor;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.dataformat.bindy.kvp.BindyKeyValuePairDataFormat;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.model.dataformat.BindyType;

public class DataFormatFIXDemo {

    public static void main(String[] args) throws Exception {
        CamelContext context = new DefaultCamelContext();
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {
                BindyKeyValuePairDataFormat format = new BindyKeyValuePairDataFormat(Order.class);
                from("direct:start")
                        .marshal().bindy(BindyType.KeyValue, Order.class)
                        //.marshal(format)
                        //.marshal().custom("")

                        .to("stream:out");
            }
        });
        ProducerTemplate template = context.createProducerTemplate();
        context.start();
        //template.sendBody("direct:start", "This is a test message");
        //Order order = new Order(new Header("Begin", 6), new Trailer(), "1232456", "1215154", "12313213", "12132132", "side", "Test Descriptoin");
        Map<String, Object> obj = new HashMap<>();
        Header header = new Header();
        header.setBeginString("FIX 4.1");
        header.setBodyLength(20);
        header.setMsgSeqNum(1);
        header.setMsgType("0");
        header.setSendCompId("INVMGR");
        header.setTargetCompId("BRKR");

        Trailer trailer = new Trailer();
        trailer.setCheckSum(220);

        Order order = new Order();
        order.setAccount("BE.CHM.001");
        order.setClOrdId("CHM0001-01");
        order.setIDSource("4");
        order.setSecurityId("BE0001245678");
        order.setSide("1");
        order.setText("this is a camel - bindy test");

        order.setHeader(header);
        order.setTrailer(trailer);

        obj.put(order.getClass().getName(), order);
        obj.put(header.getClass().getName(), header);
        obj.put(trailer.getClass().getName(), trailer);
        ArrayList<Map<String, Object>> list = new ArrayList<>(Arrays.asList(obj));
        template.sendBody("direct:start", list);//new ArrayList<>(Arrays.asList(obj))
        Thread.sleep(10000);
        context.stop();
    }
}
