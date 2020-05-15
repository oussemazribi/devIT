/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.TGT.myapp.gui;

import com.TGT.myapp.services.ServiceBlog;
import com.codename1.components.SpanLabel;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;

/**
 *
 * @author HPENVY
 */
public class AfficherListBlog extends Form {

    public AfficherListBlog(Form previous) {
        setTitle("List Blogs");
        
        SpanLabel sp = new SpanLabel();
        sp.setText(ServiceBlog.getInstance().getAllBlogs().toString());
        add(sp);
        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
    
    
}

