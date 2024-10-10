//Alexander Kindall Program3
import java.util.*;

public class Program3{
  public static void sop(String s) {// this function is made to print out something to the screen to save time
    System.out.println(s);// java print function
  }

  public static void main(String[] args) {
    Scanner ReadIn = new Scanner(System.in); // Create a Scanner object

    // Employee Class Demonstrater
    Employee[] employees = new Employee[3];// Employees array to store 3 employee objects
    for (int i = 0; i < 3; i++) {// get input for each employee
      employees[i] = new Employee();// initializes employee object
      sop("Enter Employee name, Id number, department, and position");
      String name = ReadIn.nextLine();
      int id = ReadIn.nextInt();
      ReadIn.nextLine(); // Consume the leftover newline
      String depart = ReadIn.nextLine();
      String pos = ReadIn.nextLine();

      employees[i].setName(name);
      employees[i].setId(id);
      employees[i].setDepartment(depart);
      employees[i].setPosition(pos);

      sop("Employee " + (i + 1) + "'s name is " + employees[i].getName() +
          " their Id number is " + employees[i].getId() +
          " They work in the " + employees[i].getDepartment() + " department" +
          " and they work in " + employees[i].getPosition() + " position.");

    }
    sop("");
    // Temperature class Demonstrator
    Temperature temp = new Temperature();
    sop("Enter a Farenheit temperature");
    double farenheit = ReadIn.nextDouble();
    temp.setFarenheit(farenheit);
    sop("For " + temp.getFarenheit() + " degress in Farenheit, it is "
        + temp.getCelsius() + " degrees in Celcius and "
        + temp.getKelvin() + " degrees in Kelvin");

    sop("");
    // Speed of sound class demonstrator
    int dist = 0;
    SpeedofSound speed = new SpeedofSound();
    sop("Do you want sound to travel through Air(1), Water(2) or Steel(3)?");
    int choice = ReadIn.nextInt();
    if (choice == 1) {
      sop("How far do you want the sound to travel?");
      dist = ReadIn.nextInt();
      speed.setDistance(dist);
      sop("In air, with a distance of " + speed.getDistance() + " it takes this amount of time to travel: "
          + speed.getSpeedinAir());
    } else if (choice == 2) {
      sop("How far do you want the sound to travel?");
      dist = ReadIn.nextInt();
      speed.setDistance(dist);
      sop("In water, with a distance of " + speed.getDistance() + " it takes this amount of time to travel: "
          + speed.getSpeedinWater());
    } else if (choice == 3) {
      sop("How far do you want the sound to travel?");
      dist = ReadIn.nextInt();
      speed.setDistance(dist);
      sop("In steel, with a distance of " + speed.getDistance() + " it takes this amount of time to travel: "
          + speed.getSpeedinSteel());
    } else {
      sop("No");
    }
    sop("");
    //Book Club points demonstrator
    sop("From Serendipity Book Sellers, how many books have you purchased this month?");
    int points = 0;
    int books = ReadIn.nextInt();
    if(books == 0){
      points = 0;
    }
    else if (books == 1){
      points = 5;
    }
    else if(books == 2){
      points = 15;
    }
    else if(books == 3){
      points = 30;
    }
    else if(books >= 4){
      points = 60;
    }
    sop("Great! From you buying " + books + " books, you get " + points + " points!");

    //DistanceTraveled demonstrator
    sop("Enter a speed(in MPH) for a vehicle and the amount of hours it takes to travel to a destination.");
    int mph = ReadIn.nextInt();
    int hours = ReadIn.nextInt();
    DistanceTraveled d = new DistanceTraveled();
    d.setSpeed(mph);
    int firstHour = 1;
    do{
      d.setTime(firstHour);
      sop("Hour: " + d.getTime() + " | Distance" + d.getDistance());
      firstHour++;
    }while(firstHour<=hours);
    sop("");
    //Greatest and least of these Demonstrator
    int input = 0;
    int largest = 0;
    int smallest = 0;
    sop("Enter a series of as many integers as you want, to end enter -99");
    while(true){
      input = ReadIn.nextInt();
      if (input == -99){
        break;
      }
      
      if(input > largest){
        largest = input;
      }

      if(input < largest && input != 0){
        smallest = input;
      }

      if (input < smallest){
        smallest = input;
      }
      
    }
    sop("The Greatest of these is: " + largest + " and the Least of these is: " + smallest);
  }
}