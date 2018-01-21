package RPS;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

/* This class creates the conditions for the game and graphically organizes it */

public class PaneOrganizer {
	
	private BorderPane _borderPane;
	private Options _userOption;
	private Options _computerOption;
	private Label _label;
 
	/* instantiates the borderPane and the label for the game. The constructor also calls the set up buttons method in order for the buttons to show up*/
	public PaneOrganizer() {
		_borderPane = new BorderPane();

		_label = new Label("choose rock, paper or scissors please");
		_borderPane.setStyle("-fx-background-color: #e6e6ff");
		Pane gamePane = new Pane();
		_borderPane.setCenter(gamePane);
		_label.toFront();
		this.setUpButtons();
		gamePane.getChildren().add(_label);
	
		
		
	
	}
	
	/* allows the app to know about the borderPane in order for the game to run */

	public Pane getRoot() {
		return _borderPane;
	}
	
	/* graphically creates the buttons and what actions that have*/


	private void setUpButtons() {
		HBox buttonPane = new HBox();
		Button rock = new Button("rock");
		Button paper = new Button("paper");
		Button scissors = new Button("scissors");
		Button start = new Button("start");
		Button playAgain = new Button("play again");
		rock.setOnAction(new RockHandler());
		paper.setOnAction(new PaperHandler());
		scissors.setOnAction(new ScissorsHandler());
		start.setOnAction(new StartHandler());
		playAgain.setOnAction(new PlayHandler());
		_borderPane.setBottom(buttonPane);
		buttonPane.setSpacing(Constants.BUTTON_SPACING);
		buttonPane.getChildren().addAll(rock, paper, scissors, start, playAgain);
		buttonPane.setFocusTraversable(false);

	}
	
	/* makes the computer use Math.random to randomly choose a choice*/

	public void randomOption() {
		int rand = (int) (Math.random() * 3);
		_computerOption = null;
		switch (rand) {
		case 0:
			_computerOption = Options.ROCK;
			break;
		case 1:
			_computerOption = Options.PAPER;
			break;
		case 2:
			_computerOption = Options.SCISSORS;
			break;
		default:
			_computerOption = Options.ROCK;
		}
	}
	
	/* creates the conditions of the game to see who wins or loses*/

	public void game() {
		if (_userOption == _computerOption) {
			_label.setText("it is a tie!");
		} else if ((_userOption == Options.ROCK && _computerOption == Options.SCISSORS)
				|| (_userOption == Options.PAPER && _computerOption == Options.ROCK)
				|| (_userOption == Options.SCISSORS && _computerOption == Options.PAPER)) {
			_label.setText("YOU WIN!           The computer picked " + _computerOption);
		} else if (_userOption == null){
			_label.setText("choose rock, paper or scissors please");

		} else {
			_label.setText("YOU LOSE!         The computer picked " + _computerOption);
		}
	}
	
	/* if the rock button is clicked than the user option is rock */

	private class RockHandler implements EventHandler<ActionEvent> {

		

		public void handle(ActionEvent option) {
			_userOption = Options.ROCK;
		}
	}
	
	/* if the paper button is clicked than the user option is paper */

	private class PaperHandler implements EventHandler<ActionEvent> {

		

		public void handle(ActionEvent option) {
			_userOption = Options.PAPER;
		}
	}

	/* if the scissor button is clicked than the user option is scissors */
	private class ScissorsHandler implements EventHandler<ActionEvent> {



		public void handle(ActionEvent option) {
			_userOption = Options.SCISSORS;
		}
	}
	
	/* when the start button is clicked then the computer picks a random choice and the game conditions are checked*/

	private class StartHandler implements EventHandler<ActionEvent> {

		

		public void handle(ActionEvent option) {
			PaneOrganizer.this.randomOption();
			PaneOrganizer.this.game();
		}
	}
	
	
	/* This sets the user and the computers options back to null when the game is restarted*/
	
	private class PlayHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent option) {
			_computerOption = null;
			_userOption = null;
			_label.setText("choose rock, paper or scissors please");
		}
	}

}
