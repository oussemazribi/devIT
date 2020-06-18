/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.Utils;

import com.codename1.components.ImageViewer;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;

/**
 *
 * @author hero
 */
public class Imageservices {
    
    private static Imageservices Imageservices;
    
    private Imageservices(){}
    
    public static Imageservices getInstance()
    {
        if(Imageservices == null) Imageservices = new Imageservices();
        return Imageservices;
    }
    
    public Image getImageFromURL(String url)
    {
        try {
            ConnectionRequest request = new ConnectionRequest();
            request.setUrl("http://localhost/CGT/uploads/"+url);
            NetworkManager.getInstance().addToQueueAndWait(request);
            Image image = Image.createImage(new ByteArrayInputStream(request.getResponseData()));
            return image.scaled(64, 64);
        } catch (IOException ex) {
        }
        
        return null;
    }
    
	public Image getImageAlbumFromURL(String src)
    {   Image img=null;
        ImageViewer iv=null;
        EncodedImage ec;
        String url ="http://localhost/Fos/web/uploads/Mixed/"+src;
        try {
            ec=EncodedImage.create("/logo.png");
            img=URLImage.createToStorage(ec,url,url,URLImage.RESIZE_SCALE);
            iv=new ImageViewer(img);
            return img;
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       return img;
      
    }
    
    public Image getImageProfilFromURL(String source)
    {   Image img=null;
        ImageViewer iv=null;
        EncodedImage ec;
        String url ="http://localhost/CGT/web/uploads/"+source;
        try {
            ec=EncodedImage.create("/logo.png");
            img=URLImage.createToStorage(ec,url,url,URLImage.RESIZE_SCALE);
            iv=new ImageViewer(img);
            return img.scaled(100,100);
        } catch (IOException ex) {
         
            System.out.println(ex.getMessage());
        }
       return img;
    }
        public Image getImageCommentaireFromURL(String source)
    {   Image img=null;
        ImageViewer iv=null;
        EncodedImage ec;
        String url ="http://localhost/Fos/web/uploads/"+source;
        try {
            ec=EncodedImage.create("/logo.png");
            img=URLImage.createToStorage(ec,url,url,URLImage.RESIZE_SCALE);
            iv=new ImageViewer(img);
            return img.scaled(60,60);
        } catch (IOException ex) {
     
            System.out.println(ex.getMessage());
        }
       return img;
    }
}