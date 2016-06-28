/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo.module;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.naveed.demo.service.GreetService;
import com.naveed.demo.service.IGreetService;

/**
 *
 * @author naveed
 */
public class GreetModule extends AbstractModule {

    @Override
    protected void configure() {
        //Explicit binding can be done. if your service is not annotated or want to change the implementation
        bind(IGreetService.class).to(GreetService.class).in(Scopes.SINGLETON);
    }
}