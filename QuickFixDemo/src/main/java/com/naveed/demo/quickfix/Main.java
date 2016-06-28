/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.demo.quickfix;

import quickfix.Application;
import quickfix.ConfigError;
import quickfix.DefaultMessageFactory;
import quickfix.FileLogFactory;
import quickfix.FileStoreFactory;
import quickfix.Message;
import quickfix.MessageFactory;
import quickfix.Session;
import quickfix.SessionID;
import quickfix.SessionNotFound;
import quickfix.SessionSettings;
import quickfix.SocketInitiator;
import quickfix.field.BeginString;
import quickfix.field.HeartBtInt;
import quickfix.fix40.Logon;

/**
 *
 * @author nmrehman
 */
public class Main {

    public static void main(String[] args) {
        SocketInitiator socketInitiator = null;
        try {
            SessionSettings sessionSettings = new SessionSettings("C:\\Users\\nmrehman\\Documents\\Naveed-Dev\\Demos\\QuickFixDemo\\FixSettings.cfg");
            Application application = new DemoFixApp();
            FileStoreFactory fileStoreFactory = new FileStoreFactory(sessionSettings);
            FileLogFactory logFactory = new FileLogFactory(sessionSettings);
            MessageFactory messageFactory = new DefaultMessageFactory();
            socketInitiator = new SocketInitiator(application, fileStoreFactory, sessionSettings, logFactory, messageFactory);
            socketInitiator.start();
            SessionID sessionId = socketInitiator.getSessions().get(0);
            sendLogonRequest(sessionId);
            int i = 0;
            do {
                try {
                    Thread.sleep(1000);
                    System.out.println(socketInitiator.isLoggedOn());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                i++;
            } while ((!socketInitiator.isLoggedOn()) && (i < 30));
        } catch (ConfigError e) {
            e.printStackTrace();
        } catch (SessionNotFound e) {
            e.printStackTrace();
        } catch (Exception exp) {
            exp.printStackTrace();
        } finally {
            if (socketInitiator != null) {
                socketInitiator.stop(true);
            }
        }
    }

    private static void sendLogonRequest(SessionID sessionId)
            throws SessionNotFound {
        Logon logon = new Logon();
        Message.Header header = logon.getHeader();
        header.setField(new BeginString("FIX.4.2"));
        logon.set(new HeartBtInt(30));
        //logon.set(new ResetSeqNumFlag(true));
        boolean sent = Session.sendToTarget(logon, sessionId);
        System.out.println("Logon Message Sent : " + sent);
    }

}
