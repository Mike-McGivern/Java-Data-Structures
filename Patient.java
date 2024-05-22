import java.time.LocalDate;

public class Patient {

   private String firstName;
   private String lastName;
   private String patientID;
   private LocalDate DOB;
	
   public Patient() {
   	
   	
   	
   	
   }
	
   public Patient(String f, String l, String p, int year, int month, int day) {
      firstName = f;
      lastName = l;
      if (p.compareTo("1000000") < 0 || p.compareTo("9999999") > 0)
         throw new IllegalStateException();
      else
         patientID = p;
      DOB = LocalDate.of(year, month, day); //***********************
   }
	
   public Patient(Patient p) {
      this.setFirstName(p.getFirstName());
      this.setLastName(p.getLastName());
      this.setPatientID(p.getPatientID());
      this.DOB = LocalDate.of(p.getDOB().getYear(), p.getDOB().getMonthValue(), p.getDOB().getDayOfMonth());  //*************************************
   }
	
   public String getName() {
      return lastName + ", " + firstName;
   }
	
   public String getFirstName() {
      return firstName;
   }
		
   public String getLastName() {
      return lastName;
   }
	
   public String getPatientID() {
      return patientID;
   }
	
   public LocalDate getDOB() {
      return DOB;
   }
	
   public void setFirstName(String f) {
      firstName = f;
   }
	
   public void setLastName(String l) {
      lastName = l;
   }
	
   public void setPatientID(String p) {
      patientID = p;
   }

   public String toString() {
      return getName() + " " + patientID + " " + DOB;
   }
}

	
	
	
