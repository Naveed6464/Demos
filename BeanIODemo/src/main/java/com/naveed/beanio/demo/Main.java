package com.naveed.beanio.demo;

import java.io.File;
import java.io.PrintWriter;
import java.io.StringReader;
import org.beanio.BeanReader;
import org.beanio.BeanWriter;
import org.beanio.StreamFactory;
import org.beanio.builder.StreamBuilder;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        StreamFactory factory = StreamFactory.newInstance();
        StreamBuilder builder = new StreamBuilder("stu")
                .format("fixedlength")
                //.parser(new DelimitedParserBuilder(','))
                .addRecord(Student.class);


        /*StreamBuilder builder = new StreamBuilder("stu")
         .format("delimited")
         .parser(new DelimitedParserBuilder('|'))
         .addRecord(new RecordBuilder("student")
         .type(Student.class)
         .minOccurs(1)
         .addField(new FieldBuilder("firstName"))
         .addField(new FieldBuilder("lastName"))
         .addField(new FieldBuilder("age"))
         );*/
        factory.define(builder);
        PrintWriter writer = new PrintWriter(System.out);
        //BeanWriter out = factory.createWriter("stu", writer);
        BeanWriter out = factory.createWriter("stu", new File("output1.txt"));

        Student student = new Student("Naveedur", "Rahman", 28);
        out.write(student);
        out.write(student);
        out.write(student);
        out.flush();
        out.close();

        StringReader reader = new StringReader("Naveedur            Rahman              28 \nNaveed              Rahman              28 ");
        BeanReader in = factory.createReader("stu", reader);
        Student stud;
        while ((stud = (Student) in.read()) != null) {
            System.out.println(">>> " + stud.getFirstName() + " " + stud.getLastName());
        }
        in.close();
    }
}
