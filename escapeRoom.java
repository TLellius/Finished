// CS-2011-05 & 6 Group Project File
// Tony Lau, Bryant Duong, Franciso Casillas Jr
// Desciption: Text Based adventure game included with puzzles to move through

import java.util.Scanner;
import java.util.Arrays;
// helps bring color for the text
import java.io.*;

public class escapeRoom {
  public static void main (String[] args) {
    // checks for -help
    if(args.length != 0 && args[0].equals("-help")) {
      showHelp();
    }
    Scanner input = new Scanner(System.in);
    String inputP = "";
    Boolean game = true; //decides if the game is still going or over
    long timeStart = System.currentTimeMillis();
    // decided which room to be in
    int room = 0;
    Boolean doorOne = false;
    Boolean doorTwo = false;
    Boolean doorThree = false;
    // strings used for the left, right, middle interaction for rooms 1-3
    String[] wallLeft = {"The white wall. There are three empty circles on"
                        + " top of a rectangular prism.",
                         "A few names come to mind while looking at these"
                         + " bookshelves, I wonder who they are.",
                         "You see a boy and girl are about to cross a busy"
                         + " street after getting out of school. She's a bit"
                         + " taller and seems to be talking a lot to that"
                         + " boy."};
    String[] wallMiddle = {"A wall of both black and white. There rests a table"
                        + ".", "Four portraits are nailed to the wall. While "
                        + "there are no mirrors, you can tell the only painted "
                        + "picture is of you. But who are the others?",
                        "You found words on the wall. However, these words seem"
                        + " to hold further meaning."};
    String[] wallRight = {"The black wall. There are three empty circles on"
                        + " top of a rectangular prism.",
                         "A few names come to mind while looking at these"
                         + " bookshelves. But why is it blurry?",
                         "You see cars stopped all around that street. So many "
                         + "people surrond the boy. Something on the street is "
                         + "too blurry to see, but under it is a pool of red."};
    //all the variables needed for Room One
    //icons: apple, dead tree, car, handholding, splatter, ice cream
    Boolean[] inventoryRoomOne = {false, false, false, false, false, false};
    Boolean[] inventoryRoomOneMiddle = {true, true, true, true, true, true};
    Boolean[] inventoryRoomOneLeft = {false, false, false};
    Boolean[] inventoryRoomOneRight = {false, false, false};
    int roomOneCompleteCheck = 0;

    //all the variables needed for Room Two
    // family names: Mom: Janet, Dad: Edward, Sister: Melanie,
    // Main Charcter: Jimmy
    String[] descRoomTwoLeft = {" \"Janet was a caring and extroverted women."
                                + " She cared for her children and wanted to"
                                + " make this world a better place for her "
                                + "family. Poker, Blackjack, she liked anything"
                                + " you could play with a standard set of"
                                + " 52 cards.\" ",
                                " \"Melanie was a smart and good girl going"
                                + " into her junior year of highschool. She"
                                + " would always get into petty fights with her"
                                + " brother. Not a huge fan of parties but"
                                + " often got pressued into joining.\" ",
                                " \"Edward was a hardworking and serious man,"
                                + " but under that hard shell he had a big"
                                + " heart and enjoyed vacations with his"
                                + " family. Loves his basketball.\" "};
    String[] descRoomTwoRight = {" \"Janet was only a shell of her former self."
                                + " She still had that outgoing spirit, but"
                                + " it always felt off and shallow. Loud for "
                                + " the sake of being loud. She became a poker"
                                + " addict, blaming her losses on how life is"
                                + " screwing her over constantly.\" ",
                                  "There doesn't seem to be anything you can"
                                + " find on Melanie.",
                                " \"Edward was still that hardworking and"
                                + " serious man, but he wasn't very talkative."
                                + " He spends most of his days off watching"
                                + " basketball without a single chuckle.\" "};
    Boolean[] roomTwoProgress = {false, false, false};
    int roomTwoCompleteCheck = 0;

    //all the variables needed for Room Three
    /*
    middle story: The conversation between the two siblings was distracting for
    them both. The two, Melanie and Jimmy, crossed the red light during rush
    hour traffic. At the last second, she had saw a car coming too fast, knowing
    it was too late for her she gave him a push back to the sidewalk.
    The car didn't slow down and ran over the poor girl. She was
    greatful that someone she loved could continue their life despite her
    mistakes.
    puzzle version: It was too late. The car was too fast. Melanie pushed Jimmy
    to the sidewalk, causing her to get fatally injured. In a minute, she was
    dead.
    }
    */
    String[] stringsRoomThree = {"causing her to get fatally injured.",
                                  "Melanie pushed Jimmy to the sidewalk,",
                                  "In a minute, she was dead.",
                                  "It was too late.",
                                  "The car was too fast."};

    int roomThreeProgress = 0;

    // Intro Statement to the story
    System.out.println("You wake up to a monochrome room. Black and white."
                      + " Good and bad. Both states exist, but who can tell"
                      + " which is which? What contains you in this place are"
                      + " four walls, but the one behind you doesn't have much"
                      + " on it. Looks  like the only ways to go are left, "
                      + "middle, and right. A hint of curiosity strokes your"
                      + " mind.");
    // while loop for game to run
    while(game) {
      //in 30 minutes, aka 1800000 milliseconds, you lose
      if ((System.currentTimeMillis()-timeStart) > 1800000) {
        System.out.println("Time's up.");
        System.exit(0);
      }
      System.out.println("\u001B[33m" + "Where will you go next?" +
                        "\u001B[0m");
      inputP = input.nextLine();
      if (inputP.toLowerCase().equals("middle")) {
        if (room == 0 && doorOne) {
          System.out.println("The door is open. Would you like to move on?");
          inputP = input.nextLine();
          if (inputP.toLowerCase().equals("yes")) {
            room = 1;
            System.out.println("A myriad of colors strike at your senses. It"
                              + " would take some time for your eyes to adjust."
                              + " This room is just as mysterious as the others"
                              + ". Only thing left to do is to explore this "
                              + "bright and colorful room.");
          }
        }
        else if (room == 1 && doorTwo) {
          System.out.println("Move to the next room?");
          inputP = input.nextLine();
          if (inputP.toLowerCase().equals("yes")) {
            room = 2;
            System.out.println("It was one foot after the other until he froze."
                              + " The fog in his head started to clear up, but"
                              + " did he want that to happen? Before making "
                              + "a final decision, he felt a set of hands on "
                              + "his back give him a push. He turned around "
                              + "to find the door shut. The only light source"
                              + " was a torch lit on the left side.");
          }
        }
        else if (room == 2 && doorThree) {
          System.out.println("Have you decided to leave?");
          inputP = input.nextLine();
          if (inputP.toLowerCase().equals("yes")) {
            room = 2;
            // end text for the end of the game
            System.out.println("As you walk through the door you hear a familar"
                              + " voice.");
            //Melanie speaking
            System.out.println("\u001B[35m" +" \"It's not your fault Jimmy, "
                              + "it never was. I should've been keeping a better"
                              + " eye on our surroundings.");
            // delay messages so user can read
            pause(2000);
            System.out.println("Please keep moving on with your life. You still"
                              + "have Mom and Dad. And.. tell them sorry"
                              + " for me.");
            pause(2000);
            System.out.println("I can't believe this is how I go out, huh? What"
                              + " an idiot I am.\" ");
            pause(2000);
            //Jimmy speaking
            System.out.println("\u001B[34m" + " \"Stop saying that! It's not "
                              + "fair! It's not fair at all for you to take "
                              + "all the blame!\" ");
            pause(2000);
            //Back to Melanie
            System.out.println("\u001B[35m" + " \"But it's true, though!.. "
                              + "Heheh. Well, thanks for that I guess. Tell Mom"
                              + " and Dad I'll be ok.\" " + "\u001B[0m");
            }
            game = !game;
        }
        else if (room != 2 || roomThreeProgress == 2) {
          System.out.println(wallMiddle[room]);
        }
      }
      else if (inputP.toLowerCase().equals("left")) {
        System.out.println(wallLeft[room]);
      }
      else if (inputP.toLowerCase().equals("right") && ((room != 2) ||
              (roomThreeProgress >= 1 && room == 2))) {
        System.out.println(wallRight[room]);
      }
      else if (inputP.toLowerCase().equals("right") && room == 2) {

      }
      else if (inputP.toLowerCase().equals("exit")) {
        System.exit(2);
      }
      else {
        System.out.println("Invalid action.");
      }
      // room check that contains the gimmicks of each room
      if (room == 0) {
        roomOne(input, inputP, inventoryRoomOne, inventoryRoomOneLeft,
                inventoryRoomOneRight, inventoryRoomOneMiddle, doorOne);
        roomOneCompleteCheck = 0;
        for (int i=0;i<3;i++) {
          if (inventoryRoomOneLeft[i] && inventoryRoomOneRight[i]) {
            roomOneCompleteCheck++;
          }
        }
        if (roomOneCompleteCheck == 3) {
          doorOne = !doorOne;
        }
      }
      else if (room == 1) {
        roomTwo(input, inputP, descRoomTwoLeft, descRoomTwoRight,
                roomTwoProgress, doorTwo);
        roomTwoCompleteCheck = 0;
        for (int i=0;i<roomTwoProgress.length;i++)
        {
          if (roomTwoProgress[i] == true) {
            roomTwoCompleteCheck++;
          }
        }
        if (roomTwoCompleteCheck == 3) {
          doorTwo = !doorTwo;
        }
      }
      else if (room == 2) {
        roomThreeProgress = roomThree(input, inputP, roomThreeProgress,
                            stringsRoomThree);
        if (roomThreeProgress == 3) {
          doorThree = true;
        }
      }
      else {
        System.exit(1); //supposed to be unreachable
      }
      pause(1000);
    }
  }
  // -help Method
  public static void showHelp() {
    System.out.println("Rules: User will type left, right, middle as their"
                        + " options and if the door is open, they will need to"
                        + " go to the middle room and type yes to keep moving"
                        + " on. If you want to quit, type exit to leave when "
                        + " prompted to pick a wall.");
    System.out.println("");
    System.out.println("Make sure to read closely as the text will include "
                      + "other needed inputs besides the usual options.");
    System.out.println("");
    System.out.println("Now, please enjoy a story of recollection, regret, and"
                        + " moving on.");
    System.out.println("");
    System.exit(0);
  }

