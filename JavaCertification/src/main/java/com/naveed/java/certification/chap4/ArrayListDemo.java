/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.java.certification.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nmrehman
 */
public class ArrayListDemo {

    public static void main(String[] args) {
        String one = "One";
        String two = new String("Two");
        List<String> firstList = new ArrayList<>(Arrays.asList(one, two));
        firstList.add(one);
        List<String> secondList = new ArrayList<>(Arrays.asList("Three", "Four"));

        firstList.addAll(1, secondList);
        secondList.add("Five");
        firstList.add("5");
        for (String str : firstList) {
            System.out.println(str);
        }

        List<String> thirdList = firstList;
        thirdList.add("Six");
        firstList.add("6");
        one = one.replace("O", "B");
        for (String str : firstList) {
            System.out.println("First " + str);
        }
        for (String str : thirdList) {
            System.out.println("Third " +str);
        }
        String text = "<div>\n" +
"                <a class = \"btn btn-default btn-sm\" data-ui-sref = \"app.crud({id : data.id, type: 'edit', name: name})\">\n" +
"                    <i class='glyphicon glyphicon-edit'></i></a>\n" +
"                <a class=\"btn btn-default btn-sm\" data-ui-sref=\"app.crud({id : data.id, type: 'view', name: name})\">\n" +
"                    <i class='glyphicon glyphicon-th-list'></i></a>\n" +
"            </div>";
    }

}
