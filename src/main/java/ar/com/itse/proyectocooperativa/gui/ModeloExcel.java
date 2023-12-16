package ar.com.itse.proyectocooperativa.gui;

import org.apache.poi.ss.usermodel.*;
import java.io.File;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.ListAutoNumber;
import java.io.FileOutputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ModeloExcel {

    Workbook wb;

    public String Exportar(File archivo, JTable tablaD) {
        String respuesta = "No se realizo la exportacion";

        int numFila = tablaD.getRowCount(), numColumna = tablaD.getColumnCount();
        if (archivo.getName().endsWith("xls")) {
            wb = new HSSFWorkbook();
        } else {
            wb = new XSSFWorkbook();
        }
        Sheet hoja = wb.createSheet("Prueba");
        try {
            for (int i = -1; i < numFila; i++) {
                Row fila = hoja.createRow(i + 1);
                for (int j = 0; j < numColumna; j++) {
                    Cell celda = fila.createCell(j); // Fix index here
                    if (i == -1) {
                        celda.setCellValue(String.valueOf(tablaD.getColumnName(j)));
                    } else {
                        celda.setCellValue(String.valueOf(tablaD.getValueAt(i, j)));
                    }
                }
            }

            wb.write(new FileOutputStream(archivo));

            respuesta = "Exportacion exitosa";
        } catch (Exception e) {
            // Handle exceptions
        }

        return respuesta;
    } // fin exportar
}
