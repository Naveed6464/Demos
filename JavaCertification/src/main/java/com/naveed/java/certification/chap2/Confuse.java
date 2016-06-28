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
public class Confuse {

    public static void main(String[] args) {
        int myInt = 7;
        boolean result = true; //bool to confuse
        if (result == true) {
            do {
                System.out.println(myInt);
            } while (myInt > 10);
        }
    }
}
