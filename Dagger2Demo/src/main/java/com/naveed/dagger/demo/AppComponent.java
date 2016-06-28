/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.dagger.demo;

import dagger.Component;
import javax.inject.Singleton;

/**
 *
 * @author nmrehman
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    EmployeeService service();

    void inject(EmployeePayroll payroll);
}
