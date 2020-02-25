/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Entite;

public class Amitie {

    
private int idUser1 ;
private int idUser2 ;
private String Etat ;
private int SenderId ;
private int BlockId ;

    public void setIdUser1(int idUser1) {
        this.idUser1 = idUser1;
    }

    public void setIdUser2(int idUser2) {
        this.idUser2 = idUser2;
    }

    public void setEtat(String Etat) {
        this.Etat = Etat;
    }

    public void setSenderId(int SenderId) {
        this.SenderId = SenderId;
    }

    public void setBlockId(int BlockId) {
        this.BlockId = BlockId;
    }

    public int getIdUser1() {
        return idUser1;
    }

    public int getIdUser2() {
        return idUser2;
    }

    public String getEtat() {
        return Etat;
    }

    public int getSenderId() {
        return SenderId;
    }

    public int getBlockId() {
        return BlockId;
    }

    public Amitie(int idUser1, int idUser2, String Etat, int SenderId, int BlockId) {
       
        this.idUser1 = idUser1;
        this.idUser2 = idUser2;
        this.Etat = Etat;
        this.SenderId = SenderId;
        this.BlockId = BlockId;
    }

    @Override
    public String toString() {
        return "Amitie{"+ " idUser1=" + idUser1 + ", idUser2=" + idUser2 + ", Etat=" + Etat + ", SenderId=" + SenderId + ", BlockId=" + BlockId + '}';
    }
}
