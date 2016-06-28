/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.utils;

import org.controlsfx.control.action.Action;
import org.controlsfx.dialog.Wizard;

/**
 *
 * @author naveed
 */
public class UIUtils {

    public void showDialog(String msg) {
        //Dialogs.create().title("Saladin").message(msg).showInformation();
    }

    public void showDialog(String title, String msg) {
        //Dialogs.create().title(title).message(msg).showInformation();

//        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//        alert.initStyle(StageStyle.UTILITY);
//        alert.setTitle("Information");
//        alert.setHeaderText(title);
//        alert.setContentText(message);
//
//        alert.showAndWait();
    }

    public Action confirmDialog(String msg) {
        //return Dialogs.create().title("Saladin").message(msg).showConfirm();
        return null;
    }

    public Action confirmDialog(String title, String msg) {
        //return Dialogs.create().title(title).message(msg).showConfirm();
        return null;
    }
}
