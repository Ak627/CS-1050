
public class Employee {
    String name;
    int idNumber;
    String department;
    String position;
    public Employee{
        name = " ";
        idNumber = 000000;
        department = " ";
        position = " ";
    }
    public String setName(String n){
        name = n;
    }
    public int setId(int Id){
        idNumber = Id;
    }
    public String setDepartment(String d){
        department = d;
    }
    public String setPosition(String p){
        position = p;
    }

    public String getName(String n){
        return name;
    }
    public int getId(int Id){
        return idNumber;
    }
    public String getDepartment(String d){
        return department;
    }
    public String getPosition(String p){
        return position;
    }
}