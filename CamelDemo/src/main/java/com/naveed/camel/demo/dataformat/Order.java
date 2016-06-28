package com.naveed.camel.demo.dataformat;

import java.util.Date;
import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Link;
import org.apache.camel.dataformat.bindy.annotation.Message;
import org.apache.camel.dataformat.bindy.annotation.Section;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nmrehman
 */
@Message(keyValuePairSeparator = "=", pairSeparator = "\u0001", type = "FIX", version = "4.4")
//@Data
@Section(number = 2)
public class Order {

    @Link
    Header header;

    @Link
    Trailer trailer;

    @KeyValuePairField(tag = 1) // Client reference
    private String account;

    @KeyValuePairField(tag = 11) // Order reference
    private String clOrdId;

    @KeyValuePairField(tag = 22) // Fund ID type (Sedol, ISIN, ...)
    private String iDSource;

    @KeyValuePairField(tag = 48) // Fund code
    private String securityId;

    @KeyValuePairField(tag = 54) // Movement type ( 1 = Buy, 2 = sell)
    private String side;

    @KeyValuePairField(tag = 58) // Free text
    private String text;

    @KeyValuePairField(tag = 777, pattern = "dd-MM-yyyy HH:mm:ss", timezone = "GMT-3")
    private Date created;

    public Order() {
    }

    public Order(Header header, Trailer trailer, String Account, String ClOrdId, String IDSource, String SecurityId, String Side, String Text) {
        this.header = header;
        this.trailer = trailer;
        this.account = Account;
        this.clOrdId = ClOrdId;
        this.iDSource = IDSource;
        this.securityId = SecurityId;
        this.side = Side;
        this.text = Text;
    }

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Trailer getTrailer() {
        return trailer;
    }

    public void setTrailer(Trailer trailer) {
        this.trailer = trailer;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String Account) {
        this.account = Account;
    }

    public String getClOrdId() {
        return clOrdId;
    }

    public void setClOrdId(String ClOrdId) {
        this.clOrdId = ClOrdId;
    }

    public String getIDSource() {
        return iDSource;
    }

    public void setIDSource(String IDSource) {
        this.iDSource = IDSource;
    }

    public String getSecurityId() {
        return securityId;
    }

    public void setSecurityId(String SecurityId) {
        this.securityId = SecurityId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String Side) {
        this.side = Side;
    }

    public String getText() {
        return text;
    }

    public void setText(String Text) {
        this.text = Text;
    }

    @Override
    public String toString() {

        return Order.class.getName() + " --> 1: " + this.account + ", 11: " + this.clOrdId + ", 22: " + this.iDSource + ", 48: " + this.securityId + ", 54: " + this.side
                + ", 58: " + this.text + ", 777: " + this.created;

    }
}
