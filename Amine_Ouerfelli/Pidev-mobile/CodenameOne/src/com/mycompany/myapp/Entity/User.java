/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Entity;

import com.codename1.io.Externalizable;
import com.codename1.io.Util;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 *
 * @author asus
 */
public class User implements Serializable,Externalizable {
    private Integer id;
    private String username;
    private String usernameCanonical;
    private String email;
    private String emailCanonical;
    private boolean enabled;
    private String salt;
    private String password;
    private Date lastLogin;
    private String confirmationToken;
    private Date passwordRequestedAt;
    private String roles;
    private String typecompte;
    private String prenom;
    private String numtel;
    private String imguser;
    private int nbdiament;
    private String typetalent;

    public User(Integer id, String username, String imguser) {
        this.id = id;
        this.username = username;
        this.imguser = imguser;
    }

    public User() {
       
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUsernameCanonical() {
        return usernameCanonical;
    }

    public void setUsernameCanonical(String usernameCanonical) {
        this.usernameCanonical = usernameCanonical;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmailCanonical() {
        return emailCanonical;
    }

    public void setEmailCanonical(String emailCanonical) {
        this.emailCanonical = emailCanonical;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(Date lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getConfirmationToken() {
        return confirmationToken;
    }

    public void setConfirmationToken(String confirmationToken) {
        this.confirmationToken = confirmationToken;
    }

    public Date getPasswordRequestedAt() {
        return passwordRequestedAt;
    }

    public void setPasswordRequestedAt(Date passwordRequestedAt) {
        this.passwordRequestedAt = passwordRequestedAt;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    public String getTypecompte() {
        return typecompte;
    }

    public void setTypecompte(String typecompte) {
        this.typecompte = typecompte;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNumtel() {
        return numtel;
    }

    public void setNumtel(String numtel) {
        this.numtel = numtel;
    }

    public String getImguser() {
        return imguser;
    }

    public void setImguser(String imguser) {
        this.imguser = imguser;
    }

    public int getNbdiament() {
        return nbdiament;
    }

    public void setNbdiament(int nbdiament) {
        this.nbdiament = nbdiament;
    }

    public String getTypetalent() {
        return typetalent;
    }

    public void setTypetalent(String typetalent) {
        this.typetalent = typetalent;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getAbsoluteImage() {
        return absoluteImage;
    }

    public void setAbsoluteImage(String absoluteImage) {
        this.absoluteImage = absoluteImage;
    }

    public String getWebImage() {
        return webImage;
    }

    public void setWebImage(String webImage) {
        this.webImage = webImage;
    }
    private String file;
    private String absoluteImage;
    private String webImage;

    public User(Integer id, String username, String usernameCanonical, String email, String emailCanonical, boolean enabled, String salt, String password, Date lastLogin, String confirmationToken, Date passwordRequestedAt, String roles, String typecompte, String prenom, String numtel, String imguser, int nbdiament, String typetalent, String file, String absoluteImage, String webImage) {
        this.id = id;
        this.username = username;
        this.usernameCanonical = usernameCanonical;
        this.email = email;
        this.emailCanonical = emailCanonical;
        this.enabled = enabled;
        this.salt = salt;
        this.password = password;
        this.lastLogin = lastLogin;
        this.confirmationToken = confirmationToken;
        this.passwordRequestedAt = passwordRequestedAt;
        this.roles = roles;
        this.typecompte = typecompte;
        this.prenom = prenom;
        this.numtel = numtel;
        this.imguser = imguser;
        this.nbdiament = nbdiament;
        this.typetalent = typetalent;
        this.file = file;
        this.absoluteImage = absoluteImage;
        this.webImage = webImage;
    }

    @Override
    public int getVersion() {
        return 1;
    }

    @Override
    public void externalize(DataOutputStream out) throws IOException {
        Util.writeObject(id, out);
        Util.writeObject(username, out);
        Util.writeObject(imguser, out);
    }

    @Override
    public void internalize(int version, DataInputStream in) throws IOException {
        id = (Integer) Util.readObject(in);
        username = (String) Util.readObject(in);
        salt = (String) Util.readObject(in);
        imguser = (String) Util.readObject(in);
    }

    @Override
    public String getObjectId() {
      return "User"; 
    }
    public static User createUser(Map<String,Object> mappedUser)
    {
        User user = new User();
        user.setId((int)Float.parseFloat(mappedUser.get("id").toString()));
        if(mappedUser.get("username") != null)
            user.setUsername(mappedUser.get("username").toString());
        if(mappedUser.get("imguser") != null)
            user.setImguser(mappedUser.get("imguser").toString());
        if(mappedUser.get("password")!=null)
            user.setPassword(mappedUser.get("password").toString());
         if(mappedUser.get("email")!=null)
            user.setPassword(mappedUser.get("password").toString());
        return user;
    }
    
    
}
