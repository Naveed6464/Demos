/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author nmrehman
 */
public class Pagination {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15));

        int perPage = 10;
        int currentPage = 0;
        int pagesize = list.size() / perPage;
        for (int i = currentPage; i <= pagesize; i++) {
            pagination(i, perPage, list);
        }
        int from = Math.max(0, currentPage * perPage);
        int to = Math.min(list.size(), (currentPage + 1) * perPage);
        System.out.println("From " + from + " To " + to);
        System.out.println("Page Size " + pagesize + " " + list.size());
    }

    public static void pagination(int currentPage, int perPage, List<Integer> list) {
        int from = Math.max(0, currentPage * perPage);
        int to = Math.min(list.size(), (currentPage + 1) * perPage);
        System.out.println("List " + list.subList(from, to));
    }
}