  // first room Method
  public static void roomOne(Scanner input, String action, Boolean[] inventory,
                            Boolean[] wallLeft, Boolean[] wallRight,
                            Boolean[] wallMiddle, boolean door) {
    int inventoryCheck = 0; //checks if player already has an icon
    for (int k=0;k<6;k++) {
      if (inventory[k])
      {
        inventoryCheck++;
      }
    }
    if (action.toLowerCase().equals("left")) {
      int correct = 0; //checks how many icons are on the left wall
      for (int i=0;i<3;i++)
      {
        if (wallLeft[i])
        {
          correct++;
        }
      }
      System.out.println("There are " + correct + " icons on this wall.");
      if (inventory[0] || inventory[3] || inventory[5]) {
        insertIcon(input, action, inventory, wallLeft, wallRight);
      }
      else {
        System.out.println("It doesn't seem like what you're currently holding"
                          + " is applicable here.");
      }
    }
    else if (action.toLowerCase().equals("right")) {
      int correct = 0; //checks how many icons are on the right wall
      for (int i=0;i<3;i++)
      {
        if (wallRight[i])
        {
          correct++;
        }
      }
      System.out.println("There are " + correct + " icons on this wall.");
      if (inventory[1] || inventory[2] || inventory[4]) {
        insertIcon(input, action, inventory, wallLeft, wallRight);
      }
      else {
        System.out.println("It doesn't seem like what you're currently holding"
                          + " is applicable here.");
      }
    }
    else if (action.toLowerCase().equals("middle") && inventoryCheck == 0
            && door == false) {
      System.out.println("\u001B[33m" + "There are icons on the table. Which "
                        + "icons 1 - 6 will you be taking?" + "\u001B[0m");
      int actionInt = input.nextInt();
      action = input.nextLine();
      // certain icons will bring up certain messages relating to story
      if ((actionInt-1) >= 0) {
        if (wallMiddle[actionInt-1] = true) {
          inventory[actionInt-1] = true;
          wallMiddle[actionInt-1] = false;
          System.out.println("Icon " + (actionInt) + " is obtained.");
          switch (actionInt-1) {
            case 0: System.out.println("You picked up an icon having an"
                                      + " apple.");
                    break;
            case 1: System.out.println("You picked up an icon showing a dead"
                                      + " tree.");
                    break;
            case 2: System.out.println("You pick up an icon showing a crashed"
                                      + " car. The image makes you slightly"
                                      + " tremble. But, why?");
                    break;
            case 3: System.out.println("You pick up an icon showing hands"
                                      + " holding. The hand looks familiar."
                                      + " It brings you comfort.");
                    break;
            case 4: System.out.println("You pick up an icon showing blood"
                                      + " splatter. The longer you stare at it,"
                                      + " the more the hole in your heart aches"
                                      + ". Let's move on.");
                    break;
            case 5: System.out.println("You picked up an icon with ice cream. A"
                                      + " tender feeling rings in your heart.");
                    break;
            default: System.out.println("You've already used that icon.");
                     break;
        }
      }
    }
  }
}
  // method to check if icons match to those in inventory and see if those will
  // fit in the wall
  public static void insertIcon(Scanner input, String action,
                                Boolean[] inventory, Boolean[] wallLeft,
                                Boolean[] wallRight) {
    System.out.println("\u001B[33m"+ "Would you like to insert the icon?"
                      + "\u001B[0m");
    action = input.nextLine();
    if (action.toLowerCase().equals("yes"))
    {
      System.out.println("You push the icon into the circle. You feel a " +
                        "rumbling that ends as suddenly as it appeared.");
      if (inventory[0]) {
          inventory[0] = false;
          wallLeft[0] = true;
      }
      else if (inventory[3]) {
          inventory[3] = false;
          wallLeft[1] = true;
      }
      else if (inventory[5]) {
          inventory[5] = false;
          wallLeft[2] = true;
      }
      else if (inventory[1])
      {
        inventory[1] = false;
        wallRight[0] = true;
      }
      else if (inventory[2]) {
        inventory[2] = false;
        wallRight[1] = true;
      }
      else if (inventory[4]) {
        inventory[4] = false;
        wallRight[2] = true;
      }
      else {
        System.exit(1);
      }
    }
  }
  // second room method
  public static void roomTwo(Scanner input, String action, String[] leftWall,
                            String[] rightWall, Boolean[] complete,
                            Boolean door) {
    if (action.toLowerCase().equals("left")) {
      descFamily(input, action, leftWall);
    }
    else if (action.toLowerCase().equals("right")) {
      descFamily(input, action, rightWall);
    }
    else if (action.toLowerCase().equals("middle") && (!door)) {
      String[] dialogue = {" \"What was Dad's name?\" ", " \"A rumble. Must "
                          + "mean it was correct. Now who was Mom again...?\" ",
                          " \"Another rumble. Ok. And.. who was.. Sis.. \" ",
                          " \"..Melanie.\" "};
      System.out.println("\u001B[33m" + "Are you ready to guess?" +
                        "\u001B[0m");
      action = input.nextLine();
      if (action.toLowerCase().equals("yes")) {
        System.out.println("\u001B[33m" + dialogue[0] + "\u001B[0m");
        action = input.nextLine();
        if (action.toLowerCase().equals("edward")) {
          complete[0] = true;
          System.out.println("\u001B[33m" + dialogue[1] + "\u001B[0m"); {
            action = input.nextLine();
            if (action.toLowerCase().equals("janet")) {
              complete[1] = true;
              System.out.println("\u001B[33m" + dialogue[2] + "\u001B[0m");
              {
                action = input.nextLine();
                if (action.toLowerCase().equals("melanie")) {
                  complete[2] = true;
                  System.out.println("\u001B[33m" + dialogue[3] + "\u001B[0m");
                }
              }
            }
          }
        }
      }
    }
  }
  //methods for left and right walls of room two
  public static void descFamily(Scanner input, String action, String[] wall) {
    System.out.println("\u001B[33m" + "Janet, Melanie, and Edward... Who do you"
                      + " want to read up on?" + "\u001B[0m");
    action = input.nextLine();
    // certain names will call upon those walls for the text
    if (action.toLowerCase().equals("janet")) {
      System.out.println(wall[0]);
    }
    else if (action.toLowerCase().equals("melanie")) {
      System.out.println(wall[1]);
    }
    else if (action.toLowerCase().equals("edward")) {
      System.out.println(wall[2]);
    }
    else {
      System.out.println("There seems to be no details related to that "
                        + "unfamiliar name.");
    }
  }
  // third room Method
  public static int roomThree(Scanner input, String action, int progress,
                              String[] stringsRoomThree) {
    // restricts user from going middle before right wall
    if (action.toLowerCase().equals("left")) {
      if (progress == 0) {
        System.out.println("The torch over the right wall lights up.");
        progress = 1;
      }
    }
    else if (action.toLowerCase().equals("right")) {
      if (progress >= 1) {
        if (progress == 1) {
          progress = 2;
          System.out.println("The torch over the front wall lights up.");
        }
      else {
        System.out.println("It's too dark to see anything...");
      }
    }
      else {
        System.out.println("It's too dark to see anything...");
      }
    }
    else if (action.toLowerCase().equals("middle")) {
      if (progress == 2) {
        progress = sortRoomThree(input, action, progress, stringsRoomThree);
      }
      else if (progress < 2) {
        System.out.println("It's too dark to see anything...");
      }
    }
    return progress;
  }
  // method for third room for the puzzle
  public static int sortRoomThree(Scanner input, String action, int progress,
                                  String[] stringsRoomThree) {
    int actionInt;
    String tempStringOne = "";
    String tempStringTwo = "";
    int tempIntOne = -1;
    Boolean roomThreePuzzle = true;

    while(roomThreePuzzle) {
      System.out.println("\u001B[33m" + "Would you like to read, sort, or leave"
                        + " the words alone?" + "\u001B[0m");
      action = input.nextLine();
      if (action.toLowerCase().equals("read")) {
        System.out.println( "\u001B[33m" + "It seems there is a lot of text"
                          + " here labeled 1 to 5 which one to read?"
                          + "\u001B[0m");
        actionInt = input.nextInt();
        if (actionInt <= 4) {
          System.out.println(stringsRoomThree[actionInt-1]);
        }
      }
      else if (action.toLowerCase().equals("sort")) {
        System.out.println("\u001B[33m" + "Which words will you be swapping"
                          + " from 1 to 5?" );
        actionInt = input.nextInt();
        if (actionInt <= 5) {
          tempStringOne = stringsRoomThree[actionInt-1];
          tempIntOne = actionInt;
          System.out.println("Pick another from 1 to 5.");
          actionInt = input.nextInt();
          if (actionInt <= 5) {
            tempStringTwo = stringsRoomThree[actionInt-1];
            stringsRoomThree[tempIntOne-1] = tempStringTwo;
            stringsRoomThree[actionInt-1] = tempStringOne;
            tempStringOne = "";
            tempStringTwo = "";
            tempIntOne = -1;
            // will print out what current order of the statements are
            System.out.println(stringsRoomThree[0] + " " + stringsRoomThree[1] +
                              " " + stringsRoomThree[2] + " " +
                              stringsRoomThree[3] + " " + stringsRoomThree[4]);
          }
          else {
            System.out.println("Invalid input.");
          }
        }
        else {
          System.out.println("Invalid input.");
        }
        if ((stringsRoomThree[0].equals("It was too late.")) &&
          (stringsRoomThree[1].equals("The car was too fast.")) &&
          (stringsRoomThree[2].equals("Melanie pushed Jimmy to the sidewalk,"))
          && (stringsRoomThree[3].equals("causing her to get fatally injured."))
          && (stringsRoomThree[4].equals("In a minute, she was dead."))) {
            System.out.println(" \"I remember now.\" ");
            progress = 3;
            roomThreePuzzle = !roomThreePuzzle;
          }
        }
      else if (action.toLowerCase().equals("leave")) {
        roomThreePuzzle = !roomThreePuzzle;
        action = "";
      }
    }
    return progress;
  }

  public static void pause(long milliseconds) {
   try {
     Thread.sleep(milliseconds);
   } catch (InterruptedException ie) {}
  }
}
