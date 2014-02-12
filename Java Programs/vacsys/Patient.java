package vacsys;
import java.lang.Math;

/**
 * Class that represents a patient with their
 * age, zipcode, priority value, and name
 * @author Brenden Bishop
 */

public class Patient<T> implements Comparable<T> {
 
 private String name;
 private int age;
 private String zipcode;
 private int priority;
 
 /**
 * Default contructor to create a patient with empty name,
 * no age and no priority value
 */
 public Patient()
 {
  name = "";
  age = 0;
  priority = 0;
 }
 
 /**
 * Method to set the name of the Patient
 * @param String setName
 */
 public void setName(String setName)
 {
  name = setName;
 }
 
 /**
 * Method to set the age of the Patient
 * @param int setAge
 */
 public void setAge(int setAge)
 {
  age = setAge;
 }
 
 /**
 * Method to set the zipcode of the Patient
 * @param String setZip
 */
 public void setZip(String setZip)
 {
  zipcode = setZip;
 }
 
 /**
 * Method to calculate the priority value of the Patient
 * @param float zpop, float tpop
 */
 public void setPriority(float zpop, float tpop)
 {
  priority = (int)((float)((Math.abs(35.0 - age)) / 5.0) + (1.0*(zpop / tpop)) * 10.0);
 }
 
 /**
 * Method to get the name of the Patient
 * @return String name
 */
 public String getName()
 {
  return name;
 }
 
 /**
 * Method to get the age of the Patient
 * @return int age
 */
 public int getAge()
 {
  return age;
 }
 
 /**
 * Method to get the zipcode of the Patient
 * @return String zipcode
 */
 public String getZip()
 {
  return zipcode;
 }
 
 /**
 * Method to get the priority value of the Patient
 * @return int priority
 */
 public int getPriority()
 {
  return priority;
 }
 
 /**
 * Method to compare two priority values of the given Patients
 * this method is necessary for the heapRebuild process to 
 * compare childs to parents.
 * @return int 
 */
 public int compareTo(Patient<T> patient)
 {
	 if(this.priority > patient.getPriority()){
	   return 1;
	  }
	  else
	  { 
	   if(this.priority == patient.getPriority())
	   {
	    return 0;
	   }
		   else{
		    return -1;
		   }	
	   }
	}
 
 /**
 * Method to return a clean display of the entire Patient's info
 * @return string of patients info
 */
 public String toString()
 {
  return name + ", " + age + ", " + zipcode +  "\n";
 }

 @SuppressWarnings("unchecked")
 @Override
 public int compareTo(T object) 
 {
  return compareTo((Patient<T>) object);
 }
}
