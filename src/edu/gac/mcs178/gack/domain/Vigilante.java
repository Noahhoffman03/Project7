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
			
			
			//add 2 else if statements 1st for if vigi has glasses(Doesn't shoot, 2nd if player has (vigi takes them
			Person victim = others.get(Utility.randInt(others.size()));
			isBlind(victim);
				
			
		} else {
			super.act();
		}
	}

	public void isBlind(Person person) {
		say("Who goes there, are you the witch? I can't see without my glasses ");
		shoot(person);
		say("BAM");
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
