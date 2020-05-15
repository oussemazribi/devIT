/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.components.MultiButton;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.EAST;
import static com.codename1.ui.layouts.BorderLayout.NORTH;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import static com.codename1.ui.layouts.BorderLayout.WEST;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Commentaire;
import com.mycompany.myapp.Entity.Medias;
import com.mycompany.myapp.Entity.Publication;
import static com.mycompany.myapp.GUI.editpost.popo;
import static com.mycompany.myapp.GUI.show1post.Post;
import com.mycompany.myapp.Services.CommentaireService;
import com.mycompany.myapp.Services.PostService;
import com.mycompany.myapp.Utils.Imageservices;

/**
 *
 * @author asus
 */
public class Home extends Form {

    Form current;
    Resources theme;
    
    public Home(Resources theme) {
        current = this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        Style stitle = getToolbar().getTitleComponent().getUnselectedStyle();     
        stitle.setBgImage(theme.getImage("background toolbar.png"));
        stitle.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);

        /**************************************************************/
        Container Head=new Container(new BorderLayout());
        Button add=new Button("What's on your Mind ?");
        Head.add(CENTER,add) ;     
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
              new addnewpost(theme).show();
            }
        });
        add(Head);
        
        /**********************************************************/
        for (Publication post : PostService.getInstance().getAllPosts()) {
            Container item = new Container(new BorderLayout());
            Container top = new Container(new BorderLayout());
            Container User = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label username = new Label();
            Label Profilepic = new Label();
            
            Container Reactscomments = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label nbcomments = new Label();
            Label nbreacts = new Label();
            Label commenticon = new Label();
            Label date = new Label();
            Label reacticon = new Label();
            Container Content = new Container(new BorderLayout());
            Container MediaHolder = new Container();
            Container Buttons = new Container(new BorderLayout());
            Container Buttonreact = new Container(BoxLayout.x());
            Container south=new Container(new BorderLayout());
            Container Comments=new Container(BoxLayout.y());
            Button love = new Button();
            Button Like = new Button();
            Button Dislike = new Button();
            Button share = new Button();
            Button menupost = new Button();
            menupost.setIcon(theme.getImage("postmenu.png"));
            Button showmenu = new Button();
            /******************************************/
            Container commentfield=new Container(new BorderLayout());
            Image imgc=null;
            //imgc=Imageservices.getInstance().getImageCommentaireFromURL();
            Label avatarc=new Label();
            Button submit=new Button("submit");
            TextField tf=new TextField();
            commentfield.add(WEST,avatarc);
            commentfield.add(CENTER,tf);
            commentfield.add(EAST,submit);
            south.add(SOUTH,commentfield);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                  Commentaire c=new Commentaire();
                  if(tf.getText()!="")
                  { c.setcontenu(tf.getText());
                   boolean o= CommentaireService.getInstance().ajoutercommentaire(c);
                 if(o)
                 { Dialog.show("Done","Your Comment was Posted","ok",null);
                     revalidate();}}
                  
                }
            });
            /*menupost.addActionListener(new ActionListener() {
                 @Override
                 public void actionPerformed(ActionEvent evt) {
                      Dialog.show("Dialog Title", "This is the dialog body, it can contain anything...", "OK", "Cancel");
                 }
             });*/
            menupost.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Dialog d = new Dialog("Post parameters");
                    d.setLayout(BoxLayout.y());
                    Button supprimer = new Button("Supprimer");
                    Button edit=new Button("edit");
                    supprimer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            boolean yes = PostService.getInstance().Deletepost(post);
                            if (yes == true) {
                              revalidate();                             
                            }

                        }
                    });
                    edit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                           popo=post;
                           new editpost(theme).show();
                        }
                    });
                    d.add(supprimer);
                    d.add(edit);
                    d.showPopupDialog(showmenu);
                }
            });
            /**
             * *****************************
             */
            username.setText(post.getIdUser().getUsername());
            username.setUIID("contenuettexte");
            Image userimg = null;
            userimg = Imageservices.getInstance().getImageProfilFromURL(post.getIdUser().getImguser());
            Profilepic.setIcon(userimg);
            User.add(Profilepic);
            User.add(username);
            nbcomments.setText(post.getNb_comments().toString());
            nbreacts.setText(post.getNb_votes().toString());
            date.setText("now");
            Container Reacts = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container CommentsCount = new Container(new BoxLayout(BoxLayout.X_AXIS));
            reacticon.setIcon(theme.getImage("heart_icon.png"));
            Reacts.addAll(reacticon, nbreacts);
            commenticon.setIcon(theme.getImage("comment_icon.png"));
            CommentsCount.addAll(commenticon, nbcomments);
            Container infoHolder = new Container(new BoxLayout(BoxLayout.X_AXIS));
            infoHolder.addAll(Reacts, CommentsCount);
            Reactscomments.add(menupost).add(showmenu);
            Reactscomments.addAll(date, infoHolder);
            top.add(CENTER, User);
            top.add(EAST, Reactscomments);
            /**
             * *************
             */
            if (post.getMediapost() != null) {
                for (Medias m : post.getMediapost()) {
                    Label media = new Label();
                    Image img = null;
                    img = Imageservices.getInstance().getImageAlbumFromURL(m.getSource());
                    media.setIcon(img);
                    MediaHolder.add(media);

                }
            }
            if(post.getCommentaires()!=null)
            {
                for(Commentaire c :post.getCommentaires())
                {
                    MultiButton comment=new MultiButton();
                    Image imguser=null;
                    imguser=Imageservices.getInstance().getImageCommentaireFromURL(c.getiduser().getImguser());
                    Label avatar=new Label();
                    avatar.setIcon(imguser);
                    comment.setTextLine1(c.getiduser().getUsername());
                    comment.setTextLine3(c.getcontenu());               
                    Button edit=new Button();
                    edit.setIcon(theme.getImage("icons8-modifier-50.png"));
                    edit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                         CommentaireService.getInstance().ediCommentaire(c);
                        }
                    });
                    Button delete=new Button();
                    delete.setIcon(theme.getImage("icons8-effacer-50.png"));
                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            CommentaireService.getInstance().supprimerCommentaire(c);
                            revalidate();
                        }
                    });
                    Container bottons=new Container();     
                    bottons.addAll(edit,delete);
                    SwipeableContainer swipe = new SwipeableContainer(bottons,comment);
                    Comments.add(swipe);
                    
                }
                south.add(CENTER,Comments);
            }
            love.setIcon(theme.getImage("heart.png"));
            Like.setIcon(theme.getImage("like1.png"));
            Dislike.setIcon(theme.getImage("dis.png"));
            Buttonreact.addAll(Like, love, Dislike);
            Buttons.add(CENTER, Buttonreact);
            Label contenu = new Label(post.getContenu());
            //contenu.setUIID("contenuettexte");
            Label titre = new Label(post.getTitre());
            //titre.setUIID("contenuettexte");
            Content.add(NORTH, titre);
            Content.add(SOUTH, contenu);
            Content.add(CENTER, MediaHolder);
            south.add(NORTH,Buttons);
            item.setUIID("postbody");
            item.add(NORTH, top);
            item.add(CENTER, Content);
            item.add(SOUTH, south);
            Button vote=new Button("votez");
            vote.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                 Post=post;
                 new show1post(theme).show();
                }
            });
            Container t=new Container(BoxLayout.x());
            t.add(vote);
            SwipeableContainer sw = new SwipeableContainer(t,item);
            add(sw);

        }

    }

}
