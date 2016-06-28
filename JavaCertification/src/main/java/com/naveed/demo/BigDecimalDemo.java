/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.math.BigDecimal;

/**
 *
 * @author nmrehman
 */
public class BigDecimalDemo {

    public static void main(String[] args) {
        BigDecimal one = new BigDecimal(0);
        BigDecimal two = new BigDecimal(-100.00000043530000000000);
        System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>>");

        if (two.compareTo(BigDecimal.ZERO) <= 0) {
            System.out.println("Greater then zero " + two);
        }
    }

}
