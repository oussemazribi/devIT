/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TGT.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;

/**
 *
 * @author HPENVY
 */
public class HomeBlog extends Form {
     Form current;
     
    public HomeBlog() {
        current = this; //Récupération de l'interface(Form) en cours
        setTitle("Home Blog");
        setLayout(BoxLayout.y());

        add(new Label("Choose an option"));
        Button btnAddBlog = new Button("Ajout Blog");
        Button btnListBlogs = new Button("List Blog");

        btnAddBlog.addActionListener(e -> new AjoutBlog(current).show());
        btnListBlogs.addActionListener(e -> new AfficherListBlog(current).show());
        addAll(btnAddBlog, btnListBlogs);

    }    
}
