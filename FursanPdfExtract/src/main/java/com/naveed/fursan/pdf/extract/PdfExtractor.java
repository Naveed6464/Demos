/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract;

import com.naveed.fursan.pdf.extract.entities.AgentAnalysis;
import com.google.common.base.Joiner;
import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.naveed.fursan.pdf.extract.entities.PdfDocument;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;
import org.beanio.BeanReader;
import org.beanio.StreamFactory;
import org.beanio.builder.StreamBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author nmrehman
 */
public class PdfExtractor {

    final static Logger log = LoggerFactory.getLogger(PdfExtractor.class);

    StreamFactory factory = StreamFactory.newInstance();
    List<AgentAnalysis> list = new ArrayList<>();

    public PdfExtractor() {
        StreamBuilder builder = new StreamBuilder("agent")
                .format("fixedlength")
                .addRecord(AgentAnalysis.class);
        factory.define(builder);
    }

    public List<AgentAnalysis> extract(String filename, PdfDocument pdfDocument) throws IOException {
        PdfReader reader = new PdfReader(filename);
        int n = reader.getNumberOfPages();
        try {
            for (int page = 1; page <= n; page++) {
                byte[] streamBytes = reader.getPageContent(page);
                PRTokeniser tokenizer = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(streamBytes)));
                List<String> linesListAll = new ArrayList<>();
                while (tokenizer.nextToken()) {
                    if (tokenizer.getTokenType() == PRTokeniser.TokenType.STRING) {
                        String line = tokenizer.getStringValue();
                        if (!line.trim().startsWith("TOT") && !line.trim().startsWith("......") && !line.trim().startsWith("------") && !line.trim().isEmpty()) {
                            linesListAll.add(tokenizer.getStringValue());
                        }
                    }
                }
                String[] split = linesListAll.get(4).split("\\|");
                if (split.length < 3) {
                    //continue;
                } else if (!split[2].trim().equals("AGENT BILLING ANALYSIS")) {
                    //continue;
                } else if (linesListAll.size() > 21 && linesListAll.get(21).trim().equals("DISTRIBUTION OF TAXES PER ISO CODE")) {
                    //continue;
                } else {
                    //List<String> linesList = new ArrayList<>();
                    for (int i = 23; i < linesListAll.size() - 1; i = i + 2) {
                        int count = i + 1;
                        //linesList.add(linesListAll.get(i) + linesListAll.get(count));
                        String line = linesListAll.get(i) + linesListAll.get(count);
                        mapData(line, page, pdfDocument);
                    }
                    //mapData(linesList, page, pdfDocument);
                }
            }
        } catch (Exception e) {
            log.error("Exception >> " + e);
        }
        return list;
    }

    public void mapData(String line, int pageNo, PdfDocument pdfDocument) {
        try {
            //StringReader reader = new StringReader(line);
            BeanReader in = factory.createReader("agent", new StringReader(line));
            AgentAnalysis agent_analysis = (AgentAnalysis) in.read();
            if (agent_analysis.getAir().trim().isEmpty() && agent_analysis.getCurr().trim().isEmpty()) {
                AgentAnalysis last = list.get(list.size() - 1);
                last.append(agent_analysis);
            } else {
                agent_analysis.setPageNoAndPdfDoc(pageNo, pdfDocument);
                list.add(agent_analysis);
            }
            in.close();
        } catch (Exception ex) {
            log.error("Exception-BeanIO " + ex);
            log.info(pageNo + " - Line: " + line);
        }
    }

    public void mapData(List<String> linesList, int pageNo, PdfDocument pdfDocument) {
        StringBuilder str = new StringBuilder();
        for (String line : linesList) {
            str.append(line).append("\n");
        }
        try {
            StringReader reader = new StringReader(str.toString());
            BeanReader in = factory.createReader("agent", reader);
            AgentAnalysis agent_analysis;
            while ((agent_analysis = (AgentAnalysis) in.read()) != null) {
                if (agent_analysis.getAir().trim().isEmpty() && agent_analysis.getCurr().trim().isEmpty()) {
                    AgentAnalysis last = list.get(list.size() - 1);
                    last.append(agent_analysis);
                } else {
                    agent_analysis.setPageNoAndPdfDoc(pageNo, pdfDocument);
                    list.add(agent_analysis);
                }
            }
            in.close();
        } catch (Exception ex) {
            log.error("Exception-BeanIO " + ex);
            log.info(pageNo + " - Line: " + Joiner.on("***").join(linesList));
        }
    }

    public void demo() throws IOException {
        PdfReader reader = new PdfReader("sample.pdf");
        int n = reader.getNumberOfPages();
        byte[] streamBytes = reader.getPageContent(455);
        PRTokeniser tokenizer = new PRTokeniser(new RandomAccessFileOrArray(new RandomAccessSourceFactory().createSource(streamBytes)));

        List<String> linesListAll = new ArrayList<>();

        int c = 0;
        while (tokenizer.nextToken()) {
            if (tokenizer.getTokenType() == PRTokeniser.TokenType.STRING) {
                //System.out.println(">> " + c++ + tokenizer.getStringValue());
                String line = tokenizer.getStringValue();
                if (!line.startsWith("TOT") && !line.trim().startsWith(".........") && !line.trim().isEmpty()) {
                    linesListAll.add(tokenizer.getStringValue());
                }
            }
        }
        String[] split = linesListAll.get(4).split("\\|");

        System.out.println(" " + split[2].trim().equals("AGENT BILLING ANALYSIS"));
        List<String> linesList = new ArrayList<>();

        System.out.println(">>>>>>>>>> " + linesListAll.get(21).trim());
        System.out.println(" >>> " + linesListAll.size() + " >> " + linesListAll.get(21).trim().equals("DISTRIBUTION OF TAXES PER ISO CODE"));
        System.out.println(">>>>>>>>>> Size " + linesListAll.size());

        for (int i = 23; i < linesListAll.size() - 1; i = i + 2) {
            int count = i + 1;
            linesList.add(linesListAll.get(i) + linesListAll.get(count));
        }

        for (String line : linesList) {
            System.out.println("" + line);
        }
    }

}
