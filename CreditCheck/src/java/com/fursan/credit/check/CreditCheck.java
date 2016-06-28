/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursan.credit.check;

import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author nmrehman
 */
@WebService
public class CreditCheck {

    @WebMethod
    public Response GetCustomerCreditLimit(String ClientCode, double Amount, String Username, String Password) {
        //Business logic needs to implent here
        return new Response("Y", "111.0");
    }

    @WebMethod
    public Response GetCustomerCreditLimit(String ClientCode, String Username, String Password) {
        //Business logic needs to implent here
        return new Response("Y", "111.0");
    }

}
