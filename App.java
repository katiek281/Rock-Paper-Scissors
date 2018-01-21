package RPS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
  * This is the  main class where my game will start.
  * The main method of this application calls the App constructor. The App class 
  * creates top-level object, sets up the scene and shows the stage.
  */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // this creates the top-level object, sets up the scene, and shows the stage.
    		stage.setTitle("RPS");
		PaneOrganizer organizer = new PaneOrganizer();
		Scene scene = new Scene(organizer.getRoot(), Constants.APP_SIZE,
				Constants.APP_SIZE);
		stage.setScene(scene);
		stage.show();
    }

   
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
