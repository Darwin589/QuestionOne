public class Feeder {
    public static void main(String[]args){
        Feeder game = new Feeder(240);
        System.out.println(game.simulateManyDays(4,10));
        Feeder game1 = new Feeder(50);
        game1.simulateOneDay(12);
    }
    private int currentFood;
    public Feeder(int food){
        currentFood = food;
    }
    public void simulateOneDay(int numBirds){
        double chance = (Math.random()*101)+1;
        if(chance <= 5){
            currentFood=0;
        }
        else{
            int birdEats = (int)(Math.random()*41)+10;
            int total = numBirds * birdEats;
            if(total> currentFood){
                currentFood =0;
            }
            else{
                currentFood -=total;
            }
        }
    }
    public int simulateManyDays(int numBirds, int numDays){
        for(int day =0; day <= numDays;day++){
            if(currentFood ==0){
                return day;
            } 
            simulateOneDay(numBirds);
        }
        return numDays;
    }
}
