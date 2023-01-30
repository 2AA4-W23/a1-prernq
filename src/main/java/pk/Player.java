package pk;

public class Player {
    private int score;
    private Faces[] die;
    private FortuneCards card;
    private int wins = 0;

    public Player(int score, Faces[] die, FortuneCards card){
        this.score = score;
        this.die = die;
        this.card = card;
    }
    
    public void reset(){
        this.score = 0;
        this.card = null;
        this.die = null;
    }

    public void updatescore(int newScore){
        this.score = newScore;
    }

    public void updatecard(FortuneCards newCard){
        this.card = newCard;
    }

    public void updatedie(Faces[] newDie){
        this.die = newDie;
    }

    public void updatewins(){
        wins += 1;
    }

    public Faces[] getdie() {
        return die;
    }

    public FortuneCards getcard() {
        return card;
    }

    public int getscore(){
        return score;
    }

    public int getwins(){
        return wins;
    }

}