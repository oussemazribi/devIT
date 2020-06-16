/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Myapp.GUI;

import com.codename1.components.MultiButton;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ServiceReclamation;
import com.pidev.Myapp.Entities.Reclamation;
import com.pidev.Myapp.Utils.imageservices;

/**
 *
 * @author BENTEKFA
 */
public class ListeReclamations extends Form {
    Resources theme;
    Form current;
    static Reclamation rclam;
    public ListeReclamations(Resources theme) {
        setTitle("Liste");
        setLayout(BoxLayout.y());
        setUIID("Form");
        if (ServiceReclamation.getInstance().getAllReclamations() != null) {
            for(Reclamation r :ServiceReclamation.getInstance().getAllReclamations())
            { /*  System.out.println(r);
                Container all=new Container(BoxLayout.y()); /* setbg*/
               // all.setUIID("Form");
              
               
                  Image capt=null;
                if(r.getPhoto()!=null)
              
                capt=imageservices.getInstance().getImageAlbumFromURL(r.getPhoto());
                MultiButton mb=new MultiButton();
                 mb.setIcon(capt);
                 mb.setTextLine1(r.getObjet());
                 mb.setTextLine2(r.getEtat());
                 mb.setTextLine3(r.getDescription());
                 
                /*Label photo=new Label();
                //photo.setIcon(cap);
                Label text=new Label();
                text.setText(r.getEtat());
                Label desc=new Label();
                desc.setText(r.getDescription());*/
                //****/
                Container buttons=new Container(BoxLayout.x());
                Button tr=new Button();
                Button Delet=new Button();
                Button Detail=new Button("Détails");
                buttons.addAll(Detail);
                Detail.addActionListener(new ActionListener() {
                      @Override
                      public void actionPerformed(ActionEvent evt) {
                          rclam=r;
                          new Details(theme).show();
                      }
                  });
     
         
                Image im=theme.getImage("icons8-button-50.png").scaled(100, 100);
                tr.setIcon(im);/***pour les buttons et les Label on utilise setIcon(parametre) :fonction prdefinie qui prend pour parametres un argument de type IMage dans le cas d'un theme on utilise la fct :theme.getImage(nom d image dans le fichier .res)**/
                 /*Delet.setIcon();*/
                SwipeableContainer swipe=new SwipeableContainer(buttons,mb);
                add(swipe);
                
            }
        }
                getToolbar().addMaterialCommandToLeftBar("Return", FontImage.MATERIAL_ARROW_BACK, e -> new Acceuil(theme).showBack());


    }
}
