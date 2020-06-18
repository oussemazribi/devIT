/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.capture.Capture;
import com.codename1.io.FileSystemStorage;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import com.codename1.ui.util.Resources;
import java.io.IOException;


/**
 *
 * @author asus
 */
public class addmedia extends Form {
    Form current;
    Resources theme;
    public addmedia(Resources theme)
    {   setUIID("postbody");
        setTitle("Addmedia");
        setLayout(new BorderLayout());
        getToolbar().addCommandToLeftBar("hella", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               new addnewpost(theme).show();
            }
        });
        /*******************************/
        Container inside=new Container();
        Container Button=new Container();
        Button capture=new Button("Got it");
        capture.setIcon(theme.getImage("camera.png"));
        Label cadre=new Label();
        inside.add(cadre);
        Button.add(capture);
        Container bottom=new Container(new BorderLayout());
        bottom.add(CENTER,Button);
        add(CENTER,inside);
        add(SOUTH,bottom);
        capture.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             String cheminimage=Capture.capturePhoto();
             if(cheminimage!=null)
             {
                 Image photo=null;
                 try {
                     photo=Image.createImage(cheminimage);
                    
                 } catch (IOException ex) {
                   Dialog.show("Erreur!", ex.getMessage(), "OK", null);
                 }
                 cadre.setIcon(photo.scaled(1225,2436));
                 revalidate();
             }
           
            }
        });
        
        
        
        
        
        
        
    }
    
}
