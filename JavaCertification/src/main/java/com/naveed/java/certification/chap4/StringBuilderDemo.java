/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.java.certification.chap4;

/**
 *
 * @author nmrehman
 */
public class StringBuilderDemo {

    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder("123456");
        CharSequence subSequence = sb1.subSequence(2, 4);
        System.out.println("Sub " + subSequence);
        sb1.deleteCharAt(3);
        sb1.reverse();
        System.out.println(sb1);

        //Arrays
        int[] arr1;
        int[] arr2 = new int[3];
        char[] arr3 = {'a', 'b'};
        byte[] arr4 = { 1, 2};
        short[] arr5 = { 1, 2, 3};
        arr1 = arr2;
        //arr1 = arr3; //error
        //arr1 = arr4; //error
        //arr1 = arr5; //error
        StringBuilder ejg = new StringBuilder(10 + 2 + "SUN" + 4 + 5);
        System.out.println(" - " + ejg);
        ejg.append(ejg.delete(3, 6));
        System.out.println(" - " + ejg);
    }

}
