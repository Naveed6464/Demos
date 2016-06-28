package com.naveed.demo.netty;

import com.naveed.netty.core.server.HttpServer;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author naveed
 */
public class NettyBootstrap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Properties prop = new Properties();
        try {
            //load a properties file from class path.
            prop.load(NettyBootstrap.class.getClassLoader().getResourceAsStream("config.properties"));
        } catch (IOException ex) {
            System.out.println(" Error Reading Property File. " + ex);
        }
        HttpServer server = new HttpServer();
        HttpServerHandler handler = new HttpServerHandler();
        server.start(Integer.parseInt(prop.getProperty("netty.port")), handler);
    }
}
