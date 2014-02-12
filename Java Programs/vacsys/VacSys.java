package vacsys;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
* This class called VacSys is to create a heap of patient requests
* based on their priority values. The top priority patients will be at the top
* of the list and will be called when the next patient is requested.
* This should also write to a file a list of the patients requested and
* all of their information.
*/
@SuppressWarnings("rawtypes")
public class VacSys {

 private VacSysPriorityQueue system;
 private HashMap<String, Integer> zipcodes;
 private Map<Integer, ArrayList<Patient>> sortedPatients;
 private Map<Integer, ArrayList<Patient>> insertedPatient;
 private int tpop;
 private int zpop;
 
 /**
 * Default contructor for creating a VacSys file with
 * the heap of patients, the zipcodes, and total population
 */
 public VacSys()
 {
  system = new VacSysHeap();
  zipcodes = new HashMap<String, Integer>();
  tpop = 0;
 }
 
 @SuppressWarnings("unchecked")
 // Creates a system with an empty HashMap and VacSysHeap
 public VacSys(String filename) throws IOException
 {
  zipcodes = new HashMap<String, Integer>();
  system = new VacSysHeap();

  sortedPatients = new HashMap<Integer, ArrayList<Patient>>();
  tpop = 0;
  
  FileReader file = new FileReader(filename);
  BufferedReader buffer = new BufferedReader(file);
  
  while((buffer.readLine()) != null)
  {
	  tpop++;
  }
  System.out.print(tpop);
  file.close();
  
  file = new FileReader(filename);
  buffer = new BufferedReader(file);
  String string;
  try
  {
	  //While loop to get all info from File until end.
	  while((string = buffer.readLine()) != null)
	  {
	   String info[] = string.split(", ");
	   //Creates new Patient on each line
	   Patient temp = new Patient();
	   temp.setName(info[0]);
	   temp.setAge(Integer.parseInt(info[1]));
	   temp.setZip(info[2]);
	   
	   int pop = 0;
	   if(zipcodes.containsKey(info[2])){
		   pop = zipcodes.get(info[2]);
	   }
	   pop++;
	   zipcodes.put(info[2], pop);
	   zpop = ZipPopulation(info[2]);
	   
	   temp.setPriority(zpop, tpop);
	   int tempPriority = temp.getPriority();
	   //System.out.println(temp);
	   /*
	    * Checks to see if the Priority value exists, if not, creates
	    * a new key with a new ArrayList of Patients.
	    */  
	   if(!sortedPatients.containsKey(tempPriority))
	   {
	    sortedPatients.put(tempPriority, new ArrayList<Patient>());
	   }
	   sortedPatients.get(tempPriority).add(temp);
	  } // end while
	  // Inserts info into VacSysHeap
	  for (Object key : sortedPatients.keySet()) 
	  {
	      ArrayList value = sortedPatients.get(key);
	      system.addArray(value);
	      sortedPatients.remove(value);
	  }
	  file.close();
  }
  catch(Exception e)
  {
   e.printStackTrace();
  }
 }
 /**
 * Calculates the number of patients living in a 
 * particular zipcode.
 * @param String zip, zipcode the population is for
 * @return int count, the number of patients in that zipcode.
 */
 private int ZipPopulation(String zip)
 {
  int count = 0;
  if(zipcodes.containsKey(zip)){
	  count = zipcodes.get(zip);
  }
  return count;
 }
 
 /**
 * Takes in the name, age, and zipcode for the patient
 * to be entered into the VacSysHeap of requests
 * @param String name, int age, String zipcode
 * @return true, when the request has been inserted
 */
 @SuppressWarnings("unchecked")
 public boolean insert(String name, int age, String zip)
 {
  Patient newPatient = new Patient();
  newPatient.setAge(age);
  newPatient.setName(name);
  newPatient.setZip(zip);

  int zpop = ZipPopulation(zip);
  newPatient.setPriority(zpop ,tpop);
  int patientPriority = newPatient.getPriority();

  if(!sortedPatients.containsKey(patientPriority))
  {
   sortedPatients.put(patientPriority, new ArrayList<Patient>());
   insertedPatient.put(patientPriority, new ArrayList<Patient>());
   for (Object key : insertedPatient.keySet()) 
	  {
	      ArrayList value = insertedPatient.get(key);
	      system.addArray(value);
	      insertedPatient.remove(value);
	  }
   }
  sortedPatients.get(patientPriority).add(newPatient);
  return true;
 }

 /**
 * Removes the next request from the list of patients
 * @return String patient, the patients info for the request.
 */
 public String remove()
 {
   return system.remove();
 }



 /**
  * Removes the number of requests and stores them in a separate CSV file
  * @param int num, number of requests, and String filename, the name of the file.
  */
 public boolean remove(int num, String filename){
  try
  {
   File file = new File(filename);
   if(!file.exists())
   {
    file.createNewFile();
   }

   BufferedWriter bufferedw = new BufferedWriter(new FileWriter(file));

   for(int i = 0; i < num; i++)
   {
    bufferedw.write(remove());
   }
   bufferedw.close();
  }
   catch(IOException e)
   {
    e.printStackTrace();
    return false;
   }
   return true;
  }
 }
