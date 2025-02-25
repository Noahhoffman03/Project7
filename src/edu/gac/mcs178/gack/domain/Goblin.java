package edu.gac.mcs178.gack.domain;

import java.util.ArrayList;
import java.util.List;

import edu.gac.mcs178.gack.Utility;

public class Goblin extends AutoPerson{
public String name = David;
public String place = dormitory;
  public Goblin(String name, String place){
      this.name = name;
      this.place = place;
  }
  public void greet(List<person> people){
    if (!people.isEmpty()){
      say("Hi, what the dawg doing");
      say("Yo mama's so poor, the ducks throw bread at her.");
    }
  }
}
