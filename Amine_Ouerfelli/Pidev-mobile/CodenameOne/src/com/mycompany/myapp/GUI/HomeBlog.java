/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.ui.Button;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;

/**
 *
 * @author HPENVY
 */
public class HomeBlog extends Form {

    Form current;

    public HomeBlog(Resources res) {
        current = this;
        setTitle("Home Blog");
        setLayout(BoxLayout.y());
        Style stitle = getToolbar().getTitleComponent().getUnselectedStyle();

        current.getToolbar().addMaterialCommandToSideMenu("Competition", FontImage.MATERIAL_TRENDING_UP, e -> {

        });
        current.getToolbar().addMaterialCommandToSideMenu("Publication", FontImage.MATERIAL_TRENDING_UP, e -> {
            addnewpost add = new addnewpost(res);
            add.show();
        });
        current.getToolbar().addMaterialCommandToSideMenu("Blog", FontImage.MATERIAL_TRENDING_UP, e -> {
            HomeBlog H = new HomeBlog(res);
            H.show();

        });
        current.getToolbar().addMaterialCommandToSideMenu("Messagerie", FontImage.MATERIAL_TRENDING_UP, e -> {

        });
        current.getToolbar().addMaterialCommandToSideMenu("Reclamation", FontImage.MATERIAL_TRENDING_UP, e -> {
             
        });

        add(new Label("Choisissez une option"));
        Button btnAddBlog = new Button("Ajout Blog");
        Button btnListBlogs = new Button("List Blog");
        addAll(btnAddBlog, btnListBlogs);
        btnAddBlog.addActionListener(e -> new AjoutBlog(res).show());
        btnListBlogs.addActionListener(e -> new AfficherListBlog(res));

    }

    public Form getCurrent() {
        return current;
    }

    public void setCurrent(Form current) {
        this.current = current;
    }

}
