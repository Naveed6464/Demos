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
@Section(number = 3)
@Link
public class Trailer {

    @KeyValuePairField(tag = 10)
    // CheckSum
    private int checkSum;

    public void setCheckSum(int checkSum) {
        this.checkSum = checkSum;
    }

    public int getCheckSum() {
        return checkSum;
    }

    public Trailer() {
    }

    public Trailer(int checkSum) {
        this.checkSum = checkSum;
    }

    @Override
    public String toString() {
        return Trailer.class.getName() + " --> 10: " + this.checkSum;
    }

}
