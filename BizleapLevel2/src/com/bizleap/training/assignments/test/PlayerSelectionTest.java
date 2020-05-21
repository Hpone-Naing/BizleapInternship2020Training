package com.bizleap.training.assignments.test;

import com.bizleap.training.assignments.PlayerSelection;

public class PlayerSelectionTest {

	public static void main(String[] args) {
		PlayerSelection playerSelection = new PlayerSelection();
		System.out.println("Players are selected if age is between 16 and 30 and height above 180 include");
		if(playerSelection.isAcceptPlayer(25, 200))
			System.out.println("Player age 25 and height 200: selected.");
		else 
			System.out.println("Player age 25 and height 200: Player is rejected.");
		
		if(playerSelection.isAcceptPlayer(25, 100))
			System.out.println("Player age 25 and height 100: Player is selected.");
		else 
			System.out.println("Player age 25 and height 100: Player is rejected.");
	}
}
