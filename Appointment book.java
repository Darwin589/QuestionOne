public class AppointmentBook{
  public int findFreeBlock(int period, int duration){
    int blockLength = 0;
    for (int minute = 0; minute < 60; minute++){
      if (isMinuteFree(period, minute)){
      blockLength++;
      if (blockLength == duration){
      return minute – blockLength + 1;
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
