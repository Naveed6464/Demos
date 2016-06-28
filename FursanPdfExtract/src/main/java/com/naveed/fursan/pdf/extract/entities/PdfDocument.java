/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.fursan.pdf.extract.entities;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author nmrehman
 */
@Entity
public class PdfDocument extends AbstractEntity {

    private String fileName;
    @Temporal(TemporalType.TIMESTAMP)
    private Date extractedDate;
    private int totalRecords;
    private String elapsedTime;

    public PdfDocument() {
    }

    public PdfDocument(String fileName, Date extractedDate) {
        this.fileName = fileName;
        this.extractedDate = extractedDate;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Date getExtractedDate() {
        return extractedDate;
    }

    public void setExtractedDate(Date extractedDate) {
        this.extractedDate = extractedDate;
    }

    public void setElapsedTime(String elapsedTime) {
        this.elapsedTime = elapsedTime;
    }

    public String getElapsedTime() {
        return elapsedTime;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void updateElapsedTimeAndTotalRecords(String elapsedTime, int totalRecords) {
        this.elapsedTime = elapsedTime;
        this.totalRecords = totalRecords;
    }
}
