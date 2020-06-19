/*
 * Copyright (c) 2016, Codename One
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated 
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation 
 * the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, 
 * and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions 
 * of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, 
 * INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A 
 * PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT 
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF 
 * CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE 
 * OR THE USE OR OTHER DEALINGS IN THE SOFTWARE. 
 */
package GUI;

import com.codename1.capture.Capture;
import com.codename1.components.FloatingActionButton;
import com.codename1.components.ImageViewer;
import com.codename1.components.SpanLabel;
import com.codename1.components.ToastBar;
import com.codename1.facebook.User;
import com.codename1.io.Log;
import com.codename1.maps.Tile;
import com.codename1.ui.Button;
import com.codename1.ui.Command;

import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Font;
import com.codename1.ui.FontImage;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.URLImage;
import com.codename1.ui.animations.CommonTransitions;
import com.codename1.ui.events.ActionEvent;
import static com.codename1.ui.events.ActionEvent.Type.Command;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.geom.Dimension;
import com.codename1.ui.geom.Rectangle;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.RoundBorder;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import Entities.Conversation;
import Entities.Message;
import static Entities.Session.getCurrentSession;
import Entities.fos_user;
import Services.ServiceMessagerie;
import Services.ServiceUser;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;



/**
 * GUI builder created Form
 *
 * @author shai
 */
