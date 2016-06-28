package com.naveed.fursan.pdf.extract;

import com.google.common.base.Stopwatch;
import com.naveed.fursan.pdf.extract.entities.AgentAnalysis;
import com.naveed.fursan.pdf.extract.entities.PdfDocument;
import com.naveed.fursan.pdf.extract.service.AgentAnalysisService;
import com.naveed.fursan.pdf.extract.service.PdfDocumentService;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author naveedurrahman.com
 */
public class Main {

    final static Logger log = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws IOException {
        PdfExtractor extractor = new PdfExtractor();
        PdfDocumentService documentService = new PdfDocumentService();
        AgentAnalysisService analysisService = new AgentAnalysisService();

        String fileName = "sample.pdf";
        PdfDocument pdfDocument = new PdfDocument(fileName, new Date());
        PdfDocument byFileName = documentService.getByFileName(fileName);
        if (byFileName == null) {
            pdfDocument = documentService.save(pdfDocument);

            final Stopwatch stopwatch = Stopwatch.createStarted();
            List<AgentAnalysis> extracted = extractor.extract(fileName, pdfDocument);
            stopwatch.stop();

            analysisService.save(extracted);

            System.out.println("Total Records : " + extracted.size());
            System.out.println("Elapsed time in Minutes : " + stopwatch.elapsed(TimeUnit.MINUTES)
                    + " Seconds: " + stopwatch.elapsed(TimeUnit.SECONDS) + " Milliseconds: " + stopwatch.elapsed(TimeUnit.MILLISECONDS));

            pdfDocument.updateElapsedTimeAndTotalRecords(stopwatch.elapsed(TimeUnit.MINUTES) + ":" + stopwatch.elapsed(TimeUnit.SECONDS) + ":" + stopwatch.elapsed(TimeUnit.MILLISECONDS), extracted.size());
            documentService.update(pdfDocument);
        } else {
            System.out.println("File Alreday Exist "  + pdfDocument.getExtractedDate());
        }
    }

}
