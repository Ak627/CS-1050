public class SpeedofSound {
    public double distance;
  
    public SpeedofSound() {
      distance = 0;
    }
  
    public void setDistance(double d) {
      distance = d;
    }
  
    public double getDistance() {
      return distance;
    }
  
    public double getSpeedinAir() {
      return distance / 1100;
    }
  
    public double getSpeedinWater() {
      return distance / 4900;
    }
  
    public double getSpeedinSteel() {
      return distance / 16400;
    }
  }