/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;


import com.codename1.components.InfiniteScrollAdapter;
import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Component;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Blog;
import static com.mycompany.myapp.GUI.AfficheParBlog.id;
import com.mycompany.myapp.Services.ServiceBlog;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author HPENVY
 */
public class AfficherListBlog extends Form {

    Form f;
    public AfficherListBlog(Resources res) {

        f = new Form ("",new BoxLayout(BoxLayout.Y_AXIS));
        f.getToolbar().addMaterialCommandToSideMenu("Competition", FontImage.MATERIAL_TRENDING_UP, e -> {

        });
        f.getToolbar().addMaterialCommandToSideMenu("Publication", FontImage.MATERIAL_TRENDING_UP, e -> {
            addnewpost add = new addnewpost(res);
            add.show();
        });
        f.getToolbar().addMaterialCommandToSideMenu("Blog", FontImage.MATERIAL_TRENDING_UP, e -> {
            HomeBlog H = new HomeBlog(res);
            H.show();

        });
        f.getToolbar().addMaterialCommandToSideMenu("Messagerie", FontImage.MATERIAL_TRENDING_UP, e -> {

        });
        f.getToolbar().addMaterialCommandToSideMenu("Reclamation", FontImage.MATERIAL_TRENDING_UP, e -> {
             
        });
        System.out.println("helloooooo");
        ServiceBlog serviceTask = new ServiceBlog();

                  InfiniteScrollAdapter.createInfiniteScroll(f.getContentPane(), () -> { 
        
                      
                      java.util.List<Map<String, Object>> data = serviceTask.getAllBlogs();
                     
        MultiButton[] cmps = new MultiButton[data.size()];
         String lb = "List des Blogs";
            f.add(lb);
        for(int iter = 0 ; iter < cmps.length ; iter++) {
            Map<String, Object> currentListing = data.get(iter);
            if(currentListing == null) { 
                InfiniteScrollAdapter.addMoreComponents(f.getContentPane(), new Component[0], false);
                return;
            }
            String summary = (String)currentListing.get("sujet");
            cmps[iter] = new MultiButton();
            cmps[iter].setTextLine1(summary);
            
           cmps[iter].addActionListener((e) -> {
                 String sujet=String.valueOf(currentListing.get("sujet"));
                 String contenu=String.valueOf(currentListing.get("contenu"));
                 Date date;
                
                    
                try {
                    date = new SimpleDateFormat("yyyy-MM-dd").parse("2020-06-08");
               
                 String photo=String.valueOf(currentListing.get("photo"));
                 Blog ac=new Blog(Math.round(Float.parseFloat(String.valueOf(currentListing.get("id")))), sujet, contenu, date, photo) ;
                AfficheParBlog.blog=ac; 
                AfficheParBlog.id = Math.round(Float.parseFloat(String.valueOf(currentListing.get("id"))));
                AfficheParBlog a = new AfficheParBlog(res);
                a.getF().show();
              
                } catch (ParseException ex) {
                }
               
               
            });  
        }
      
          InfiniteScrollAdapter.addMoreComponents(f.getContentPane(), cmps, false);
    }, true); 
       
       
        f.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> {
             HomeBlog m = new HomeBlog(res);
                m.getCurrent().show();
             });
       
        f.show();
        
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }

}
