package pk;
//import pk.Dice;
//import pk.Faces;
//import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class game {
    //private static Scanner input;

    //rolls eight die
    public static Faces[] roll_eight() { 
        Faces[] rolled = new Faces[8];
        Dice die = new Dice();
        
        for(int i = 0; i < 8; i++){
            Faces die_roll = die.roll();
            rolled[i] =  die_roll;
        }
        return rolled;
    }


    //plays a turn using random strategy
    public static void random_turn(Player player){
        Faces[] die = player.getdie();
        Boolean end =  end_game(die);
        Random motive= new Random();
        Boolean[] motive_arr = new Boolean[8];
        System.out.println("  (DEBUG) endgame? " + end);
        int num_to_reroll = 0;

        //picks which die to keep and which to reroll randomly
        for(int i = 0; i < 8; i++){
            motive_arr[i] = motive.nextBoolean();
            if(motive_arr[i] == true && die[i] != Faces.SKULL){
                num_to_reroll += 1;

            } 
        }
        if(num_to_reroll >= 2){
            if(end_game(die) == false){
                for(int i=0; i < die.length; i++){
                    if(end_game(die) == false){
                        //System.out.println("here");
                        //System.out.println("motive " + motive);
                        if(die[i] != Faces.SKULL && motive_arr[i]){
                            die[i] = reroll();
                            System.out.println("rerolled at index " + i);
                            System.out.println("  (DEBUG) new roll " + Arrays.toString(die));
                        }    
                    }
                }
            }
        }
        
        player.updatedie(die);
        System.out.println("here");
        
        //if the player roll 3 skull --> scores
        if(!end_game(die)){
            score(player);
        }
        return;
    }



    //plays using combo-driven strategy
    public static void combo_turn(Player player){
        System.out.println("got to here");
        Faces[] rolled = player.getdie();
        //Boolean end = end_game(rolled);
        Faces common = Faces.DIAMOND;

        int sabercount = 0;
        int monkeycount = 0;
        int parrotcount = 0;
        int goldcount = 0;
        int diamondcount = 0;
        int skullcount = 0;

        for(int i=0; i <8; i++){
            if(rolled[i] == Faces.SABER){
                sabercount += 1;
            }else if(rolled[i] == Faces.MONKEY){
                monkeycount += 1;
            }else if(rolled[i] == Faces.PARROT){
                parrotcount += 1;
            }else if(rolled[i] == Faces.GOLD){
                goldcount += 1;
            }else if(rolled[i] == Faces.DIAMOND){
                diamondcount += 1;
            }else{
                skullcount += 1;
            }
        }
        System.out.println("got to here 2");
        
        int[] counts = {sabercount, monkeycount, parrotcount, goldcount, diamondcount};
        Arrays.sort(counts);

        if(player.getcard() == FortuneCards.SEABATTLE_2 || player.getcard() == FortuneCards.SEABATTLE_3 || player.getcard() == FortuneCards.SEABATTLE_4){
            common = Faces.SABER;
        }else {
            if(counts[4] == sabercount){
                common = Faces.SABER;
            }else if(counts[4] == monkeycount){
                common = Faces.MONKEY;
            }else if(counts[4] == parrotcount){
                common = Faces.PARROT;
            }else if(counts[4] == goldcount){
                common = Faces.GOLD;
            }else if(counts[4] == diamondcount){
                common = Faces.DIAMOND;
            }
        }
        
        
        if(end_game(rolled) == false && skullcount <= 2){
            for(int i=0; i < rolled.length; i++){
                System.out.print("here 3");
                if(end_game(rolled)== false){
                    if(rolled[i] != Faces.SKULL && rolled[i] != common){
                        rolled[i] = reroll();
                    }
                }
            }
        }
        
        player.updatedie(rolled);

        if(end_game(rolled) == false){
            score(player);
        }

        return;
    }


    //returns one reroll
    public static Faces reroll(){
        Dice die = new Dice();
        Faces die_roll = die.roll();
        return die_roll;
    }



    public static Faces[] roll_again(Faces[] reroll){
        int num_rolls = reroll.length;
        Dice die = new Dice();
        for(int i = 0; i <= num_rolls; i++){
            Faces die_roll = die.roll();
            reroll[i] = die_roll;
        }
        return reroll;

    }



    //returns the number of games being played
    public static int num_games(){
        /*input =  new Scanner(System.in);
        System.out.println("Enter the number of games you'd like to play: ");
        int num_of_games =  input.nextInt(); */
        int num_of_games = 42;
        return num_of_games;
    }



    //checks whether a turn should end
    public static Boolean end_game(Faces[] rolled){
        int count = 0;
        Boolean end = false;
        for(int i = 0; i < 8; i++){
            if(rolled[i] == Faces.SKULL){
                count += 1;
            }
            if(count == 3){
                end = true;
            }
        }
        return end;
    }

    /*public static void keep_die(Faces[] rolled){
        Faces[] keep =  new Faces[8];
        input = new Scanner(System.in);

        for(int i=0; i <=8; i++){
            System.out.println("Die"+i+" rolled " + rolled[i]);

            System.out.println("Would you like to keep this die? (y/n): ");
            String motive = input.nextLine();
            
            if(motive == "y" || motive == "Y"){
                keep[i] = rolled[i];
            }

        }
    }*/



    //calculates the score after a turn has ended
    public static void score(Player player){
        int score = player.getscore();
        Faces[] rolled = player.getdie();
        FortuneCards card = player.getcard();
        
        int generatedcount =0;
        int sabercount = 0;
        int monkeycount = 0;
        int parrotcount = 0;
        int goldcount = 0;
        int diamondcount = 0;

        for(int i=0; i <8; i++){
            if(rolled[i] == Faces.SABER){
                sabercount += 1;
            }else if(rolled[i] == Faces.MONKEY){
                monkeycount += 1;
            }else if(rolled[i] == Faces.PARROT){
                parrotcount += 1;
            }else if(rolled[i] == Faces.GOLD){
                goldcount += 1;
            }else if(rolled[i] == Faces.DIAMOND){
                diamondcount += 1;
            }
        }

        //takes into account fortune cards
        if(card == FortuneCards.SEABATTLE_2){
            if(sabercount >= 2){
                score += 300;
            }else{
                score -= 300;
            }
       
        }else if (card == FortuneCards.SEABATTLE_3){
            if(sabercount >= 3){
                score += 500;
            }else{
                score -= 500;
            }
        
        }else if (card == FortuneCards.SEABATTLE_4){
            if(sabercount >= 4){
                score += 1000;
            }else{
                score -= 1000;
            }
        
        }else if (card == FortuneCards.MONKEYBUSINESS){
            monkeycount += parrotcount;
            parrotcount = 0;
        }

        //for each set of identical objects, calculates the score
        if(sabercount == 3){score += 100; generatedcount +=3;}
        if(sabercount == 4){score += 200; generatedcount +=4;}
        if(sabercount == 5){score += 500; generatedcount +=5;}
        if(sabercount == 6){score += 1000; generatedcount +=6;}
        if(sabercount == 7){score += 2000; generatedcount +=7;}
        if(sabercount == 8){score += 4000; generatedcount +=8;}

        if(monkeycount == 3){score += 100; generatedcount +=3;}
        if(monkeycount == 4){score += 200; generatedcount +=4;}
        if(monkeycount == 5){score += 500; generatedcount +=5;}
        if(monkeycount == 6){score += 1000; generatedcount +=6;}
        if(monkeycount == 7){score += 2000; generatedcount +=7;}
        if(monkeycount == 8){score += 4000; generatedcount +=8;}

        if(parrotcount == 3){score += 100; generatedcount +=3;}
        if(parrotcount == 4){score += 200; generatedcount +=4;}
        if(parrotcount == 5){score += 500; generatedcount +=5;}
        if(parrotcount == 6){score += 1000; generatedcount +=6;}
        if(parrotcount == 7){score += 2000; generatedcount +=7;}
        if(parrotcount == 8){score += 4000; generatedcount +=8;}
        
        if(goldcount == 3){score += 100; generatedcount +=3;}
        if(goldcount == 4){score += 200; generatedcount +=4;}
        if(goldcount == 5){score += 500; generatedcount +=5;}
        if(goldcount == 6){score += 1000; generatedcount +=6;}
        if(goldcount == 7){score += 2000; generatedcount +=7;}
        if(goldcount == 8){score += 4000; generatedcount +=8;}

        if(diamondcount == 3){score += 100; generatedcount +=3;}
        if(diamondcount == 4){score += 200; generatedcount +=4;}
        if(diamondcount == 5){score += 500; generatedcount +=5;}
        if(diamondcount == 6){score += 1000; generatedcount +=6;}
        if(diamondcount == 7){score += 2000; generatedcount +=7;}
        if(diamondcount == 8){score += 4000; generatedcount +=8;}

        // if all 8 die generated a score, 500 more points awarded
        if(generatedcount == 8){score += 500;}

        score += (goldcount + diamondcount)*100;

        player.updatescore(score);
        return;
    }
    

    //main function, runs all turns
    public static void main(String strat){
        strat.toLowerCase();
        
        int numofgames = num_games();
        CardDeck deck = new CardDeck();
        deck.make_and_shuffle();

        Player player1 = new Player(0, null, null);
        Player player2 = new Player(0, null, null);


        if(strat == "random random"){
            while(numofgames >= 1){
                System.out.println("  (DEBUG) num of games = " + numofgames);
                while(player1.getscore() < 6000 && player2.getscore() < 6000){
                    player1.updatedie(roll_eight());
                    System.out.println("  (DEBUG) player1 rolled " + Arrays.toString(player1.getdie()));
                    player1.updatecard(deck.draw());
                    System.out.println("  (DEBUG) player1 drew " + player1.getcard());
                    random_turn(player1);
                    System.out.println("  (DEBUG) player1 score " + player1.getscore());

                    if(player1.getscore() < 6000){
                        player2.updatedie(roll_eight());
                        player2.updatecard(deck.draw());
                        random_turn(player2);
                        System.out.println("  (DEBUG) player2 score " + player2.getscore());
                    }
                }

                if(player1.getscore() >= 6000){
                    player1.updatewins();
                }else if(player2.getscore() >= 6000){
                    player2.updatewins();
                }else{
                    player1.updatewins();
                    player2.updatewins();
                }
                System.out.println("player 1 wins: " + player1.getwins());
                System.out.println("player 2 wins: " + player2.getwins());
                player1.updatescore(numofgames); //maven is skipping so do this to avoid, reset after
                player1.reset();
                player2.reset();
                numofgames--;
            }

        }else if((strat =="random combo") || (strat == "combo random")){
            while(numofgames >= 1){
                while(player1.getscore() < 6000 && player2.getscore() < 6000){
                    player1.updatedie(roll_eight());
                    System.out.println("  (DEBUG) player1 rolled " + Arrays.toString(player1.getdie()));
                    player1.updatecard(deck.draw());
                    System.out.println("  (DEBUG) player1 drew " + player1.getcard());
                    random_turn(player1);
                    System.out.println("  (DEBUG) player1 score " + player1.getscore());
                    
                    if(player1.getscore() < 6000){
                        player2.updatedie(roll_eight());
                        System.out.println("  (DEBUG) player2 rolled " + Arrays.toString(player2.getdie()));
                        player2.updatecard(deck.draw());
                        System.out.println("  (DEBUG) player2 drew " + player2.getcard());
                        combo_turn(player2);
                        System.out.println("  (DEBUG) player2 score " + player2.getscore());
                    }

                }
                 if(player1.getscore() >= 6000){
                    player1.updatewins();
                }else if(player2.getscore() >= 6000){
                    player2.updatewins();
                }else{
                    player1.updatewins();
                    player2.updatewins();
                }
                player1.updatescore(numofgames); //maven is skipping so do this to avoid, reset after
                System.out.println("player 1 wins: " + player1.getwins());
                System.out.println("player 2 wins: " + player2.getwins());
                player1.reset();
                player2.reset();
                numofgames--;
            }

        }else if(strat =="combo combo"){
            while(numofgames >= 1){
                while(player1.getscore() < 6000 && player2.getscore() < 6000){
                    player1.updatedie(roll_eight());
                    player1.updatecard(deck.draw());
                    combo_turn(player1);
                    
                    if(player1.getscore() < 6000){
                        player2.updatedie(roll_eight());
                        player2.updatecard(deck.draw());
                        combo_turn(player2);
                    }

                }
                 if(player1.getscore() >= 6000){
                    player1.updatewins();
                }else if(player2.getscore() >= 6000){
                    player2.updatewins();
                }else{
                    player1.updatewins();
                    player2.updatewins();
                }
                System.out.println("player 1 wins: " + player1.getwins());
                System.out.println("player 2 wins: " + player2.getwins());
                System.out.println("player 1 win percentage: " + (player1.getwins()/42) + "%");
                System.out.println("player 2 win percentage: " + (player2.getwins()/42) + "%");

                player1.updatescore(numofgames); //interations skipping so do this to avoid, reset after
                player1.reset();
                player2.reset();
                numofgames--;
            }

        }


    }
}
