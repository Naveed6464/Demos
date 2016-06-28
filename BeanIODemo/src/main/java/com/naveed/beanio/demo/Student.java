/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.beanio.demo;

import org.beanio.annotation.Field;
import org.beanio.annotation.Record;

/**
 *
 * @author nmrehman
 */
@Record(minOccurs = 0, maxOccurs = -1, name = "student")
public class Student {

    @Field(at = 0,length = 20, maxLength = 20)
    private String firstName;
    @Field(at = 20, length = 20, maxLength = 20)
    private String lastName;
    @Field(at = 40, length = 3, maxLength = 20)
    private int age;

    public Student() {
    }

    public Student(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
