package pk;
//import pk.Dice;
//import pk.Faces;
import java.util.Scanner;

public class game {
    private static Scanner input;

    public static void roll_eight() {
        Faces[] rolled = new Faces[8];
        Dice die = new Dice();
        for(int i = 0; i <= 8; i++){
            Faces die_roll = die.roll();
            rolled[i] =  die_roll;

        }

    }

    public static int num_games(){
        input =  new Scanner(System.in);
        System.out.println("Enter the number of games you'd like to play: ");
        int num_of_games =  input.nextInt();
        return num_of_games;
    }

    public static Boolean end_game(Faces[] rolled){
        int count = 0;
        Boolean end = false;
        for(int i = 0; i <=8; i++){
            if(rolled[i] == Faces.SKULL){
                count += 1;
            }
            if(count == 3){
                end = true;
            }
        }
        return end;
    }

    public static void keep_die(Faces[] rolled){
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
    }

    public static void score(int score, Faces[] rolled){
        int generatedcount =0;
        int sabercount = 0;
        int monkeycount = 0;
        int parrotcount = 0;
        int goldcount = 0;
        int diamondcount = 0;

        for(int i=0; i <=8; i++){
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

        if(generatedcount == 8){score += 500;}

        score += (goldcount + diamondcount)*100;
        
    }
    
    public static void main(){
        roll_eight();
    }
}
