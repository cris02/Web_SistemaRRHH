/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bitlab.utilidades;

import com.bitlab.controladores.PlanillaControlador;
import com.bitlab.manejadores.DetallePlanillaManejador;
import com.lowagie.text.BadElementException;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.HeaderFooter;
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
import java.util.Date;
import java.util.GregorianCalendar;
import javax.annotation.ManagedBean;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletContext;

/**
 *
 * @author henry
 */
@Named("reporte")
@SessionScoped
public class Reporte implements Serializable {

    public void preProcessPDF(Object document) throws BadElementException, IOException, DocumentException {
        Document pdf = (Document) document;

        //seta a margin e página, precisa estar antes da abertura do documento, ou seja da linha: pdf.open()
        pdf.setMargins(20f, 20f, 20f, 20f);
        pdf.setPageSize(PageSize.A4);
        pdf.addTitle("Título here brother");
        pdf.addCreationDate();
        pdf.addAuthor("Henry Callejas");
        pdf.addHeader("Encabezado", "A ver");
        pdf.addSubject("Titulo");
        pdf.addTitle("Titulo");
        pdf.getPageNumber();

        pdf.open();

        //aqui pega o contexto para formar a url da imagem
        ServletContext servletContext = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
        String logo = servletContext.getRealPath("") + File.separator + "/dist/assets/img" + File.separator + "logo.png";

        //cria a imagem e passando a url
        Image image = Image.getInstance(logo);
        
        image.scalePercent(10);
        image.setAbsolutePosition(0, PageSize.A4.getHeight() - image.getScaledHeight());

        //alinha ao centro
        image.setAlignment(Image.ALIGN_CENTER);
        

        //adciona a img ao pdf
        pdf.add(image);

        Font fuente = new Font();
        fuente.setSize(20);
        //adiciona um paragrafo ao pdf, alinha também ao centro
        Paragraph p1 = new Paragraph(" ", fuente);
        p1.setExtraParagraphSpace(10);
        Paragraph p = new Paragraph("Planilla de Pagos Bitlab", fuente);
        Paragraph p2 = new Paragraph(" ", fuente);
        p.setFont(new Font(Font.BOLD));
//        p.setExtraParagraphSpace(40);
        p.setAlignment(1);
        p.setSpacingBefore(50);
//        p.setAlignment("center");
        pdf.add(p1);
        pdf.add(p);
        pdf.add(p2);
        
        Paragraph abajo = new Paragraph("Persona encargada: Henry Callejas");
        abajo.setSpacingAfter(10f);
        pdf.add(abajo);
        
        
        Calendar greg = new GregorianCalendar();
        String dia = Integer.toString(greg.get(Calendar.DAY_OF_MONTH));
        String mes = Integer.toString(greg.get(Calendar.MONTH) +1);
        String ano = Integer.toString(greg.get(Calendar.YEAR));
        greg.get(Calendar.HOUR);
        
//        String fechaGenerada = fecha.getDay() +"/" + fecha.getMonth() + "/" +fecha.getYear() + " " + fecha.getHours() + ":" +fecha.getMinutes() + ":" +fecha.getSeconds();
        String fechaGenerada = "Reporte generado: " + dia + "/" + mes + "/" + ano + " - " + greg.get(Calendar.HOUR) + ":" +greg.get(Calendar.MINUTE) + ":" + greg.get(Calendar.SECOND);
        Paragraph fecha1 = new Paragraph();
        
        fecha1.add(fechaGenerada);
        fecha1.setSpacingAfter(20f);
        pdf.add(fecha1);
        
        
        PdfPTable tabla = new PdfPTable(3);
        Font colorBlanco = new Font();
        colorBlanco.setColor(Color.white);
        PdfPCell cell = new PdfPCell(new Phrase("some clever text", colorBlanco)); 
        cell.setHorizontalAlignment(1);
        Color myColor = WebColors.getRGBColor("#5a01b7"); 
        cell.setBackgroundColor(myColor); 
        tabla.addCell(cell);
        pdf.add(tabla);

    }
}
