/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author asus
 */
public class Medias {
    private int id;
    private String type;
    private String source;
    private String mediatype;
    private String Description;

    public Medias() {
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String Description) {
        this.Description = Description;
    }
    private int iduser;
    private int idpub;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getMediatype() {
        return mediatype;
    }

    public void setMediatype(String mediatype) {
        this.mediatype = mediatype;
    }

    public int getIduser() {
        return iduser;
    }

    public void setIduser(int iduser) {
        this.iduser = iduser;
    }

    public int getIdpub() {
        return idpub;
    }

    public void setIdpub(int idpub) {
        this.idpub = idpub;
    }

    public Medias(int id, String type, String source, String mediatype, int iduser, int idpub,String Description) {
        this.id = id;
        this.type = type;
        this.source = source;
        this.mediatype = mediatype;
        this.iduser = iduser;
        this.idpub = idpub;
        this.Description=Description;
    }
}
