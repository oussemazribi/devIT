/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TGT.myapp.gui;

import com.TGT.myapp.entities.Blog;
import com.codename1.ui.Button;

import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.TGT.myapp.services.ServiceBlog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import java.io.IOException;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

/**
 *
 * @author HPENVY
 */
public class AjoutBlog extends Form {

    Picker TripDate = new Picker();
    Button photo = new Button("Ajouter image");
    String cap ="";
    Label ph = new Label();

    public AjoutBlog(Form previous) {
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
                   Alert alert=new Alert(Alert.AlertType.ERROR, "les champs sujet et contenue sont vides", ButtonType.CLOSE);
                        
                } else {
                    try {
                        Blog b = new Blog(tfSujet.getText(), tfcontenu.getText(), TripDate.getDate());
                        b.setPhoto(cap);
                        if (ServiceBlog.getInstance().AjoutBlog(b)) 
                       {
                            Alert alert=new Alert(Alert.AlertType.CONFIRMATION, "Connexion accepté", ButtonType.OK);                     
                        } else {
                            Alert alert=new Alert(Alert.AlertType.ERROR, "Server error", ButtonType.CLOSE);                      
                        }
                    } catch (NumberFormatException e) {   
                    } catch (IOException ex) {
                        
                    }

                }

            }
        });
 addAll(tfSujet,tfcontenu,TripDate,photo,btnValider);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e-> previous.showBack()); // Revenir vers l'interface précédente
    }
}
