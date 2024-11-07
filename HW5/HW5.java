//Alexander Kindall HW5
import java.util.*;

public class HW5{
    public static void CreateNewCheck(Check check, Scanner ReadIn){
        int num = 0;
        double am = 0.0;
        String pay = "";
        String reas = "";        
        String date = "";

        System.out.println("Enter Check number, Check Amount, Name of the Payee, Reason for the check, and Todays Date in mm/dd/yyyy format.");
        try{
            num = ReadIn.nextInt();
            am = ReadIn.nextDouble();
            ReadIn.nextLine();
            pay = ReadIn.nextLine();
            reas = ReadIn.nextLine();
            date = ReadIn.nextLine();
            if(date.length() > 10){
                System.out.println("Too long for mm/dd/yyyy format!");
                System.exit(1);
            }
            else if(date.length() < 8){
                System.out.println("Too short for mm/dd/yyyy format!");
                System.exit(1);
            }
            else{
                char slash = '/';
                if(!date.contains(Character.toString(slash))){
                    System.out.println("No / detected, not in mm/dd/yyyy format!");
                    System.exit(1);
                }
            
            }
            check.setCheckNum(num);
            check.setAmount(am);
            check.setPayee(pay);
            check.setReason(reas);
            check.setTodayDate(date);
        }catch(InputMismatchException e){
            System.out.println("Exception detected:" + e);
            System.out.println("Invalid input!.");
            System.exit(1);
        }
        
    }

    public static void GetCheckDetails(Check check){//Gets check details
        System.out.println("Check number:" + check.getCheckNum());
        System.out.println("Amount payed:" + check.getAmount());
        System.out.println("Payee:" + check.getPayee());
        System.out.println("Reason:" + check.getReason());
        System.out.println("Date:" + check.getTodayDate());
    }

    public static void issueCheck(Check [] checks, int num){//issueCheck class
        int notThere = 0;
        for(int i = 0; i < checks.length; i++){
            if(num == checks[i].getCheckNum()){
                checks[i].printCheck();
                break;
            }
            else{
                notThere +=1;
            }
        }
        if(notThere >=checks.length){
            System.out.println("Not a Check in the Register! Try again!");
        }

    }

    public static void PrintRegister(Check [] checks){//prints check register to the screen
        for(int i = 0; i < checks.length; i ++){
            System.out.println("Check " + (i+1));
            GetCheckDetails(checks[i]);
            System.out.println("");
        }
    }

//main program --------------------------------------------------------------------------------------|
    public static void main(String [] args){
        boolean moreWork = false;

        Scanner ReadIn = new Scanner(System.in);

        Check[] checks = new Check[5];
        for(int i = 0; i < checks.length; i++){
            checks[i] = new Check();
            CreateNewCheck(checks[i], ReadIn);
            
        }

        moreWork = true;
        
        while(moreWork == true){
            System.out.println("Enter R for check register, N to see one specific check, or S to stop");
            String choice = ReadIn.nextLine();
            choice = choice.toUpperCase();
            if(choice.equals("R")){
                PrintRegister(checks);
            }
            else if(choice.equals("N")){
                System.out.println("Please enter check number.");
                int n = ReadIn.nextInt();
                issueCheck(checks, n);
                ReadIn.nextLine();
            }
            else if(choice.equals("S")){
                moreWork = false;
            }
            else{
                System.out.println("Not correct input! Try again!");
            }
        }
        ReadIn.close();
    }
}