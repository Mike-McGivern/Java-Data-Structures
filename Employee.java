package cs0048spring2024.assign1;

import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;

class Employee {
   private String firstName = "";
   private String lastName = "";
   private int employeeID = 0;
   private double payRate = 0.0;
  
   private static ArrayList<Employee> arList = new ArrayList<Employee>(); //constructor 1
   
   public void Employee(String firstName, String lastName, int employeeID, double payRate) { //constructor 2 (custom for Employee data type)
      firstName = this.firstName;
      lastName = this.lastName;
      employeeID = this.employeeID;
      payRate = this.payRate;
   }
   
   public String getFirstName(int index) {
      //firstName = arList.get(index).toString();
      return firstName;
   }
   public String getLastName(int index) {
      //lastName = arList.get(index).toString();
      return lastName;
   }
   public int getEmployeeID(int index) {
      //employeeID = (int)(arList.get(index));
      return employeeID;
   }
   public double getPayRate(int index) {
     // payRate = (double)(arList.get(index));
      return payRate;
   }
   public void setFirstName(String newFirstName) {
      firstName = newFirstName;
   }
   public void setLastName(String newLastName) {
      lastName = newLastName;
   }
   public void setEmployeeID(int newEmployeeID) {
      employeeID = newEmployeeID;
   }
   public void setPayRate(double newPayRate) {
      payRate = newPayRate;
   }
   public String toString(ArrayList arrL) {
      return arList.toString();
   }
   
}