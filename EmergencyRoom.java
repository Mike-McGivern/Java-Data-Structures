import java.util.Iterator;
import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Arrays;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Comparator;
import java.time.DateTimeException;

public class EmergencyRoom {
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String character;
      Patient currentPatientJoining, currentPatientLeaving;
      Case currentCaseJoining, currentCaseLeaving;
      currentPatientJoining = new Patient();
      currentCaseJoining = new Case();
      PriorityQueue<Case> patientPriorityQueue = new PriorityQueue<Case>();
      String firstName = "" ; 
      String lastName = "";
      String patientID = "";
      int Arrivals = 0;
      int Seen = 0;
      int SumOfWait = 0;
      double averageWait = 0;
      int year = 0; 
      int month = 0; 
      int day = 0; 
      int priority = 0;
      boolean errorERCase = false;
      int timer = 0;
      int totalJoining;
      int totalLeave; 
      System.out.println("SIMULATION CYCLE 1");
      Scanner fileIn = new Scanner(System.in);
      try {
         fileIn = new Scanner(new File("Data.txt"));
      }
      catch (FileNotFoundException e) {
         System.out.println("File not found");
         System.exit(1);
      }
      System.out.println("Setting Priority Queue with 5 initial cases.");
      for (int i = 0; i < 5; i++) {
         while (!errorERCase) {
         
            firstName = fileIn.next() ; 
            lastName = fileIn.next() ;
            patientID = fileIn.next();
            year = fileIn.nextInt() ; 
            month = fileIn.nextInt() ; 
            day = fileIn.nextInt() ; 
            priority = fileIn.nextInt();
            try {
               currentPatientJoining = new Patient(firstName, lastName, patientID, year, month, day);
               errorERCase = true;
            }
            catch (DateTimeException e) {
               System.out.println("Cannot create " + firstName + " " + lastName +
                  	" - incorrect DOB information.\nProgram will ignore case and continue");
            }
            catch (IllegalStateException e) {
               System.out.println("Cannot create " + firstName + " " + lastName +
                  	" - incorrect Patient ID.\nProgram will ignore case and continue");
            }
         }
         errorERCase = false;
         while (!errorERCase) {
            try {
               currentCaseJoining = new Case(currentPatientJoining, priority, 0);
               errorERCase = true;
            }
            catch (IllegalStateException e) {
               System.out.println("Cannot create " + firstName + " " + lastName +
                  	" - incorrect priority.\nProgram will ignore case and continue");
            }
         }
         errorERCase = false;
         System.out.println("Queue Join." + currentCaseJoining);
         patientPriorityQueue.add(currentCaseJoining);
      
      }
      while (timer < 10) {
         System.out.print("Press any key to continue.");
         character = sc.next();
         System.out.println("Cycle " + (timer + 1));
         totalJoining = getNumPatientsJoining();
         if (totalJoining == 0) 
            System.out.println("No new patients in this cycle");
         else {
            for (int i = 0; i < totalJoining; i++) {
               while (!errorERCase) {
                  firstName = fileIn.next() ; 
                  lastName = fileIn.next() ;
                  patientID = fileIn.next();
                  year = fileIn.nextInt() ; 
                  month = fileIn.nextInt() ; 
                  day = fileIn.nextInt() ; 
                  priority = fileIn.nextInt();
                  try {
                     currentPatientJoining = new Patient(firstName, lastName, patientID, year, month, day);
                     errorERCase = true;
                  }
                  catch (DateTimeException e) {
                     System.out.println("Cannot create " + firstName + " " + lastName +
                        " - incorrect DOB information.\nProgram will ignore case and continue");
                  }
                  catch (IllegalStateException e) {
                     System.out.println("Cannot create " + firstName + " " + lastName +
                        " - incorrect Patient ID.\nProgram will ignore case and continue");
                  }
               }
               errorERCase = false;
               while (!errorERCase) {
                  try {
                     currentCaseJoining = new Case(currentPatientJoining, priority, 0);
                     errorERCase = true;
                  }
                  catch (IllegalStateException e) {
                     System.out.println("Cannot create " + firstName + " " + lastName +
                        " - incorrect priority.\nProgram will ignore case and continue");
                  }
               }
               errorERCase = false;	
               currentPatientJoining = new Patient(firstName, lastName, patientID, year, month, day);
               currentCaseJoining = new Case(currentPatientJoining, priority, 0);
               System.out.println("Patient entering the emergency room: " + currentCaseJoining);
               patientPriorityQueue.add(currentCaseJoining);
            }
         }
         totalLeave = getNumPatientsLeaving();
         if (totalLeave == 0)
            System.out.println("No patients being seen in this cycle");
         else {
            for (int i = 0; i < totalLeave; i++) {
               currentCaseLeaving = patientPriorityQueue.poll();
               System.out.println("Leaving the queue: " + currentCaseLeaving);
            }
         }
         timer++;
         Iterator<Case> iter = patientPriorityQueue.iterator();
         int index = -1;
         Case c;
         while (iter.hasNext()) {
            c = iter.next();
            c.setTimeWaiting(c.getTimeWaiting() + 1);
         }
      }
      fileIn.close();
      System.out.println("\nSIMULATION PART 2\n");
      errorERCase = false;
      try {
         fileIn = new Scanner(new File("Data.txt"));
      }
      catch (FileNotFoundException e) {
         System.out.println("File not found");
         System.exit(1);
      }
      System.out.println("Prime Priority Queue with 5 initial cases.");
      for (int i = 0; i < 5; i++) {
         while (!errorERCase) {
         
            firstName = fileIn.next() ; 
            lastName = fileIn.next() ;
            patientID = fileIn.next();
            year = fileIn.nextInt() ; 
            month = fileIn.nextInt() ; 
            day = fileIn.nextInt() ; 
            priority = fileIn.nextInt();
            try {
               currentPatientJoining = new Patient(firstName, lastName, patientID, year, month, day);
               errorERCase = true;
            }
            catch (DateTimeException e) {
            }
            catch (IllegalStateException e) {
            }
         }
         errorERCase = false;
         while (!errorERCase) {
            try {
               currentCaseJoining = new Case(currentPatientJoining, priority, 0);
               errorERCase = true;
            }
            catch (IllegalStateException e) {
            }
         }
         errorERCase = false;
         patientPriorityQueue.add(currentCaseJoining);
      
      }
      Arrivals = 5;
   
