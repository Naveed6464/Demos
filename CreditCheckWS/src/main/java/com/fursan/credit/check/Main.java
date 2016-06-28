/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursan.credit.check;

import javax.xml.ws.Endpoint;

/**
 *
 * @author nmrehman
 */
public class Main {

    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8090/creditcheck", new CreditCheckSOAP());
        System.out.println("Credit Check Web Service is now running at below url  - \n\t http://localhost:8090/creditcheck?wsdl");
        
        //ResourceConfig resourceConfig = new ResourceConfig(HelloWorld.class, Teams.class);
        //GrizzlyHttpServerFactory.createHttpServer(URI.create("http://localhost:8080/"), resourceConfig);
    }

}
