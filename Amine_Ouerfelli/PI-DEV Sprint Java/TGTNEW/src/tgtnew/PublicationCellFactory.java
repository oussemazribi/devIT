
package tgtnew;

import entities.Publication;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

/**
 *
 * @author asus
 */
public class PublicationCellFactory implements Callback<ListView<Publication>, ListCell<Publication>>{

    @Override
  public ListCell<Publication> call(ListView<Publication> param) {
        return new PublicationCell();
    }
  
}

