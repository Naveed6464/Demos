/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo.service;

/**
 *
 * @author naveed
 */
public class GreetService implements IGreetService {

    @Override
    public String greet(String greetings) {
        return "Hello " + greetings;
    }
}
