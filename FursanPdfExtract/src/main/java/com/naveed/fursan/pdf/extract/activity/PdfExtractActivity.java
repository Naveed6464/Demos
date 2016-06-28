/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.activity;

import com.google.common.base.Stopwatch;
import com.naveed.fursan.pdf.extract.PdfExtractor;
import com.naveed.fursan.pdf.extract.config.AppProperties;
import com.naveed.fursan.pdf.extract.entities.AgentAnalysis;
import com.naveed.fursan.pdf.extract.entities.PdfDocument;
import com.naveed.fursan.pdf.extract.service.AgentAnalysisService;
import com.naveed.fursan.pdf.extract.service.PdfDocumentService;
import com.naveed.fursan.pdf.extract.utils.UIUtils;
import com.saladin.fx.activity.AbstractActivity;
import com.saladin.fx.annotation.Activity;
import com.saladin.fx.navigation.NavigationController;
import com.saladin.fx.task.BackgroundTask;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javax.inject.Inject;

/**
 *
 * @author naveedur
 */
@Activity(value = "fxml/extract")
public class PdfExtractActivity extends AbstractActivity {

    @Inject
    private NavigationController navigationController;
    //@Inject
    AppProperties applicationProperties = AppProperties.getInstance();
    @Inject
    UIUtils uiUtils;
    
    @Inject
    PdfExtractor extractor;
    @Inject
    PdfDocumentService documentService;
    @Inject
    AgentAnalysisService analysisService;

    @FXML
    TextField pdfdocumentFilePath;
    
    //@FXML
    //ComboBox<String> replayBrowserCmbBox;
    //final ObservableList<String> replayBrowserList = FXCollections.observableArrayList();
    /**
     * Activation Code
     */
    @Override
    public void init() {

    }

    public void save(ActionEvent event) {
        final String fileName = pdfdocumentFilePath.getText();
        final PdfDocument pdf = new PdfDocument(fileName, new Date());
        final PdfDocument pdfDocument = documentService.save(pdf);
        final Stopwatch stopwatch = Stopwatch.createStarted();
        final BackgroundTask<Integer> task = new BackgroundTask<Integer>() {
            @Override
            protected Integer call() throws Exception {
                List<AgentAnalysis> extracted = extractor.extract(fileName, pdfDocument);
                analysisService.save(extracted);
                return extracted.size();
            }

            @Override
            protected void onSuccess(Integer totalRecords) {
                stopwatch.stop();
                pdfDocument.updateElapsedTimeAndTotalRecords(stopwatch.elapsed(TimeUnit.MINUTES) + ":" + stopwatch.elapsed(TimeUnit.SECONDS) + ":" + stopwatch.elapsed(TimeUnit.MILLISECONDS), totalRecords);
                documentService.update(pdfDocument);
                uiUtils.showDialog("Settings saved Successfully.");
            }
        };
        new Thread(task).start();

    }

    public void back(ActionEvent event) {
        navigationController.goBack();
    }
}
