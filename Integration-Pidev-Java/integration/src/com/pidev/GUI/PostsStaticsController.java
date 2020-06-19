/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Service.ServicePublication;
import com.pidev.Entite.Publication;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;

/**
 * FXML Controller class
 *
 * @author asus
 */
public class PostsStaticsController implements Initializable {

    @FXML
    private BarChart<String,Integer> barchart;
    @FXML
    private CategoryAxis X;
    private ObservableList<String> monthNames = FXCollections.observableArrayList();
    ServicePublication serp=new ServicePublication();
    List l;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        String[] months = DateFormatSymbols.getInstance(Locale.FRENCH).getMonths();
        
        monthNames.addAll(Arrays.asList(months));
         X.setCategories(monthNames);
        try {
            l=serp.readAll();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        setdata(l);
         
         
    }    
    public void setdata(List<Publication> L)
    {
                // Count the number of people having their birthday in a specific month.
        int[] monthCounter = new int[12];
        for (Publication p : L) {
            int month = p.getdate().getMonth() - 1;
            monthCounter[month]++;
        }

        XYChart.Series<String, Integer> series = new XYChart.Series<>();
        
        // Create a XYChart.Data object for each month. Add it to the series.
        for (int i = 0; i < monthCounter.length; i++) {
            series.getData().add(new XYChart.Data<>(monthNames.get(i), monthCounter[i]));
        }
        
        barchart.getData().add(series);
    }
    }

