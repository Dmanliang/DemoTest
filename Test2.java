import java.util.Scanner;//needed for the scanner class
import java.util.Random;//needed for the random method

public class Test2 {

    public static void main(String[] args)
    {
        //get the user's name
        String name; //to hold the user's name
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your name\n");
        name = keyboard.nextLine();
        //Display the welcome message and the instructions of the game
        System.out.println(name + ", Welcome to the Dice Game! This program is designed by Feiya Yu and it allows you to play a little dice game.");
        System.out.println("Here are the rules for the game:A new player begins with his first dice roll (4 die = 1 set of dice). This is known as the \"starting roll.\"\n" +
                "If the player rolls a 6, 12, 13, 17, 19, or 23 the player wins.\n" +
                "If the player rolls a 9, 11, 18, or 24 the player loses.\n" +
                "If the player rolls any other number, the \"starting roll\" becomes the \"goal number.\"\n" +
                "The player must continue to roll the dice until either one of two things happens:\n" +
                "The player rolls a 23, and he loses.\n" +
                "The player rolls the \"goal number\" again, and you wins!\n");
        int total = 0; //to hold the total value of dice
        String input; //to hold input
        int goalnumber=0;
        boolean isfirst = true;
        String choice; //choice 1 or 2
        int times;   
        while(true){
        	System.out.println("Please choice the game type,enter \"1\" to play the game manually, or enter \"2\" to have the computer play on its own:\n");
        	choice = keyboard.nextLine();
	        if(choice.equals("1")){
	        	total = roll();
	            System.out.println("Simulating the rolling...");
	            System.out.println("Your total score is " + total);
	            if (total == 6 || total == 12 || total == 13 || total == 17 || total == 19 || total == 23) {
	                System.out.println("You Won!");
	            }else if (total == 9 || total == 11 || total == 18 || total == 24){
	                System.out.println("You lost.");
	            } else {
	                if (isfirst) {
	                    goalnumber = total;
	                    isfirst = false;
	                    System.out.println("You lost!");
	                }
	                System.out.println("Simulating the rolling again..");
	                while(true){
	                	total = roll();
		                if (total == goalnumber){
		                	System.out.println("You Won!");
		                }else if (total == 23){
		                	System.out.println("You lost!");
		                }else{
							System.out.println("You lost!");
		                }
	                }
	            }
	        }else if(choice.equals("2")){
	        	 System.out.print("Please input times:");
	        	 times = Integer.parseInt(keyboard.nextLine());
	        	 int count =0;
	    	     while(count <= times) {
		            total = roll();
		            count++;
		            System.out.println("Simulating the rolling...");
		            System.out.println("Your total score is " + total);
		            if (total == 6 || total == 12 || total == 13 || total == 17 || total == 19 || total == 23) {
		                System.out.println("You Won!");
		            }else if (total == 9 || total == 11 || total == 18 || total == 24){
		                System.out.println("You lost.");
		            } else {
		                if (isfirst) {
		                    goalnumber = total;
		                    isfirst = false;
		                    System.out.println("You lost!");
		                }
		                System.out.println("Simulating the rolling again..");
		                while(true){
		                	total = roll();
			                if (total == goalnumber){
			                	System.out.println("You Won!");
			                	break;
			                }else if (total == 23){
			                	System.out.println("You lost!");
			                	break;
			                }else{
								continue;
			                }
		                }
		            }
		        }
	        }else{
	        	System.out.print("The game is Eixt!");
	        	break;
	        }
	        System.out.println("if repeat?");
 			input = keyboard.nextLine();
 			if(input.equals("y") || input.equals("Y")){
 				continue;
 			}else{
 				System.out.println("The game over!");
 				break;
 			}
        }
    }
    

    
    //The roll method simulates the rolling of the dies.
    public static int roll() {
        int die1=(int)(Math.random()*6+1);
        int die2=(int)(Math.random()*6+1);
        int die3=(int)(Math.random()*6+1);
        int die4=(int)(Math.random()*6+1);
        int total = die1 + die2+ die3 + die4;
        System.out.println("die1,die2,die3,die4 is "+die1+","+die2+","+die3+","+die4+" and total is "+total);
        return total;
    }

    public class Die{
        private int die;
        
        public Die(int die){
        	this.die = die;
        }
        
        public int getDie(){
        	return die;
        }
        
        public void setDie(int die){
        	this.die = die;
        }
        
    }
}