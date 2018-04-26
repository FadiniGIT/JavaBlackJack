import java.io.File;
import java.util.Scanner;

import javafx.scene.text.Text;

public class Logic {
	
	
	public void moneyCheckinitial(Text gameDisplay, Player player, int i, double userInput) {
		gameDisplay.setText("Hello, welcome to a game of 21");
		//t.setText( t.getText() +"\n"+ String.format( "You have $" + player.getTotalMoney() + " how much will you bet." )   );
		//gameDisplay.setText(gameDisplay.getText()+"\nYou have $" + player.getTotalMoney() + " how much will you bet.");
		
		double betMoney = 0;
		
		//betMoney = userInput.nextDouble();
		
		while(i==0) {
		
			//betMoney = 0;
		
			try {
			
				betMoney = userInput;
			
				i=1;
		
			} catch  (Exception e) {
			
				System.out.println("Please Input a valid amount");
		
			}
		
		}
		
		i = 0;
		
		int controlAsk = 1;
		
		if (betMoney > player.getTotalMoney()) {
			
			System.out.println("You don't have enough money.");
			
				
			
					gameDisplay.setText(gameDisplay.getText()+"\nYou have $" + player.getTotalMoney() + " how much will you bet.");
					
					betMoney = userInput;
					System.out.println(betMoney);
					
					if (betMoney < player.getTotalMoney()) {
						System.out.println("Inside if loop");
						
						controlAsk = 0;
						
						player.setBetMoney(betMoney);
						
					} else {
						System.out.println(betMoney);
						System.out.println("Inside else loop");
						controlAsk = 1;
						
						player.setBetMoney(betMoney);
						
					}
					
				
				
		}else {
			
			player.setBetMoney(betMoney);
		}
		//return betMoney;
	}
	
	public void moneyCheck(Text gameDisplay,Player player, int i, double userInput) {
		
		double betMoney = 0;
		
		while(i==0) {
		
			//betMoney = 0;
		
			try {
			
				betMoney = userInput;
			
				i=1;
		
			} catch  (Exception e) {
			
				System.out.println("Please Input a valid amount");
		
			}
		
		}
		
		i = 0;
		
		int controlAsk = 1;
		
		if (betMoney > player.getTotalMoney()) {
			
			System.out.println("You don't have enough money.");
			
				while (controlAsk == 1) {
			
					gameDisplay.setText(gameDisplay.getText()+"\nYou have $" + player.getTotalMoney() + " how much will you bet.");
					
					betMoney = userInput;
					
					if (betMoney < player.getTotalMoney()) {
						
						controlAsk = 0;
						
						player.setBetMoney(betMoney);
						
					} else {
						
						controlAsk = 1;
						
						player.setBetMoney(betMoney);
						
					}
					
				}
				
		}else {
			
			player.setBetMoney(betMoney);
		}
		//return betMoney;
	}
	
	public void drawUserDeck(Deck playingDeck, Deck userDeck) {
		
		userDeck.draw(playingDeck);
		
		userDeck.draw(playingDeck);
		
	}
	
	public void drawDealerDeck(Deck playingDeck, Deck dealerDeck) {
		
		dealerDeck.draw(playingDeck);
		
		dealerDeck.draw(playingDeck);
	
	}
	
	public void showUserHand(Text gameDisplay, Deck userDeck, Deck dealerDeck) {
		
		gameDisplay.setText(/*gameDisplay.getText()+*/"\nHand: ");
		
		gameDisplay.setText(gameDisplay.getText()+"\n"+userDeck.toString());
		
		gameDisplay.setText(gameDisplay.getText()+"\nYour hand's value is: "+ userDeck.cardsValue());
		
		gameDisplay.setText(gameDisplay.getText()+"\nDealer Hand: " + dealerDeck.getCard(0).toString() + " is visible");
		
		gameDisplay.setText(gameDisplay.getText()+"\nWill you hit or stand");
		
	}
	
	public void hit(Text gameDisplay, Player player, boolean endRound, Scanner userInput, Deck userDeck, Deck playingDeck) {
	
		userDeck.draw(playingDeck);
		
		gameDisplay.setText(gameDisplay.getText()+"\nYou drew a "+ userDeck.getCard(userDeck.deckSize()-1).toString());
		
		if (userDeck.cardsValue() > 21) {
			
			gameDisplay.setText(gameDisplay.getText()+"\nBust, hand is at: "+ userDeck.cardsValue());
						
			
			endRound = true;
			
			player.setCont(endRound);
					
		}
	}

	public void printDealerHand(Text gameDisplay, Deck dealerDeck) {
		
		gameDisplay.setText(gameDisplay.getText()+"\nDealer's hand: \n " + dealerDeck.toString());
		
	}
	
