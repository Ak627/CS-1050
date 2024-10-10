public class DistanceTraveled{
    private int speed;
    private int time;
    private int distance;
    public DistanceTraveled(){
        speed = 0;
        time  = 0;
        distance = 0;
    }
    public int getDistance(){
        distance = speed * time;
        return distance;
    }
    public int getSpeed(){
        return speed;
    }
    public int getTime(){
        return time;
    }

    public void setSpeed(int s){
        speed = s;
    }
    public void setTime(int t){
        time = t;
    }

}