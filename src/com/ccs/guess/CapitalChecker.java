package com.ccs.guess;

import java.io.BufferedReader;
import java.io.Console;
import java.io.File;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class CapitalChecker {
	// HashMap to store States and Capital.
	static Map<Integer, String> states = new HashMap<Integer, String>();
	static Map<Integer, String> capital = new HashMap<Integer, String>();
	static int score=0;

	public static void main(String[] args) {
		// this is the main function which starts the game.

		try {
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+                                         +");
			System.out.println("+    Welcome! to Guess The Capitals !!    +");
			System.out.println("+                                         +");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("Loading Game...");
			Thread.sleep(1000);
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
			System.out.println("+                                             +");
			System.out.println("+Keep Guessing the Capitals, Type 'q' to quit +");
			System.out.println("+                                             +");
			System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
			// load the states and their capitals in the memory
			File f = new File("C:/Users/Nitin/Desktop/GuessTheGame/state_capitals.txt");
			BufferedReader b = new BufferedReader(new FileReader(f));

			String info;

			// read the file
			int i=0;
			while ((info = b.readLine()) != null) {
				String[] st = info.split("\t");
				//System.out.println(st[0] + " " + st[1]);
				states.put(i, st[0].toLowerCase());
				capital.put(i, st[1].toLowerCase());
				i++;
			}
			// size of the list
			//System.out.println(statesAndCapital.size());
			
			Thread.sleep(1000);
			System.out.println("Brace yourself.");
			Thread.sleep(2000);
			Random r= new Random();
			
			String answer = "";
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			while(!answer.equals("q")){
				int n=r.nextInt(states.size());
				String question ="What is the capital of "+states.get(n);
				System.out.println(question);
				//answer = br.readLine();
				
				if((answer = br.readLine()) != null){
					if(answer.equals(capital.get(n))){
						System.out.println("Your Answer is Correct!");
						score++;
					}
					else if(!answer.equals("q")){
						System.out.println("Your Answer is Incorrect");
					}
				}
				else
					break;
			}
				
			System.out.println("Your Score is : "+ score+" !");
			System.out.println("Thanks for playing !");
			b.close();
			br.close();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
