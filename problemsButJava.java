import java.util.Scanner;
public class problemsButJava {
    public static void sop(String s){//this function is made to print out something to the screen to save time
        System.out.println(s);//java print function
    }
    public static void main (String [] args){
        //calculates the sum of all numbers from 1-10^6 and multiplies it by 4
        double sum = 0.0;
        for(int i = 1; i <= Math.pow(10,6); i++){
            double T1 = Math.pow(-1, i+1);
            double T2 = 2 * i -1;
            sum = sum + T1/T2;
        }
        sop("Your answer is " + 4*sum);
        //finds the next 20 leap years
        Scanner readIn = new Scanner(System.in);
        int leap = 0;
        sop("What year is it in numbers?");
        int Year = readIn.nextInt();
        while(leap != 20){
            Year += 4;
            if (Year%4 == 0){
                if(Year%100 == 0){
                    if(Year%400 == 0){
                        leap +=1;
                        sop("Leap Year "+ leap + ": " + Year);
                    }
                }
                else{
                    leap +=1;
                    sop("Leap Year "+ leap + ": " + Year);
                }
            }
        }
    }
}
