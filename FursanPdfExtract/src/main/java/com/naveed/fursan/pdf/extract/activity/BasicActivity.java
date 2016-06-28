/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.activity;

import com.saladin.fx.activity.AbstractActivity;
import com.saladin.fx.navigation.NavigationController;
import javafx.event.ActionEvent;
import javafx.geometry.Rectangle2D;
import javax.inject.Inject;

/**
 *
 * @author naveedur
 */
//@Activity(value = "fxml/somefxml")
public class BasicActivity extends AbstractActivity {

    @Inject
    Rectangle2D rectangle2D;
    @Inject
    private NavigationController navigationController;

    @Override
    public void init() {
        getView().setPrefHeight(rectangle2D.getHeight());
        getView().setPrefWidth(rectangle2D.getWidth());
    }

    @Override
    public void onActivated() {
    }

    public void save(ActionEvent event) {
    }

    public void clear(ActionEvent event) {
    }

    public void back(ActionEvent event) {
        navigationController.goBack();
    }
}
