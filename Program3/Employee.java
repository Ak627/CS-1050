public class Employee {
    String name;
    int idNumber;
    String department;
    String position;
    public Employee(){
        name = " ";
        idNumber = 000000;
        department = " ";
        position = " ";
    }
    public void setName(String n){
        name = n;
    }
    public void setId(int Id){
        idNumber = Id;
    }
    public void setDepartment(String d){
        department = d;
    }
    public void setPosition(String p){
        position = p;
    }

    public String getName(){
        return name;
    }
    public int getId(){
        return idNumber;
    }
    public String getDepartment(){
        return department;
    }
    public String getPosition(){
        return position;
    }
}