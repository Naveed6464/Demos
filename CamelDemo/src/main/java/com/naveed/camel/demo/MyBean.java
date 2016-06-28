/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.camel.demo;

/**
 *
 * @author nmrehman
 */
public class MyBean {

    String test(String custom) {
        return custom + " Modified!";
    }
    
    public String map(String custom) {
        return custom + " Modified2!";
    }

}
