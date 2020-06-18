/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tgtnew;

import entities.Medias;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author asus
 */
public class MediaFactory implements Callback<ListView<Medias>, ListCell<Medias>>{

    @Override
    public ListCell<Medias> call(ListView<Medias> param) {
         return new Mediacell();
    }
    
}
