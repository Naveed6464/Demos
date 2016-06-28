/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.xcelite.demo;

import com.ebay.xcelite.annotations.Column;
import java.util.Date;

/**
 *
 * @author nmrehman
 */
public class User {

    @Column(name = "Firstname")
    private String firstName;

    @Column(name = "Lastname")
    private String lastName;

    @Column
    private long id;

    @Column
    private Date birthDate;

    public User() {
    }

    public User(String firstName, String lastName, long id, Date birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = id;
        this.birthDate = birthDate;
    }

}
