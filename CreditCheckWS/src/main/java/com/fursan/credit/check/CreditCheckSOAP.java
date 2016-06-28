/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursan.credit.check;

import com.fursan.credit.check.entities.SUB_AGENT_OUT_BAL;
import com.fursan.credit.check.service.SUB_AGENT_OUT_BAL_Service;
import javax.jws.WebMethod;
import javax.jws.WebService;

/**
 *
 * @author nmrehman
 */
@WebService
public class CreditCheckSOAP {

    SUB_AGENT_OUT_BAL_Service service = new SUB_AGENT_OUT_BAL_Service();
    
    @WebMethod
    public Response GetCustomerCreditLimit(String ClientCode, double Amount, String Username, String Password) {
        SUB_AGENT_OUT_BAL sub_agent_out_bal = service.getAgentOutBalance(ClientCode);
        return new Response(sub_agent_out_bal.getCU_NO(), sub_agent_out_bal.getOUT_BAL(), sub_agent_out_bal.getCR_LIMIT());
    }

    @WebMethod
    public Response GetCustomerCreditLimit2(String ClientCode, String Username, String Password) {
        SUB_AGENT_OUT_BAL sub_agent_out_bal = service.getAgentOutBalance(ClientCode);
        return new Response(sub_agent_out_bal.getCU_NO(), sub_agent_out_bal.getOUT_BAL(), sub_agent_out_bal.getCR_LIMIT());
    }

}
