package prefix;

import java.util.*; // List, ArrayList
import java.io.*;   // FileReader, BufferedReader

/**
 * Class to store a table of (Key<String>, Value<Integer>) pairs. 
 * @author Brenden Bishop
 * This will create a HashMap inside a HashMap since a simple hashmap
 * with the prefix, integer, was still too slow. This makes a hashmap of the
 * first character of the prefix entered with keys from a-z. If the key
 * already exists for that character then it adds the entire prefix
 * string with its mapped integer value to the hashmap, keys_values, inside
 * that key of the particular character of the keys of hashmap first_char.
 */
public class FastPrefixDictionary implements PrefixDictionary
{
    private HashMap<String, Integer>  keys_values;
    @SuppressWarnings("rawtypes")
	private HashMap<Character, HashMap> first_char;

    /**
     * Constructor to build the dictionary from a CSV file.
     * @param filename the path of the CSV file
     *
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public FastPrefixDictionary(String filename)
    {
    keys_values = new HashMap<String, Integer>();
    first_char = new HashMap<Character, HashMap>();
	try {
	    BufferedReader file = new BufferedReader(new FileReader(filename));
	    String line;
	    String[] lineList;
	    while((line = file.readLine()) != null) {
		lineList = line.split(",");
		if(first_char.containsKey(lineList[0].charAt(0)))
		{
			keys_values = first_char.get(lineList[0].charAt(0));
			keys_values.put(lineList[0].trim(), Integer.parseInt(lineList[1].trim()));
		}
		else
		{
		keys_values = new HashMap<String, Integer>();
		first_char.put(lineList[0].charAt(0), keys_values);
	    }
	    }
	    file.close();
	} catch(Exception ex) {
	    System.out.println(ex);
	}
    }

    /**
     * Method to return the sum of all values with 
     * keys containing the given string as a prefix.
     * Note, sum must be a long since sum of values
     * may exceed int capacity.
     * @param prefix the prefix string
     * @return the sum of all matching values
     */
    @SuppressWarnings({ "unchecked" })
	public long sum(String prefix)
    {
	prefix = prefix.trim();
	long sum = 0;
	if(first_char.containsKey(prefix.charAt(0)))
		{
		   keys_values = first_char.get(prefix.charAt(0));
		   for(String key2: keys_values.keySet())
			{
		    	if(key2.startsWith(prefix))
		    		{
		    			sum += keys_values.get(key2);
		    		}
				}
		    }
	return sum;
    }
}