/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.activity;

import com.saladin.fx.activity.AbstractActivity;
import com.saladin.fx.annotation.Activity;
import com.saladin.fx.annotation.Param;
import com.saladin.fx.navigation.NavigationController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.web.WebView;
import javax.inject.Inject;

/**
 *
 * @author naveedur
 */
@Activity(value = "fxml/webView")
public class WebViewActivity extends AbstractActivity {

    @Inject
    private NavigationController navigationController;
    @FXML
    WebView webView;

    @Param
    private String linkUrl;

    @Override
    public void onActivated() {        
        webView.getEngine().load(linkUrl);
    }

    public void back(ActionEvent event) {
        navigationController.goBack();
    }
}
