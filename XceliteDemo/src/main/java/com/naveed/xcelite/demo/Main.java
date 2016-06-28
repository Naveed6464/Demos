package com.naveed.xcelite.demo;

import com.ebay.xcelite.Xcelite;
import com.ebay.xcelite.reader.SheetReader;
import com.ebay.xcelite.sheet.XceliteSheet;
import com.ebay.xcelite.writer.SheetWriter;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Xcelite xcelite = new Xcelite();
        XceliteSheet sheet = xcelite.createSheet("users");
        SheetWriter<User> writer = sheet.getBeanWriter(User.class);

        List<User> users = new ArrayList<User>();
        users.add(new User("Naveedur", "Rahman", 1, new Date()));
        users.add(new User("Md", "Salahuddin", 2, new Date()));
        writer.write(users);
        xcelite.write(new File("users_doc.xlsx"));

        SheetReader<User> reader = sheet.getBeanReader(User.class);
        Collection<User> users1 = reader.read();
        for(User user : users1){
            System.out.println(">>>>>>>>>>>> " + user);
        }
    }
}
