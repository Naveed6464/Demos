/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.naveed.barcode.demo;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.krysalis.barcode4j.BarcodeException;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.xml.sax.SAXException;

/**
 *
 * @author nmrehman
 */
public class DataMatrixDemo {

    public void createDataMatrixBarCode(String outFilePath, String msg) throws IOException, ConfigurationException, SAXException, BarcodeException {
        DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();        
        String filepath = outFilePath + "datamatrix.xml";
        org.apache.avalon.framework.configuration.Configuration cfg = builder.buildFromFile(new File(filepath));
        BarcodeGenerator gen = BarcodeUtil.getInstance().createBarcodeGenerator(cfg);

        OutputStream out = new java.io.FileOutputStream(new File(outFilePath + "outdatamatrix2.png"));
        BitmapCanvasProvider bitmapProvider = new BitmapCanvasProvider(
                out, "image/x-png", 300, BufferedImage.TYPE_BYTE_GRAY, true, 0);
        gen.generateBarcode(bitmapProvider, msg);
        bitmapProvider.finish();
    }

}
