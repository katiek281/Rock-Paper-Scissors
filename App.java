package RPS;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
  * This is the  main class where your Pacman game will start.
  * The main method of this application calls the App constructor. The App class 
  * creates top-level object, sets up the scene and shows the stage.
  */

public class App extends Application {

    @Override
    public void start(Stage stage) {
        // this creates the top-level object, sets up the scene, and shows the stage.
    		stage.setTitle("RPS");
		PaneOrganizer organizer = new PaneOrganizer();
		Scene scene = new Scene(organizer.getRoot(), 400,
				400);
		stage.setScene(scene);
		stage.show();
    }

    /*
    * Here is the mainline! No need to change this.
    */
    public static void main(String[] argv) {
        // launch is a method inherited from Application
        launch(argv);
    }
}
