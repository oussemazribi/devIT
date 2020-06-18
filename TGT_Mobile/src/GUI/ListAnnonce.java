/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.capture.Capture;
import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.FileSystemStorage;
import com.codename1.io.Util;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import Entities.Annonce;
import Entities.Categorie;
import Services.AnnonceService;
import java.io.IOException;
import java.util.ArrayList;
import static Entities.Session.getCurrentSession;


/**
 *
 * @author ousse
 */
public class ListAnnonce extends BaseForm {
    Form f ;    
    public ArrayList<Annonce> annonces = new ArrayList<>(); 
    AnnonceService annS = new AnnonceService();
    private EncodedImage placeHolder;
    com.codename1.ui.util.Resources resourceObjectInstance;


    public ListAnnonce(Resources res , int c  ){
        f =new Form(" Annonces");
        f=this;
        ComboBox<Categorie> anns = new ComboBox<>();
                    annonces = annS.getAnnonces();
                    anns.addItem(new Categorie(0, "Choisir une categorie"));
      for (Categorie s : annS.getCaegories()){
          anns.addItem(s);
      } 
 
      anns.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent evt) {
             new ListAnnonce(res, anns.getSelectedItem().getId()).getF().show();
               
            }
        });
      if(c == 0 ){
          annonces = annS.getAnnonces();
      }else {
          annonces = annS.getAnnonceByCat(c);
      }
       f.getStyle().setBgColor(0xFFFFFF);
      Container table  = new Container(BoxLayout.y());
            f.add(anns);

        for (Annonce s : annonces){
      Container content = new Container(BoxLayout.x() );
      Container detail = new Container(BoxLayout.y());
     Container detail2 = new Container(BoxLayout.y());
          Container action = new Container(BoxLayout.y());
     Container cell = new Container(BoxLayout.y());
     
     //placeHolder = EncodedImage.createFromImage(Image.createImage(f.getWidth(), f.getWidth() / 5, 0xffff0000), false);
           // String url = Statics.BASE_URL + List.get(i).getImage();
         
            String url = "http://localhost/Intégration_Web/web/uploads";
            System.out.println(url);
//            ConnectionRequest connection = new ConnectionRequest();
//            connection.setUrl(url);
//            URLImage imgurl = URLImage.createToStorage(placeHolder, url, url);
//            ImageViewer img = new ImageViewer(imgurl.scaled(imgurl.getWidth()  , imgurl.getHeight() *2 ));

Image placeholder1 = Image.createImage(f.getWidth(),500);
                EncodedImage en = EncodedImage.createFromImage(placeholder1, false);
                URLImage urli = URLImage.createToStorage(en, s.getImages(), url + "/" +s.getImages());
                ImageViewer img = new ImageViewer();
                img.setImage(urli);
            

  Button modifer = new Button("Modifier");
                    modifer.addActionListener((evt) -> {
                        new ModifierAnnonce(res, s).getF().show();
                    }); 
                       Button supprimer = new Button("Supprimer");
                    supprimer.addActionListener((evt) -> {
                        annS.deleteAnnonce(s.getId());
           Dialog.show("", "Annonce  "+s.getNom()+" est supprimeé", "ok",null);
     new ListAnnonce(res, anns.getSelectedItem().getId()).getF().show();


                    }); 
                       Button Reserver = new Button("Interessé");
                    Reserver.addActionListener((evt) -> {
                       
           new Inters(res).getF().show();
              
                    }); 
      
          Label nom = new Label("Nom :"+s.getNom()); 
          Label cat = new Label("Categorie :"+s.getCategorie()); 
          Label prix = new Label("Prix : "+s.getPrix()+"€");
          Label etat = new Label("Etat : "+s.getEtat());
          Label desc = new Label("Utilisateur : "+s.getUser());
          Label date = new Label("Date : "+s.getDate());

if(s.getIduser()==getCurrentSession().getId()){
        action.add(supprimer);
        action.add(modifer);

}else {
    action.add(Reserver);
}
            
          
          detail2.add(nom);
          detail2.add(cat);
          detail2.add(etat);
          detail.add(prix);
                  detail.add(date);
                   detail.add(desc);
           content.add(detail2);
           content.add(detail);
           cell.add(img);
           cell.add(content);
           cell.add(action);
table.add(cell);
table.add(new Label("_______________________________________________________________________"));
      }
//                   Toolbar tb=f.getToolbar();
//       
//          
//            tb.addMaterialCommandToSideMenu("Ajouter une Annonce ",FontImage.MATERIAL_SHOPPING_BASKET, (e)->{
//                new AddAnnonce(res).getF().show();
//        });
//            tb.addMaterialCommandToSideMenu("Liste des annonces ",FontImage.MATERIAL_SHOPPING_BASKET, (e)->{
//                new ListAnnonce(res,0).getF().show();
//        });
f.add(table);
f.getToolbar().addMaterialCommandToOverflowMenu("Ajouter Annonce", FontImage.MATERIAL_ADD_CIRCLE, (e) -> {
            new AddAnnonce(res).getF().show();
    });


installSidemenu(resourceObjectInstance);
    }
    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
     protected boolean isCurrentTrending() {
        return true;
    }
    
}
