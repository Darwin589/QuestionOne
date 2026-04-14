public class Feeder {
    public static void main(String[]args){
        Feeder game = new Feeder(50);
        game.simulateManyDays(4,4);
    }
    private int currentFood;
    public Feeder(int food){
        currentFood = food;
    }
    public void simulateOneDay(int numBirds){
        double chance = Math.random();
        if(chance <= 0.05){
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
        for(int day =0; day < numDays;day++){
            if(currentFood ==0){
                return day;
            }
            simulateOneDay(numBirds);
        }
        return numDays;
    }
}
