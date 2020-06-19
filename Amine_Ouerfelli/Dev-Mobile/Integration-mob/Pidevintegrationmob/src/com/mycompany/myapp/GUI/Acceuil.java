/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.GUI.AjoutReclamation;

/**
 *
 * @author BENTEKFA
 */
public class Acceuil extends Form{
Resources theme;
Form current;
    public Acceuil(Resources theme) {
        current=this;
        setTitle("Acceuil");
        setLayout(BoxLayout.y());
        
        add(new Label("Choisir votre compte"));
        Button btnAdmin = new Button("Admin");
        Button btnSimple = new Button("Simple User");
        
        btnAdmin.addActionListener(e-> new ListeReclamations(theme).show());
        btnSimple.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                Resources theme=UIManager.initFirstTheme("/theme") ;
                new AjoutReclamation(theme).show();
            }
        });
        addAll(btnAdmin,btnSimple);
        
        
    }
    
}
