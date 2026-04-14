public class Level{

  public int getScore(){
    int score =0;
    if(level.One.goalReached()){
      score=levelOne.getPoints();
      if(levelTwo.goalReached()){
        score+=levelTwo.getPoints();
        if(levelThree.goalReached()){
          score +=levelThree.getPoints();
        }
      }
    }
    if(isBonus()){
      score *= 3;
    }
    return score;
  }

  public int playManyTimes(int num){
    int max = 0;
    for (int i = 0; i < num; i++){
      play();
      int score = getScore();
      if (score > max){
        max = score;
      }
    }
    return max;
    }
}
