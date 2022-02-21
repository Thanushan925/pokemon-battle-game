/** This class represents a Pokemon which contains a Name, Max and
 *  remaining HP, attack, defense, speed, types, mega compatibility,
 *  weakness, resistance, and various moves.
 *
 *
 *  @author Thanushan Satheeskumar
*/

import java.util.Arrays;

public class Pokemon {
  private String name;
  private int maxHP;
  private int remainingHP;
  private double attack;
  private double defense;
  private double speed;
  private String type1;
  private String type2;
  private boolean mega;
  private String[] weakness;
  private String[] resistance;
  private String[] moves;
  private String[] moveTypes;
  private int[] moveDamages;

  /** Creates a Pokemon with the given parameter values.
   *  @param nme - the Pokemon's name
   *  @param thp - the Pokemon's total HP
   *  @param atk - the Pokemon's attack stat
   *  @param def - the Pokemon's defense stat
   *  @param spe - the Pokemon's speed stat
   *  @param t1 - the Pokemon's first type
   *  @param t2 - the Pokemon's second type
   *  @param mga - the Pokemon's mega compatibility
   *  @param weak - the Pokemon's weaknesses
   *  @param resist - the Pokemon's resistances
   *  @param mvs - the Pokemon's moves
   *  @param mvtp - the Pokemon's move's types
   *  @param mvdm - the Pokemon's move's damages
  */
  public Pokemon(String nme, int thp, double atk, double def, double spe, String t1, String t2, boolean mga, String[] weak, String[] resist, String[] mvs, String[] mvtp, int[] mvdm) {
    this.name = nme;
    this.maxHP = thp;
    this.remainingHP = thp;
    this.attack = atk;
    this.defense = def;
    this.speed = spe;
    this.type1 = t1;
    this.type2 = t2;
    this.mega = mga;
    this.weakness = weak;
    this.resistance = resist;
    this.moves = mvs;
    this.moveTypes = mvtp;
    this.moveDamages = mvdm;
  }

  /** Returns the Pokemon's name
   *  @return name - Pokemon's name
  */
  public String getName() {
    return this.name;
  }

  /** Changes the Pokemon's name
   *  @param newName - Pokemon's new name
  */ 
  public void setName(String newName) {
    this.name = newName;
  }

  /** Returns the Pokemon's first type
   *  @return type1 - Pokemon's first type
  */
  public String getType1() {
    return this.type1;
  }

  /** Returns the Pokemon's second type
   *  @return type2 - Pokemon's second type
  */
  public String getType2() {
    return this.type2;
  }
  
  /** Returns the Pokemon's Max HP
   *  @return maxHP - Pokemon's Max HP
  */
  public int getMaxHP() {
    return this.maxHP;
  }

  /** Returns the Pokemon's Remaining HP
   *  @return remainingHP - Pokemon's Remaining HP
  */
  public int getRemainingHP() {
    return this.remainingHP;
  }

  /** Changes the Pokemon's remaining HP
   *  @param newHP - Pokemon's new HP
  */ 
  public void setRemainingHP(int newHP) {
    this.remainingHP = newHP;
  }

  /** Returns the Pokemon's attack stat
   *  @return attack - Pokemon's attack stat
  */
  public double getAttack() {
    return this.attack;
  }

  /** Changes the Pokemon's attack stat
   *  @param newName - Pokemon's new name
  */ 
  public void setAttack(double newAttack) {
    this.attack = newAttack;
  }

  /** Returns the Pokemon's defense stat
   *  @return defense - Pokemon's defense stat
  */
  public double getDefense() {
    return this.defense;
  }
  
  /** Changes the Pokemon's defense
   *  @param newDefense - Pokemon's new defense
  */ 
  public void setDefense(double newDefense) {
    this.defense = newDefense;
  }

  /** Returns the Pokemon's speed stat
   *  @return speed - Pokemon's speed stat
  */
  public double getSpeed() {
    return this.speed;
  }
  
  /** Changes the Pokemon's speed
   *  @param newSpeed - Pokemon's new speed
  */ 
  public void setSpeed(double newSpeed) {
    this.speed = newSpeed;
  }

  /** Returns the Pokemon's mega compatibility
   *  @return mega - Pokemon's mega compatibility
  */
  public boolean getMega() {
    return this.mega;
  }

  /** Returns the Pokemon's weaknesses
   *  @return weakness - Pokemon's weaknesses
  */
  public String[] getWeakness() {
    return this.weakness;
  }

  /** Returns the Pokemon's resistances
   *  @return resistance - Pokemon's resistances
  */
  public String[] getResistance() {
    return this.resistance;
  }

  /** Returns the Pokemon's moves
   *  @return moves - Pokemon's moves
   *  @param index - index of move
  */
  public String getMoves(int index) {
    return this.moves[index];
  }

  /** Returns the Pokemon's move's types
   *  @return move's types - Pokemon's move's types
   *  @param index - index of move's types
  */
  public String getMoveTypes(int index) {
    return this.moveTypes[index];
  }

  /** Returns the Pokemon's move's damages
   *  @return move's damages - Pokemon's move's damages
   *  @param index - index of move's damages
  */
  public int getMoveDamages(int index) {
    return this.moveDamages[index];
  }

  /** Returns a quick description of a Pokemon
   *  @return name - Pokemon's name
   *  @return type1 - Pokemon's first type
   *  @return type2 - Pokemon's second type
  */
  public String toString() {
    return this.name + " " + type1 + type2;
  }
}