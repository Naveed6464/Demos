package com.naveed.demo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.controlsfx.dialog.Dialogs;
import org.kordamp.bootstrapfx.scene.layout.Panel;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        /*Button btn = new Button();
         btn.setText("Say 'Hello World'");
         btn.setOnAction(new EventHandler<ActionEvent>() {

         @Override
         public void handle(ActionEvent event) {
         System.out.println("Hello World!");
         }
         });
         StackPane root = new StackPane();
         root.getChildren().add(btn);
         Scene scene = new Scene(root, 300, 250);
         primaryStage.setTitle("Hello World!");
         primaryStage.setScene(scene);
         primaryStage.show();*/

        Panel panel = new Panel("Remittance Property File Password Encryption");
        panel.getStyleClass().add("panel-primary");
        BorderPane content = new BorderPane();
        content.setPadding(new Insets(20));

        Label label1 = new Label("Password:");
        final TextField passwordTF = new TextField();
        HBox hb = new HBox();
        hb.getChildren().addAll(label1, passwordTF);
        hb.setSpacing(10);

        Label label2 = new Label("Encrypted:");
        final TextField encryptedTF = new TextField();
        HBox hb2 = new HBox();
        hb2.getChildren().addAll(label2, encryptedTF);
        hb2.setSpacing(10);

        Button button = new Button("Encrypt");
        button.getStyleClass().setAll("btn", "btn-info");

        button.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                if (passwordTF.getText().isEmpty()) {
                    /*Alert alert = new Alert(AlertType.WARNING);
                     alert.setTitle("Warning Dialog");
                     alert.setHeaderText("Look, a Warning Dialog");
                     alert.setContentText("Careful with the next step!");
                     alert.showAndWait();*/
                    Dialogs.create()
                            .title("Remittance!")
                            //.masthead("I can have an optional masthead too")
                            .message("Password should not be empty!")
                            .showWarning();
                } else {

                }
            }
        });

        VBox vbox = new VBox();
        vbox.setPadding(new Insets(15, 12, 15, 12));
        vbox.setSpacing(10);
        vbox.getChildren().addAll(hb, hb2, button);

        content.setCenter(vbox);
        panel.setBody(content);

        Scene scene = new Scene(panel);
        scene.getStylesheets().add("bootstrapfx.css");

        primaryStage.setTitle("Remittance");
        primaryStage.setScene(scene);
        primaryStage.sizeToScene();
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
}
