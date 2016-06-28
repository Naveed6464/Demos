/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.activity;

import com.saladin.fx.activity.AbstractActivity;
import com.saladin.fx.annotation.Activity;
import com.saladin.fx.navigation.NavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javax.inject.Inject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author naveedur
 */
@Activity(value = "fxml/login2")
public class LoginActivity extends AbstractActivity {

    Logger log = LoggerFactory.getLogger(LoginActivity.class);

    @FXML
    private TextField userName;
    @FXML
    private PasswordField password;
    @FXML
    private Label loginMsgLbl;
    //@Inject
    //UserService userService;
    @Inject
    private NavigationController navigationController;
    //@Inject
    //private ErrorHandler errorHandler;    
    //@Inject
    //AppProperties applicationProperties;    

    @Override
    public void init() {
        loginMsgLbl.setText("");
    }

    public void login(ActionEvent event) {
        if (!userName.getText().equals("")) {
            doLogin();
        } else {
            loginMsgLbl.setText("Invalid User Name or Password");
        }
    }

    public void loginKeyEvent(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            doLogin();
        }
    }

    public void doLogin() {
        loginMsgLbl.setText("");
        /*Task<User> loginTask = new Task<User>() {
         @Override
         protected User call() throws Exception {
         return userService.login(userName.getText(), password.getText());
         }
         @Override
         protected void succeeded() {
         System.out.println("Success");
         }
         };*/

        /*BackgroundTask<User> loginTask = new BackgroundTask<User>() {
         @Override
         protected User call() throws Exception {
         return userService.login(userName.getText(), password.getText());
         }

         @Override
         protected void onSuccess(User user) {
         if ((user != null && user.getUserName() != null) && user.getUserName().equals(userName.getText().trim())) {
         applicationProperties.setUser(user);
         loginMsgLbl.setText("Success " + user.getFirstName());
         navigationController.goTo(new Place("main"));
         } else {
         loginMsgLbl.setText("Invalid User Name or Password");
         }
         }
         };*/
        //new Thread(loginTask).start();
    }
}
