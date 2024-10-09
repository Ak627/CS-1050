import java.util.Random;//importing random class from util
public class scoreExample {
    public static void main(String [] args){
        // create instance of Random class
        Random rand = new Random();
        for(int i = 0; i < 10; i ++){//loop that runs 10 times
            System.out.println("Score #" + (i+1));
            // Generate random integers in range 1 to 100
            int score = rand.nextInt(100+1);
            System.out.println("Score is " + score);
            char grade;
            //checking if the score value is less than a certain value to give a grade
            if (score > 90) {grade = 'A';}
            else if (score > 80) {grade = 'B';}
            else if (score > 70) {grade = 'C';}
            else if (score > 60) {grade = 'D';}
            else {grade = 'F';}

            System.out.println("Grade is: " + grade);
        }
    }
}