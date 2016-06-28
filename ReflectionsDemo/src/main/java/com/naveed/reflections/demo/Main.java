package com.naveed.reflections.demo;

import java.lang.reflect.Method;
import java.util.Set;
import org.reflections.Reflections;
import org.reflections.scanners.MethodAnnotationsScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;
import static org.reflections.ReflectionUtils.*;
import org.reflections.scanners.MethodParameterScanner;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Reflections reflections = new Reflections(new ConfigurationBuilder().setUrls(ClasspathHelper.forPackage("com.naveed")).setScanners(new MethodAnnotationsScanner(), new MethodParameterScanner()));
        Set<Method> annotated = reflections.getMethodsAnnotatedWith(BeforeCommit.class);
        Set<Method> all = getAll(annotated, withParameters(Entity.class));
        //withAnyParameterAnnotation(BeforeCommit.class);
        //annotated = reflections.getMethodsMatchParams(Entity.class);                
        System.out.println(">>>>>>>>>>>>> " + all.size());
        for (Method methd : all){
            System.out.println("Method " + methd.getName());
        }
    }
}
