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
import static Entities.Session.getCurrentSession;
import com.codename1.components.ImageViewer;
import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.util.Resources;
import java.io.IOException;


/**
 * Utility methods common to forms e.g. for binding the side menu
 *
 * @author Shai Almog
 */
public class BaseForm extends Form {
    
     Form current;
     private Resources theme;
     String url = "http://localhost/Intégration_Web/web/uploads";
    public void installSidemenu(Resources res) {
         try {
             Image selection = Image.createImage("/selection-in-sidemenu.png");
             
             Image inboxImage = null;
             if(isCurrentInbox()) inboxImage = selection;
             
             Image trendingImage = null;
             if(isCurrentTrending()) trendingImage = selection;
             
             Image calendarImage = null;
             if(isCurrentCalendar()) calendarImage = selection;
             
             Image statsImage = null;
             if(isCurrentStats()) statsImage = selection;
             
             Button inboxButton = new Button("Inbox", inboxImage);
             inboxButton.setUIID("SideCommand");
             inboxButton.getAllStyles().setPaddingBottom(0);
             Container inbox = FlowLayout.encloseMiddle(inboxButton,
                     new Label("18", "SideCommandNumber"));
             inbox.setLeadComponent(inboxButton);
             inbox.setUIID("SideCommand");
             //inboxButton.addActionListener(e -> new InboxForm().show());
             getToolbar().addComponentToSideMenu(inbox);
             
             getToolbar().addCommandToSideMenu("Message", statsImage, e -> new InboxForm().show());
             getToolbar().addCommandToSideMenu("Compétition", calendarImage, 
                     
                     e -> {
                         if(getCurrentSession().getTypecompte().equals("Chasseur du talent"))
                             new afficherComp(current).show();
                         else
                             new afficherCompUser(current).show();
                     }
                         
             
             );
             getToolbar().addCommandToSideMenu("Trending", null, e -> {});
             getToolbar().addCommandToSideMenu("Annonce", trendingImage, e -> new ListAnnonce(theme , 0).getF().show());
             getToolbar().addCommandToSideMenu("Logout", null, e -> new SignInForm(res).show());
             
             Image placeholder = Image.createImage(300, 250);
            EncodedImage enc = EncodedImage.createFromImage(placeholder, false);
            URLImage urlim = URLImage.createToStorage(enc, getCurrentSession().getImguser(), url + "/" + getCurrentSession().getImguser());
            ImageViewer imgV = new ImageViewer();
            imgV.setImage(urlim);
             
             // spacer
             getToolbar().addComponentToSideMenu(new Label(" ", "SideCommand"));
            getToolbar().addComponentToSideMenu(new Label(urlim, "Container"));
             getToolbar().addComponentToSideMenu(new Label(getCurrentSession().getUsername(), "SideCommandNoPad"));
             getToolbar().addComponentToSideMenu(new Label(getCurrentSession().getTypecompte(), "SideCommandSmall"));             
              getToolbar().addComponentToSideMenu(new Label(String.valueOf(getCurrentSession().getNbdiament())+"  Diamond", "SideCommandSmall"));

             
         } catch (IOException ex) {
             System.out.println(ex.getMessage());
         }
    }

        
    protected boolean isCurrentInbox() {
        return false;
    }
    
    protected boolean isCurrentTrending() {
        return false;
    }

    protected boolean isCurrentCalendar() {
        return false;
    }

    protected boolean isCurrentStats() {
        return false;
    }
}
