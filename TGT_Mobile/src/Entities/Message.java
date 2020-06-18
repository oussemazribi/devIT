/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entities;
import java.util.Date;
/**
 *
 * @author HP
 */
public class Message {
       private int id_Message;
    private int id_Sender;
    private int id_Receiver;
    private String Contenu;
     private String Etat = "Not_Seen";
    private Date Date_Message;
    private int id_Conversation;
    public Message() {
    }
    public Message(int id_Message, int id_Sender, int id_Receiver, String Contenu, Date Date_Message, int id_Conversation) {
        this.id_Message = id_Message;
        this.id_Sender = id_Sender;
        this.id_Receiver = id_Receiver;
        this.Contenu = Contenu;
        this.Date_Message = Date_Message;
        this.id_Conversation = id_Conversation;
    }
    public Message(int id_Sender, int id_Receiver, String Contenu) {
        this.id_Sender = id_Sender;
        this.id_Receiver = id_Receiver;
        this.Contenu = Contenu;
    }
    public Message(String Contenu) {
        this.Contenu = Contenu;
    }
    @Override
    public String toString() {
        return "Message{" + "id_Message=" + id_Message + ", id_Sender=" + id_Sender + ", id_Receiver=" + id_Receiver + ", Contenu=" + Contenu + ", Etat=" + Etat + ", Date_Message=" + Date_Message + ", id_Conversation=" + id_Conversation + '}';
    }
    public int getId_Message() {
        return id_Message;
    }
    public void setId_Message(int id_Message) {
        this.id_Message = id_Message;
    }
    public int getId_Sender() {
        return id_Sender;
    }
    public void setId_Sender(int id_Sender) {
        this.id_Sender = id_Sender;
    }
    public int getId_Receiver() {
        return id_Receiver;
    }
    public void setId_Receiver(int id_Receiver) {
        this.id_Receiver = id_Receiver;
    }
    public String getContenu() {
        return Contenu;
    }
    public void setContenu(String Contenu) {
        this.Contenu = Contenu;
    }
    public String getEtat() {
        return Etat;
    }
    public void setEtat(String Etat) {
        this.Etat = Etat;
    }
    public Date getDate_Message() {
        return Date_Message;
    }
    public void setDate_Message(Date Date_Message) {
        this.Date_Message = Date_Message;
    }
    public int getId_Conversation() {
        return id_Conversation;
    }
    public void setId_Conversation(int id_Conversation) {
        this.id_Conversation = id_Conversation;
    }
}