
package com.pidev.Myapp.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.services.ServiceReclamation;
import com.pidev.Myapp.Entities.Reclamation;
import java.io.IOException;

/**
 *
 * @author BENTEKFA
 */
public class AjoutReclamation extends Form {

    String objet = "";
    String cap = "";
    Resources theme;
    
    public AjoutReclamation(Resources theme) {
        Label TitleLabel = new Label("Veuillez sélectionner le sujet de votre réclamation :");
        setLayout(BoxLayout.y());
        Label SujetLabel = new Label("Sujet: ");
        Container objete = new Container();
        Container Sujets = new Container(BoxLayout.y());
        Button btn1 = new Button("Harcélement");
        Button btn2 = new Button("Violence");
        Button btn3 = new Button("Nudité");
        Button btn4 = new Button("Terrorisme");
        Button btn5 = new Button("Fausse information");
        Button btn6 = new Button("Autre chose");
        btn1.setUIID("ButtonGroupOnly");
        btn2.setUIID("ButtonGroupOnly");
        btn3.setUIID("ButtonGroupOnly");
        btn4.setUIID("ButtonGroupOnly");
        btn5.setUIID("ButtonGroupOnly");
        btn6.setUIID("ButtonGroupOnly");
        objete.setUIID("Sujets");
        objete.addAll(TitleLabel,SujetLabel,btn1, btn2, btn3, btn4, btn5, btn6);
        //objete.add(WEST, SujetLabel);
        //objete.add( Sujets);
        Label DescriptionLabel = new Label ("Description: ");
        TextArea ta1 = new TextArea();
        
        Button SendBtn = new Button("Envoyer");
        Image env=theme.getImage("icons8-send-48.png").scaled(100, 100);
        SendBtn.setIcon(env);

        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                objet = "Harcélement";
            }

        });

        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                objet = "Violence";
            }
        });

        btn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                objet = "Nudité";
            }
        });

        btn4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                objet = "Terrorisme";
            }
        });

        btn5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                objet = "Fausse information";
            }
        });    
        
        Image autre=theme.getImage("icons8-google-web-search-48.png").scaled(100, 100);
        btn6.setIcon(autre);
        btn6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                objet = "Autre chose";
            }
        });

        Label ph = new Label();
        Button photo = new Button("Ajouter image");
        Image addimg=theme.getImage("icons8-add-image-40.png").scaled(100, 100);
        photo.setIcon(addimg);
        photo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openGallery(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String photo = (String) evt.getSource();
                        if (photo != null) {
                            Image im = null;
                            try {
                                im = Image.createImage(photo);
                                ph.setIcon(im.scaled(200, 200));
                                cap = photo;

                            } catch (IOException ex) {
                                System.out.println(ex.getMessage());
                            }
                        }
                    }
                }, TOP);
            }
        });

        SendBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Reclamation r = new Reclamation();
                r.setObjet(objet);
                r.setDescription(ta1.getText());
                r.setPhoto(cap);
                r.setEtat("Non traitée");
                try {
                    ServiceReclamation.getInstance().addReclamation(r);
                } catch (IOException ex) {
                    System.out.println(ex.getMessage());
                }

            }

        });

        getToolbar().addMaterialCommandToLeftBar("Return", FontImage.MATERIAL_ARROW_BACK, e -> new Acceuil(theme).showBack());
        addAll(objete, DescriptionLabel, ta1, photo, ph, SendBtn);

    }
}
