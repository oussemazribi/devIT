/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Services.ServiceReclamation;
import com.mycompany.myapp.Entity.Reclamation;
import static com.mycompany.myapp.GUI.ListeReclamations.rclam;
import com.mycompany.myapp.Utils.Imageservices;

/**
 *
 * @author BENTEKFA
 */
public class Details extends Form {

    Resources theme;
    Form current;

    public Details(Resources theme) {
        setTitle("Détails");
        setLayout(BoxLayout.y());
       // SpanLabel s=new SpanLabel(rclam.toString());
        Container s=new Container(BoxLayout.x());

        Image im=null;
        im=Imageservices.getInstance().getImageAlbumFromURL(rclam.getPhoto());
        Label ph=new Label();
        ph.setIcon(im);
        Container s2=new Container(BoxLayout.y());
        Label ob=new Label(rclam.getObjet());
        Label et=new Label(rclam.getEtat());
        s2.addAll(ob,et);
        s.addAll(ph,s2);
        Label desc=new Label(rclam.getDescription());
        Button tr=new Button("Traiter");
                   tr.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   boolean yes=ServiceReclamation.getInstance().traiterreclamation(rclam);
                   if(yes)
                   {
                       Dialog.show("Info","Reclamation Traitée", "ok",null);
                       revalidate();
                   }
                   else
                   {
                       Dialog.show("Alert","Reclamation non Traitée", "ok",null);
                   }
                }
            });
        Button Delet=new Button("Supprimer");
        Delet.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                  boolean yes=ServiceReclamation.getInstance().Deleterec(rclam);
                   if(yes)
                   {
                       Dialog.show("Info","Reclamation Supprimée", "ok",null);
                       revalidate();
                   }
                   else
                   {
                       Dialog.show("Alert","Reclamation non Supprimée", "ok",null);
                   }
                
         
            }
        });
        addAll(s,desc,tr,Delet);
        getToolbar().addMaterialCommandToLeftBar("Return", FontImage.MATERIAL_ARROW_BACK, e -> new ListeReclamations(theme).showBack());

 
    }
}
