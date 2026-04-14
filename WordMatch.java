public class WordMatch{
    private String secret;

    public static void main(String[]args){
        WordMatch w = new WordMatch("Mississippi");
        System.out.println(w.scoreGuess("iss"));
        WordMatch ww = new WordMatch("aaaabb");
        System.out.println(ww.scoreGuess("a"));
        WordMatch game = new WordMatch("concatenation");
        System.out.println(game.findBetterGuess("ten","nation"));
    }
    public WordMatch(String info){
        secret = info;
    }
    public int scoreGuess(String guess){
        int count =0;
        for(int i =0;i <=secret.length()-guess.length();i++){
            if(secret.substring(i,i+guess.length()).equals(guess)){
                count++;
            }
        }
        return count*guess.length()*guess.length();
    }
    public String findBetterGuess(String guess1, String guess2){
        if(scoreGuess(guess1)>scoreGuess(guess2)){
            return guess1;
        }
        if(scoreGuess(guess2)>scoreGuess(guess1)){
            return guess2;
        }
        else{
            return guess1;
        }
    }

}