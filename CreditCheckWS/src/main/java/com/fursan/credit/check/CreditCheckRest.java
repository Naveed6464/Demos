/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursan.credit.check;

import com.fursan.credit.check.entities.SUB_AGENT_OUT_BAL;
import com.fursan.credit.check.service.SUB_AGENT_OUT_BAL_Service;

/**
 *
 * @author nmrehman
 */
//@Path("team")
public class CreditCheckRest {

    SUB_AGENT_OUT_BAL_Service service = new SUB_AGENT_OUT_BAL_Service();

    //@GET
    //@Produces(value = "application/json")
    //@Path("/{CU_CODE}/{amount}") //@PathParam("CU_CODE") String CU_CODE, @PathParam("amount") double amount
    public Response GetCustomerCreditLimit(String CU_CODE, double amount) {
        SUB_AGENT_OUT_BAL sub_agent_out_bal = service.getAgentOutBalance(CU_CODE);
        return new Response(sub_agent_out_bal.getCU_NO(), sub_agent_out_bal.getOUT_BAL(), sub_agent_out_bal.getCR_LIMIT());
    }

    //@GET
    //@Produces(value = "application/json")
    //@Path("/{CU_CODE}/{amount}") //@PathParam("CU_CODE") String CU_CODE
    public Response GetCustomerCreditLimit2(String CU_CODE) {
        SUB_AGENT_OUT_BAL sub_agent_out_bal = service.getAgentOutBalance(CU_CODE);
        return new Response(sub_agent_out_bal.getCU_NO(), sub_agent_out_bal.getOUT_BAL(), sub_agent_out_bal.getCR_LIMIT());
    }
}
