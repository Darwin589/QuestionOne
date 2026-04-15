public class AppointmentBook1{
  private boolean isMinuteFree(int period, int minute){
    if(period >= 1 && period <=8 && minute >=0 && minute <= 59){
      return true;
    }
    return false;
  }
  private void reserveBlock(int period, int startMinute,int duration){

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
}
