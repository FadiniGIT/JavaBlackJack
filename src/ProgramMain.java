
import java.util.Scanner;


import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;


public class ProgramMain extends Application{
	
	Button buttonH;
	Button buttonS;
	Button buttonB;
	Button buttonStart;
	
	MenuBar menu;
	Menu fileMenu;

	Label labelBet;
	Text testText;
	TextField betInput;
	
	
	public static void main(String[] args) {
		launch(args);
	}

/************************************************************/
	@Override
	public void start(Stage primaryStage) throws Exception{
/************************************************************/		
		Deck playingDeck = new Deck();
		
		playingDeck.createDeck();
		playingDeck.shuffleDeck();
		
		int i = 0;
		
		boolean endRound = false;
		
		//System.out.println(playingDeck);
		
/************************************************************/
// Creates the deck for the user and dealer
		Deck userDeck = new Deck();
		Deck dealerDeck = new Deck();
		
		double playerMoney = 100.00;
		
		Player player = new Player(playerMoney);
		
		Scanner userInput = new Scanner(System.in);
		
		Logic gameLogic = new Logic();
		
		Text gameDisplay = new Text();
		
		FileIO fileIO = new FileIO();
		
		
/************************************************************/
		primaryStage.setTitle("21");
				
		buttonH = new Button("      Hit     ");
		buttonS = new Button("   Stand   ");
		buttonB = new Button("   Bet   ");
		buttonStart = new Button("  Start  ");
		
		menu = new MenuBar();
		fileMenu = new Menu("File"); 
		fileMenu.setOnAction(e -> {
		fileIO.useFile();

		HighScoreWindow.display(fileIO);
		});
		
		labelBet = new Label("Bet Amount: ");
		betInput = new TextField();
		
		betInput.setPromptText("You have $100");
		testText = new Text("Input money and then start.");
		
		buttonS.setDisable(true);
		buttonH.setDisable(true);
		buttonH.setOnAction(e ->{	
			
			gameLogic.hit(gameDisplay, player, endRound, userInput, userDeck, playingDeck);
			if (userDeck.cardsValue() < 21) {
				gameLogic.showUserHand(gameDisplay, userDeck, dealerDeck);
			} else {
				gameLogic.lostToDealer(gameDisplay, player, endRound, dealerDeck, userDeck);
				gameLogic.dealerDrawCards(gameDisplay, player, endRound, playingDeck, dealerDeck, userDeck);
				gameLogic.dealerBusted(gameDisplay, player, endRound, dealerDeck, userDeck);
				gameLogic.userTied(gameDisplay, player, endRound, userDeck,  dealerDeck);
				gameLogic.userWinLoss(gameDisplay, player, endRound, userDeck, dealerDeck);
				gameLogic.moveCardsToDeck(gameDisplay, playingDeck, userDeck, dealerDeck, player);
				fileIO.useFile();
				fileIO.writeFile(player);
				
				buttonStart.setDisable(false);
				buttonS.setDisable(true);
				buttonH.setDisable(true);
			}
			if(player.getTotalMoney() <= 0) {
				System.out.println("Game over, you ran out of money.");
				buttonS.setDisable(true);
				buttonH.setDisable(true);
				buttonStart.setDisable(true);
			}
		});
	
		buttonS.setOnAction(e -> {
			gameLogic.printDealerHand(gameDisplay, dealerDeck);
			gameLogic.lostToDealer(gameDisplay, player, endRound, dealerDeck, userDeck);
			gameLogic.dealerDrawCards(gameDisplay, player, endRound, playingDeck, dealerDeck, userDeck);
			gameLogic.dealerBusted(gameDisplay, player, endRound, dealerDeck, userDeck);
			gameLogic.userTied(gameDisplay, player, endRound, userDeck,  dealerDeck);
			gameLogic.userWinLoss(gameDisplay, player, endRound, userDeck, dealerDeck);
			gameLogic.moveCardsToDeck(gameDisplay, playingDeck, userDeck, dealerDeck, player);
			fileIO.useFile();
			fileIO.writeFile(player);
			
			
			buttonStart.setDisable(false);
			buttonS.setDisable(true);
			buttonH.setDisable(true);
			
			if(player.getTotalMoney() <= 0) {
				buttonS.setDisable(true);
				buttonH.setDisable(true);
				buttonStart.setDisable(true);
			}
		});
		buttonB.setOnAction(e -> isNum(betInput, betInput.getText()));
		buttonStart.setOnAction(e ->{
			
			
			
			buttonStart.setText("  Bet  ");
			buttonStart.setDisable(true);
			buttonS.setDisable(false);
			buttonH.setDisable(false);
			
			try {
			    Integer.parseInt(betInput.getText());
			} catch(Exception x) {
			    System.out.println("Non-numeric character exist");
			    buttonS.setDisable(true);
				buttonH.setDisable(true);
				buttonStart.setDisable(false);
				buttonStart.setText("Enter a number and try again.");
			}
			
			double info = Double.parseDouble(betInput.getText());
			
			if (info > 0 && info <= player.getTotalMoney()) {
			
				
				
				try {
				
				
				int t = 0;
						
				if(t < 1) {
					gameLogic.moneyCheckinitial(gameDisplay, player, i, Double.parseDouble(betInput.getText()));
					t++;
				}else {
					gameLogic.moneyCheck(gameDisplay, player, i, Double.parseDouble(betInput.getText()));
				}
				gameLogic.drawUserDeck(playingDeck, userDeck);			
				gameLogic.drawDealerDeck(playingDeck, dealerDeck);
				gameLogic.showUserHand(gameDisplay, userDeck, dealerDeck);
			} catch (Exception e2) {
				betInput.setText("Enter a number.");
			}
			}else {
			buttonS.setDisable(true);
			buttonH.setDisable(true);
			buttonStart.setDisable(false);
			buttonStart.setText("  Start  ");
					} 
		});
			
		Pane layout = new Pane();
		
		BorderPane bar= new BorderPane();	
		
		labelBet.setLayoutX(313);
		labelBet.setLayoutY(480);
		
		gameDisplay.setLayoutX(375);
		gameDisplay.setLayoutY(75);
		
		betInput.setLayoutX(25);
		betInput.setLayoutY(125);
		
		buttonStart.setLayoutX(75);
		buttonStart.setLayoutY(175);
		
		buttonH.setLayoutX(75);
		buttonH.setLayoutY(400);
		
		buttonS.setLayoutX(75);
		buttonS.setLayoutY(450);
		
		testText.setLayoutX(25);
		testText.setLayoutY(100);
		
		fileMenu.getItems().add(new MenuItem("High Score"));
		
		menu.getMenus().addAll(fileMenu);
		
		bar.setTop(menu);
		
		layout.getChildren().addAll(gameDisplay, buttonStart, buttonH, buttonS, testText, betInput);

		bar.setCenter(layout);
		
		Scene scene = new Scene(bar, 650, 650);
		
		primaryStage.setScene(scene);
		primaryStage.show();
		
		
	}
	
	private boolean isNum(TextField input, String message) {
		try {
			int bet = Integer.parseInt(input.getText());

			System.out.println(bet);
			
			return true;
			
		}catch (NumberFormatException e) {
			
			System.out.println("Bad, "+message+ " is not a number");
			
			return false;
		}

}
}



