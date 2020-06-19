/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.capture.Capture;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import Entities.Annonce;
import Entities.Categorie;
import Services.AnnonceService;
import java.io.IOException;
import rest.file.uploader.tn.FileUploader;
import static Entities.Session.getCurrentSession;

/**
 *
 * @author ousse
 */
public class AddAnnonce  extends BaseForm{
    Form f ; 
    
     private FileUploader file;
    
    String fileNameInServer;
    
    private String imgPath;
    com.codename1.ui.util.Resources resourceObjectInstance;
    
    public AddAnnonce(Resources res){
                f = new Form("Ajouter une Annonce ");
                f=this;
                        f.getStyle().setBgColor(0xFFFFFF);

                        Container x = new Container(BoxLayout.y());
Label l = new Label(" Nom:");
Label l2 = new Label(" Prix:");
Label l3 = new Label(" Description:");
             TextField nom = new TextField("", "Nom");
             TextField prix = new TextField("", "Prix");
             TextField description = new TextField("", "Description",20,TextField.ANY);
             ComboBox<Categorie> categorie = new ComboBox<>();
             for (Categorie c  : new AnnonceService().getCaegories()) {
                 categorie.addItem(c);
                   }
            Button adImage = new Button("Choisir une image");
                 adImage.addPointerReleasedListener(new ActionListener() {
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
                    //FileUploader fu = new FileUploader("http://localhost:8080/PI/web");
                    fileNameInServer = fu.upload(news);
                 //   path.setText(fileNameInServer);

                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (Exception ex) {
                }
            }
        }); 
                    Button ajouter = new Button("Ajoute une nouvelle annonce");
                    ajouter.addActionListener((ActionEvent evt) -> {
                        if(nom.getText().isEmpty() || prix.getText().isEmpty() || description.getText().isEmpty()){
                            Dialog.show("Erreur", "Veuilliez remplir tous les champs ", "ok",null);
                        }else {
                        
                             try {
           new AnnonceService().addAnnonce(getCurrentSession().getId(), categorie.getSelectedItem().getId(), nom.getText(), description.getText(), Integer.parseInt(prix.getText()),fileNameInServer);
            new ListAnnonce(res, 0).getF().show();

                   
                        } catch (Exception e) {
                                 System.out.println(e);
                                 Dialog.show("Erreur", "Saisir un prix valide ", "ok",null);

                        }
                        }
                       
                    });
//                      Toolbar tb=f.getToolbar();
//       
//          
//            tb.addMaterialCommandToSideMenu("Ajouter une Annonce ",FontImage.MATERIAL_SHOPPING_BASKET, (e)->{
//                new AddAnnonce(res).getF().show();
//        });
//            tb.addMaterialCommandToSideMenu("Liste des annonces ",FontImage.MATERIAL_SHOPPING_BASKET, (e)->{
//                new ListAnnonce(res,0).getF().show();
//        });
                  Label categ = new Label("Categorie");
                   x.add(l);
                                      x.add(nom);

                   x.add(l2);
                   x.add(prix);
                   x.add(categ);
                   x.add(categorie);
                   x.add(l3);
                   x.add(description);
                   x.add(adImage);
                   x.add(ajouter);
                   f.add(x);
                   
        installSidemenu(resourceObjectInstance);
    }

    public Form getF() {
        return f;
    }

    public void setF(Form f) {
        this.f = f;
    }
     protected boolean isCurrentStats() {
        return true;
    }
    
}
