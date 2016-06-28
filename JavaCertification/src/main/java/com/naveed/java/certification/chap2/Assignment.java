/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.java.certification.chap2;

/**
 *
 * @author nmrehman
 */
public class Assignment {

    private static int a, b, c = 10;
    private static long lng = 10L;
    private static boolean bool;

    public static void main(String[] args) {
        System.out.printf("A %d B %d C %d", a, b, c);
        a = b = c = 14;
        System.out.printf("A %d B %d C %d", a, b, c);
        //bool = 10;
        //a = bool;
        lng = a;
        //a = lng;
        System.out.println("Boolean");
        
    }

}
