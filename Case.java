public class Case implements Comparable<Case> {

   private Patient patient;
   private int priority;  
   private int timeWaiting;
	
   public Case() {
   
   }
	
   public Case(Patient p, int prior, int t) {
      patient = new Patient(p);
      if (prior < 1 || prior > 10)
         throw new IllegalStateException();
      else
         priority = prior;
      timeWaiting = t;
   }
	
   public Patient getPatient() {
      return new Patient(this.patient);
   }
	
   public int getPriority() {
      return priority;
   }

   public int getTimeWaiting() {
      return timeWaiting;
   }
	
   public void setPatient(Patient p) {
      patient = new Patient(p);
   }
	
   public void setPriority(int p) {
      priority = p; 
   }

   public void setTimeWaiting(int t) {
      timeWaiting = t;
   }
	
   public String toString() {
      return patient + " Priority = " + priority + " Time Waiting = " + timeWaiting;
   }
	
	
   public int compareTo(Case c) {
      if (this.getPriority() < c.getPriority())
         return -1;
      else if (c.getPriority() < this.getPriority())
         return 1;
      else;
      return 0;
   }
	
	
}

	
	