      System.out.println("Run 100 cycles: ");
   	
      while (timer < 100) {
         totalJoining = getNumPatientsJoining();
         Arrivals += totalJoining;
         for (int i = 0; i < totalJoining; i++) {
            while (!errorERCase) {
               firstName = fileIn.next() ; 
               lastName = fileIn.next() ;
               patientID = fileIn.next();
               year = fileIn.nextInt() ; 
               month = fileIn.nextInt() ; 
               day = fileIn.nextInt() ; 
               priority = fileIn.nextInt();
               try {
                  currentPatientJoining = new Patient(firstName, lastName, patientID, year, month, day);
                  errorERCase = true;
               }
               catch (DateTimeException e) {
               }
               catch (IllegalStateException e) {
               }
            }
            errorERCase = false;
            while (!errorERCase) {
               try {
                  currentCaseJoining = new Case(currentPatientJoining, priority, 0);
                  errorERCase = true;
               }
               catch (IllegalStateException e) {
               }
            }
            errorERCase = false;	
            currentPatientJoining = new Patient(firstName, lastName, patientID, year, month, day);
            currentCaseJoining = new Case(currentPatientJoining, priority, 0);
            patientPriorityQueue.add(currentCaseJoining);
         }
         totalLeave = getNumPatientsLeaving();
         Seen += totalLeave;
      
         for (int i = 0; i < totalLeave; i++) {
            currentCaseLeaving = patientPriorityQueue.poll();
            SumOfWait += currentCaseLeaving.getTimeWaiting();
         
         }
         timer++;
         Iterator<Case> iter = patientPriorityQueue.iterator();
         int index = -1;
         Case c;
         while (iter.hasNext()) {
            c = iter.next();
            c.setTimeWaiting(c.getTimeWaiting() + 1);
         }
      }
   	
      fileIn.close();
      averageWait = (double)SumOfWait/Seen;
      System.out.println("Simulation Cycle 2 Results: ");
      System.out.println("Patients Arrivaling: " + Arrivals);
      System.out.println("Patients seen: " + Seen);
      System.out.printf("Average Wait Time %.2f\n", averageWait);
   }
		
   public static int getNumPatientsLeaving() {
      int r = (int)(Math.random() * 4);
      int ret = 0;
      switch (r) {
         case 0: {
            ret = 0;
            break;
         }
         case 1: case 2: {
            ret = 1;
            break;
         }
         case 3:
            ret = 2;
      }
      return ret;
   	
   }
   public static int getNumPatientsJoining() {
      int r =  (int)(Math.random() * 10);
      int ret = 0;
      switch (r) {
         case 0: case 1: {
            ret = 0;
            break;
         }
         case 2: case 3: case 4:  {
            ret = 1;
            break;
         }
         case 5: case 6: case 7:  {
            ret = 2;
            break;
         }
         case 8: case 9:
            ret = 3;
      }
      return ret;
   }

   public static void printPQ(PriorityQueue<Case> pq) {
      Case cas = pq.poll();
      System.out.println(cas);
      pq.add(cas);
   }



			
}

