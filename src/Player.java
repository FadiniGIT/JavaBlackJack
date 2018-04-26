
public class Player {
	
	private double betMoney;
	private double totalMoney;
	private boolean cont;
	
	public Player() {
		
		betMoney = 0;
		
		totalMoney = 100;
		
		cont = false;
	}
	

	public Player(double totalMonei) {
		
		betMoney = 0;
		
		totalMoney = totalMonei;

	}
	
	public boolean isCont(boolean endRound) {
		
		return cont = endRound;
		
	}

	public void setCont(boolean cont) {
		
		this.cont = cont;
		
	}
	
	public double getBetMoney() {
		
		return betMoney;
		
	}
	
	public void setBetMoney(double betMoney) {
		
		this.betMoney = betMoney;
		
	}
	
	public double getTotalMoney() {
		
		return totalMoney;
		
	}
	
	public void setTotalMoney(double playerMoney) {
		
		this.totalMoney = playerMoney;
		
	}
	
	public void subBetMoney() {
		
		totalMoney -= betMoney;
		
	}
	
	public void addBetMoney() {
		
		totalMoney += betMoney;
		
	}

}
