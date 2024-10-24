import java.util.*;

public class forcecalc{
    static double G = 9.8;
    public static double Force(double m1, double m2, double r){
        double F = (G*m1*m2)/Math.pow(r,2);
        return F;
    }
    public static void main(String [] args){
        double a,b,c;
        Scanner readIn = new Scanner(System.in);
        System.out.println("Enter 3 values one on each line to find Force.");
        a = readIn.nextDouble();//nextDouble assigns a double or real number to the variable a
        b = readIn.nextDouble();
        c = readIn.nextDouble();
        System.out.println(Force(a,b,c));
    }
}