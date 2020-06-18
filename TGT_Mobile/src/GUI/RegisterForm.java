/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

/**
 *
 * @author loume78
 */
import Entities.fos_user;
import Services.ServiceUser;
import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import static com.codename1.ui.Component.BASELINE;
import static com.codename1.ui.Component.CENTER;
import com.codename1.ui.Container;

import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;

import java.io.IOException;
import rest.file.uploader.tn.FileUploader;


/**
 * GUI builder created Form
 *
 * @author Shai Almog
 */
public class RegisterForm extends Form {
    
    private static fos_user User;
    Form current;
    String fileNameInServer;
    
    private String imgPath;
  

    public RegisterForm() {
        this(com.codename1.ui.util.Resources.getGlobalResources());
    }
    
    public RegisterForm(com.codename1.ui.util.Resources resourceObjectInstance) {
        
        initGuiBuilderComponents(resourceObjectInstance);
        getTitleArea().setUIID("Container");
        getToolbar().setUIID("Container");
        getToolbar().getTitleComponent().setUIID("SigninTitle");
        FontImage mat = FontImage.createMaterial(FontImage.MATERIAL_CLOSE, "SigninTitle", 3.5f);
        //getToolbar().addCommandToLeftBar("", mat, e -> new SplashForm().show());
        getContentPane().setUIID("SignInForm");
    }

//-- DON'T EDIT BELOW THIS LINE!!!
    private com.codename1.ui.Container gui_Container_1 = new com.codename1.ui.Container(new com.codename1.ui.layouts.BoxLayout(com.codename1.ui.layouts.BoxLayout.Y_AXIS));
    private com.codename1.ui.Label gui_Label_1 = new com.codename1.ui.Label();
    private com.codename1.ui.ComponentGroup gui_Component_Group_1 = new com.codename1.ui.ComponentGroup();
    private com.codename1.ui.TextField gui_Text_Field_2 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_1 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_3 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_4 = new com.codename1.ui.TextField();
    private com.codename1.ui.TextField gui_Text_Field_5 = new com.codename1.ui.TextField();
    private com.codename1.ui.Button gui_Button_2 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_3 = new com.codename1.ui.Button();
    private com.codename1.ui.Button gui_Button_1 = new com.codename1.ui.Button();
    private com.codename1.ui.ComboBox cb1 = new com.codename1.ui.ComboBox() ;


// <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void guiBuilderBindComponentListeners() {
        EventCallbackClass callback = new EventCallbackClass();
        gui_Button_2.addActionListener(callback);
    }

    class EventCallbackClass implements com.codename1.ui.events.ActionListener, com.codename1.ui.events.DataChangedListener {
        private com.codename1.ui.Component cmp;
        public EventCallbackClass(com.codename1.ui.Component cmp) {
            this.cmp = cmp;
        }

        public EventCallbackClass() {
        }

        public void actionPerformed(com.codename1.ui.events.ActionEvent ev) {
            com.codename1.ui.Component sourceComponent = ev.getComponent();
            if(sourceComponent.getParent().getLeadParent() != null) {
                sourceComponent = sourceComponent.getParent().getLeadParent();
            }

            if(sourceComponent == gui_Button_2) {
               // onButton_2ActionEvent(ev);
            }
        }

        public void dataChanged(int type, int index) {
        }
    }
    private void initGuiBuilderComponents(com.codename1.ui.util.Resources resourceObjectInstance) {
        
           Image im1 , im2;
        try {
            im1 = Image.createImage("/login.jpg");
            ImageViewer v1 = new ImageViewer(im1);
            v1.setHeight(1);
            v1.setWidth(1);
            v1.setX(CENTER);
            
      
        guiBuilderBindComponentListeners();
        setLayout(new com.codename1.ui.layouts.BorderLayout());
        setTitle("Register");
        setName("SignInForm");
         Button picture = new Button("parcourir");
        picture.setMaterialIcon(FontImage.MATERIAL_CLOUD_UPLOAD);
        
        TextField path = new TextField("", "aucun fichier choisi");
        path.setMaxSize(BASELINE);
        
        Container cc = new Container(BoxLayout.x());
        cc.setName("Cover Image");
        
        addComponent(com.codename1.ui.layouts.BorderLayout.CENTER, gui_Container_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Container_1.addComponent(gui_Label_1);
        gui_Container_1.add(v1);
        gui_Container_1.addComponent(gui_Component_Group_1);
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Component_Group_1.addComponent(gui_Text_Field_2);
        gui_Component_Group_1.addComponent(gui_Text_Field_1);
        gui_Component_Group_1.addComponent(cb1);
        gui_Component_Group_1.addComponent(gui_Text_Field_4);
        gui_Component_Group_1.addComponent(cc);
       
      
        gui_Text_Field_2.setText("Username");
        gui_Text_Field_2.setName("Text_Field_2");
        gui_Text_Field_1.setText("Password");
        gui_Text_Field_1.setName("Text_Field_1");

        cb1.addItem("Simple Utilisateur");
        cb1.addItem("Chasseur du talent");
        gui_Text_Field_4.setText("Email");
        gui_Text_Field_4.setName("Text_Field_4");
        gui_Text_Field_5.setText("photo");
        gui_Text_Field_5.setName("Text_Field_5");
        gui_Container_1.addComponent(gui_Button_2);
        gui_Container_1.addComponent(gui_Button_3);
        gui_Label_1.setUIID("CenterLabel");
        gui_Label_1.setName("Label_1");
        //gui_Label_1.setIcon(resourceObjectInstance.getImage("profile_image.png"));
        gui_Component_Group_1.setName("Component_Group_1");
        gui_Button_2.setText("Register");
        gui_Button_2.setName("Button_2");
        
       
        
        picture.addPointerReleasedListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                try {
                    imgPath = Capture.capturePhoto();

                    System.out.println(imgPath);
                    String link = imgPath.toString();
                    int pod = link.indexOf("/", 2);
                    String news = link.substring(pod + 2, link.length());
                    System.out.println("" + news);

                    FileUploader fu = new FileUploader("http://localhost/Intégration_Web/web");

                    fileNameInServer = fu.upload(news);
                    path.setText(fileNameInServer);

                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                }
            }
        });
        
        

        cc.add(picture);
        cc.add(path);
        
        gui_Button_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
               
                 fos_user f = new fos_user(gui_Text_Field_2.getText(), gui_Text_Field_4.getText(), gui_Text_Field_1.getText(), cb1.getSelectedItem().toString(), path.getText().toString()) ;
               ServiceUser su = new ServiceUser() ;
          
               
               su.addUser(f);
               new SignInForm().show() ;

               
            }
        });
        
        gui_Button_3.setText("");
        gui_Button_3.setUIID("CenterLabelSmall");
        gui_Button_3.setName("Button_3");
        addComponent(com.codename1.ui.layouts.BorderLayout.SOUTH, gui_Button_1);
        gui_Container_1.setScrollableY(true);
        gui_Container_1.setName("Container_1");
        gui_Button_1.setText("SignIN");
        gui_Button_1.setUIID("CenterLabel");
        gui_Button_1.setName("Button_1");
        gui_Button_1.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent evt) {
                 new SignInForm().show() ;
                }
            });
        
          } catch (IOException ex) {
           
        }
    }// </editor-fold>

//-- DON'T EDIT ABOVE THIS LINE!!!
//    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
//        new InboxForm().show();
//    }

 



//-- DON'T EDIT ABOVE THIS LINE!!!
    public void onButton_2ActionEvent(com.codename1.ui.events.ActionEvent ev) {
   //   new InboxForm().show();
    }
  
    

}
