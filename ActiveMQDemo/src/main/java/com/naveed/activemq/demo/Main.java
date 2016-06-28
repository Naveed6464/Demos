package com.naveed.activemq.demo;

import javax.jms.JMSException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws JMSException {        
        //http://www.coderpanda.com/jms-example-using-apache-activemq/
        //http://activemq.apache.org/hello-world.html
        JmsMessageSender sender = new JmsMessageSender();
        sender.sendMessage("This is sample message sent by Naveed");
        JmsMessageReciver reciver = new JmsMessageReciver();
        reciver.receiveMessage();
    }
}