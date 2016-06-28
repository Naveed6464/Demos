/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.camel.demo.cxf;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author nmrehman
 */
@WebService
public class OrderEndpoint {
    
    @WebMethod
    String order(String partName, int amount, String customerName){
        return "OK";
    }
}
