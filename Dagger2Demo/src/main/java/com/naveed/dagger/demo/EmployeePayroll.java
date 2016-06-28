/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.dagger.demo;

import javax.inject.Inject;

/**
 *
 * @author nmrehman
 */
public class EmployeePayroll {

    @Inject
    Employee employee;

    @Inject
    public EmployeePayroll() {
    }

    public void sayHello() {
        System.out.println("Hello World! " + employee.getFirstName());
    }
}
