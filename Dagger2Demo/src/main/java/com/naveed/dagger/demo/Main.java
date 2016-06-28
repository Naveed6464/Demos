package com.naveed.dagger.demo;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        AppComponent component = DaggerAppComponent.create();
        component.service().sayHello();
        EmployeePayroll payroll = new EmployeePayroll();
        component.inject(payroll);
        payroll.sayHello();
    }
}