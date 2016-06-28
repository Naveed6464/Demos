/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fursan.credit.check;

/**
 *
 * @author nmrehman
 */
public class Response {

    String Code;
    String Name;
    String AllowTransaction;
    String CreditLimit;
    double OSBalance;
    String Category;
    String PercentageOverCL;
    String BlockCreditSale;
    String ReachingPercentage;
    String Message;

    public Response() {
    }

    public Response(String Code, String Name, String AllowTransaction, String CreditLimit, double OSBalance, String Category, String PercentageOverCL, String BlockCreditSale, String ReachingPercentage, String Message) {
        this.Code = Code;
        this.Name = Name;
        this.AllowTransaction = AllowTransaction;
        this.CreditLimit = CreditLimit;
        this.OSBalance = OSBalance;
        this.Category = Category;
        this.PercentageOverCL = PercentageOverCL;
        this.BlockCreditSale = BlockCreditSale;
        this.ReachingPercentage = ReachingPercentage;
        this.Message = Message;
    }

    public Response(String AllowTransaction, String CreditLimit) {
        this("", "", AllowTransaction, CreditLimit, 0.0, "", "", "", "", "");
    }

    public String getCode() {
        return Code;
    }

    public void setCode(String Code) {
        this.Code = Code;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }

    public String getAllowTransaction() {
        return AllowTransaction;
    }

    public void setAllowTransaction(String AllowTransaction) {
        this.AllowTransaction = AllowTransaction;
    }

    public String getCreditLimit() {
        return CreditLimit;
    }

    public void setCreditLimit(String CreditLimit) {
        this.CreditLimit = CreditLimit;
    }

    public double getOSBalance() {
        return OSBalance;
    }

    public void setOSBalance(double OSBalance) {
        this.OSBalance = OSBalance;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String Category) {
        this.Category = Category;
    }

    public String getPercentageOverCL() {
        return PercentageOverCL;
    }

    public void setPercentageOverCL(String PercentageOverCL) {
        this.PercentageOverCL = PercentageOverCL;
    }

    public String getBlockCreditSale() {
        return BlockCreditSale;
    }

    public void setBlockCreditSale(String BlockCreditSale) {
        this.BlockCreditSale = BlockCreditSale;
    }

    public String getReachingPercentage() {
        return ReachingPercentage;
    }

    public void setReachingPercentage(String ReachingPercentage) {
        this.ReachingPercentage = ReachingPercentage;
    }

    public String getMessage() {
        return Message;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

}
