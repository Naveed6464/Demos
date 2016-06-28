package com.naveed.demo;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.naveed.demo.module.GreetModule;
import com.naveed.demo.service.IGreetService;

/**
 *
 * @author Naveedur Rahman
 *
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new GreetModule());
        IGreetService service = injector.getInstance(IGreetService.class);
        String greet = service.greet("World!");
        System.out.println("Service " + greet);
    }
}
