package com.naveed.beanio.demo;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.DelimitedParserBuilder;
import org.beanio.builder.FieldBuilder;
import org.beanio.builder.RecordBuilder;
import org.beanio.builder.StreamBuilder;

public class Main2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StreamFactory factory = StreamFactory.newInstance();

        /*StreamBuilder builder = new StreamBuilder("stu")
         .format("fixedlength")
         //.parser(new DelimitedParserBuilder(','))
         .addRecord(Map.class);*/
        StreamBuilder builder = new StreamBuilder("stu")
                .format("fixedlength")
                //.parser(new DelimitedParserBuilder('|'))
                .addRecord(new RecordBuilder("student")
                        .type(HashMap.class)
                        .minOccurs(1)
                        .addField(new FieldBuilder("firstName").at(0).length(20))
                        .addField(new FieldBuilder("lastName").at(20).length(20))
                        .addField(new FieldBuilder("age").at(40).length(3))
                );
        factory.define(builder);
        PrintWriter writer = new PrintWriter(System.out);
        //BeanWriter out = factory.createWriter("stu", writer);
        BeanWriter out = factory.createWriter("stu", new File("output2.txt"));

        Student student = new Student("Naveedur", "Rahman", 28);

        //out.write(student);
        //out.write(student);
        //out.write(student);
        HashMap<String, String> obj = new HashMap<>();
        obj.put("firstName", "Naveedur");
        obj.put("lastName", "Rahman");
        obj.put("age", "10");
        
        out.write(obj);out.write(obj);

        out.flush();
        out.close();

        StringReader reader = new StringReader("Naveedur            Rahman              28 \nNaveed2              Rahman2             28 ");
        BeanReader in = factory.createReader("stu", reader);
        Student stud;
        /*while ((stud = (Student) in.read()) != null) {
         System.out.println(">>> " + stud.getFirstName() + " " + stud.getLastName());
         }*/
        HashMap<String, String> map = new HashMap<>();
        while ((map = (HashMap) in.read()) != null) {
            for (Map.Entry<String, String> key : map.entrySet()) {
                System.out.println(">>>>>> " + key.getKey() + " " + key.getValue());
            }
        }
        in.close();
    }
}
