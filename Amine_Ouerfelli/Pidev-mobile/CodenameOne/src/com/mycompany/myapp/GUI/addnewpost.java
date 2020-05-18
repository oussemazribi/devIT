/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import Sessioncontrol.Session;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.TOP;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.NORTH;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import static com.codename1.ui.layouts.BorderLayout.WEST;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Publication;
import com.mycompany.myapp.Services.PostService;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author asus
 */
public class addnewpost extends Form {

    Form current;
    Resources theme;
    static ArrayList<String> MediaContainer = new ArrayList<>();

    public addnewpost(Resources theme) {
        current = this;
        setTitle("Home");
        setLayout(new BorderLayout());
        setUIID("postbody");
        getToolbar().addCommandToLeftBar(SOUTH, null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Home(theme).show();
            }
        });

        Container entete = new Container(new BorderLayout());
        Container body = new Container(new BorderLayout());
        Container mediaholder = new Container();
        Container Buttom = new Container(BoxLayout.y());
        /**
         * **********entete**********
         */
        Label username = new Label();
        //Image img=
        Label imguser = new Label();
        //imguser.setIcon(img);
        entete.add(WEST, imguser);
        entete.add(CENTER, username);
        /**
         * ***********Body*************
         */
        Container Content = new Container(BoxLayout.y());
        TextField title = new TextField();
        TextArea Contenu = new TextArea();
        body.add(NORTH, title);
        body.add(CENTER, Contenu);
        body.add(SOUTH, mediaholder);
        /**
         * ************Buttom*****************
         */
        Button Addmedia = new Button();
        Addmedia.setIcon(theme.getImage("icons8-dossier-de-photos-60.png"));
        Button Camera = new Button();
        Camera.setIcon(theme.getImage("camera.png"));
        Addmedia.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Display.getInstance().openGallery(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        String media = (String) evt.getSource();
                        if (media != null) {
                            Image img = null;
                            try {
                                System.out.println(evt.getSource().getClass());
                                String what=(String)evt.getSource();
                                img = Image.createImage(media);
                                Container imageetvid = new Container(new BorderLayout());
                                Container butts = new Container(BoxLayout.x());
                                Button supp = new Button();
                                supp.setIcon(theme.getImage("icons8-effacer-50.png"));
                                supp.addActionListener(new ActionListener() {
                                    @Override
                                    public void actionPerformed(ActionEvent evt) {
                                        mediaholder.removeComponent(imageetvid);
                                        MediaContainer.remove(what);
                                        revalidate();
                                    }
                                });
                                Label image = new Label();
                                image.setIcon(img.scaled(200,200));
                                imageetvid.add(CENTER, image);
                                butts.add(supp);
                                imageetvid.add(SOUTH, butts);
                                mediaholder.add(imageetvid);
                                revalidate();
                                MediaContainer.add((String)evt.getSource());
                            } catch (IOException ex) {
                                Dialog.show("Error", "Image not supported", "Ok", null);
                            }

                        }

                    }
                }, TOP);
            }
        });

        Buttom.add(Addmedia);
        Buttom.add(Camera);
        Camera.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new addmedia(theme).show();
            }
        });
        /******************************************/
       getToolbar().addCommandToRightBar("Post",null,new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
             Publication p=new Publication();
             p.setContenu(Contenu.getText());
             p.setTitre(title.getText());
             p.setIdUser(Session.getInstance().getuser());
                try {
                    boolean yes=PostService.getInstance().addPost(p, MediaContainer);
                    if(yes)
                    {
                        Dialog.show("Success","Votre pub est a jour","ok",null);
                    }
                    else
                    {
                        Dialog.show("Error","Post non mis a jour ","OK",null);
                    }
                } catch (IOException ex) {
                    Dialog.show("Success",ex.getMessage(),"ok",null);
                   
                }
             
             
            }
        });
         /***************************************/
        /**
         * ************************************
         */
        add(NORTH, entete);

        add(CENTER, body);

        add(SOUTH, Buttom);

    }
}
