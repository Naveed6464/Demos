/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.pdf.demo;

import java.io.StringReader;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.beanio.builder.StreamBuilder;

/**
 *
 * @author nmrehman
 */
public class TestBeanIO {

    public static void main(String[] args) {
        StreamFactory factory = StreamFactory.newInstance();
        StreamBuilder builder = new StreamBuilder("agent")
                .format("fixedlength")
                .addRecord(AgentAnalysis.class);
        factory.define(builder);

        StringBuilder str = new StringBuilder();
        str.append(" 077  SAR  2718312473 2      FVVV  04JAN16          113.00                    |                                        |                                                 |   113.00                               \n");
        str.append(" 079  SAR  9777128383        FVVV  07JAN16                                    |  2014.00                               |                                                 |             CCAX376655XXXXX1518         \n");
        str.append(" 589  SAR  9777128234        FFFF  07JAN16         1555.00                    |                                        |                         155.50-                 |  2278.50    NR 9WSA1520001F             \n");
        str.append("                                                                              |               90.00 CP                 |                                                 |             RF0659777048054 12          ");

        StringReader reader = new StringReader(str.toString());

        BeanReader in = factory.createReader("agent", reader);
        AgentAnalysis agent_analysis;
        while ((agent_analysis = (AgentAnalysis) in.read()) != null) {
            System.out.println(">>> " + agent_analysis);            
        }
        in.close();
    }
}
