/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import com.codename1.capture.Capture;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.util.Resources;
import com.nexmo.client.NexmoClient;
import com.nexmo.client.NexmoClientException;
import com.nexmo.client.sms.SmsSubmissionResponse;
import com.nexmo.client.sms.messages.TextMessage;
import java.io.IOException;

/**
 *
 * @author ousse
 */
public class Inters extends BaseForm {
        Form f ; 
            com.codename1.ui.util.Resources resourceObjectInstance;

        
        public  Inters(Resources res){
       f = new Form("Saisir votre numero ");
                       f=this;

       
            TextField numero = new TextField("","Veuillez saisir votre numero");
               Button interesser = new Button("Contacter ");
                    interesser.addActionListener((evt) -> {
                          NexmoClient client = new NexmoClient.Builder()
                         .apiKey("00262660")
  .apiSecret("aANPPiRX4BujaCL8")

                        .build();

                String messageText = "Un utilisateur est intéressé a votre annonce veuillez le contacter sur  :"+numero.getText() ;
                TextMessage message = new TextMessage("Annonce", "21625212148", messageText);
           Dialog.show("", "L'utilisateur est notifié", "ok",null);
           

                try {
                    SmsSubmissionResponse response = client.getSmsClient().submitMessage(message);
                } catch (IOException ex) {

                } catch (NexmoClientException ex) {

                }
                new ListAnnonce(res, 0).getF().show();
                    }); 
                    f.add(numero);
                    f.add(interesser);
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
