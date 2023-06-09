package hust.soict.dsai.aims.screen;

import java.io.IOException;

import javax.swing.JFrame;

import hust.soict.dsai.aims.store.Store;
import javafx.application.Platform;
import javafx.embed.swing.JFXPanel;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class AddCompactDiscToStoreScreen extends JFrame 
{
    private Store store;

    public AddCompactDiscToStoreScreen(Store store)
    {
        super();

        this.store = store;

        JFXPanel fxPanel = new JFXPanel();
        this.add(fxPanel);
        this.setTitle("Add CD To Store");
        this.setSize(1024, 768);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setVisible(false);
        Platform.runLater(new Runnable()
        {
            @Override
            public void run()
            {
                try {
                    FXMLLoader loader = new FXMLLoader(
                        getClass().getResource("addCD.fxml")
                    );
                    AddCDToStoreController controller = new AddCDToStoreController(store);
                    loader.setController(controller);
                    Parent root = loader.load();
                    fxPanel.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}