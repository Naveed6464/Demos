package com.naveed.pdf.demo;

import com.itextpdf.text.io.RandomAccessSourceFactory;
import com.itextpdf.text.pdf.PRTokeniser;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.RandomAccessFileOrArray;
import com.itextpdf.text.pdf.parser.PdfTextExtractor;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author nmrehman
 */
public class ItextDemo {

    public static void main(String[] args) throws IOException {
        PdfReader reader = new PdfReader("sample.pdf");
        int n = reader.getNumberOfPages();
        //System.out.println(PdfTextExtractor.getTextFromPage(reader, 20));
System.out.println("<<<<<<<<<<<<>>>>>>>>>>>>>>> " + n);
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
        System.out.println(" >>> " + linesListAll.size()  + " >> " + linesListAll.get(21).trim().equals("DISTRIBUTION OF TAXES PER ISO CODE"));
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
