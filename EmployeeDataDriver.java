package cs0048spring2024.assign1;

import java.util.Scanner;
import java.util.Iterator;
import java.util.ArrayList;
import java.io.File;

class EmployeeDataDriver {
   public static ArrayList<Employee> arrList = new ArrayList<Employee>();
   public static ArrayList<String> strArrList = new ArrayList<String>();
   public static  ArrayList<String> payRateArrList = new ArrayList<String>();  
   public static void main(String args[]) {
      arrList = readData();
      System.out.println("MASTER LIST: "+arrList);
      int i = 0;
      while(i <= arrList.size()) {
         i = i + 3;
      }
      System.out.println("The number of Employees in this file is "+i/4+".");
      System.out.println();
      printEmployee(93, 93);
      System.out.println();
      String nameOf58 = printEmployee(58, 58); //this will create a string of employee's first name at index 58 as index 58 is an ID number.
      deleteName(nameOf58);
      System.out.println();
      System.out.println("The number of employees' with an hourly wadge between $13.00 and $15.00 is "+countBetween(13.00, 15.00)+".");
      System.out.println();
      printNamesBetween(15.50, 18.00);
      deleteName("Romeo");
      printEmployee(100, arrList.size());
      
   }
   public static ArrayList readData() { //write this method first.
      try {
         Scanner sc = new Scanner(new File("EmployeeData.txt"));
         while(sc.hasNextLine() == true) {
            strArrList.add(sc.next());
         }
         sc.close(); //Closing Scanner Object.
         return strArrList;
      }
      catch (Exception e) {
         System.out.print("ERROR: File Not Found; Exiting Program");
         System.exit(1);
      }
      return strArrList;
   }
   public static int countBetween(double lowerPayRate, double upperPayRate) {
      int accumulate = 0;
      for(int i = 3; i <= strArrList.size(); i = i + 4) {
         payRateArrList.add(strArrList.get(i));
      }   
      for(int i = 0; i < payRateArrList.size(); i++) {
         if(Double.parseDouble(payRateArrList.get(i)) >= lowerPayRate && Double.parseDouble(payRateArrList.get(i)) <= upperPayRate) {
            accumulate++;
         }
      } 
      return accumulate;
   }
   public static void printNamesBetween(double lowerPayRate, double upperPayRate) { // use itereator
      int i = 0;
      ArrayList<String> namesArrList = new ArrayList<String>();
      for(int j = 0; j < strArrList.size(); j++) {
         namesArrList.add(strArrList.get(j));
         j++;
         namesArrList.add(strArrList.get(j));
         j++;
         j++;
      }
      Iterator iter = namesArrList.iterator();
      System.out.println("The Employees' with an hourly wadge between $"+lowerPayRate+" and $"+upperPayRate+" is as follows:");
      while(iter.hasNext()) {
         if(Double.parseDouble(payRateArrList.get(i)) >= lowerPayRate && Double.parseDouble(payRateArrList.get(i)) <= upperPayRate) {
            System.out.println(iter.next());
            System.out.println(iter.next());
            System.out.println();
            i++;
         }
         else {
            iter.next();
            iter.next();
            i++;
         }
      }
      System.out.println("{END OF LIST}");
      System.out.println();   
   }
   public static void deleteName(String employeeName) { // use iterator DELETE ROMEO (from master list only, master list and file or just file??)
      System.out.println("Terminating "+employeeName+"'s employment.");
      Iterator iter = strArrList.iterator();
      String toDelete = "";
      while(iter.hasNext()) {
         toDelete = iter.next().toString();
         if(toDelete.equals(employeeName)){
            iter.remove(); //remove first name
            iter.next();   //point last name and remove
            iter.remove();
            iter.next(); //point id and remove
            iter.remove();
            iter.next(); // point payrate and delete.
            iter.remove();
         } //SHOULD I NOW REPOPULATE ALL THE OTHER ARRAYSLISTS AND TAKE ROMEO OUT OF THE FILE??
      }
      System.out.println("Modified MASTER LIST without "+employeeName+": "+arrList);
      System.out.println();
   }
   public static String printEmployee(int lowerIndex, int upperIndex) {
      if(lowerIndex == upperIndex) {
         System.out.println("The employee at index "+lowerIndex+" is "+arrList.get(lowerIndex)+".");
         return strArrList.get(lowerIndex - 2);
      } else {
         System.out.println("Printing employees' data from index "+lowerIndex+" to "+(upperIndex+4)/4+":");
         for(int i = lowerIndex*4; i < upperIndex; i++) {
            System.out.print(arrList.get(i)+" "); //firstName
            i++;
            System.out.print(arrList.get(i)+" "); //LastName
            i++;
            System.out.print(arrList.get(i)+ " "); //ID
            i++;
            System.out.println(arrList.get(i)); // Wadge and new line
         }
         System.out.println();
         System.out.println("{END OF LIST}");
         System.out.println();
         return "-1";
      }
   }
}