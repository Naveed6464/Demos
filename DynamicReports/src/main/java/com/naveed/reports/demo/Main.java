package com.naveed.reports.demo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import net.sf.dynamicreports.jasper.builder.JasperReportBuilder;
import net.sf.dynamicreports.report.builder.DynamicReports;
import net.sf.dynamicreports.report.builder.column.Columns;
import net.sf.dynamicreports.report.builder.component.Components;
import net.sf.dynamicreports.report.builder.datatype.DataTypes;
import net.sf.dynamicreports.report.constant.HorizontalAlignment;
import net.sf.dynamicreports.report.exception.DRException;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Connection connection = null;
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:C:/DB/reports", "sa", "");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
            return;
        }
        JasperReportBuilder report = DynamicReports.report();//a new report
        report
                .columns(
                        Columns.column("Customer Id", "id", DataTypes.integerType()),
                        Columns.column("First Name", "first_name", DataTypes.stringType()),
                        Columns.column("Last Name", "last_name", DataTypes.stringType()),
                        Columns.column("Date", "date", DataTypes.dateType()))
                .title(//title of the report
                        Components.text("SimpleReportExample")
                        .setHorizontalAlignment(HorizontalAlignment.CENTER))
                .pageFooter(Components.pageXofY())//show page number on the page footer
                .setDataSource("SELECT id, first_name, last_name, date FROM customers",
                        connection);

        try {
            //show the report
            report.show();
            
            //export the report to a pdf file            
            report.toPdf(new FileOutputStream("C:\\Users\\nmrehman\\Documents\\report.pdf"));
        } catch (DRException | FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
