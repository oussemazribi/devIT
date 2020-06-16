/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Myapp.Utils;

import com.codename1.components.ImageViewer;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.Image;
import com.codename1.ui.URLImage;
import java.io.IOException;

/**
 *
 * @author BENTEKFA
 */
public class imageservices {
        private static imageservices imageservices;
    
    private imageservices(){}
    
    public static imageservices getInstance()
    {
        if(imageservices == null) imageservices = new imageservices();
        return imageservices;
    }
    
    public Image getImageAlbumFromURL(String src)
    {   Image img=null;
        ImageViewer iv=null;
        EncodedImage ec;
        String url ="http://localhost/symfony-api/web/uploads/Reclamation/"+src;
        try {
            ec=EncodedImage.create("/pho.jpg");
            img=URLImage.createToStorage(ec,url,url,URLImage.RESIZE_SCALE);
            iv=new ImageViewer(img);
            return img.scaled(200,200);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
       return img;
    }
}
