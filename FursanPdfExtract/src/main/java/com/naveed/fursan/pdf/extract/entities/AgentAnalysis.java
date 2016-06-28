/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.entities;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

/**
 *
 * @author nmrehman
 */
@Record(minOccurs = 0, maxOccurs = -1)
@Entity
public class AgentAnalysis extends AbstractEntity {

    private static final String VALUE_SEPERATOR = " | ";

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

    private int pageNo;
    @ManyToOne
    private PdfDocument pdfDocument;

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

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPdfDocument(PdfDocument pdfDocument) {
        this.pdfDocument = pdfDocument;
    }

    public PdfDocument getPdfDocument() {
        return pdfDocument;
    }

    public void setPageNoAndPdfDoc(int pageNo, PdfDocument pdfDocument) {
        this.pageNo = pageNo;
        this.pdfDocument = pdfDocument;
    }

    public void appendGrossFareCash(String grossFareCash) {
        if (!grossFareCash.trim().isEmpty()) {
            this.grossFareCash = this.grossFareCash.trim().isEmpty() ? grossFareCash.trim() : this.grossFareCash.trim() + VALUE_SEPERATOR + grossFareCash.trim();
        }
    }

    public void appendTaxCash(String taxCash) {
        if (!taxCash.trim().isEmpty()) {
            this.taxCash = this.taxCash.trim().isEmpty() ? taxCash.trim() : this.taxCash.trim() + VALUE_SEPERATOR + taxCash.trim();
        }
    }

    public void appendGrossFareCredit(String grossFareCredit) {
        if (!grossFareCredit.trim().isEmpty()) {
            this.grossFareCredit = this.grossFareCredit.trim().isEmpty() ? grossFareCredit.trim() : this.grossFareCredit.trim() + VALUE_SEPERATOR + grossFareCredit.trim();
        }
    }

    public void appendTaxCredit(String taxCredit) {
        if (!taxCredit.trim().isEmpty()) {
            this.taxCredit = this.taxCredit.trim().isEmpty() ? taxCredit.trim() : this.taxCredit.trim() + VALUE_SEPERATOR + taxCredit.trim();
        }
    }

    public void appendStCommRate(String stCommRate) {
        if (!stCommRate.trim().isEmpty()) {
            this.stCommRate = this.stCommRate.trim().isEmpty() ? stCommRate.trim() : this.stCommRate.trim() + VALUE_SEPERATOR + stCommRate.trim();
        }
    }

    public void appendStCommAmount(String stCommAmount) {
        if (!stCommAmount.trim().isEmpty()) {
            this.stCommAmount = this.stCommAmount.trim().isEmpty() ? stCommAmount.trim() : this.stCommAmount.trim() + VALUE_SEPERATOR + stCommAmount.trim();
        }
    }

    public void appendSupplCommAmount(String supplCommAmount) {
        if (!supplCommAmount.trim().isEmpty()) {
            this.supplCommAmount = this.supplCommAmount.trim().isEmpty() ? supplCommAmount.trim() : this.supplCommAmount.trim() + VALUE_SEPERATOR + supplCommAmount.trim();
        }
    }

    public void appendRemarks(String remarks) {
        if (!remarks.trim().isEmpty()) {
            this.remarks = this.remarks.trim().isEmpty() ? remarks.trim() : this.remarks.trim() + VALUE_SEPERATOR + remarks.trim();
        }
    }

    public void append(AgentAnalysis agentAnalysis) {
        appendGrossFareCash(agentAnalysis.getGrossFareCash());
        appendTaxCash(agentAnalysis.getTaxCash());
        appendGrossFareCredit(agentAnalysis.getGrossFareCredit());
        appendTaxCredit(agentAnalysis.getTaxCredit());
        appendStCommRate(agentAnalysis.getStCommRate());
        appendStCommAmount(agentAnalysis.getStCommAmount());
        appendSupplCommAmount(agentAnalysis.getSupplCommAmount());
        appendRemarks(agentAnalysis.getRemarks());
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
