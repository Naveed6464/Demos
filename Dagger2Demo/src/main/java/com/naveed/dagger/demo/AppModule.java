/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.dagger.demo;

import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 *
 * @author nmrehman
 */
@Singleton
@Module
public class AppModule {       

    @Provides
    @Singleton
    public Employee provideEmployee2() {
        return new Employee("Naveedur", "Rahman");
    }

}
