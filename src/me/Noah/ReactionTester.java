package me.Noah;
import java.util.Random;

/**
 * This class will contain a few methods that
 *  will help run the Reaction Tester "Game"
 *
 * @author Nkinlaw
 * @version 5/20/2021
 */
public class ReactionTester {
    //Instance Variables
    private int myRandomNumber;

    //Instance
    Random rand = new Random();

    //Constructor for objects of the class
    public ReactionTester(){
        //Init instance variables
        myRandomNumber = (int)(Math.random()*5+1);//Uses Math class to create a random num
    }

    //METHODS
    /**
     * SimpleCountDown method - this will count down for us
     */
    public void simpleCountDown(){
        //This block of code will loop through a countdown
        for(int countDown = 5; countDown > 0; countDown--){
            System.out.println(countDown);
            try{
                Thread.sleep(1000);
            }catch (InterruptedException ex){
                //Hope this works
                System.out.println("I've been interrupted");
            }
        }
    }//End of simpleCountDown

    /**
     * The randomSleepTime method will create a
     *  pause for a "random" amount of time
     */
    public void randomSleepTime(){
        myRandomNumber = rand.nextInt(5)+1;
        try{
            Thread.sleep(myRandomNumber*1000);
        }catch (InterruptedException ex){
            //Hope this works
            System.out.println("I've been interrupted");
        }
    }//END of randomSleepTime

}//END of Class