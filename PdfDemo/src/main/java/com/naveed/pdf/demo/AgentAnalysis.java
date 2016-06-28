/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.pdf.demo;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

/**
 *
 * @author nmrehman
 */
@Record(minOccurs = 0, maxOccurs = -1)
public class AgentAnalysis {

    @Field(at = 1, length = 3)
    private String air;

    @Field(at = 6, length = 3)
    private String curr;

    @Field(at = 11, length = 10)
    private long documentNumber;

    @Field(at = 22, length = 2)
    private int cd;

    @Field(at = 29, length = 4)
    private String voidCPNS;

    @Field(at = 35, length = 7)
    private String issueDate;

    @Field(at = 50, length = 10)
    private String grossFareCash;

    @Field(at = 63, length = 7)
    private String taxCash;

    @Field(at = 81, length = 8)
    private String grossFareCredit;

    @Field(at = 94, length = 10)
    private String taxCredit;

    @Field(at = 120, length = 5)
    private String stCommRate;

    @Field(at = 131, length = 8)
    private String stCommAmount;

    @Field(at = 144, length = 8)
    private String supplCommAmount;

    @Field(at = 171, length = 8)
    private double payableBalance;

    @Field(at = 183, length = 25)
    private String remarks;

    public AgentAnalysis() {
    }

    public String getAir() {
        return air;
    }

    public void setAir(String air) {
        this.air = air;
    }

    public String getCurr() {
        return curr;
    }

    public void setCurr(String curr) {
        this.curr = curr;
    }

    public long getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(long documentNumber) {
        this.documentNumber = documentNumber;
    }

    public int getCd() {
        return cd;
    }

    public void setCd(int cd) {
        this.cd = cd;
    }

    public String getVoidCPNS() {
        return voidCPNS;
    }

    public void setVoidCPNS(String voidCPNS) {
        this.voidCPNS = voidCPNS;
    }

    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }

    public String getIssueDate() {
        return issueDate;
    }

    public String getGrossFareCash() {
        return grossFareCash;
    }

    public void setGrossFareCash(String grossFareCash) {
        this.grossFareCash = grossFareCash;
    }

    public String getTaxCash() {
        return taxCash;
    }

    public void setTaxCash(String taxCash) {
        this.taxCash = taxCash;
    }

    public String getGrossFareCredit() {
        return grossFareCredit;
    }

    public void setGrossFareCredit(String grossFareCredit) {
        this.grossFareCredit = grossFareCredit;
    }

    public String getTaxCredit() {
        return taxCredit;
    }

    public void setTaxCredit(String taxCredit) {
        this.taxCredit = taxCredit;
    }

    public String getStCommRate() {
        return stCommRate;
    }

    public void setStCommRate(String stCommRate) {
        this.stCommRate = stCommRate;
    }

    public String getStCommAmount() {
        return stCommAmount;
    }

    public void setStCommAmount(String stCommAmount) {
        this.stCommAmount = stCommAmount;
    }

    public String getSupplCommAmount() {
        return supplCommAmount;
    }

    public void setSupplCommAmount(String supplCommAmount) {
        this.supplCommAmount = supplCommAmount;
    }

    public double getPayableBalance() {
        return payableBalance;
    }

    public void setPayableBalance(double payableBalance) {
        this.payableBalance = payableBalance;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Air = ").append(air).append(", ");
        builder.append("Curr = ").append(curr).append(", ");
        builder.append("DocumentNumber = ").append(documentNumber).append(", ");
        builder.append("CD = ").append(cd).append(", ");
        builder.append("VoidCPNS = ").append(voidCPNS).append(", ");
        builder.append("IssueDate = ").append(issueDate).append(", ");
        builder.append("GrossFareCash = ").append(grossFareCash).append(", ");
        builder.append("taxCash = ").append(taxCash).append(", ");
        builder.append("grossFareCredit = ").append(grossFareCredit).append(", ");
        builder.append("taxCredit = ").append(taxCredit).append(", ");
        builder.append("stCommRate = ").append(stCommRate).append(", ");
        builder.append("stCommAmount = ").append(stCommAmount).append(", ");
        builder.append("supplCommAmount = ").append(supplCommAmount).append(", ");
        builder.append("payableBalance = ").append(payableBalance).append(", ");
        builder.append("remarks = ").append(remarks).append(", ");
        return builder.toString();
    }

}