	public void lostToDealer(Text gameDisplay, Player player, boolean endRound, Deck dealerDeck, Deck userDeck) {
		
		if((dealerDeck.cardsValue() > userDeck.cardsValue()) && endRound == false) {
			
			gameDisplay.setText(gameDisplay.getText()+"\nYou lost to the dealer");
			
			endRound = true;
			
			player.setCont(endRound);
		
		}
		
		player.isCont(endRound);
	}
	
	public void dealerDrawCards(Text gameDisplay, Player player, boolean endRound, Deck playingDeck, Deck dealerDeck, Deck userDeck) {
		
		while((dealerDeck.cardsValue() < 17) && endRound == false) {
			
			dealerDeck.draw(playingDeck);
			
			gameDisplay.setText(gameDisplay.getText()+"\nDealer drew a "+ dealerDeck.getCard(dealerDeck.deckSize()-1).toString());
			
			
		}
		
		player.isCont(endRound);
	}
	
	public void dealerBusted(Text gameDisplay, Player player, boolean endRound, Deck dealerDeck, Deck userDeck) {
		
		gameDisplay.setText(gameDisplay.getText()+"\nDealer hand: " + dealerDeck.cardsValue());
		
		if ((dealerDeck.cardsValue() > 21) && (userDeck.cardsValue() > 21)) {
				
				

				
			}else if ((dealerDeck.cardsValue() > 21) && endRound == false) {
			
				gameDisplay.setText(gameDisplay.getText()+"\nThe dealer busted.");
			
			
			
			endRound = true;
			
			player.setCont(endRound);
			
		}
		
		player.isCont(endRound);
	}

	public void userTied(Text gameDisplay, Player player, boolean endRound, Deck userDeck, Deck dealerDeck) {
		//if tied
		if ((userDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
		
			gameDisplay.setText(gameDisplay.getText()+"\nPush!");
		
			endRound = true;
			
			player.setCont(endRound);
		
		}
		
		player.isCont(endRound);
	}
	 
	public void userWinLoss(Text gameDisplay, Player player, boolean endRound, Deck userDeck, Deck dealerDeck) {
		
		if ((userDeck.cardsValue() > 21) && (dealerDeck.cardsValue() > 21) && endRound == false) {
			
			gameDisplay.setText(gameDisplay.getText()+"\nYou lost the hand");
			
			player.subBetMoney();
			
			//System.out.println(betMoney + "TEST2");
			
			endRound = true;
			
			player.setCont(endRound);
		
		}else if ((userDeck.cardsValue() <= 21) && (dealerDeck.cardsValue() > 21 && endRound == false)) {
			
			gameDisplay.setText(gameDisplay.getText()+"\nYou won!");
			
			player.addBetMoney();
			
			//System.out.println(betMoney + "TEST1");
			
			endRound = true;
			
			player.setCont(endRound);
			
		}else if ((userDeck.cardsValue() > dealerDeck.cardsValue()) && endRound == false && (userDeck.cardsValue() < 22)) {
			
			gameDisplay.setText(gameDisplay.getText()+"\nYou won!");
			
			player.addBetMoney();
			
			//System.out.println(betMoney + "TEST1");
			
			endRound = true;
			
			player.setCont(endRound);
			
		
		} else if ((userDeck.cardsValue() == dealerDeck.cardsValue()) && endRound == false) {
			
			gameDisplay.setText(gameDisplay.getText()+"\nYou and the dealer tied.");
			
		} else if(endRound == false) {
			
			gameDisplay.setText(gameDisplay.getText()+"\nYou lost the hand");
			
			player.subBetMoney();
			
			//System.out.println(betMoney + "TEST2");
			
			endRound = true;
			
			player.setCont(endRound);
		
		}
		
		player.isCont(endRound);
	}
	
	public void moveCardsToDeck(Text gameDisplay, Deck playingDeck, Deck userDeck, Deck dealerDeck, Player player) {
		
		userDeck.moveAllToDeck(playingDeck);
		
		dealerDeck.moveAllToDeck(playingDeck);
		
		gameDisplay.setText(gameDisplay.getText()+"\nEnd of hand");
		if (player.getTotalMoney() <= 0) {
			gameDisplay.setText(gameDisplay.getText()+"\nGame over");
		}else {
		gameDisplay.setText(gameDisplay.getText()+"\nYou have $" + player.getTotalMoney() + " how much will you bet.");
		}
	}
private Scanner x;
	
	public void openFile() {
		try {
			x = new Scanner(new File("HighScores.txt"));
		}
		catch(Exception e){
			System.out.println("Cannot find file");
			
		}
	}
	
	public void readFile() {
		while(x.hasNext()) {
			String a = x.next();
			System.out.println(a);
			
		}
	}
	
	public void closeFile() {
		x.close();
	}
	

}
