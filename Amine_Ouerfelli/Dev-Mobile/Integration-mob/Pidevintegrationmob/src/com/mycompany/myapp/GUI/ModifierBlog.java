package com.mycompany.myapp.GUI;

import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Blog;
import com.mycompany.myapp.Services.ServiceBlog;
import java.io.IOException;
import javafx.scene.image.ImageView;

public class ModifierBlog extends Form {

    public class ModifierReserv {

        Form f;
        TextField Sujet;
        TextField Contenu;
        Picker dateCreation;
        Button btnMod, btnAnnuler;

        public ModifierReserv(Resources res) {

            f = new Form("Modifier");
            btnMod = new Button("Modifier");
            btnAnnuler = new Button("Annuler");
            Container c1 = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Sujet = new TextField("", "Sujet");
            Contenu = new TextField("", "Contenu");

            dateCreation = new Picker();
            dateCreation.setType(Display.PICKER_TYPE_DATE_AND_TIME);
            ImageView iv = new ImageView();

            SimpleDateFormat sfd = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            System.out.println("+++++++++++++++++" + sfd.format(dateCreation.getValue()));
           

            c1.addAll(Sujet, Contenu, dateCreation);

            f.add(c1);
            f.add(btnMod);
            f.add(btnAnnuler);

            btnMod.addActionListener((e) -> {
                ServiceBlog ser = new ServiceBlog();
                Blog b = new Blog();
                b.setSujet(Sujet.getText());
                b.setConteu(Contenu.getText());
                b.setDateCreation(dateCreation.getDate());

                try {
                    ser.ModifBlog(b);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            });
            btnAnnuler.addActionListener((e) -> {
                Contenu.setText("");
                Sujet.setText("");

            });
            
 addAll(Sujet,Contenu,dateCreation,btnMod,btnAnnuler);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK
                , e->  {
             AfficherListBlog aff = new AfficherListBlog(res);
                aff.getF().show();
             });

        }


    }
}