public class ChatForm extends BaseForm {
   
    
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_6 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_1 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_1 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_1 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_7 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_2 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_2 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_2 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_2 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_8 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_3 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_3 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_3 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_3 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_9 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_1_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());
    private com.codename1.ui.Container gui_Container_2_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_1_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_4_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.FlowLayout());
    private com.codename1.ui.Label gui_Label_4_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Container gui_Container_3_4 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_3_4 = new com.codename1.ui.Label();
    private com.codename1.ui.Label gui_Label_2_4 = new com.codename1.ui.Label();
    private com.codename1.ui.TextArea gui_Text_Area_1_4 = new com.codename1.ui.TextArea();
    private com.codename1.ui.Label gui_Label_5 = new com.codename1.ui.Label();
    private com.codename1.ui.Label te = new com.codename1.ui.Label();
    private com.codename1.ui.Label teste = new com.codename1.ui.Label();
    
    private com.codename1.ui.Container test = new com.codename1.ui.Container(new com.codename1.ui.layouts.BorderLayout());


    public ChatForm(int ide) {
        
         getToolbar().setTitleComponent(
                FlowLayout.encloseCenterMiddle(
                        new Label("Your Texts", "Title"),
                        new Label("", "InboxNumber")
                        
                )
        );  
            Label picture = new Label("", "Container");
        Style s = UIManager.getInstance().getComponentStyle("TitleCommand");
        Image camera = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, s);
           FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
             FontImage mat2 = FontImage.createMaterial(FontImage.MATERIAL_CAMERA, "SigninTitle", 3.5f);
           getToolbar().addCommandToLeftBar("", mat, e -> new InboxForm().show());
       
            getToolbar().addCommandToRightBar("", camera,  ev -> {
            try {
                Image image = Image.createImage(Capture.capturePhoto());
                teste.setIcon(image);
                revalidate();
            } catch (IOException e) {
                // TODO: handle exception
                Log.e(e);
            }
        });
      

        
        gui_Label_5.setShowEvenIfBlank(true);
        gui_Label_6.setShowEvenIfBlank(true);
        gui_Label_7.setShowEvenIfBlank(true);
        gui_Label_8.setShowEvenIfBlank(true);
        gui_Label_9.setShowEvenIfBlank(true);
        
        gui_Text_Area_1.setRows(2);
        gui_Text_Area_1.setColumns(100);
        gui_Text_Area_1.setEditable(false);
        gui_Text_Area_1_1.setRows(2);
        gui_Text_Area_1_1.setColumns(100);
        gui_Text_Area_1_1.setEditable(false);
        gui_Text_Area_1_2.setRows(2);
        gui_Text_Area_1_2.setColumns(100);
        gui_Text_Area_1_2.setEditable(false);
        gui_Text_Area_1_3.setRows(2);
        gui_Text_Area_1_3.setColumns(100);
        gui_Text_Area_1_3.setEditable(false);
        gui_Text_Area_1_4.setRows(2);
        gui_Text_Area_1_4.setColumns(100);
        gui_Text_Area_1_4.setEditable(false);
        
        FloatingActionButton fab  = FloatingActionButton.createFAB(FontImage.MATERIAL_ADD);
        RoundBorder rb = (RoundBorder)fab.getUnselectedStyle().getBorder();
        rb.uiid(true);
        fab.bindFabToContainer(getContentPane());
        fab.addActionListener(e -> {
            fab.setUIID("FloatingActionButtonClose");
            Image oldImage = fab.getIcon();
            FontImage image = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "FloatingActionButton", 3.8f);
            fab.setIcon(image);
            Dialog popup = new Dialog();
            popup.setDialogUIID("Container");
            popup.setLayout(new LayeredLayout());
            Button c1 = new Button();
            Button trans = new Button("");
            trans.setUIID("Container");
             c1.setUIID("Container");
             Style c1s = c1.getAllStyles();
             c1s.setMarginUnit(Style.UNIT_TYPE_DIPS);
             c1s.setMarginLeft(4);
            c1s.setMarginTop(5);
            c1s.setMarginBottom(10);
          //  c1s.setMarginRight(14);
           popup.add(trans).
                    add(FlowLayout.encloseIn(c1));
                 
            

            
            ActionListener a = ee -> popup.dispose();
             c1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                    TextArea aa = new TextArea("test");
                }
            });
            
            popup.setTransitionInAnimator(CommonTransitions.createEmpty());
            popup.setTransitionOutAnimator(CommonTransitions.createEmpty());
            popup.setDisposeWhenPointerOutOfBounds(true);
            int t = ChatForm.this.getTintColor();
            ChatForm.this.setTintColor(0);
            popup.showPopupDialog(new Rectangle(ChatForm.this.getWidth() - 10, ChatForm.this.getHeight() - 10, 10, 10));
            ChatForm.this.setTintColor(t);
            fab.setUIID("FloatingActionButton");
            fab.setIcon(oldImage);
        });
        

            Message c = new Message();
            ServiceMessagerie sm = new ServiceMessagerie();
              fos_user f = new fos_user() ;
            ServiceUser su = new ServiceUser() ;
              ArrayList<Message> listevents = sm.getAllmessages(ide);
              
              
               for (Message ev : listevents) {
                    fos_user usere = su.getuser(ev.getId_Sender());
                      fos_user usere1 = su.getuser(ev.getId_Receiver());

                      
                     te.setText(""+usere1.getId());
                         System.out.println(ev.getId_Message());
                            System.err.println(ev.getId_Message());
                
                    
            //System.out.println("eveent   ::::::"+ev.toString());
            ImageViewer imv = null;
            Image img;
           
            //System.out.println("http://localhost/pidev2/web/" + ev.getPhoto());    
            
            //img.scaled(50, 50);
            //System.out.println("http://localhost/pidev2/web/" + ev.getPhoto());
       

            Container bouhom = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container sepa = new Container(new BoxLayout(BoxLayout.Y_AXIS));
            Container title = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ctnnb = new Container(new BoxLayout(BoxLayout.X_AXIS));

            Container C2 = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container ph = new Container(new BoxLayout(BoxLayout.X_AXIS));
            Container test = new Container(new BoxLayout(BoxLayout.X_AXIS));
                   
        Image im1 , im2;
        
      
           
              if(getCurrentSession().getId()== usere1.getId())
              {   
                
                      Image placeholder = Image.createImage(300, 250);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, usere.getImguser() , "http://localhost/Intégration_Web/web/uploads" + usere1.getImguser());
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
        
                   Label l1 = new Label();
                  Container aareth = new Container(new BoxLayout(BoxLayout.X_AXIS));
                  Label lname = new Label("" +usere.getUsername());
                  
                  Label l = new Label(": "+ev.getContenu());
                  if(ev.getEtat().equals("NotSeen"))
                  {
                  
            l1.setText("✓");
                  }
                    if(ev.getEtat().equals("Seen"))
                  {
                  
              l1.setText("✔✔");
                  }
                
                  
            l1.	addPointerPressedListener(new ActionListener() {
                          @Override
                          public void actionPerformed(ActionEvent evt) {
                             sm.modifierMessage(ev.getId_Message());
                               ChatForm c = new ChatForm(ide);
                               c.show() ;
                          }
                      });
           
            l.getAllStyles().setMarginRight(RIGHT);
            l.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));

             l1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             aareth.addAll(lname,l);
             title.add(imgV);
            title.add(ph);
            title.add(aareth);
              title.add(l1);
                    }
              
              
              
              else if(getCurrentSession().getId()== usere.getId())
              {  
                       Image placeholder = Image.createImage(300, 250);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, usere.getImguser() , "http://localhost/Intégration_Web/web/uploads" + usere.getImguser());
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
                        Label l1 = new Label();
                  Container aareth = new Container(new BoxLayout(BoxLayout.X_AXIS));
                  Label lname = new Label(""+usere.getUsername());
                  
                  Label l = new Label(": "+ev.getContenu());
                      if(ev.getEtat().equals("NotSeen"))
                  {
                  
            l1.setText("✓");
                  }
                    if(ev.getEtat().equals("Seen"))
                  {
                  
              l1.setText("✔✔");
                  }
               FontImage del = FontImage.createMaterial(FontImage.MATERIAL_DELETE, "SigninTitle", 3.5f);
             Label delet = new Label();
             delet.setIcon(del);
             delet.addPointerPressedListener(new ActionListener() {
                           @Override
                           public void actionPerformed(ActionEvent evt) {
                                Dialog.show("Dialog", "Comfirm deleting", "OK", "Annuler");
                  
                  sm.deletMessage(ev.getId_Message());
                    new ChatForm(ide).show();
                           }
                       }
             );
            l.getAllStyles().setMarginRight(RIGHT);
            l.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));

             l1.getAllStyles().setFont(Font.createSystemFont(Font.FACE_SYSTEM, Font.STYLE_BOLD, Font.SIZE_SMALL));
             aareth.addAll(lname,l);
                 title.add(imgV);
            title.add(ph);
            title.add(aareth);
              title.add(l1);
              title.add(delet);
               }
              
            
            //C1.add(i);
            //bouhom.add(ph);
          //  bouhom.add(lc);
         
            bouhom.add(title);
            bouhom.add(C2);
            bouhom.add(ctnnb);

            bouhom.add(sepa);
     
           
            bouhom.setLeadComponent(title);
            add(bouhom);
         
            add(test);
          
            
               }
               
                 
               TextField tfName = new TextField("","Message");
           
                Button btnValider = new Button("send 👋");
                btnValider.addActionListener(new ActionListener() {
             @Override
             public void actionPerformed(ActionEvent evt) {
           ServiceMessagerie sm = new ServiceMessagerie();
                        Message t = new Message(tfName.getText());
                       int aa= Integer.parseInt(te.getText());
                       System.err.println("heeeellllllllllo"+aa);
                        if( ServiceMessagerie.getInstance().addMessage(t,ide,getCurrentSession().getId(),aa))
                          //  Dialog.show("Success","Connection accepted",new Command("OK"));
                              Dialog.show("Success", "Message send", "OK", "Annuler");
                        new ChatForm(ide).show();
                
                
            }
         });
             
           
               add(tfName);
               add(btnValider);
               add(teste);
              
               
               
              
              
               
              
              
              
              
              
              
              
         
       
      
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!

    public static class show {

        public show() {
        }
    }
      private void showToast(String text) {
        Image errorImage = FontImage.createMaterial(FontImage.MATERIAL_ERROR, UIManager.getInstance().getComponentStyle("Title"), 4);
        ToastBar.Status status = ToastBar.getInstance().createStatus();
        status.setMessage(text);
        status.setIcon(errorImage);
        status.setExpires(2000);
        status.show();
    }
      private void setImage(String filePath, ImageViewer iv) {
            try {
                Image i1 = Image.createImage(filePath);
                iv.setImage(i1);
                iv.getParent().revalidate();
            } catch (Exception ex) {
                
                Dialog.show("Error", "Error during image loading: " + ex, "OK", null);
            }
    }
}
