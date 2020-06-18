/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import Sessioncontrol.Session;
import com.codename1.components.MultiButton;
import com.codename1.share.FacebookShare;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.SwipeableContainer;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import static com.codename1.ui.layouts.BorderLayout.EAST;
import static com.codename1.ui.layouts.BorderLayout.NORTH;
import static com.codename1.ui.layouts.BorderLayout.SOUTH;
import static com.codename1.ui.layouts.BorderLayout.WEST;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.Entity.Commentaire;
import com.mycompany.myapp.Entity.Medias;
import com.mycompany.myapp.Entity.Publication;
import com.mycompany.myapp.Entity.reactions;
import static com.mycompany.myapp.GUI.editpost.popo;
import static com.mycompany.myapp.GUI.reactlist.possst;
import static com.mycompany.myapp.GUI.show1post.Post;
import com.mycompany.myapp.Services.CommentaireService;
import com.mycompany.myapp.Services.PostService;
import com.mycompany.myapp.Services.ReactService;
import com.mycompany.myapp.Utils.Imageservices;
import java.util.Objects;

/**
 *
 * @author asus
 */
public class Profile extends BaseForm {
     
    
    Form current;
    Resources theme = UIManager.initFirstTheme("/theme_1");
    static int iduser;
    public Profile(Resources resourceObjectInstance) {
        current = this;
        setTitle("Home");
        setLayout(BoxLayout.y());
        installSidemenu(theme);
        getToolbar().addMaterialCommandToRightBar("", FontImage.MATERIAL_PUBLIC, e -> {
        });

        //stitle.setBgImage();
        //stitle.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
//        setBgImage(resourceObjectInstance.getImage("BG copy.png"));
        /**
         * ***********************************************************
         */
        Container Head = new Container(new BorderLayout());
        Button add = new Button("What's on your Mind ?");
        Head.add(CENTER, add);
        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new addnewpost(resourceObjectInstance).show();
            }
        });
        add(Head);

        /**
         * *******************************************************
         */
        for (Publication post : PostService.getInstance().getAllPosts()) {
            if(post.getIdUser().getId()==iduser){
            Container item = new Container(new BorderLayout());
            Container top = new Container(new BorderLayout());
            Container User = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Label username = new Label();
            Label Profilepic = new Label();
            /**
             * **********************************************
             */

            /**
             * ************************************************
             */
            Container Reactscomments = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Label nbcomments = new Label();
            Label nbreacts = new Label();
            Label commenticon = new Label();
            Label date = new Label();
            Button reacticon = new Button();
            reacticon.setUIID("bt");
            reacticon.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                   possst=post;
                   System.out.println(possst.getReactions());
                   new reactlist(theme).show();
                  
                }
            });
            Container Content = new Container(new BorderLayout());
            Container MediaHolder = new Container();
            Container Buttons = new Container(new BorderLayout());
            Container Buttonreact = new Container(BoxLayout.x());
            Container south = new Container(new BorderLayout());
            Container Comments = new Container(BoxLayout.y());
            Button love = new Button();
            love.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    reactions r = new reactions();
                    r.setiduser(Session.getInstance().getuser());
                    r.settype(2);
                    r.setidpublication(post.getId());
                    ReactService.getInstance().reagir(r);
                    revalidate();
                }
            });
            Button Like = new Button();
            Like.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    reactions r = new reactions();
                    r.setiduser(Session.getInstance().getuser());
                    r.settype(1);
                    r.setidpublication(post.getId());
                    ReactService.getInstance().reagir(r);
                    revalidate();
                }
            });
            Button Dislike = new Button();
            Dislike.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    reactions r = new reactions();
                    r.setiduser(Session.getInstance().getuser());
                    r.settype(3);
                    r.setidpublication(post.getId());
                    ReactService.getInstance().reagir(r);
                    revalidate();
                }
            });
            Button share = new Button();
            Button menupost = new Button();
            menupost.setUIID("bt");
            menupost.setIcon(resourceObjectInstance.getImage("postmenu.png"));
            Button showmenu = new Button();
            /**
             * ***************************************
             */
            Container commentfield = new Container(new BorderLayout());
            Image imgc = null;
            imgc=Imageservices.getInstance().getImageProfilFromURL(Session.getInstance().getuser().getImguser()).scaled(50,50);
            Label avatarc = new Label();
            avatarc.setIcon(imgc);
            Button submit = new Button();
            submit.setUIID("bt");
            submit.setIcon(resourceObjectInstance.getImage("submit.png"));
            TextField tf = new TextField();
            commentfield.add(WEST, avatarc);
            commentfield.add(CENTER, tf);
            commentfield.add(EAST, submit);
            south.add(SOUTH, commentfield);
            submit.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Commentaire c = new Commentaire();
                    if (tf.getText() != "") {
                        c.setpost(post);
                        c.setcontenu(tf.getText());
                        c.setuser(Session.getInstance().getuser());
                        boolean o = CommentaireService.getInstance().ajoutercommentaire(c);
                        if (o) {
                            Dialog.show("Done", "Your Comment was Posted", "ok", null);
                            revalidate();
                        }
                    }

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
                    Dialog d = new Dialog();
                    d.setLayout(BoxLayout.y());
                    Button supprimer = new Button("Supprimer");
                    supprimer.setIcon(theme.getImage("icons8-effacer-50.png"));
                    supprimer.setUIID("bt");
                    Button edit = new Button("edit");
                    edit.setIcon(theme.getImage("icons8-modifier-50.png"));
                    edit.setUIID("bt");
                    supprimer.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            boolean yes = PostService.getInstance().Deletepost(post);
                            if (yes == true) {
                                Dialog.show("info","Post Deleted","ok",null);
                                revalidate();
                            }

                        }
                    });
                    edit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            popo = post;
                            new editpost(resourceObjectInstance).show();
                        }
                    });
                    Button shareonsocialmedia = new Button("share on facebook");
                    shareonsocialmedia.setUIID("bt");
                    shareonsocialmedia.setIcon(theme.getImage("shares.png"));
                    shareonsocialmedia.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            FacebookShare fb = new FacebookShare();
                            fb.share(post.toString());
                        }
                    });
                    Button partager = new Button("share ");
                    partager.setUIID("bt");
                    partager.setIcon(theme.getImage("share.png"));
                    partager.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Publication p = new Publication();
                            if("shared".equals(post.getType()))
                                p.setContenu(post.getContenu());
                            else
                            p.setContenu(String.valueOf(post.getId()));
                            p.setIdUser(Session.getInstance().getuser());
                            p.setType("shared");
                            PostService.getInstance().sharepost(p);
                            
                            Dialog.show("Info", "Post shared with success", "Ok", null);
                            revalidate();

                        }
                    });
                    if(post.getIdUser().getId()==Session.getInstance().getuser().getId())
                    {d.add(supprimer);
                    d.add(edit);}
                    d.add(shareonsocialmedia);
                    d.add(partager);
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
            
            Profilepic.setMask(resourceObjectInstance.getImage("Ellipse 4.png").createMask());
            Profilepic.setIcon(userimg);
            User.add(Profilepic);
            User.add(username);
            nbcomments.setText(post.getNb_comments().toString());
            nbreacts.setText(post.getNb_votes().toString());
            date.setText(post.getDate().substring(0,9));
            Container Reacts = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container CommentsCount = new Container(new BoxLayout(BoxLayout.X_AXIS));
            reacticon.setIcon(resourceObjectInstance.getImage("heart_icon.png"));
            Reacts.addAll(reacticon, nbreacts);
            commenticon.setIcon(resourceObjectInstance.getImage("comment_icon.png"));
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

            if (post.getCommentaires() != null) {
                for (Commentaire c : post.getCommentaires()) {
                    MultiButton comment = new MultiButton();
                    Image imguser = null;
                    imguser = Imageservices.getInstance().getImageProfilFromURL(c.getiduser().getImguser());
                    comment.setIcon(imgc);
                    comment.setTextLine1(c.getiduser().getUsername());
                    comment.setUIIDLine1("contenuettexte");
                    comment.setTextLine3(c.getcontenu());
                    comment.setUIIDLine3("contenuettexte");
                    Button edit = new Button();
                    edit.setIcon(resourceObjectInstance.getImage("icons8-modifier-50.png"));
                    edit.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            Dialog ed = new Dialog();
                            ed.setLayout(BoxLayout.y());
                            Label lb = new Label("Edit Comment");
                            TextField tfcom = new TextField();
                            tfcom.setHint(c.getcontenu());
                            Button editcom = new Button();

                            editcom.addActionListener(new ActionListener() {
                                @Override
                                public void actionPerformed(ActionEvent evt) {
                                    String com = tfcom.getText();
                                    if (com != null) {
                                        c.setcontenu(com);
                                        if(CommentaireService.getInstance().ediCommentaire(c))
                                        {
                                            ed.dispose();
                                        }
                                         
                                    }
                                }
                            });
                            editcom.setIcon(resourceObjectInstance.getImage("icons8-modifier-50.png"));
                            ed.addAll(lb, tfcom, editcom);
                            ed.show();
                        }
                    });
                    Button delete = new Button();
                    delete.setIcon(resourceObjectInstance.getImage("icons8-effacer-50.png"));
                    delete.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent evt) {
                            boolean yes = CommentaireService.getInstance().supprimerCommentaire(c);
                            if (yes) {
                                revalidate();
                            }
                        }
                    });
                    Container bottons = new Container();
                    if(Objects.equals(c.getiduser().getId(), post.getIdUser().getId())||c.getiduser().getId()==Session.getInstance().getuser().getId())
                    bottons.addAll(edit, delete);
                    SwipeableContainer swipe = new SwipeableContainer(bottons, comment);
                    Comments.add(swipe);

                }
                south.add(CENTER, Comments);
            }
            love.setIcon(resourceObjectInstance.getImage("heart.png"));
            love.setUIID("bt");
            Like.setIcon(resourceObjectInstance.getImage("like1.png"));
            Like.setUIID("bt");
            Dislike.setIcon(resourceObjectInstance.getImage("dis.png"));
            Dislike.setUIID("bt");
            Buttonreact.addAll(Like, love, Dislike);
            Buttons.add(CENTER, Buttonreact);
            Label sp1=new Label();
            sp1.setIcon(resourceObjectInstance.getImage("separator.png"));
            Label sp2=new Label();
            sp2.setIcon(resourceObjectInstance.getImage("separator.png"));
            Label sp3=new Label();
            sp3.setIcon(resourceObjectInstance.getImage("separator.png"));
            Buttons.add(NORTH,sp1);
            Buttons.add(SOUTH,sp3);
            top.add(SOUTH,sp2);
            //titre.setUIID("contenuettexte");
            south.add(NORTH, Buttons);
            item.setUIID("postbody");
            item.add(NORTH, top);
            if ("shared".equals(post.getType())) {
                int trv = 0;
                Publication pop=new Publication();
                System.out.println("shared");
                for (Publication p : PostService.getInstance().getAllPosts()) {
                    if (p.getId() == Integer.parseInt(post.getContenu())) {
                        trv = 1;
                        pop=p;
                    }
                    System.out.println("shared");
                    Container sharedBox = new Container(new BorderLayout());
                    Container mh = new Container();
                    Container to = new Container(new BorderLayout());
                    Container Users = new Container(new BoxLayout(BoxLayout.X_AXIS));
                    Label usernames = new Label(p.getIdUser().getUsername());
                    Image userimg2 = null;
                    userimg2 = Imageservices.getInstance().getImageProfilFromURL(post.getIdUser().getImguser());
                    Label Profilepics = new Label();
                    Profilepics.setIcon(userimg2);
                    to.add(WEST, userimg2);
                    to.add(CENTER, usernames);
                    
                    Label tit=new Label(pop.getTitre());
                    to.add(SOUTH,tit);
                    Label con=new Label(pop.getContenu());
                    for (Medias m1 : pop.getMediapost()) {
                        Label media2 = new Label();
                        Image img23 = null;
                        img23 = Imageservices.getInstance().getImageAlbumFromURL(m1.getSource());
                        media2.setIcon(img23);
                        mh.add(media2);
                    }
                    usernames.setUIID("contenuettexte");
                    sharedBox.add(CENTER, mh);
                    sharedBox.add(NORTH, to);
                    sharedBox.add(SOUTH,con);
                    item.add(CENTER, sharedBox);
                }

            } else {

                Label contenu = new Label(post.getContenu());
                //contenu.setUIID("contenuettexte");
                Label titre = new Label(post.getTitre());
                if (post.getMediapost() != null) {
                    for (Medias m : post.getMediapost()) {
                        Label media = new Label();
                        Image img = null;
                        img = Imageservices.getInstance().getImageAlbumFromURL(m.getSource());
                        media.setIcon(img);
                        MediaHolder.add(media);

                    }
                }
                Content.add(NORTH, titre);
                Content.add(SOUTH, contenu);
                Content.add(CENTER, MediaHolder);
                item.add(CENTER, Content);
            }
            item.add(SOUTH, south);
            Button visitprofile=new Button("User's Profile");
            visitprofile.setUIID("bt");
            visitprofile.setIcon(resourceObjectInstance.getImage("profile.png"));
            visitprofile.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                 iduser=post.getIdUser().getId();
                 new Profile(theme).show();
                }
            });
            Button vote = new Button("votez");
            vote.setUIID("bt");
            vote.setIcon(theme.getImage("icons8-vote-64.png"));
            vote.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    Post = post;
                    new show1post(resourceObjectInstance).show();
                }
            });
            Container t = new Container(BoxLayout.x());
            t.add(vote);
            SwipeableContainer sw = new SwipeableContainer(t, item);
            add(sw);

        }

    }
      
    }}


