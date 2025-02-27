package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Vigilante extends AutoPerson {
	
	private Place graveyard;
	
	public Vigilante(String name, Place place, int threshold, Place graveyard) {
		super(name, place, threshold);
		this.graveyard = graveyard;
	}

	@Override
	public void act() {
	    List<Person> others = otherPeopleAtSamePlace();
	    if (!others.isEmpty()) {
	        Person victim = others.get(Utility.randInt(others.size()));
	        
	        List<Thing> personsPossessions = new ArrayList<>(victim.getPossessions());
	        say(personsPossessions.toString());

	        // Check if the victim has "Sam's missing glasses"
	        for (Thing item : personsPossessions) {
	            if (item.getName().equals("Sam's missing glasses")) {  
	                say("Hold on are those my glasses?");
	                victim.give(item, this);
	                return;
	            }
	        }

	        // Check if the vigilante has "Sam's missing glasses"
	        for (Thing item : this.getPossessions()) {
	            if (item.getName().equals("Sam's missing glasses")) {
	                say("You're lucky I have my glasses, I might've mistaken you for a witch!");
	                return;
	            }
	        }

	        // If neither has the glasses, vigi is still blind and shoots
	        isBlind(victim);
	        
	    } else {
	        super.act();
	    }
	}


	
	public void isBlind(Person person) {
		say("Who goes there, are you the witch? I can't see without my glasses ");
		say("BAM");
		shoot(person);
	}
	
	public void shoot(Person person) {
		// need to copy person.getPossessions() in order to avoid a ConcurrentModificationException
		List<Thing> personsPossessions = new ArrayList<Thing>(person.getPossessions());
		for (Thing thing : personsPossessions) {
			person.lose(thing);
		}
		person.say("Bleh!");
		person.moveTo(graveyard);
	}
}
