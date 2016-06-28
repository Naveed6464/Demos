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
import java.net.URISyntaxException;
import java.net.URL;
import org.apache.avalon.framework.configuration.ConfigurationException;
import org.apache.avalon.framework.configuration.DefaultConfigurationBuilder;
import org.krysalis.barcode4j.BarcodeException;
import org.krysalis.barcode4j.BarcodeGenerator;
import org.krysalis.barcode4j.BarcodeUtil;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.output.eps.EPSCanvasProvider;
import org.krysalis.barcode4j.output.svg.SVGCanvasProvider;
import org.xml.sax.SAXException;

/**
 *
 * @author nmrehman
 */
public class BarcodeFromXML {

    public void createBarCode(String outputFilePath, String msg) throws SAXException, IOException, ConfigurationException, BarcodeException {
        DefaultConfigurationBuilder builder = new DefaultConfigurationBuilder();
        //URL url = this.getClass().getResource("barcode-cfg.xml");//new File("C:\\Temp\\barcode-cfg.xml")       
        //String filepath = this.getClass().getResource("").getPath() + "barcode-cfg.xml";
        String filepath = outputFilePath + "datamatrix.xml";
        org.apache.avalon.framework.configuration.Configuration cfg = builder.buildFromFile(new File(filepath));
        BarcodeGenerator gen = BarcodeUtil.getInstance().createBarcodeGenerator(cfg);

        //The CanvasProvider takes the painting instructions and transforms them to the target format. 
        //Depending on the desired output format you need to instantiate a different class. 
        SVGCanvasProvider provider = new SVGCanvasProvider(false, 0);
        gen.generateBarcode(provider, msg);
        org.w3c.dom.DocumentFragment frag = provider.getDOMFragment();
        System.out.println(">>>>>>>>>>>>> ");
        System.out.println(" " + frag.toString());
        System.out.println(">>>>>>>>>>>>> ");

        OutputStream out = new java.io.FileOutputStream(new File(outputFilePath + "output.eps"));

        EPSCanvasProvider epsprovider = new EPSCanvasProvider(out, 0);
        gen.generateBarcode(epsprovider, msg);
        epsprovider.finish();

        out = new java.io.FileOutputStream(new File(outputFilePath + "output.png"));
        BitmapCanvasProvider bitmapProvider = new BitmapCanvasProvider(
                out, "image/x-png", 300, BufferedImage.TYPE_BYTE_GRAY, true, 0);
        gen.generateBarcode(bitmapProvider, msg);
        bitmapProvider.finish();
    }

}
