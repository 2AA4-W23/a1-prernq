package pk;
import java.util.Random;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;

public class CardDeck {
    private FortuneCards[] deck = new FortuneCards[35];
    private int deckIndex = 0;

    public FortuneCards draw(){
        if (deckIndex == deck.length-1) {
            make_and_shuffle();
            deckIndex=0;
        }
        FortuneCards card = deck[deckIndex++];

        return card;

    }

    public FortuneCards[] make_and_shuffle(){
        int monkeyBusinessCount = 0;
        int seabattleCount = 0;

        for(int i =0; i < 35; i++){
            if(seabattleCount< 2){
                deck[i] = FortuneCards.SEABATTLE_2;
                seabattleCount +=1;
           
            }else if(seabattleCount < 4){
                deck[i] =  FortuneCards.SEABATTLE_3;
                seabattleCount += 1;
            
            }else if(seabattleCount < 6){
                deck[i] = FortuneCards.SEABATTLE_4;
                seabattleCount += 1;
            
            }else if(monkeyBusinessCount < 4){
                deck[i] = FortuneCards.MONKEYBUSINESS;
                monkeyBusinessCount += 1;

            }else{
                deck[i] = FortuneCards.NOP;
            }
        }
        //System.out.println("  (DEBUG) deck made = " + Arrays.toString(deck));
        List<FortuneCards> deckList = Arrays.asList(deck);
		Collections.shuffle(deckList);
		deckList.toArray(deck);
        //System.out.println("  (DEBUG) deck shuffled = " + Arrays.toString(deck));
        return deck;
    }

}
