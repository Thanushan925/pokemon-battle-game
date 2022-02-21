/** This class represents a Trainer which contains a Name, and a team
 *
 *
 *  @author Thanushan Satheeskumar
*/

import java.util.ArrayList;
import java.util.Collections;

public class Trainer {
  private ArrayList<Pokemon> team;
  private String name;

  /** Creates a Trainer with the given parameter values.
   *  @param nme - the Trainer's name
   *  @param tm - the Trainer's team
  */
  public Trainer(String nme, ArrayList<Pokemon> tm) {
    this.name = nme;
    this.team = tm;
  }

  /** Returns the Trainer's name
   *  @return name - Trainer's name
  */
  public String getName() {
    return this.name;
  }

  /** Removes the first Pokemon in the Trainer's team
   *
  */
  public void removeFaintedPokemon() {
    this.team.remove(0);
  }

  /** Swaps the first Pokemon, as well as the Pokemon with
   *  an index in the Trainer's team
   *  @param index
  */
  public void switchPokemon (int index) {
    Collections.swap(this.team, 0, index);
  }

  /** Returns the Trainer's Pokemon
   *  @return Pokemon
  */
  public Pokemon getPokemon(int index) {
    return this.team.get(index);
  }
  
  /** Returns the number of Pokemon left in the Trainer's team
   *  @return the size of the Trainer's team.
  */
  public int getPokemonLeft() {
    return this.team.size();
  }

  /** Returns Trainer's current team
   *  @return team - Trainer's team
   */
  public String toString() {
    return this.team + "";
  }
}