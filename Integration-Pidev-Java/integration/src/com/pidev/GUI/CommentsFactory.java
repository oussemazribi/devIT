/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.pidev.GUI;

import com.pidev.Entite.Commentaire;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author asus
 */
public class CommentsFactory implements Callback<ListView<Commentaire>, ListCell<Commentaire>> {
        @Override
    public ListCell<Commentaire> call(ListView<Commentaire> param) {
        return new CommentCell();
    }
}
