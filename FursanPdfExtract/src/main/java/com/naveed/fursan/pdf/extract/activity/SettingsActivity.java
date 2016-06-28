/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.activity;

import com.naveed.fursan.pdf.extract.config.AppProperties;
import com.naveed.fursan.pdf.extract.utils.UIUtils;
import com.saladin.fx.activity.AbstractActivity;
import com.saladin.fx.annotation.Activity;
import com.saladin.fx.navigation.NavigationController;
import com.saladin.fx.task.BackgroundTask;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.inject.Inject;

/**
 *
 * @author naveedur
 */
@Activity(value = "fxml/settings")
public class SettingsActivity extends AbstractActivity {

    @Inject
    private NavigationController navigationController;
    //@Inject
    AppProperties applicationProperties = AppProperties.getInstance();
    @Inject
    UIUtils uiUtils;
    @FXML
    TextField jdbcDriver;
    @FXML
    TextField jdbcUrl;
    @FXML
    TextField jdbcUser;
    @FXML
    PasswordField jdbcPassword;
    //@FXML
    //ComboBox<String> replayBrowserCmbBox;
    //final ObservableList<String> replayBrowserList = FXCollections.observableArrayList();

    /**
     * Activation Code
     */
    @Override
    public void init() {
        //replayBrowserList.setAll("Mozila Firefox", "Google Chrome", "Internet Explorer");
        //replayBrowserCmbBox.setItems(replayBrowserList);
        jdbcDriver.setText(applicationProperties.getJdbcDriver());
        jdbcUrl.setText(applicationProperties.getJdbcUrl());
        jdbcUrl.setText(applicationProperties.getJdbcUrl());
        jdbcPassword.setText(applicationProperties.getJdbcPassword());
    }

    public void save(ActionEvent event) {
        final BackgroundTask<Void> task = new BackgroundTask<Void>() {
            @Override
            protected Void call() throws Exception {
                applicationProperties.saveProperties(jdbcDriver.getText(), jdbcUrl.getText(), jdbcUser.getText(), jdbcPassword.getText());
                return null;
            }

            @Override
            protected void onSuccess(Void value) {
                uiUtils.showDialog("Settings saved Successfully.");
            }
        };
        new Thread(task).start();
    }

    public void back(ActionEvent event) {
        navigationController.goBack();
    }
}
