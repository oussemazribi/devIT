/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.ImageViewer;
import com.codename1.components.ToastBar;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextComponent;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.EAST;
import static com.codename1.ui.layouts.BorderLayout.NORTH;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import static com.codename1.ui.layouts.BorderLayout.WEST;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Blog;
import com.mycompany.myapp.Services.ServiceBlog;
import java.io.IOException;

/**
 *
 * @author asus
 */
public class AfficheParBlog extends Form {

    Form f;
    public static Blog blog;
    public static int id;
    

    public AfficheParBlog(Resources res) {
        ServiceBlog se = new ServiceBlog();
        Button btnmodifier = new Button("Modifier");
        Button btnsupprimer = new Button("Supprimer");
        f = new Form("", new BoxLayout(BoxLayout.Y_AXIS));
        

        TextComponent ttitre1 = new TextComponent().labelAndHint("Sujet");
        FontImage.setMaterialIcon(ttitre1.getField().getHintLabel(), FontImage.MATERIAL_DETAILS);
        ttitre1.text(blog.getSujet());

        TextComponent tdescription1 = new TextComponent().labelAndHint("Contenu");
        FontImage.setMaterialIcon(tdescription1.getField().getHintLabel(), FontImage.MATERIAL_DETAILS);
        tdescription1.text(blog.getConteu());

        PickerComponent datedebut = PickerComponent.createDateTime(null).label("Date de création");
        datedebut.getPicker().setDate(blog.getDateCreation());

        ImageViewer iv = new ImageViewer();
        Image imagemodif;
        try {
            String s = blog.getPhoto();
            System.out.println("photo"+s);
            

            
            imagemodif = URLImage.createImage("file://C://wamp64//www//citeculture//web//images//"+"").scaled(1200, 600);

            iv.setImage(imagemodif);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }

        TextModeLayout tl = new TextModeLayout(2, 2);
        Container comps = new Container(tl);
        comps.add(tl.createConstraint().widthPercentage(60), ttitre1);
        comps.add(tl.createConstraint().horizontalSpan(2), tdescription1);
        comps.add(tl.createConstraint().widthPercentage(30), datedebut);
        comps.add(tl.createConstraint().widthPercentage(30), iv);

        comps.setScrollableY(true);

        f.add(comps);
        f.add(btnmodifier);
        f.add(btnsupprimer);
        f.show();
        /*    btnmodifier.addActionListener((ee) -> {
         ServiceEvent ser = new ServiceEvent();
         ser.modifierActivite(id,ttitre1.getText(), tdescription1.getText(), datedebut.getPicker().getText(), datefin.getPicker().getText(), etat.getPicker().getText());
         System.out.println("Activité modifiée");
         ToastBar.showMessage("Activité modifiée avec succès", FontImage.MATERIAL_INFO);
         });
         btnsupprimer.addActionListener((ee) -> {
         ServiceEvent ser = new ServiceEvent();
         ser.supprimerActivite(id);
         System.out.println("Activité supprimée");
         ToastBar.showMessage("Activité supprimée avec succès", FontImage.MATERIAL_INFO);
         ActiviteAffichageBack a = new ActiviteAffichageBack(res);
         a.getF().show();
         });
         */
        f.getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> {
            AfficherListBlog m = new AfficherListBlog(res);
            m.getF().show();
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
