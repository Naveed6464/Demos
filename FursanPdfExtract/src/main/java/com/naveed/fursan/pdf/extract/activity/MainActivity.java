/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.activity;

import com.saladin.fx.activity.AbstractActivity;
import com.saladin.fx.annotation.Activity;
import com.saladin.fx.navigation.NavigationController;
import com.saladin.fx.navigation.PlaceBuilder;
import javafx.event.ActionEvent;
import javax.inject.Inject;

/**
 *
 * @author naveedur
 */
@Activity(value = "fxml/main")
public class MainActivity extends AbstractActivity {

    @Inject
    private NavigationController navigationController;
    //@Inject
    //AppProperties applicationProperties;

    public void gotoReportExtract(ActionEvent event) {
        navigationController.goTo(new PlaceBuilder("pdfextract").build());
    }    

    public void gotoAdmin(ActionEvent event) {        
        navigationController.goTo(new PlaceBuilder("webview").parameter("linkUrl", "someurl" + "admin.html").build());
    }

    public void gotoSettings(ActionEvent event) {
        navigationController.goTo(new PlaceBuilder("settings").build());
    }
}