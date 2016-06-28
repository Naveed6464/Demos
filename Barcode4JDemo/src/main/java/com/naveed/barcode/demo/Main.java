package com.naveed.barcode.demo;

public class Main {

    /**
     * @param args the command line arguments
     * @throws java.lang.Exception
     */
    public static void main(String[] args) throws Exception {
        //BarcodeGeneratorDemo generator = new BarcodeGeneratorDemo();
        //generator.createBarCode39("Mohammed Salahuddin");
        //generator.createBarCode128("Naveedur Rahman");
        //BarcodeFromXML barcodeFromXML = new BarcodeFromXML();
        //barcodeFromXML.createBarCode(barCodePath, "123456789012");
        String barCodePath = "C:\\Users\\nmrehman\\Documents\\barcodeImages\\";
        DataMatrixDemo dataMatrixDemo = new DataMatrixDemo();
        dataMatrixDemo.createDataMatrixBarCode(barCodePath, "Vivek");
    }
}
