import java.util.*;
import java.util.ArrayList;

class Main {
  public static void main(String[] args) {
    pPlayer player1;
    String answer; //input for strings
    int intAnswer; // input for integers

    String[] suits = {"Hearts", "Diamonds", "Clubs", "Spades"};
    String[] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    ArrayList<cCard> numberDeck = new ArrayList<>();
    ArrayList<cCard> arithmeticDeck = new ArrayList<>();

    for (String suit : suits) {
        for (String rank : ranks) {
            int value;
            if (rank.equals("Ace")) {
                value = 1;
            } else if (rank.equals("King") || rank.equals("Queen") || rank.equals("Jack")) {
                value = 10;
            } else {
                value = Integer.parseInt(rank);
            }

            numberDeck.add(new cCard(rank + " of " + suit, value));
        }
    }

    Scanner input = new Scanner(System.in);
    System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n");
    System.out.println("Hello and welcome to PolyCards Gambler's Artifice!");
    System.out.println("Do you have a save file you wish to Load? Y/N");
    System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n");
    answer = input.nextLine();
    System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n");

    if (answer.equals("Y")){
      //player1.syncData();
      System.out.println("Sorry, this feature is not accessible yet.");
    }

    do {
      System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n");
      System.out.printf("Welcome, %s!\n", player1.getName());
      System.out.printf("You currently have %d moolahz.\n\n", player1.getChips());
      System.out.printf("Choose between the following choices:\n1. Buy more moolahz. (Developer Option)\n2. Challenge players in an arena\n3. Change your name\n4. Save the game\n5. Close the game\n");
      System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n\n");  

      try {
        intAnswer=input.nextInt();
        switch (intAnswer){
          case 1:
          System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n");
          System.out.printf("Please Input (in integer form) the amount of chips to add.");
          System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n\n");  
          intAnswer = input.nextInt();
          player1.setChips(intAnswer);
          break;

          case 2:
            String continueInput = "";
            while(!continueInput.equals("No") || !continueInput.equals("no")){
              System.out.println("Player 1, How many chips would you like to bet?");  
              int bet = input.nextInt(); 
              do {
                player1.draw(numberDeck);
                player1.draw(arithmeticDeck);
                player1.draw(arithmeticDeck);
                player2.draw(numberDeck);
                player2.draw(arithmeticDeck);
                player2.draw(arithmeticDeck);
                player1.roundScore = player1.calculate();//Calculate method calculates round score of a player based on their number cards.
                player1.roundScore = player1.calculate();//Calculate method calculates round score of a player based on their number cards.
                int counting = 0;
                if(player1.roundScore > player2.roundScore) counting = 1;
                for(int i = 0; i < 5; i++){
                  Scanner turnInput = new Scanner(System.in);
                  int action = 0;
                  if((counting % 2 ) == 0) {
                    //player1 goes first
                    System.out.println("Which would you like to do?\n Draw a card. \n Play a card. \n Skip your turn.");
                    action = turnInput.nextInt();
                    switch(action){
                      case 1:
                        player1.draw(totalDeck);
                        break;
                      case 2:
                        player1.playCard(turnInput);
                        break;
                      default:
                      System.out.println("You skipped your turn.");
                    }
                    counting +=1;
                    player1.testScore();
                    player2.testScore();
                  } else {
                    //player2 goes first
                    System.out.println("Which would you like to do?\n Draw a card. \n Play a card. \n Skip your turn.");
                    action = turnInput.nextLine();
                    switch(action){
                      case 1:
                        player1.draw(totalDeck);
                        break;
                      case 2:
                        player1.playCard(turnInput);
                        break;
                      default:
                      System.out.println("You skipped your turn.");
                    }
                    counting += 1;
                    player1.testScore();
                    player2.testScore();
                  }
                  if ((player1.roundScore > player2.roundScore) && (player1.roundscore < 21)) player1.score += 1;
                  else player2.score += 1;


                }
              } while((player1.score == 11) || (player2.score == 11));
              if(player1.score == 11){
                System.out.println(player1.getName + " wins!");
              } else {
                System.out.println(player2.getName + " wins!");
              }
              System.out.println("Do you wish to continue another game?");
              continueInput = input.nextLine(); 
              }
          break;

          case 3:
          player1.changeName(input);
          break;

          case 4:
          //player1.saveGame(input);
             System.out.println("This feature doesn't exist yet...");
          break;

          case 5:
          break;

          default:
          throw new IllegalArgumentException();
          break;
        }
      } catch (NumberFormatException e) {
        System.out.println("Error 001: Please input an integer next time.");
      } catch (IllegalArgumentException e) {
        System.out.println("Error 002: Please input a valid choice number next time.");
      }


    } while (intAnswer!=5);

    System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n");
    System.out.println("Thank you so much for playing PolyCards Gambler's Artifice!");
    System.out.println("Please play again next time...");
    System.out.printf("----- ----- ----- ----- ----- ----- ----- ----- ----- -----\n");
  }
}