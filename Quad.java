// <-- comment for the user
//Use comments for your name, the assignment number, and other important information
//libraries
//Java.io.____ <--- specific file in library or * to import all
import java.util.Scanner;//Java ultilities, Scanner imports only the Scanner from the library

//JAVA KEY WORDS ARE ALL LOWER CASE
//Class name is same as file name that holds the code
public class Quad {

    //a function to display on the screen
    //functions will work like math functions to produce a result(EX: sin(45) = .707)
    //f(p) <-- functions(parameter)
    //void means returns no value
    public static void sop(String s){//this function is made to print out something to the screen to save time
        System.out.println(s);//java print function
    }

    public static void main(String [] args){//args = argument which is parameters
        //initializing variables
        double a, b, c, x1, x2, b_sqr, fac, disc, denom, s;

        //ask the user for 3 values, a, b, and c.
        Scanner readIn = new Scanner(System.in);
        sop("Enter 3 values one on each line.");
        a = readIn.nextDouble();//nextDouble assigns a double or real number to the variable a
        b = readIn.nextDouble();
        c = readIn.nextDouble();

        //check if a = 0, if it is then end the program
        if (a == 0.0){
            sop("Linear Equation");
            sop("Thought shalt not divide by zero");
            System.exit(2);//ends the program
        }

        //calculate b^2 - 4ac
        b_sqr = b *b;
        fac = 4*a*c;
        disc = b_sqr - fac;
        // check if discriminant is less than 0, print message then stop
        if(disc < 0){
            sop("Imaginary roots");
            System.exit(1);
        }

        //calculate the square root, let s be sqrt
        s = Math.sqrt(disc);

        //calculate denominator 
        denom = 2*a;

        //calculate x1 and x2 with -b either adding or subtracting s and dividing by denom
        x1 = (-b + s) / denom;
        x2 = (-b - s) / denom;
        
        sop("roots are " + x1 + " and " + x2);//plus sign concatenates the statements(overloads the plus sign if strings)
    }//end of main
}//end of class