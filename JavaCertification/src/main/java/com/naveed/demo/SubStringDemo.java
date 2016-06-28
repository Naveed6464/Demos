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
public class SubStringDemo {

    public static void main(String[] args) {
        String ext = ".txt";
        if (ext.startsWith(".")) {
            ext = ext.substring(1);
        }
        System.out.println(">>>>>>>>>> " + ext);
    }

}
