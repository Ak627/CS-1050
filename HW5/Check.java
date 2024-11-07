//Alexander Kindall HW5
import java.io.FileWriter;
import java.io.IOException;

public class Check {
    int checkNum;
    double amount;
    String Payee;
    String Reason;
    String todayDate;
    String yourName = "Alexander Kindall";   
    public Check(){
        checkNum = 0;
        amount = 0.0;
        Payee = "";
        Reason = "";
        todayDate = "mm/dd/yyyy";
    }

    public void setCheckNum(int num){
        checkNum = num;
    }
    public void setAmount(double am){
        amount = am;
    }
    public void setPayee(String pay){
        Payee = pay;
    }
    public void setReason(String reas){
        Reason = reas;
    }
    public void setTodayDate(String date){
        todayDate = date;
    }

    public int getCheckNum(){
        return checkNum;
    }
    public double getAmount(){
        return amount;
    }
    public String getPayee(){
        return Payee;
    }
    public String getReason(){
        return Reason;
    }
    public String getTodayDate(){
        return todayDate;
    }

    public void printCheck(){
        try (FileWriter writer = new FileWriter("HW5.txt", true)) {
            writer.write("-------------------------------------------------------------------------\n");
            writer.write(""+yourName+"                                          "+checkNum+"\n");
            writer.write("Pay to the order of _"+Payee+"_______________________  $" + amount+"\n");
            writer.write("For _" + Reason+ "____________________________\n");
            writer.write("--------------------------------------------------------------------------\n");
            writer.write("\n");
        } catch (IOException e) {
            System.out.println("An error occurred: " + e);
            System.exit(1);
        }
        
    }

}
