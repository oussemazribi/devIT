/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;


import com.codename1.capture.Capture;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;

import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.util.ImageIO;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Blog;
import com.mycompany.myapp.Services.ServiceBlog;
import java.io.IOException;
import java.io.OutputStream;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author HPENVY
 */
public class AjoutBlog extends Form {
    Form current;
    Resources theme;
    Picker TripDate = new Picker();
    Button photo = new Button("Ajouter image");
    String cap ="";
    Label ph = new Label();

    public AjoutBlog(Resources res) {
        setTitle("Ajout d'un nouveau Blog");
        setLayout(BoxLayout.y());
        TextField tfSujet = new TextField("", "sujet du Blog");
        TextField tfcontenu = new TextField("", "Contenu du blog");
        photo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openGallery(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                       String photo1 = (String) evt.getSource();
                          String filePath = Capture.capturePhoto();
           if (filePath != null) {
               try {
                   photo1 = FileSystemStorage.getInstance().getAppHomePath() +  ".png";
                   
                   Image img = Image.createImage(filePath);
                   OutputStream os = FileSystemStorage.getInstance().openOutputStream(photo1);
                   ImageIO.getImageIO().save(img, os, ImageIO.FORMAT_JPEG, 0.9f);
                   os.close();
               }
               catch (Exception e) {
                   e.printStackTrace();
               }
           }
                        System.out.println(" helllo "+photo1); 
                       if (photo1 != null) {
                          Image im = null;
                              try {
                           im = Image.createImage(photo1);
                            } catch (IOException ex) {
                               
                            }
                            ph.setIcon(im.scaled(200, 200));
                            cap = photo1;
                        }
                    }
                }, TOP);
            }
        });

        Button btnValider = new Button("Ajouter Blog");

        btnValider.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfSujet.getText().length() == 0) || (tfcontenu.getText().length() == 0)) {
                    Dialog.show("Error","les champs sujet et contenue sont vides", "ok","Cancel");
                        
                } else {
                    try {
                        System.out.println("cap "+cap);
                        Blog b = new Blog(tfSujet.getText(), tfcontenu.getText(), TripDate.getDate(),cap);
                        
                        System.out.println("hello world");
                         Dialog.show("Confirmation","Voulez-vous accepter l'ajout de ce blog ", "ok","Cancel"); 
                        if (ServiceBlog.getInstance().AjoutBlog(b)) 
                       {
                            
                           new AfficherListBlog(res);
                           
                           
                           
                        } else {
                            Dialog.show("Error","Blog non accepté", "ok",null);                      
                        }
                    } catch (NumberFormatException e) {   
                    } catch (IOException ex) {
                    
                    }
                }
            }
        });
 addAll(tfSujet,tfcontenu,TripDate,photo,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e->  {
             HomeBlog m = new HomeBlog(res);
                m.getCurrent().show();
             }); // Revenir vers l'interface précédente
    }

}
