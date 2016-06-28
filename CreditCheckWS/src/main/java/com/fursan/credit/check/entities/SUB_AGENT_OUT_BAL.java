/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursan.credit.check.entities;

import javax.persistence.Entity;

/**
 *
 * @author Administrator
 */
@Entity
public class SUB_AGENT_OUT_BAL extends AbstractEntity {

    String CU_NO;
    String OUT_BAL;
    String CR_LIMIT;

    public SUB_AGENT_OUT_BAL() {
    }

    public SUB_AGENT_OUT_BAL(String CU_NO, String OUT_BAL, String CR_LIMIT) {
        this.CU_NO = CU_NO;
        this.OUT_BAL = OUT_BAL;
        this.CR_LIMIT = CR_LIMIT;
    }

    public String getCU_NO() {
        return CU_NO;
    }

    public void setCU_NO(String CU_NO) {
        this.CU_NO = CU_NO;
    }

    public String getOUT_BAL() {
        return OUT_BAL;
    }

    public void setOUT_BAL(String OUT_BAL) {
        this.OUT_BAL = OUT_BAL;
    }

    public String getCR_LIMIT() {
        return CR_LIMIT;
    }

    public void setCR_LIMIT(String CR_LIMIT) {
        this.CR_LIMIT = CR_LIMIT;
    }

}
