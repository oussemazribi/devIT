
package com.pidev.Service;

import com.pidev.Test.DataBase;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GeneratePDF {
    public static void main (String[] args){
      try {  
    
    String nom_fichier ="C:\\Users\\HPENVY\\Documents\\NetBeansProjects\\GeneratePDF\\infoBD6.pdf";
    Document doc =  new Document() ;
        PdfWriter.getInstance(doc, new FileOutputStream(nom_fichier));
        doc.open();
        DataBase obJDBConnection = new DataBase();
        Connection connection = obJDBConnection.getConnection();
          PreparedStatement ps = null ;
          ResultSet rs = null ;                
        String sql = "select * from user";
        ps=connection.prepareStatement(sql);
        rs =ps.executeQuery();
        while (rs.next()){
        Paragraph p =new Paragraph(rs.getShort(1)+" "+rs.getString(2)+" "+rs.getString(3)+" "+rs.getString(4)+" "+rs.getString(5)+" "+rs.getString(6)+" "+rs.getString(7)+"  "+rs.getString(8)+"  "+rs.getInt(9)+" "+rs.getString(10)+" "+rs.getString(11)+" "+rs.getString(12)+" ");
        doc.add(p);
        }  
        doc.close();
          System.out.println("finished");
      
      }catch (FileNotFoundException | DocumentException | SQLException e){
          System.out.println ("e");
      }
        }
    }