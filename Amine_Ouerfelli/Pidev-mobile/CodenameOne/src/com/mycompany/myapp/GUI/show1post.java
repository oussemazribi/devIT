/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import Sessioncontrol.Session;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Slider;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.EAST;
import static com.codename1.ui.layouts.BorderLayout.NORTH;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import static com.codename1.ui.layouts.BorderLayout.WEST;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Medias;
import com.mycompany.myapp.Entity.Publication;
import com.mycompany.myapp.Entity.votes;
import com.mycompany.myapp.Services.VoteService;
import com.mycompany.myapp.Utils.Imageservices;

/**
 *
 * @author asus
 */
public class show1post extends Form {

    static Publication Post;
    Form current;
    Resources theme;

    public show1post(Resources theme) {
    

        getToolbar().addCommandToLeftBar("Home", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Home(theme).show();
            }
        });
        setLayout(new BorderLayout());

        Image userimg = null;
        userimg = Imageservices.getInstance().getImageProfilFromURL(Post.getIdUser().getImguser());
        Label avatar = new Label();
        avatar.setIcon(userimg);
        Label username = new Label(Post.getIdUser().getUsername());
        Label date = new Label("");
        Label titre = new Label(Post.getTitre());
        titre.setUIID("contenuettexte");
        Label contenu = new Label(Post.getContenu());
        contenu.setUIID("contenuettexte");
        Container Mediaholder = new Container();
        Label vtnb = new Label();
        Label t1 = new Label("Votes");
        t1.setUIID("contenuettexte");
        Label rtnb = new Label();
        Label t2 = new Label("Reacts");
        t2.setUIID("contenuettexte");
        Label ctnb = new Label();
        Label t3 = new Label("Comments");
        t3.setUIID("contenuettexte");
        Container vt = new Container(BoxLayout.y());
        vt.addAll(vtnb, t1);
        Container ct = new Container(BoxLayout.y());
        ct.addAll(rtnb, t2);
        Container rt = new Container(BoxLayout.y());
        rt.addAll(ctnb, t3);
        Container x = new Container(BoxLayout.x());
        x.addAll(vt, ct, rt);
        Container ensemble = new Container(new BorderLayout());
        Container ut = new Container(BoxLayout.y());
        ut.addAll(username, titre);
        ensemble.add(CENTER, ut);
        ensemble.add(EAST, date);
        ensemble.add(SOUTH, x);
        /**
         * ******************************************************
         */
        Container top = new Container(new BorderLayout());
        top.add(WEST, avatar);
        top.add(CENTER, ensemble);
        /**
         * ****************
         */
        add(NORTH, top);
        for (Medias m : Post.getMediapost()) {
            Label med = new Label();
            Image im = null;
            im = Imageservices.getInstance().getImageAlbumFromURL(m.getSource());
            med.setIcon(im);
            Mediaholder.add(med);
        }

        add(CENTER, Mediaholder);
        Slider vote = new Slider();
        Container Stars = new Container(BoxLayout.x());
        Button s1 = new Button();
        s1.setUIID("bt");
        Image emptyStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s1.getSelectedStyle()).toImage();
        Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, s1.getSelectedStyle()).toImage();
        s1.setIcon(emptyStar);
        s1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                votes v = new votes();
                v.setvaleur(1);
                s1.setIcon(fullStar);
                v.setiduser(Session.getInstance().getuser());
                VoteService.getInstance().vote(v);
                Dialog.show("info", "you have voted "+v.getvaleur(),null,"cancel");
            }
        });
        Button s2 = new Button();
           s2.setIcon(emptyStar);
           s2.setUIID("bt");
        s2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                votes v = new votes();
                v.setvaleur(2);
                s1.setIcon(fullStar);
                s2.setIcon(fullStar);
                 v.setiduser(Session.getInstance().getuser());
                VoteService.getInstance().vote(v);
                Dialog.show("info", "you have voted "+v.getvaleur(),null,"cancel");
            }
        });
        Button s3 = new Button();
        s3.setIcon(emptyStar);
        s3.setUIID("bt");
        s3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                votes v = new votes();
                v.setvaleur(3);
                s1.setIcon(fullStar);
                s2.setIcon(fullStar);
                s3.setIcon(fullStar);
                 v.setiduser(Session.getInstance().getuser());
                VoteService.getInstance().vote(v);
                Dialog.show("info", "you have voted "+v.getvaleur(),null,"cancel");
            }
        });
        Button s4 = new Button();
        s4.setUIID("bt");
        s4.setIcon(emptyStar);
        s4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                votes v = new votes();
                v.setvaleur(4);
                s1.setIcon(fullStar);
                s2.setIcon(fullStar);
                s3.setIcon(fullStar);
                s4.setIcon(fullStar);
                v.setiduser(Session.getInstance().getuser());
                VoteService.getInstance().vote(v);
                Dialog.show("info", "you have voted "+v.getvaleur(),null,"cancel");
            }
        });
        Button s5 = new Button();
        s5.setUIID("bt");
        s5.setIcon(emptyStar);
        s5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                votes v = new votes();
                v.setvaleur(5);
                v.setiduser(Session.getInstance().getuser());
                s1.setIcon(fullStar);
                s2.setIcon(fullStar);
                s3.setIcon(fullStar);
                s4.setIcon(fullStar);
                s5.setIcon(fullStar);
                VoteService.getInstance().vote(v);
                Dialog.show("info", "you have voted "+v.getvaleur(),null,"cancel");
            }
        });
        Stars.addAll(s1,s2,s3,s4,s5);
        add(SOUTH,Stars);
        setUIID("postbody");

    }

}
