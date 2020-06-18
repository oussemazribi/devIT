/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.GUI;

import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.Form;
import com.codename1.ui.Image;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import static com.mycompany.myapp.GUI.addnewpost.MediaContainer;
import java.io.IOException;

/**
 *
 * @author asus
 */
public class Media extends Form {

    Form current;
    Resources theme;

    public Media() {
        setLayout(BoxLayout.y());
        getToolbar().addCommandToLeftBar("SOUTH", null, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                new addnewpost(theme).show();
            }
        });

        /* TreeModel tm = new TreeModel() {
            @Override
            public Vector getChildren(Object parent) {
                String[] files;
                if (parent == null) {
                    files = FileSystemStorage.getInstance().getRoots();
                    return new Vector<Object>(Arrays.asList(files));
                } else {
                    try {
                        files = FileSystemStorage.getInstance().listFiles((String) parent);
                    } catch (IOException err) {

                        files = new String[0];
                    }
                }
                String p = (String) parent;
                Vector result = new Vector();
                for (String s : files) {
                    result.add(p + s);
                }
                return result;
            }

            @Override
            public boolean isLeaf(Object node) {
                return !FileSystemStorage.getInstance().isDirectory((String) node);
            }
        };
        Tree t = new Tree(tm) {
            @Override
            protected String childToDisplayLabel(Object child) {
                String n = (String) child;
                int pos = n.lastIndexOf("/");
                if (pos < 0) {
                    return n;
                }
                return n.substring(pos);
            }
        };
        add(t);
         */

    }

}
