package com.naveed.fursan.pdf.extract;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.naveed.fursan.pdf.extract.config.AppModule;
import com.saladin.fx.SaladinFxModule;
import com.saladin.fx.navigation.NavigationController;
import com.saladin.fx.GuiceFXMLLoader;
import com.saladin.fx.navigation.Place;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.geometry.Rectangle2D;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
//import org.saladinframework.instrument.InstrumentationAgent;

/**
 *
 * @author naveed
 */
public class App extends Application {

    /*static {
     InstrumentationAgent.initialize();
     }*/
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        Injector injector = Guice.createInjector(new AppModule(),
                SaladinFxModule.create("com.naveed.fursan.pdf.extract", "com.naveed.fursan.pdf.extract.services"));
        //Intialize Fxmls
        GuiceFXMLLoader root = injector.getInstance(GuiceFXMLLoader.class);

        NavigationController navigationController = injector.getInstance(NavigationController.class);

        navigationController.goTo(new Place("main"));
        //navigationController.goTo(activity);
        Rectangle2D screenBounds = injector.getInstance(Rectangle2D.class);
        Scene scene = new Scene((Parent) navigationController.getView(), screenBounds.getWidth(), screenBounds.getHeight());
        scene.getStylesheets().add("styles.css");
        stage.setScene(scene);
        stage.setTitle("Fursan Report Extractor");
        stage.show();
    }
}
