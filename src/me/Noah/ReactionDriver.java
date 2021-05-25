package me.Noah;
import java.util.Scanner;
import java.lang.Thread;
import java.time.*;

/**
 * This is the Reaction Tester class that will
 *  run the methods from the Reaction Tester class.
 *
 * @author Nkinlaw
 * @version 5/20/2021
 */
public class ReactionDriver {
    public static void main(String[] args) {
        //Variables
        String doYouWantToPlay = ""; //Stores the User's Yes or No answer
        String enterPressed = "";
        boolean keepPlaying = true; //Allow the code to continue to loop
        double reactionTime = 0;
        double totalReactionTime = 0;
        int tries = 0;


        Scanner myKeyboard = new Scanner(System.in);
        ReactionTester rg1 = new ReactionTester();

        do{
            System.out.println("Would you like to test your reaction time (Y or N)?");
            doYouWantToPlay = myKeyboard.next();
            if(myKeyboard.hasNextLine()){
                enterPressed = myKeyboard.nextLine();
            }

            if(doYouWantToPlay.equalsIgnoreCase("Y")){
                System.out.println("This is a Reaction time tester... Here is how it works?");
                System.out.println("Rules: \n1.The counter will count down\n2.Once you see the line" +
                        "\"GO, press the ENTER Key\" press enter\n3.Then wait for the line to display" +
                        "again.\n4.This will repeat a number of times.");



                //Call Count Down Method from Reaction Tester
                //The method will loop through a countdown for
                // the user.
                rg1.simpleCountDown();

                //Interact with the user to test reaction time
                for(int i = 1; i <= 5; i++){
                    tries = i;
                    long tStart = System.currentTimeMillis();
                    System.out.println("GO, press the ENTER key");
                    if(myKeyboard.hasNextLine()){
                        enterPressed = myKeyboard.nextLine();
                    }

                    //Track the user time
                    long tEnd = System.currentTimeMillis();
                    long tElapsed = tEnd - tStart;
                    reactionTime = tElapsed / 1000.0;
                    System.out.println("You took " + reactionTime + " seconds.\n");
                    totalReactionTime = totalReactionTime + reactionTime;

                    System.out.println("WAIT....\n");
                    rg1.randomSleepTime();
                }//END OF LOOP
                System.out.println("");

                System.out.println("Calculating Score...");
                System.out.println("Your total reaction time was: " + totalReactionTime + " seconds.");
                System.out.printf("This means your average is: %.4f seconds.", totalReactionTime/tries);

                System.out.println("");
            }
            else if(doYouWantToPlay.equalsIgnoreCase("N")){
                System.out.println("\n");
                System.out.println("Goodbye");
                keepPlaying = false;
            }
            else{
                System.out.println("That is not a valid option.\n" +
                        "Please choose between Y or N.\n");
            }

        }while(keepPlaying);
    }

}//End of Class