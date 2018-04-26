import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.util.*;

public class FileIO {
	
	String score;
	String readScore;
	double intScore;

	public double useFile() {
		FileReader filereader;
		try {
			filereader = new FileReader(new File("HighScores.txt"));
			BufferedReader br = new BufferedReader(filereader);
			try {
		intScore = Double.parseDouble(br.readLine());
		//System.out.println(intScore);
				br.close();
			}
			catch (IOException e) {
				System.out.println("Cannot read the file");
			}
		}
		catch(Exception e){
			System.out.println("Cannot find file");
			e.printStackTrace();
		}
		return intScore;
	}

	public void writeFile(Player player) {
		
		if (player.getTotalMoney() > intScore) {
			
		FileWriter filewriter;
		try {
			filewriter = new FileWriter(new File("HighScores.txt"));
			BufferedWriter bw = new BufferedWriter(filewriter);
			try {
				bw.write(player.getTotalMoney()+"");
				bw.close();
		}catch (IOException e) {
			System.out.println("Cannot write to file 1");
		}
		
		}
		catch (IOException e) {
			System.out.println("Cannot write to file");
		}
		}
		else {
			
		}
		
		
	}
	
	public double getHighScore() {
			return intScore;
		}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}