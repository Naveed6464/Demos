/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

/**
 *
 * @author nmrehman
 */
public class MaxDataType {
    
    public static void main(String[] args) {
        System.out.println("byte " + Byte.MIN_VALUE +  " " + Byte.MAX_VALUE);
        System.out.println("Short " + Short.MIN_VALUE + " "+ Short.MAX_VALUE);
        System.out.println("Int " + Integer.MIN_VALUE + " "+ Integer.MAX_VALUE);
        System.out.println("Long " + Long.MIN_VALUE + " "+ Long.MAX_VALUE);
        int n = 100;
        String s = String.valueOf(n);
    }
}