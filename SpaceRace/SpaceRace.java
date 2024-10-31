//Alexander Kindall SpaceRace
import java.util.*;

public class SpaceRace {
    public static void main(String[] args) {
        String[] Quadrants = new String[70];
        for (int i = 0; i < Quadrants.length; i++) {
            if (i == 0 || i == Quadrants.length - 1) {
                Quadrants[i] = "|";
            } else {
                Quadrants[i] = "-";
            }
        }
        SpaceCraft USSEnterprise = new SpaceCraft(1);
        SpaceCraft Eagle5 = new SpaceCraft(1);

        boolean loop = true;
        String winner = "";
        Scanner Readln = new Scanner(System.in);
        String choice = "";
        
        while (true) {
            System.out.println("Would you like to increment the simulation Manually? Y/N");
            choice = Readln.nextLine();
            if (choice.equals("Y") || choice.equals("N")) {
                break;
            } else {
                System.out.println("Try that again!");
            }
        }

        while (loop == true) {

            int e = Eagle5.EagPosChange();
            int u = USSEnterprise.EntPosChange();

            if (e < 0) {
                e = 0;
            }
            if (e > Quadrants.length - 1) {
                e = Quadrants.length - 1;
            }

            if (u < 0) {
                u = 0;
            }
            if (u > Quadrants.length - 1) {
                u = Quadrants.length - 1;
            }

            Quadrants[e] = "5";
            Quadrants[u] = "E";
            if (e == u) {
                System.out.println("BUMP!");
                Quadrants[e] = "*";
            }
            
            int prevEagPos = e;
            int prevEntPos = u;
            System.out.println("Eagle 5 position:" + e + " Enterprise position:" + u);
            String joinedArray = String.join("", Quadrants);
            System.out.println(joinedArray);
            System.out.println();

            if (Quadrants[prevEagPos] != "*")
                Quadrants[prevEagPos] = "-";

            if (Quadrants[prevEntPos] != "*")
                Quadrants[prevEntPos] = "-";

            if(e == 0 || u == 0){
                if(e == 0){
                    Quadrants[prevEagPos] = "|";
                }
                if(u == 0){
                    Quadrants[prevEntPos] = "|";
                }
            }

            if (choice.equals("Y")) {
                while(true){
                System.out.println("Press enter to continue");
                String pause = Readln.nextLine();
                if(pause.equals("")){
                    break;
                }
                else{
                    System.out.println("That wasn't just enter! Try again!");
                }
            }
            }
            
            if (e >= Quadrants.length - 1 || u >= Quadrants.length - 1) {
                if (e == Quadrants.length - 1) {
                    winner = "Eagle 5";
                } else if (u == Quadrants.length - 1) {
                    winner = "USS Enterprise";
                } else if (e >= Quadrants.length - 1 && u >= Quadrants.length - 1) {
                    winner = "Both, it's a tie";
                }
                loop = false;
            }
        }
        System.out.println("Winner is " + winner + "!");
    }
}