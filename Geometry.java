//Alexander Kindall Geometry
//Using a value of PI = 3.14159 and Math.PI calculate the circumference and area of a circle using a radius made by the user
import java.util.Scanner;
public class Geometry {
    public static void main( String [] args){
        double pi = 3.14159; // hard coded value for Pi(Not Math.PI)
        //asking user for radius value
        System.out.println("Enter an integer value");
        Scanner readIn = new Scanner(System.in);
        int radius = readIn.nextInt();
        System.out.println("The radius of your circle is: " + radius);
        //calculate the circumference and area
        double circ = 2 * pi * radius;
        double area = pi * Math.pow(radius, 2);
        //print the values that have been calulated with a clear description
        System.out.println("The circumference of a circle with a radius of " + radius + " and a value of Pi equal to " + pi + " is: " + circ);
        System.out.println("The area of a circle with a radius of " + radius + " and a value of Pi equal to " + pi +  " is: " + area);
        System.out.println();

        //calculate the circumference and area but using the Math.PI value.
        circ = 2 * Math.PI * radius;
        area = Math.PI * Math.pow(radius, 2);
        //print the values that have been calulated using Math.PI with a clear description
        System.out.println("The circumference of a circle with a radius of " + radius + " and a value of Pi using Math.PI is: " + circ);
        System.out.println("The area of a circle with a radius of " + radius + " and a value of Pi using Math.PI is: " + area);
    }
}