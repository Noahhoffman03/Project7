package edu.gac.mcs178.gack;

import edu.gac.mcs178.gack.domain.AutoPerson;
import edu.gac.mcs178.gack.domain.Person;
import edu.gac.mcs178.gack.domain.Place;
import edu.gac.mcs178.gack.domain.Scroll;
import edu.gac.mcs178.gack.domain.Thing;
import edu.gac.mcs178.gack.domain.Witch;
import edu.gac.mcs178.gack.domain.Wizard;
import edu.gac.mcs178.gack.domain.Vigilante; //Adds the new character file 

public class GackWorld extends World {
	
	public GackWorld() {
		super();
		Place foodService = new Place("Food Service");
		Place po = new Place("Post Office");
		Place alumniHall = new Place("Alumni Hall");
		Place chamberOfWizards = new Place("Chamber of Wizards");
		Place library = new Place("Library");
		Place goodShipOlin = new Place("Good Ship Olin");
		Place lounge = new Place("Lounge");
		Place computerLab = new Place("Computer Lab");
		Place offices = new Place("Offices");
		Place dormitory = new Place("Dormitory");
		Place pond = new Place("Pond");
		
		Place graveyard = new Place("Graveyard");
		//Graveyard for vigilante victims
		
		Place lund = new Place("Lund");
		//creates lund
		
		foodService.addNewNeighbor("down", po);
		po.addNewNeighbor("south", alumniHall);
		alumniHall.addNewNeighbor("north", foodService);
		alumniHall.addNewNeighbor("east", chamberOfWizards);
		alumniHall.addNewNeighbor("west", library);
		chamberOfWizards.addNewNeighbor("west", alumniHall);
		chamberOfWizards.addNewNeighbor("south", dormitory);
		dormitory.addNewNeighbor("north", chamberOfWizards);
		dormitory.addNewNeighbor("west", goodShipOlin);
		library.addNewNeighbor("east", library);
		library.addNewNeighbor("south", goodShipOlin);
		goodShipOlin.addNewNeighbor("north", library);
		goodShipOlin.addNewNeighbor("east", dormitory);
		goodShipOlin.addNewNeighbor("up", lounge);
		lounge.addNewNeighbor("west", computerLab);
		lounge.addNewNeighbor("south", offices);
		computerLab.addNewNeighbor("east", lounge);
		offices.addNewNeighbor("north", lounge);
		
		dormitory.addNewNeighbor("northwest", lund);
		lund.addNewNeighbor("southeast", dormitory);
		//adds lund to map
		
		dormitory.addNewNeighbor("east", graveyard);
		lund.addNewNeighbor("east", graveyard);
		graveyard.addNewNeighbor("northwest", lund);
		graveyard.addNewNeighbor("southwest", dormitory);
		
		new AutoPerson("Max", offices, 2);
		new AutoPerson("Karl", computerLab, 4);
		new Witch("Barbara", offices, 3, pond);
		new Wizard("Elvee", offices, 1, chamberOfWizards);
		
		new Vigilante("Sam", lund, 2, graveyard); //The new character, the vigilante who hunts for witches
		
		
		lounge.gain(new Thing("Karl's glasses"));
		
		library.gain(new Scroll("Scroll of Enlightenment"));
		String[] someTitles = {"War and Peace", "Iliad", "Collected Works of Rilke"};
		for (String title : someTitles) {
			library.gain(new Scroll(title));
		}
		computerLab.gain(new Scroll("Unix Programmers Manual"));
		computerLab.gain(new Scroll("NeXT User's Reference"));
		
		lund.gain(new Scroll("Louis don't barf magival enchantment"));
		//exercise 2, adds scroll to lund
		
		dormitory.gain(new Scroll("Late lab report"));
		//class
		
		lund.gain(new Thing("Sam's missing glasses"));
		//Missing glasses for the vigilante
		
		
		setPlayer(new Person("player", dormitory));
	}
}
