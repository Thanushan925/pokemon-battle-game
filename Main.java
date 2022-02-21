/** This is the main class for the Pokemon Battle Simulator Program.
 *  It allows the user to experience a Story, and an
 *  actual Pokemon battle, using menus, and turn-based text
 *
 *  @author Thanushan Satheeskumar
*/


//////////////////////////////////////////////////////////////////////////////////////////////////
//IMPORTANT NOTICE FROM CREATOR                                                                 //
//----------------------------------------------------------------------------------------------//
//For the ultimate experience, click on the <OPEN IN A NEW TAB> button that's above the console.//
//If you are asked to enter something, enter your answer, and then press <ENTER>. Otherwise just//
//press <ENTER> to continue the game, whenever you see the [ENTER] icon. Have fun, and good luck//
//----------------------------------------------------------------------------------------------//
//////////////////////////////////////////////////////////////////////////////////////////////////


//Imports the needed libraries
import java.util.ArrayList;
import java.util.Scanner;
import java.util.List;
import java.util.Arrays;
import java.util.Random;
import java.io.File;

public class Main {
    public static void main(String[] args) {

        //Creates variables that will be used later
        Scanner input = new Scanner(System.in);
        Random random = new Random();
        int randInt;
        int choice;
        int counter = 0;
        boolean megaEvolved = false;
        
        //Creates 8 Pokemon objects
        //Red's Team
        Pokemon Pikachu = new Pokemon("Pikachu", 474, 1.15, 0.98, 1.53, "Electric", "", false, new String[] {"Ground"}, new String[] {"Electric", "Flying", "Steel"}, new String[] {"Thunderbolt", "Pay Day", "Ultra Berry", "Switch Pokemon"}, new String[] {"Electric", "Normal", "Self", "Team"}, new int[] {90, 40, 100, 0});
        
        Pokemon Snorlax = new Pokemon("Snorlax", 724, 1.75, 1.26, 0.87, "Normal", "", false, new String[] {"Fighting"}, new String[] {"Ghost"}, new String[] {"Body Slam", "Crunch", "Ultra Berry", "Switch Pokemon"}, new String[] {"Normal", "Dark", "Self", "Team"}, new int[] {85, 80, 100, 0});
        
        Pokemon Charizard = new Pokemon("Charizard", 560, 1.47, 1.40, 1.64, "Fire", "/Flying", true, new String[] {"Water", "Electric", "Rock"}, new String[] {"Fire", "Grass", "Fighting", "Bug", "Steel", "Fairy"}, new String[] {"Flamethrower", "Air Slash", "Mega Evolve", "Switch Pokemon"}, new String[] {"Fire", "Flying", "Self", "Team"}, new int[] {90, 75, 0, 0});
        
        
        //Player's Team
        Pokemon Greninja = new Pokemon("Greninja", 548, 1.56, 1.28, 1.89, "Water", "/Dark", false, new String[] {"Electric", "Grass", "Fighting", "Bug", "Fairy"}, new String[] {"Fire", "Water", "Ice", "Psychic", "Ghost", "Dark", "Steel"}, new String[] {"Water Shuriken", "Night Slash", "Ultra Berry", "Switch Pokemon"}, new String[] {"Water", "Dark", "Self", "Team"}, new int[] {75, 70, 100, 0});
        
        Pokemon Arcanine = new Pokemon("Arcanine", 584, 1.75, 1.42, 1.59, "Fire", "", false, new String[] {"Water", "Rock", "Ground"}, new String[] {"Fire", "Grass", "Ice", "Bug", "Steel", "Fairy"}, new String[] {"Flamethrower", "Iron Head", "Ultra Berry", "Switch Pokemon"}, new String[] {"Fire", "Steel", "Self", "Team"}, new int[] {90, 80, 100, 0});
        
        Pokemon Lucario = new Pokemon("Lucario", 544, 1.75, 1.31, 1.53, "Fighting", "/Steel", true, new String[] {"Fire", "Fighting", "Ground"}, new String[] {"Normal", "Grass", "Ice", "Poison", "Bug", "Rock", "Dragon", "Dark", "Steel"}, new String[] {"Aura Sphere", "Flash Cannon", "Mega Evolve", "Switch Pokemon"}, new String[] {"Fighting", "Steel", "Self", "Team"}, new int[] {80, 80, 0, 0});
        
        
        //Post-Game Pokemon
        Pokemon pgArceus = new Pokemon("Arceus", 650, 1.86, 1.86, 1.86, "Normal", "", false, new String[] {"Fighting"}, new String[] {"Ghost"}, new String[] {"Judgment", "Earth Power", "Ultra Berry", "Switch Pokemon"}, new String[] {"Normal", "Ground", "Self", "Team"}, new int[] {125, 125, 100, 0});
        
        //Prints out Story text
        System.out.println("IMPORTANT NOTICE FROM CREATOR:\n   If you are asked to enter something, enter your answer, and then press <ENTER>. Otherwise just\n   press <ENTER> to continue the game, whenever you see the [ENTER] icon. Have fun, and good luck!\n----------------------------------------------------------------------------------------------------\n[ENTER]");
        input.nextLine();
        System.out.print("\033[H\033[2J");
        System.out.flush();
        
        //This section of code is for File Reading, and printing out ASCII image (Pokemon Logo)
        Scanner pokemonFile = null;
        try {
          pokemonFile = new Scanner(new File("Pokemon.txt"));
          while (pokemonFile.hasNext()) {
            String line = pokemonFile.nextLine();
            System.out.println(line);
          }
        }
        catch (Exception e) {
          System.out.println("File did not open.");
          System.exit(-1);
        }
        System.out.println("----------------------------------------------------------------------------------------------------\n[ENTER]");
        input.nextLine();
    
        //Continues to print out Story text
        System.out.println("----------------------------------------------------------------------------------------------------");
        System.out.println("----------------------------------------------------------------------------------------------------\nOak:\n   Hello there! Welcome to the world of POKEMON! My name is OAK! People call me the POKEMON PROF!\n   This world is inhabited by creatures called POKEMON! For some people, POKEMON are pets. Others\n   use them for fights. Myself...I study POKEMON as a profession. Erm, what was your name again?\n---------------------------------------------------------------------------------------------------\nEnter Your Name:");
    
        //Creates Players's team, and creates a Trainer object called Player
        //Also asks the user for their name
        String playerName = input.nextLine();
        ArrayList<Pokemon> playerTeam = new ArrayList<Pokemon>();
        playerTeam.add(Greninja);
        playerTeam.add(Arcanine);
        playerTeam.add(Lucario);
        Trainer Player = new Trainer(playerName, playerTeam);
    
        //Creates Red's team, and creates a Trainer object called Red
        ArrayList<Pokemon> redTeam = new ArrayList<Pokemon>();
        redTeam.add(Pikachu);
        redTeam.add(Snorlax);
        redTeam.add(Charizard);
        Trainer Red = new Trainer("Red", redTeam);
    
        //Creates Arceus as a Trainer object, for Post-Game
        ArrayList<Pokemon> arceus = new ArrayList<Pokemon>();
        arceus.add(pgArceus);
        Trainer Arceus = new Trainer("Arceus", arceus);
    
        //Prints out Story text, while asking for the user's input to continue
        System.out.println("----------------------------------------------------------------------------------------------------\nOak:\n   That's right! I remember now! Your name is " + Player.getName() + "! Well, your very own POKEMON legend is\n   about to unfold! A world of dreams and adventures with POKEMON awaits! Let's go!\n----------------------------------------------------------------------------------------------------\n[ENTER]");
        input.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------------\nNarrator:\n   After a long while later, " + Player.getName() + " came back to see Professor Oak.\n----------------------------------------------------------------------------------------------------\n[ENTER]");
        input.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------------\nOak:\n   Oh, hey " + Player.getName() + ". How's it going? I've heard you just beaten the Pokemon League, and you were\n   crowned the Pokemon Champion. Congratulations! Did I ever tell you about my first student, Red.\n   Well, he's one of the best, if not the best Pokemon Trainer in the world. I want to see how far\n   both of you have come. So, I want you to do me a favour, go to Mount Silver, and battle him.\n----------------------------------------------------------------------------------------------------\n[ENTER]");
        input.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------------\nNarrator:\n   After another long while later, " + Player.getName() + " finally reached the top of the mountain. Ahead of him was\n   none other than the best Trainer himself, Red.\n----------------------------------------------------------------------------------------------------\nRed:\n   ... ... ... ...\n----------------------------------------------------------------------------------------------------\n[ENTER]");
        input.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        //This section of code is for File Reading, and printing out ASCII image (Challenged by Red)
        Scanner redFile = null;
        try {
          redFile = new Scanner(new File("Red.txt"));
          while (redFile.hasNext()) {
            String line = redFile.nextLine();
            System.out.println(line);
          }
        }
        catch (Exception e) {
          System.out.println("File did not open.");
          System.exit(-1);
        }
        System.out.println("----------------------------------------------------------------------------------------------------");
        switchPokemon(Player);
    
        //Continues to print out Story text, while asking for the user's input to continue
        System.out.println("----------------------------------------------------------------------------------------------------\n\n\nPokemon Trainer " + Red.getName() + " sent out " + Red.getPokemon(0).getName() + "!\n\nPokemon Trainer " + Player.getName() + " sent out " + Player.getPokemon(0).getName() + "!");
    
        //Main Part of Game
        //Repeats until a Trainer has no usable Pokemon left
        while (Red.getPokemonLeft() != 0 && Player.getPokemonLeft() != 0) {
          //Prints out the turn number
          counter += 1;
          System.out.println("\n\n----------------------------------------------------------------------------------------------------\nTURN " + counter + "\n----------------------------------------------------------------------------------------------------");
          
          //Displays the current Pokemon in Battle, and their type and HP
          System.out.println(Player.getName() + ": Name[" + Player.getPokemon(0).getName() + "] Type[" + Player.getPokemon(0).getType1() + Player.getPokemon(0).getType2() + "] HP[" + Player.getPokemon(0).getRemainingHP() + "/" + Player.getPokemon(0).getMaxHP() + "]");
    
          System.out.println(Red.getName() + ": Name[" + Red.getPokemon(0).getName() + "] Type[" + Red.getPokemon(0).getType1() + Red.getPokemon(0).getType2() + "] HP[" + Red.getPokemon(0).getRemainingHP() + "/" + Red.getPokemon(0).getMaxHP() + "]");
    
          //Displays the things that the User can tell the Pokemon to do
          System.out.println("\nWhat would you like " + Player.getPokemon(0).getName() + " to do:\n   1-" + Player.getPokemon(0).getMoves(0) + " (Attack)\n   2-" + Player.getPokemon(0).getMoves(1) + " (Attack)\n   3-" + Player.getPokemon(0).getMoves(2) + " (Heal/Increase Stats)\n   4-" + Player.getPokemon(0).getMoves(3));
    
          //Asks the user for their option selected
          choice = choiceRange(1,4);
    
          //Depending on each option, an action is performed
          //Option 1 represents the Pokemon's first attack
          if (choice == 1) {
    
            //Checks to see which Pokemon is faster
            if (Player.getPokemon(0).getSpeed() >= Red.getPokemon(0).getSpeed()) {
    
              //Runs the attack method, and then the defense method, since the Player's Pokemon is faster
              Attack(Player, Red, 0);
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(Player, Red, randInt);
            }
            else {
              //Runs the defense method, and then the attack method, since Red's Pokemon is faster
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(Player, Red, randInt);
              Attack(Player, Red, 0);
            }
          }
    
          //Option 2 represents the Pokemon's second attack
          else if (choice == 2) {
    
            //Checks to see which Pokemon is faster
            if (Player.getPokemon(0).getSpeed() >= Red.getPokemon(0).getSpeed()) {
    
              //Runs the attack method, and then the defense method, since the Player's Pokemon is faster
              Attack(Player, Red, 1);
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(Player, Red, randInt);
            }
            else {
              //Runs the defense method, and then the attack method, since Red's Pokemon is faster
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(Player, Red, randInt);
              Attack(Player, Red, 1);
            }
          }
    
          //Option 3 represents the Pokemon eating an Ultra Berry, or mega evolving
          else if (choice == 3) {
            megaEvolved = MegaOrBerry(Player, Red, megaEvolved);
            counter -= 1;
          }
    
          //Option 4 represents the Pokemon switching out for another
          else if (choice == 4) {
            switchPokemon(Player);
    
            //Randomizes the opposing Pokemon's attack
            randInt = random.nextInt(2);
            Defense(Player, Red, randInt);
          }
    
          //Checks at the end of each turn, to see if the opposing Pokemon has fainted or not
          if (Red.getPokemon(0).getRemainingHP() <= 0) {
            System.out.println("\n" + Red.getPokemon(0).getName() + " fainted");
            Red.removeFaintedPokemon();
    
            //Simulates the opposing Pokemon getting switched out
            if (Red.getPokemonLeft() > 0) {
              System.out.println("\n" + Red.getName() + " sent out " + Red.getPokemon(0).getName());
            }
          }
    
          //Checks at the end of each turn, to see if the opposing Pokemon has fainted or not
          if (Player.getPokemon(0).getRemainingHP() <= 0) {
            System.out.println("\n" + Player.getPokemon(0).getName() + " fainted");
            Player.removeFaintedPokemon();
            if (Player.getPokemonLeft() > 1) {
              switchPokemon(Player);
            }
          }
        }
    
        //The following runs if the Player's Pokemon all fainted. The game will also end there
        if (Player.getPokemonLeft() == 0) {
          System.out.println("\n---------------------------------------------------------------------------------------------------\nNarrator:\n   " + Player.getName() + " is out of usable Pokemon\n\n   ... ... ...\n\n   " + Player.getName() + " blacked out! " + Player.getName() + " was brought to the nearest Pokemon Centre by Red. There they\n   met up with Professor Oak.\n----------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("----------------------------------------------------------------------------------------------------\nOak:\n   Oh no " + Player.getName() + ", what happened!\n---------------------------------------------------------------------------------------------------\nGAME OVER");
          System.exit(0);
        }
    
        //The following runs if Red's Pokemon all fainted, and Player won. The game will continue to Post-Game Story
        else if (Red.getPokemonLeft() == 0) {
          System.out.println("\n---------------------------------------------------------------------------------------------------\nYou defeated Pokemon Trainer Red!\n----------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("----------------------------------------------------------------------------------------------------\nRed:\n   ... ..!\n----------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("----------------------------------------------------------------------------------------------------\nNarrator:\n   Red nodded in approval and walked away. " + Player.getName() + " went back to Professor Oak's lab, excited that\n   he has won.\n----------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("----------------------------------------------------------------------------------------------------\nOak:\n   Wow, I can't believe you beat him. I'm proud of you " + Player.getName() + ". But before I can congratulate you\n   more, I need you to do me another favour. Arceus, the legendary Pokemon, is being manipulated by\n   Team Rocket, and is currently rampaging throughout the city. I need you to stop it.\n----------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("----------------------------------------------------------------------------------------------------\nNarrator:\n   After searching throughout the city, " + Player.getName() + " finally found Arceus resting on top of a house\n   that it has destroyed. " + Player.getName() + " walked towards it, and Arceus suddenly woke up demanding a\n   fight.\n----------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("----------------------------------------------------------------------------------------------------\nArceus:\n   DODOGYUUUN!\n----------------------------------------------------------------------------------------------------\n[ENTER]");
        }
    
        //Creates pgPlayers's team, and creates a Trainer object called pgPlayer (pgPlayer = Post-Game Player)
        ArrayList<Pokemon> pgPlayerTeam = new ArrayList<Pokemon>();
        pgPlayerTeam.add(Greninja);
        pgPlayerTeam.add(Arcanine);
        pgPlayerTeam.add(Lucario);
        Trainer pgPlayer = new Trainer(playerName, pgPlayerTeam);
    
        //Resets the Pokemon's health back to 100%
        pgPlayer.getPokemon(0).setRemainingHP(pgPlayer.getPokemon(0).getMaxHP());
        pgPlayer.getPokemon(1).setRemainingHP(pgPlayer.getPokemon(1).getMaxHP());
        pgPlayer.getPokemon(2).setRemainingHP(pgPlayer.getPokemon(2).getMaxHP());
    
        //Resets the Mega-Evolved Pokemon stats back to normal
        pgPlayer.getPokemon(2).setAttack(1.75);
        pgPlayer.getPokemon(2).setDefense(1.31);
        pgPlayer.getPokemon(2).setSpeed(1.53);
        
    
        //Resets the counter to print out the turn number, resets mega values, changes name of mega evolved Pokemon, and prints out the rest of Post Game details, before the battle
        counter = 0;
        megaEvolved = false;
        input.nextLine();
        System.out.println("----------------------------------------------------------------------------------------------------");
        
        //This section of code is for File Reading, and printing out ASCII image (Challenged by Arceus)
        Scanner arceusFile = null;
        try {
          arceusFile = new Scanner(new File("Arceus.txt"));
          while (arceusFile.hasNext()) {
            String line = arceusFile.nextLine();
            System.out.println(line);
          }
        }
        catch (Exception e) {
          System.out.println("File did not open.");
          System.exit(-1);
        }
        pgPlayer.getPokemon(2).setName("Lucario");

        //Simulates the Pokemon being sent out
        switchPokemon(pgPlayer);
        System.out.println("----------------------------------------------------------------------------------------------------\n\n\nPokemon Trainer " + pgPlayer.getName() + " sent out " + pgPlayer.getPokemon(0).getName() + "!");
    
        //Main Part of Post-Game
        //Repeats until the Player has no usable Pokemon left or Arceus fainted
        while (Arceus.getPokemonLeft() != 0 && pgPlayer.getPokemonLeft() != 0) {
    
          //Prints out the turn number
          counter += 1;
          System.out.println("\n\n----------------------------------------------------------------------------------------------------\nTURN " + counter + "\n----------------------------------------------------------------------------------------------------");
          
          //Displays the current Pokemon in Battle, and their type and HP
          System.out.println(pgPlayer.getName() + ": Name[" + pgPlayer.getPokemon(0).getName() + "] Type[" + pgPlayer.getPokemon(0).getType1() + pgPlayer.getPokemon(0).getType2() + "] HP[" + pgPlayer.getPokemon(0).getRemainingHP() + "/" + pgPlayer.getPokemon(0).getMaxHP() + "]");
          System.out.println("Arceus: Name[" + Arceus.getPokemon(0).getName() + "] Type[" + Arceus.getPokemon(0).getType1() + Arceus.getPokemon(0).getType2() + "] HP[" + Arceus.getPokemon(0).getRemainingHP() + "/" + Arceus.getPokemon(0).getMaxHP() + "]");
          
          //Displays the things that the User can tell the Pokemon to do
          System.out.println("\nWhat would you like " + pgPlayer.getPokemon(0).getName() + " to do:\n   1-" + pgPlayer.getPokemon(0).getMoves(0) + " (Attack)\n   2-" + pgPlayer.getPokemon(0).getMoves(1) + " (Attack)\n   3-" + pgPlayer.getPokemon(0).getMoves(2) + " (Heal/Increase Stats)\n   4-" + pgPlayer.getPokemon(0).getMoves(3));
    
          //Asks the user for their option selected
          choice = choiceRange(1,4);
    
          //Depending on each option, an action is performed
          //Option 1 represents the Pokemon's first attack
          if (choice == 1) {
    
            //Checks to see which Pokemon is faster
            if (pgPlayer.getPokemon(0).getSpeed() >= Arceus.getPokemon(0).getSpeed()) {
    
              //Runs the attack method, and then the defense method, since the Player's Pokemon is faster
              Attack(pgPlayer, Arceus, 0);
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(pgPlayer, Arceus, randInt);
              
            }
            else {
              //Runs the defense method, and then the attack method, since Red's Pokemon is faster
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(pgPlayer, Arceus, randInt);
              Attack(pgPlayer, Arceus, 0);
            }
          }
    
          //Option 2 represents the Pokemon's second attack
          else if (choice == 2) {
    
            //Checks to see which Pokemon is faster
            if (pgPlayer.getPokemon(0).getSpeed() >= Arceus.getPokemon(0).getSpeed()) {
    
              //Runs the attack method, and then the defense method, since the Player's Pokemon is faster
              Attack(pgPlayer, Arceus, 1);
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(pgPlayer, Arceus, randInt);
              
            }
            else {
              //Runs the defense method, and then the attack method, since Red's Pokemon is faster
              //Randomizes the opposing Pokemon's attack
              randInt = random.nextInt(2);
              Defense(pgPlayer, Arceus, randInt);
              Attack(pgPlayer, Arceus, 1);
            }
          }
    
          //Option 3 represents the Pokemon eating an Ultra Berry, or mega evolving
          else if (choice == 3) {
            megaEvolved = MegaOrBerry(pgPlayer, Arceus, megaEvolved);
            counter -= 1;
          }
    
          //Option 4 represents the Pokemon switching out for another
          else if (choice == 4) {
            switchPokemon(pgPlayer);
            //Randomizes the opposing Pokemon's attack
            randInt = random.nextInt(2);
            Defense(Player, Red, randInt);
          }
    
          //Checks at the end of each turn, to see if the opposing Pokemon has fainted or not
          if (Arceus.getPokemon(0).getRemainingHP() <= 0) {
            System.out.println("\n" + Arceus.getPokemon(0).getName() + " fainted");
            Arceus.removeFaintedPokemon();
          }
    
          //Checks at the end of each turn, to see if the opposing Pokemon has fainted or not
          if (pgPlayer.getPokemon(0).getRemainingHP() <= 0) {
            System.out.println("\n" + pgPlayer.getPokemon(0).getName() + " fainted");
            pgPlayer.removeFaintedPokemon();
            if (pgPlayer.getPokemonLeft() > 1) {
              switchPokemon(pgPlayer);
            }
          }
        }
    
        //The following runs if the Player's Pokemon all fainted. The game will also end there
        if (pgPlayer.getPokemonLeft() == 0) {
          System.out.println("\n---------------------------------------------------------------------------------------------------\nNarrator:\n   " + pgPlayer.getName() + " is out of usable Pokemon\n\n   ... ... ...\n\n   " + pgPlayer.getName() + " blacked out! " + pgPlayer.getName() + " was brought to the nearest Pokemon Centre by Oak.\n---------------------------------------------------------------------------------------------------\nOak:\n   Oh my god " + pgPlayer.getName() + ", Arceus was too powerful! I shouldn't have let you battle the Legendary Pokemon!\n---------------------------------------------------------------------------------------------------\nGAME OVER");
        }
    
        //The following runs if Red's Pokemon all fainted, and Player won. The game will continue and end the Post-Game Story
        else if (Arceus.getPokemonLeft() == 0) {
          System.out.println("\n---------------------------------------------------------------------------------------------------\nNarrator:\n   After defeating Arceus, " + pgPlayer.getName() + " felt excited again, and turned around to go back to Professor\n   Oak. To " + pgPlayer.getName() + "'s surprise, " + pgPlayer.getName() + " saw Professor Oak standing beside him.\n---------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("---------------------------------------------------------------------------------------------------\nOak:\n   Well done " + pgPlayer.getName() + ", you have completed yet another achievement today. I'm very proud of yo-\n   ... ... ...\n   Wait a second, ... " + pgPlayer.getName() + ", watch out! Arceus hasn't been defeated yet!\n---------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("---------------------------------------------------------------------------------------------------\nArceus:\n   Wh-, ... Wait a second. I'm back. ... I'M BACK! Oh thank you " + pgPlayer.getName() + " for saving me. Team Rocket\n   has been manipulating me this entire time. They will be punished for this. In the mean time, I\n   must fix all of the damage I have done.\n---------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("---------------------------------------------------------------------------------------------------\nNarrator:\n   Arceus flew to the sky, and generated a green beam, that covered the entire city. In a few seconds,\n   everything came back to normal. Professor Oak and " + pgPlayer.getName() + " proudly smiled, as everyone went back\n   to their homes.\n---------------------------------------------------------------------------------------------------\n[ENTER]");
          input.nextLine();
          System.out.println("---------------------------------------------------------------------------------------------------");
          
          //This section of code is for File Reading, and printing out ASCII image (Game Completion)
          Scanner gameCompletionFile = null;
          try {
            gameCompletionFile = new Scanner(new File("GameCompletion.txt"));
            while (gameCompletionFile.hasNext()) {
              String line = gameCompletionFile.nextLine();
              System.out.println(line);
            }
          }
          catch (Exception e) {
            System.out.println("File did not open.");
            System.exit(-1);
          }
        }
        System.exit(0);
    }
    
      /** Simulates the  Player's Pokemon attacking the opposing Player's Pokemon
       *  @param trainerMain - the Player
       *  @param trainerCPU - the opposing Player
       *  @param index - index
       */
      public static void Attack(Trainer trainerMain, Trainer trainerCPU, int index) {
        //Makes sure if the Pokemon has the needed HP
        if (trainerMain.getPokemon(0).getRemainingHP() > 0) {
    
          //Creates variables that will be used later
          Random random = new Random();
    
          //Calculates the amount of damage the attack can do
          int damageDealt = (int)((trainerMain.getPokemon(0).getMoveDamages(index) * trainerMain.getPokemon(0).getAttack()) / trainerCPU.getPokemon(0).getDefense());
    
          //Prints it out to tell the user the Pokemon has used it
          System.out.println("\n" + trainerMain.getPokemon(0).getName() + " used " + trainerMain.getPokemon(0).getMoves(index));
    
          //Determines if the oppposing Pokemon dodged it or not
          if (random.nextInt(1) > 0.85) {
            System.out.println(trainerCPU.getPokemon(0).getName() + " avoided the attack");
          }
          else if (random.nextInt(1) <= 0.85) {
    
            //Checks to see if the attack was super effective or not very effective
            for (String n : trainerCPU.getPokemon(0).getWeakness()) {
              if (n == trainerMain.getPokemon(0).getMoveTypes(index)) {
                damageDealt *= 2;
                System.out.println("\nIt was Super Effective!");
              }
            }
            for (String n : trainerCPU.getPokemon(0).getResistance()) {
              if (n == trainerMain.getPokemon(0).getMoveTypes(index)) {
                damageDealt /= 2;
                System.out.println("\nIt was Not Very Effective!");
              }
            }
            
            //Changes the health on the opposing Pokemon
            trainerCPU.getPokemon(0).setRemainingHP((int)(trainerCPU.getPokemon(0).getRemainingHP() - damageDealt));
          }
        }
      }
    
      
      /** Simulates the opposing Player's Pokemon attacking the Player's Pokemon
       *  @param trainerMain - the Player
       *  @param trainerCPU - the opposing Player
       *  @param index - index
       */
      public static void Defense(Trainer trainerMain, Trainer trainerCPU, int index) {
        //Makes sure if the Pokemon has the needed HP
        if (trainerCPU.getPokemon(0).getRemainingHP() > 0) {
          
          //Creates variables that will be used later
          Random random = new Random();
    
          //Calculates the amount of damage the attack can do
          int damageDealt = (int)((trainerCPU.getPokemon(0).getMoveDamages(index) * trainerCPU.getPokemon(0).getAttack()) / trainerMain.getPokemon(0).getDefense());
    
          //Prints it out to tell the user the Pokemon has used it
          System.out.println("\n" + trainerCPU.getPokemon(0).getName() + " used " + trainerCPU.getPokemon(0).getMoves(index));
    
          //Determines if the oppposing Pokemon dodged it or not
          if (random.nextInt(1) > 0.85) {
            System.out.println(trainerMain.getPokemon(0).getName() + " avoided the attack");
          }
          else if (random.nextInt(1) <= 0.85) {
            //Checks to see if the attack was super effective or not very effective
            for (String n : trainerMain.getPokemon(0).getWeakness()) {
              if (n == trainerCPU.getPokemon(0).getMoveTypes(index)) {
                damageDealt *= 2;
                System.out.println("\nIt was Super Effective!");
              }
            }
            for (String n : trainerMain.getPokemon(0).getResistance()) {
              if (n == trainerCPU.getPokemon(0).getMoveTypes(index)) {
                damageDealt /= 2;
                System.out.println("\nIt was Not Very Effective!");
              }
            }
            //Changes the health on the Player's Pokemon
            trainerMain.getPokemon(0).setRemainingHP((int)(trainerMain.getPokemon(0).getRemainingHP() - damageDealt));
          }
        }
      }
    
      /** Player's Pokemon eats a berry to increase health, or Mega evolves to increase stats
       *  @param trainerMain - the Player
       *  @param trainerCPU - the opposing Player
       *  @param megaEvolved - indicates if the Pokemon has mega evolved or not
       */
      public static boolean MegaOrBerry(Trainer trainerMain, Trainer trainerCPU, boolean megaEvolved) {
        //Creates variables that will be used later
          Random random = new Random();
    
        //Checks to see if the Pokemon can Mega evolve or not
        if (trainerMain.getPokemon(0).getMega() == false) {
          
          //Checks to see if the Pokemon is at max health
          if (trainerMain.getPokemon(0).getRemainingHP() == (trainerMain.getPokemon(0).getMaxHP())) {
            System.out.println("\n" + trainerMain.getPokemon(0).getName() + " is already at max HP");
          }
          else {
            //Tells the user that the Pokemon ate a berry, while increasing its health
            System.out.println("\n" + trainerMain.getPokemon(0).getName() + " ate an " + trainerMain.getPokemon(0).getMoves(2));
            int healthRecovered = (int)((trainerMain.getPokemon(0).getMoveDamages(2)));
            trainerMain.getPokemon(0).setRemainingHP((int)(trainerMain.getPokemon(0).getRemainingHP() + healthRecovered));
    
            //Makes sure the health doesn't go beyond the max health
            if (trainerMain.getPokemon(0).getRemainingHP() > trainerMain.getPokemon(0).getMaxHP()) {
              trainerMain.getPokemon(0).setRemainingHP(trainerMain.getPokemon(0).getMaxHP());
            }
    
            //Opposing Player attacks during this turn
            //Randomizes the opposing Pokemon's attack
            int randInt = random.nextInt(2);
            Defense(trainerMain, trainerCPU, randInt);
          }
        }
    
        else if (trainerMain.getPokemon(0).getMega() == true) {
          if (megaEvolved == false) {
            //Tells the user that the Pokemon mega evolved, while increasing its stats
            System.out.println("\n" + trainerMain.getPokemon(0).getName() + " " + trainerMain.getPokemon(0).getMoves(2) + "d");
            trainerMain.getPokemon(0).setAttack(trainerMain.getPokemon(0).getAttack()*1.10);
            trainerMain.getPokemon(0).setDefense(trainerMain.getPokemon(0).getDefense()*1.05);
            trainerMain.getPokemon(0).setSpeed(trainerMain.getPokemon(0).getSpeed()*1.15);
    
            trainerMain.getPokemon(0).setName("Mega " + trainerMain.getPokemon(0).getName());
    
            megaEvolved = true;
          }
          else {
            System.out.println("\n" + trainerMain.getPokemon(0).getName() + " already Mega Evolved!");
          }
        }
    
        return megaEvolved;
      }
    
      /** Switches 2 Pokemon in the Player's team
       *  @param trainerMain - the Player
       */
      public static void switchPokemon(Trainer trainerMain) {
        //Creates variables that will be used later
        int choice;
    
        //Checks to see if the Pokemon is the only Pokemon left
        if (trainerMain.getPokemonLeft() == 1) {
          System.out.println("\nYou have no more usuable Pokemon other than " + trainerMain.getPokemon(0).getName());
        }
        else {
          System.out.println("\nWho would you like to send out:");
          //Lets the user know who they can switch into
          for (int i = 0; i <= trainerMain.getPokemonLeft() - 1; i++) {
            System.out.println("   " + i + "-" + trainerMain.getPokemon(i).getName() + " Type[" + trainerMain.getPokemon(i).getType1() + trainerMain.getPokemon(i).getType2() + "] HP[" + trainerMain.getPokemon(i).getRemainingHP() + "/" + trainerMain.getPokemon(i).getMaxHP() + "]");
          }
    
          //Does the switching
          choice = choiceRange(0, trainerMain.getPokemonLeft() - 1);
          if (choice != 0) {
            System.out.println("\n" + trainerMain.getName() + " sent out " + trainerMain.getPokemon(choice).getName());
            trainerMain.switchPokemon(choice);
          }
        }
      }
    
      /** Makes sure that the user inputs the values inside the right range
       *  @param lowest - the lowest value the user can input
       *  @param highest - the highest value the user can input
       */
      public static int choiceRange(int lowest, int highest) {
        //Creates variables that will be used later
        Scanner input = new Scanner(System.in);
    
        int choice = input.nextInt();
    
        while (choice < lowest || choice > highest) {
          System.out.println("You must only give a value from " + lowest + " to " + highest + "!");
          choice = input.nextInt();
        }
    
    return choice;
    }
}