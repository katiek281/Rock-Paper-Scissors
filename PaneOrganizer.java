package RPS;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

public class PaneOrganizer {
	private BorderPane _borderPane;
	private HBox _buttonPane;
	private Options _userOption;
	private Options _computerOption;
	private Label _label;

	/*
	 * Creates a new border pane and instantiates the Pacman pane. Also instantiates
	 * the sidebar which takes in the pacman pane. This also called the set up
	 * button method
	 */

	public PaneOrganizer() {
		_borderPane = new BorderPane();

		_label = new Label("choose rock, paper or scissors please");
		_borderPane.setStyle("-fx-background-color: #e6e6ff");
		Pane gamePane = new Pane();
		_borderPane.setCenter(gamePane);
		_label.toFront();
		this.setUpButtons();
		//this.createImage();
		gamePane.getChildren().add(_label);
	
		
		
	
	}

	public Pane getRoot() {
		return _borderPane;
	}
	
	private void createImage() {
		Image rock = new Image("rock.png");
		ImageView iv1 = new ImageView();
         iv1.setImage(rock);
	}

	private void setUpButtons() {
		_buttonPane = new HBox();

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
		_borderPane.setBottom(_buttonPane);
		_buttonPane.setSpacing(26);
		_buttonPane.getChildren().addAll(rock, paper, scissors, start, playAgain);
		_buttonPane.setFocusTraversable(false);

	}

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

	private class RockHandler implements EventHandler<ActionEvent> {

		// this method quits my project

		public void handle(ActionEvent option) {
			_userOption = Options.ROCK;
		}
	}

	private class PaperHandler implements EventHandler<ActionEvent> {

		// this method quits my project

		public void handle(ActionEvent option) {
			_userOption = Options.PAPER;
		}
	}

	private class ScissorsHandler implements EventHandler<ActionEvent> {

		// this method quits my project

		public void handle(ActionEvent option) {
			_userOption = Options.SCISSORS;
		}
	}

	private class StartHandler implements EventHandler<ActionEvent> {

		// this method quits my project

		public void handle(ActionEvent option) {
			PaneOrganizer.this.randomOption();
			PaneOrganizer.this.game();
		}
	}
	
	private class PlayHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent option) {
			_computerOption = null;
			_userOption = null;
			_label.setText("choose rock, paper or scissors please");
		}
	}

}
