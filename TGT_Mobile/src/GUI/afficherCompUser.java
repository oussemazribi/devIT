/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Entities.Competition;
import Entities.Participation;
import static Entities.Session.getCurrentSession;
import Entities.Ticket;
import Entities.TwilioSms;
import Entities.fos_user;
import Services.ServiceCompetition;
import Services.ServiceParticipation;
import Services.ServiceTicket;
import Services.ServiceUser;
import com.codename1.components.ImageViewer;
import com.codename1.components.MultiButton;
import com.codename1.components.ScaleImageLabel;
import com.codename1.ui.AutoCompleteTextField;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.list.DefaultListModel;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author loume78
 */
public class afficherCompUser extends BaseForm {
    
   Form current;

    Form f;
    String url = "http://localhost/Intégration_Web/web/uploads";
    EncodedImage enc;
    ServiceUser fos = new ServiceUser();
    ServiceTicket tic = new ServiceTicket();
    ServiceParticipation par = new ServiceParticipation();

    Services.ServiceCompetition ps = new ServiceCompetition();
    com.codename1.ui.util.Resources resourceObjectInstance;
    DefaultListModel<String> options = new DefaultListModel<>();

    public afficherCompUser(Form previous) {
        current = this;

        ArrayList<Competition> lis = ps.getAllCompetitions();
        
        getStyle().setBgColor(0xFFFFFF);
        setTitle("Bienvenue à nos Compétitions");

//
//        for (int i = 0; i < lis.size(); i++) {
//            
//            
//            Image placeholder1 = Image.createImage(250, 200);
//                EncodedImage en = EncodedImage.createFromImage(placeholder1, false);
//                URLImage urli = URLImage.createToStorage(en, lis.get(i).getImageC(), url + "/" +lis.get(i).getImageC());
//                ImageViewer img = new ImageViewer();
//                img.setImage(urli);
//            Label titre = new Label(lis.get(i).getTitre());
//            Label cout = new Label(String.valueOf(lis.get(i).getCout()));
//            add(img);
//            add(titre);
//            add(cout);
//            
//            
//        }
        for (Competition li : lis) {
            
             
            Competition com = new Competition(li.getIdCompetition(), li.getIdUser(),
                    li.getTitre(), li.getDescription(), li.getTypeDeTalent(),
                    li.getDateDebut(), li.getDateFin(), li.getCout(), li.getImageC());
            fos_user user = fos.FindUser(com.getIdUser());
            options.addItem(li.getTitre());

            Container c = new Container(BoxLayout.y());
            c.getStyle().setBorder(Border.createLineBorder(2));
            c.getStyle().setMargin(1, 1, 1, 1);
            c.getStyle().setPadding(0, 0, 0, 0);
            c.getStyle().setBgTransparency(255);
            c.getStyle().setBgColor(0xFDF2E9);

            Image placeholder = Image.createImage(1150, 420);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, li.getImageC(), url + "/" + li.getImageC());
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);

            Image placeholderUser = Image.createImage(150, 150);
            EncodedImage encUser = EncodedImage.createFromImage(placeholderUser, false);
            URLImage urlimUser = URLImage.createToStorage(encUser, user.getImguser(), url + "/" + user.getImguser());
            ImageViewer imgUser = new ImageViewer();
            imgUser.setImage(urlimUser);

            Container title = new Container(BoxLayout.x());

            TextField a = new TextField(li.getIdCompetition());

            Label titre = new Label(user.getUsername() + " à ajouter: ");
            
            Label titre1 = new Label(com.getTitre());

            titre1.setUIID("SignUpForm");

            title.add(imgUser);
            title.add(titre);
            title.add(titre1);

            titre1.addPointerPressedListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    new detailComp(current, com).show();
                }
            });
            
                        Container cout = new Container(BoxLayout.x());

            //Label desc = new Label("Cout : " + String.valueOf(li.getCout()) + " Diamond");
            Label desc = new Label("Cout : " );
            Label desc1 = new Label( String.valueOf(li.getCout()) + " Diamond");
            desc.setMaterialIcon(FontImage.MATERIAL_ATTACH_MONEY);
            desc.setUIID("SignUpForm");
            cout.add(desc);
            cout.add(desc1);
            
                        Container type = new Container(BoxLayout.x());


            Label aa = new Label("Talent : ");
            Label aa1 = new Label(com.getTypeDeTalent());
            aa.setMaterialIcon(FontImage.MATERIAL_GRADE);
            aa.setUIID("SignUpForm");
            
            type.add(aa);
            type.add(aa1);

            Button details = new Button(FontImage.MATERIAL_LOCAL_OFFER, "Details");
                        details.setText("Ticket");
                        details.setUIID("CenterLabelSmall");

