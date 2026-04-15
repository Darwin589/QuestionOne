import java.util.*;
public class AppointmentBook{
  private boolean schedule[][];
  
public AppointmentBook(){
{
  schedule = new boolean[8][60];
  for (int period = 0; period < 8; period++)
      Arrays.fill(schedule[period], true);
}

  private boolean isMinuteFree(int period, int minute)
{
    return schedule[period-1][minute];
}

 private void reserveBlock(int period, int startMinute, int duration)
  {
    for (int minute = startMinute; minute < startMinute + duration; minute++)
      schedule[period-1][minute] = false;
  }

  public int findFreeBlock(int period, int duration){
    int blockLength = 0;
    for (int minute = 0; minute < 60; minute++){
      if (isMinuteFree(period, minute)){
      blockLength++;
      if (blockLength == duration){
      return minute - blockLength + 1;
      }
      }
     else
     {
     blockLength = 0;
     }
     }
   return -1;
   }
  public boolean makeAppointment(int startPeriod, int endPeriod, int duration){
    for(int period = startPeriod;period <=endPeriod;period++){
      int minute = findFreeBlock(period,duration);
      if(minute != -1){
        reserveBlock(period,minute,duration);
        return true;
      }
    }
    return false;
  }
  public static void main(String[] args)
  {
    AppointmentBook ab1 = new AppointmentBook();
    ab1.reserveBlock(2, 0, 10);
    ab1.reserveBlock(2, 15, 15);
    ab1.reserveBlock(2, 45, 5);


    System.out.println("findFreeBlock(2, 15) = " + ab1.findFreeBlock(2, 15));
    System.out.println("findFreeBlock(2,  9) = " + ab1.findFreeBlock(2, 9));
    System.out.println("findFreeBlock(2, 20) = " + ab1.findFreeBlock(2, 20));
    
    AppointmentBook ab2 = new AppointmentBook();
    ab2.reserveBlock(2, 0, 25);
    ab2.reserveBlock(2, 30, 30);
    ab2.reserveBlock(3, 15, 26);
    ab2.reserveBlock(4, 0, 5);
    ab2.reserveBlock(4, 30, 14);


    System.out.println("makeAppointment(2, 4, 22) = " + ab2.makeAppointment(2, 4, 22));
    System.out.println("makeAppointment(3, 4, 3)  = " + ab2.makeAppointment(3, 4, 3));
    System.out.println("makeAppointment(2, 4, 30) = " + ab2.makeAppointment(2, 4, 30));
    
    for (int period = 2; period<= 4; period++)
    {
      System.out.println("\nPeriod " + period + "\n");
      for (int minute = 0; minute < 60; minute++)
      {
        char c = 'x';
        if (ab2.schedule[period-1][minute])
          c = '.';
        System.out.print(c);
        if (minute % 10 == 9)
          System.out.println();
      }
    }


    System.out.println();
    System.out.println("findFreeBlock(4, 16) = " + ab2.findFreeBlock(4, 16));
  }
}

}
