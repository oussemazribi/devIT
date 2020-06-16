/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.SpanButton;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Tabs;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.WEST;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Publication;
import com.mycompany.myapp.Entity.reactions;
import com.mycompany.myapp.Entity.votes;

/**
 *
 * @author asus
 */
public class reactlist extends Form {
   static Publication possst;
   Resources theme;
   Form current;
   public reactlist(Resources theme)
   {       current = this;
           setTitle("React List");
           setLayout(BoxLayout.y());
           getToolbar().addCommandToLeftBar("home", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new Home(theme).show();
            }
        });
     Tabs t=new Tabs();
     Container reacts=new Container(BoxLayout.y());
     Container Votes=new Container(BoxLayout.y());
     if(possst.getReactions().size()!=0)
     { for( reactions r : possst.getReactions()){
     Container react=new Container(new BorderLayout());
         if(r.gettype()==1)
         {  Label like=new Label();
            like.setIcon(theme.getImage("like1.png"));
            like.setUIID("bt");    
            Label username=new Label(r.getiduser().getUsername());
            react.add(WEST,username);
            react.add(CENTER,like);
         }
         else{
             if(r.gettype()==2)
                
             { Label love=new Label();
               love.setIcon(theme.getImage("heart.png"));
               love.setUIID("bt");
               Label username=new Label(r.getiduser().getUsername());
               react.add(WEST,username);
               react.add(CENTER,love);
             }
              else
             {   Label Dislike=new Label();
                 Dislike.setIcon(theme.getImage("dis.png"));
                 Label username=new Label(r.getiduser().getUsername());
                 react.add(WEST,username);
                 react.add(CENTER,Dislike);
             }
         }
        
            
     
     
      }}
     for(votes v: possst.getVotes())
     {Container Vote =new Container(new BorderLayout());    
       Label val=new Label(String.valueOf(v.getvaleur()));
       Container kol=new Container(BoxLayout.x());
       Image fullStar = FontImage.createMaterial(FontImage.MATERIAL_STAR, val.getSelectedStyle()).toImage();
       Label star=new Label();
       star.setIcon(fullStar);
       kol.addAll(val,star);
       Label username=new Label(v.getiduser().getUsername());
       Vote.add(WEST,username);
       Vote.add(CENTER,kol);
      
     }
     
     t.addTab("Vote",FontImage.MATERIAL_ACCOUNT_BOX,4,new Label("T4"));
     t.addTab("reacts",FontImage.MATERIAL_ACCOUNT_BOX,4,new Label("T3"));
    
   }
}