//            remove.getStyle().setBgTransparency(255);
//            remove.getStyle().setBgColor(0xde4223);

            details.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                      
                     Dialog d=new Dialog("Ticket pour : "+li.getTitre()+"         "); 
                     
                     d.setHeight(400);
                     d.setWidth(300);
                     Button close = new Button("Close");
                     close.addActionListener((ee) -> d.dispose());

                     
                    
                     Image img=null;  
                     try 
                     { 
                         img=Image.createImage("/logo.png");
                         img.scaled(350, 250);
                     }
                     catch (IOException ex) 
                     { 
                         Dialog.show("Erreur", ex.getMessage(), "OK", null); 
                     }
                     Label l=new Label(img); 
                     Label l1=new Label(); 
                     Label l2=new Label(); 
                     Label l3=new Label(); 
                     l.setText("Bienvenue Mr/Mme "+getCurrentSession().getUsername()
                     );
                     l1.setText(" dans notre Evenement intitulé :"+li.getTitre());
                     l2.setText(" qui aura lieu le :");
                     l3.setText(li.getDateDebut().toString());
                      
                     l.setTextPosition(Label.BOTTOM);
                     l1.setTextPosition(Label.BOTTOM);
                     l2.setTextPosition(Label.BOTTOM);
                     l3.setTextPosition(Label.BOTTOM);
                      Container box = new Container(BoxLayout.y());
                     
                     
                      box.add(l);
                      box.add(l1);
                      box.add(l2);
                      box.add(l3);
                      box.add(close);
                     d.addComponent(box);
                     
                     d.show();


                }
            });
            
            Container btn = new Container(BoxLayout.y());
            
           
            if((!par.FindParticipation(getCurrentSession().getId(), li.getIdCompetition())) && (getCurrentSession().getNbdiament()>li.getCout()) )
            {
                Button remove = new Button(FontImage.MATERIAL_ADD_CIRCLE, "Participer");
//            remove.getStyle().setBgTransparency(255);
//            remove.getStyle().setBgColor(0xde4223);

                remove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        
                        Participation p=new Participation(li.getIdCompetition(), getCurrentSession().getId());
                        Ticket t = new Ticket(li.getIdCompetition(), getCurrentSession().getId());
                        
//                        ps.supprimerComp(li.getIdCompetition());
                          par.addParticipation(p);
                          tic.addTicket(t);
                          fos.DecrementDiamant(getCurrentSession().getId(), li.getIdCompetition());
                          Dialog.show("Succes", "Participation avec succées", "ok",null);
                          TwilioSms twilio = new TwilioSms();
                    twilio.sendSms("Participation avec succés Mr/Mme --"+getCurrentSession().getUsername()+"--");
                        new afficherCompUser(current).show();
                    }
                });

                remove.setText("Participer");
                remove.setUIID("CenterLabelSmall");
                

                btn.add(remove);
            }
            else if(getCurrentSession().getNbdiament()<li.getCout())
                    {
                        
                        
                                       Button remove = new Button(FontImage.MATERIAL_ADD_CIRCLE, "Join");
//            remove.getStyle().setBgTransparency(255);
//            remove.getStyle().setBgColor(0xde4223);

                remove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        
                        Dialog.show("Error", "Vous n'avez pas le nombre exacte du diamands", "ok",null);
                    }
                });

                remove.setText("Participer");
                remove.setUIID("CenterLabelSmall");

                btn.add(remove);
                        
                        
                        
                    }
            else
            {
                Button remove = new Button(FontImage.MATERIAL_REMOVE, "Remove");
//            remove.getStyle().setBgTransparency(255);
//            remove.getStyle().setBgColor(0xde4223);

                remove.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent evt) {
                        
                        Participation p=new Participation(li.getIdCompetition(), getCurrentSession().getId());
                        Ticket t = new Ticket(li.getIdCompetition(), getCurrentSession().getId());
                        
//                        ps.supprimerComp(li.getIdCompetition());
                          par.supprimerParticipation(getCurrentSession().getId(), li.getIdCompetition());
                          tic.supprimerTicket(getCurrentSession().getId(), li.getIdCompetition());
//                          
//                          TwilioSms twilio = new TwilioSms();
//                    twilio.sendSms("Participation avec succés Mr/Mme --"+getCurrentSession().getUsername()+"--");
                        new afficherCompUser(current).show();
                    }
                });

                remove.setText("Remove");
                remove.setUIID("CenterLabelSmall");

                btn.add(remove);
                 btn.add(details);
            }
                
                

            
            c.add(title);
            c.add(imgV);
            Container det = new Container(BoxLayout.x());

            Container det1 = new Container(BoxLayout.y());

            
            det1.add(cout);
            det1.add(type);
            det.add(det1);
            det.add(btn);
            c.add(det);

            add(c);

        }

        getToolbar().addMaterialCommandToOverflowMenu("Mes Participation", FontImage.MATERIAL_ADD_CIRCLE, (e) -> {
            

        });
        
         Container toolbarC=new Container(new BorderLayout());
              TextField zoneRecherche=new AutoCompleteTextField(options); 
              zoneRecherche.setHint("Rechercher"); 
              Button boutonRecherche=new Button(FontImage.MATERIAL_SEARCH, "");
             
              
              
              
              
              
              boutonRecherche.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                
                
                Competition found=new Competition();
                 found= ps.FindCompetition(zoneRecherche.getText().toString());
                
                if(found.getIdCompetition()!=0)
                      {
                       new detailComp(current, found).show();
                      }
                else
                      {
//                          Dialog.show("error", "Competition Not Found","ok", null);
                          Dialog d=new Dialog("Sorry"); 
                     d.setTimeout(2000);
                    
                     Button close = new Button("Close");
                     close.addActionListener((ee) -> d.dispose());

                     Image img=null;  
                     try 
                     { 
                         img=Image.createImage("/sad.png");
//                         img.scaled(350, 250);
                     }
                     catch (IOException ex) 
                     { 
                         Dialog.show("Erreur", ex.getMessage(), "OK", null); 
                     }
                     Label l=new Label(img); 
                     
                     l.setText("Competition Not Found !!");
                    
       
                     l.setTextPosition(Label.BOTTOM);
   
                     d.addComponent(l);
                     
                     d.show();
                      }
            }
        });
              
              toolbarC.addComponent(BorderLayout.CENTER,zoneRecherche);
              toolbarC.addComponent(BorderLayout.EAST,boutonRecherche);
              getToolbar().setTitleComponent(toolbarC);
        
        installSidemenu(resourceObjectInstance);
//        getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_CANCEL, e
//                -> {
//            new SignInForm(resourceObjectInstance).show();
//        });
    }
    
    @Override
    protected boolean isCurrentCalendar() {
        return true;
    }

}
