/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.Service;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
/**
 *
 * @author HP
 */
public class filetourl {
    
    public static void main(String[] args) {
		File file = new File("C:/Program Files/Java/jdk1.8.0_71/COPYRIGHT");
		if (file.exists()) {
			System.out.println("PATH: " + file.getPath());

			// Convert file to URI
			URI uri = file.toURI();
			System.out.println("URI: " + uri.toString());

		
			

		}
                return ;
	}
    
    
}
