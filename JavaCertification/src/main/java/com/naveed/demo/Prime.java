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
public class Prime {

    public static void checkPrime(int... n) {
        StringBuilder str = new StringBuilder();
        boolean b = true;
        int size = n.length - 1;
        int count = 0;
        for (int x : n) {
            /*for (int i = 2; i<Math.sqrt(x); i++) {
             if(x%i == 0 ){
             b =false;
             break;
             }
             }*/

            for (int i = 1; i < x; i++) {
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        b = false;
                        break;
                    }
                }
            }
            if (b = true && x != 1) {
                if ((x & 1) != 0 || x == 2) {
                    str.append(x);
                    if (count++ != size) {
                        str.append(" ");
                    }
                }
            }
        }
        System.out.println(str);
    }

    public static void isPrime(int... n) {
        int j = 2;   //variable
        StringBuilder str = new StringBuilder();
        boolean result = true;
        int size = n.length - 1;
        int count = 0;
        for (int x : n) {
            for (int i = 2; i < x / 2; i++) {
                if (x % i == 0) {
                    result = false;
                    break;
                }
            }
            
            if (result == true && x != 1) {
                if ((x & 1) != 0 || x == 2) {
                    str.append(x);
                    if (count++ != size) {
                        str.append(" ");
                    }
                }
            }
        }
        System.out.println(str);
    }

    public static void main(String[] args) {
        checkPrime(2, 9, 45);
        isPrime(2, 9, 45);
        boolean result = true;
        int num = 7;
        for (int i = 2; i < num / 2; i++) {
            if (num % i == 0) {
                result = false;
                break;
            }
        }
        System.out.println(" R " + result);
        if (result) {
            System.out.println(num + " ");
        }
    }

}
