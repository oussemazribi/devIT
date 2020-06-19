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
import com.codename1.ui.PickerComponent;
import com.codename1.ui.TextComponent;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.TextModeLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Blog;
import com.mycompany.myapp.Services.ServiceBlog;
import com.mycompany.myapp.Utils.Imageservices;
import java.io.IOException;

/**
 *
 * @author asus
 */
public class AfficheParBlog extends Form    {

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
        
            String s = blog.getPhoto();
            System.out.println("photo"+s);            
           imagemodif = Imageservices.getInstance().getImageProfilFromURL(blog.getPhoto());

            iv.setImage(imagemodif);

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
       btnmodifier.addActionListener((ee) -> {
         ServiceBlog bl = new ServiceBlog();
            try {
                bl.ModifBlog(blog);
            } catch (IOException ex) {
               System.out.println(ex.getMessage());
            }
         System.out.println("Blog modifiée");
         ToastBar.showMessage("Blog modifié avec succès", FontImage.MATERIAL_INFO);
         });
         btnsupprimer.addActionListener((ee) -> {
         ServiceBlog ser = new ServiceBlog();
         ser.DeleteBlog(blog);
         System.out.println("Blog supprimée");
         ToastBar.showMessage("Blog supprimée avec succès", FontImage.MATERIAL_INFO);
        AfficherListBlog aff = new AfficherListBlog(res);
         aff.getF().show();
         });
        
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
