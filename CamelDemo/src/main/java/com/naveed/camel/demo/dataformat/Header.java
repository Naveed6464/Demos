/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.camel.demo.dataformat;

import org.apache.camel.dataformat.bindy.annotation.KeyValuePairField;
import org.apache.camel.dataformat.bindy.annotation.Link;
import org.apache.camel.dataformat.bindy.annotation.Section;

/**
 *
 * @author nmrehman
 */
//@Section(number = 1)
@Link
public class Header {

    @KeyValuePairField(tag = 8) // Message Header
    private String beginString;

    @KeyValuePairField(tag = 9) // Checksum
    private int bodyLength;

    @KeyValuePairField(tag = 35) // Message Type
    private String msgType;

    @KeyValuePairField(tag = 34)// Sequence number    
    private int msgSeqNum;

    @KeyValuePairField(tag = 49)// Company sender Id
    private String sendCompId;

    @KeyValuePairField(tag = 56) // target company id    
    private String targetCompId;

    public Header() {
    }

    public Header(String beginString, int bodyLength) {
        this.beginString = beginString;
        this.bodyLength = bodyLength;
    }

    public String getBeginString() {
        return beginString;
    }

    public void setBeginString(String beginString) {
        this.beginString = beginString;
    }

    public int getBodyLength() {
        return bodyLength;
    }

    public void setBodyLength(int bodyLength) {
        this.bodyLength = bodyLength;
    }

    public String getMsgType() {
        return msgType;
    }

    public void setMsgType(String msgType) {
        this.msgType = msgType;
    }

    public int getMsgSeqNum() {
        return msgSeqNum;
    }

    public void setMsgSeqNum(int msgSeqNum) {
        this.msgSeqNum = msgSeqNum;
    }

    public String getSendCompId() {
        return sendCompId;
    }

    public void setSendCompId(String sendCompId) {
        this.sendCompId = sendCompId;
    }

    public String getTargetCompId() {
        return targetCompId;
    }

    public void setTargetCompId(String targetCompId) {
        this.targetCompId = targetCompId;
    }

    @Override
    public String toString() {
        return Header.class.getName() + " --> 8: " + this.beginString + ", 9: " + this.bodyLength + ", 34: " + this.msgSeqNum + " , 35: " + this.msgType + ", 49: "
                + this.sendCompId + ", 56: " + this.targetCompId;
    }

}
