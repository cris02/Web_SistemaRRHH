/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.html.WebColors;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import java.awt.Color;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
/**
 *
 * @author henry
 */
@Named("reporte")
@SessionScoped
public class Reporte implements Serializable {
    public void preProcessPDF(Object document) throws BadElementException, IOException, DocumentException {
        //Instancia de la clase Document
        Document pdf = (Document) document;
        //Configura un margen de pagina, y por ultimo se necesita abrir el documento con pdf.open
        pdf.setMargins(10f, 10f, 10f, 10f);
        pdf.setPageSize(PageSize.A4.rotate());
        pdf.addTitle("Título here brother");
        pdf.addCreationDate();
        pdf.addAuthor("Henry Callejas");
        pdf.addHeader("Encabezado", "A ver");
        pdf.addSubject("Titulo");
        pdf.addTitle("Titulo");
        pdf.getPageNumber();
        pdf.open();
        //Obtengo el contexto para crear la imagen dentro del documento
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "/dist/assets/img" + File.separator + "logo.png";
        //Creo la imagen pasando como parametro el path de la imagen
        Image image = Image.getInstance(logo);
//        Escalo la imagen
        image.scalePercent(12, 8.7f);
        image.setAbsolutePosition(0, PageSize.A4.rotate().getHeight() - image.getScaledHeight());
        //Alineacion al centro
        image.setAlignment(Image.ALIGN_CENTER);
        //Agrego la imagen al documento pdf
        pdf.add(image);
        //Creo una fuente y le configuro un tamano de texto
        Font fuente = new Font();
        fuente.setSize(20);
        //Agrego un parrafo al pdf y lo alineo al centro
        Paragraph p1 = new Paragraph("Planilla de Pagos Bitlab", fuente);
        p1.setFont(new Font(Font.BOLD));
        p1.setAlignment(1);
        p1.setSpacingBefore(100);
        pdf.add(p1);
        Paragraph abajo = new Paragraph("Persona encargada: Mario Lopez");
        abajo.setAlignment(1);
        abajo.setSpacingBefore(20);
        abajo.setSpacingAfter(10f);
        pdf.add(abajo);
        //Configuracion de fecha de creacion de cada documento a la fecha actual
        Calendar greg = new GregorianCalendar();
        String dia = Integer.toString(greg.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(greg.get(Calendar.MONTH) + 1);
        String ano = Integer.toString(greg.get(Calendar.YEAR));
        String hora = Integer.toString(greg.get(Calendar.HOUR));
        String minutos = Integer.toString(greg.get(Calendar.MINUTE));
        String segundos = Integer.toString(greg.get(Calendar.SECOND));
        if(Integer.valueOf(dia) >=1 && Integer.valueOf(dia)<=9){
            dia = "0" +dia;
        }else if(Integer.valueOf(mes) >=1 && Integer.valueOf(mes)<=9){
            mes = "0" +mes;
        }else if(Integer.valueOf(hora) >=0 && Integer.valueOf(hora)<=9){
            hora = "0"+ hora;
        }else if(Integer.valueOf(minutos) >=0 && Integer.valueOf(minutos)<=9){
            minutos = "0" +minutos;
        }else if(Integer.valueOf(segundos) >=0 && Integer.valueOf(segundos)<=9){
            segundos = "0" +segundos;
        }
        String fechaGenerada = "Reporte generado: " + dia + "/" + mes + "/" + ano + " - " + hora + ":" + minutos + ":" + segundos;
        Paragraph fecha1 = new Paragraph();
        fecha1.setAlignment(1);
        fecha1.add(fechaGenerada);
        fecha1.setSpacingAfter(20f);
        pdf.add(fecha1);
        Font colorBlanco = new Font();
        colorBlanco.setColor(Color.white);
        Color colorAzul = WebColors.getRGBColor("#116FBF");
        //Creacion de una tabla
        PdfPTable tabla2 = new PdfPTable(8);
        PdfPCell cell1 = new PdfPCell(new Phrase("", colorBlanco));
        PdfPCell cell2 = new PdfPCell(new Phrase("Descuentos", colorBlanco));
        PdfPCell cell3 = new PdfPCell(new Phrase("", colorBlanco));
        PdfPCell cell4 = new PdfPCell(new Phrase("", colorBlanco));
        PdfPCell cell5 = new PdfPCell(new Phrase("", colorBlanco));
        PdfPCell cell6 = new PdfPCell(new Phrase("", colorBlanco));
        PdfPCell cell7 = new PdfPCell(new Phrase("", colorBlanco));
        PdfPCell cell8 = new PdfPCell(new Phrase("", colorBlanco));
        cell2.setBackgroundColor(colorAzul);
        cell2.setColspan(3);
        cell2.setPaddingLeft(90);
        cell1.setColspan(4);
        cell1.setBackgroundColor(colorAzul);
        cell3.setBackgroundColor(colorAzul);
        tabla2.addCell(cell1);
        tabla2.addCell(cell2);
        tabla2.addCell(cell3);
        tabla2.addCell(cell4);
        tabla2.addCell(cell5);
        tabla2.addCell(cell6);
        tabla2.addCell(cell7);
        tabla2.addCell(cell8);
        pdf.add(tabla2);
    }
    //Metodo para procesar documento XLS
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        CellStyle style = wb.createCellStyle();
        style.setFillBackgroundColor(IndexedColors.AQUA.getIndex());
        for (org.apache.poi.ss.usermodel.Row row : sheet) {
            for (org.apache.poi.ss.usermodel.Cell cell : row) {
                cell.setCellValue(cell.getStringCellValue().toUpperCase());
                cell.setCellStyle(style);
            }
        }
    }
}