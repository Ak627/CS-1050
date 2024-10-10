public class Temperature{
    double ftemp;
    public Temperature(){
        ftemp = 0;
    }

    public void setFarenheit(double f){
        ftemp = f;
    }
    public double getFarenheit(){
        return ftemp;
    }
    public double getCelsius(){
        double ctemp = 5/9 * (ftemp -32);
        return ctemp;
    }
    public double getKelvin(){
        double ktemp = ((5/9)*ftemp) + 459.67;
        return ktemp;
    }
}