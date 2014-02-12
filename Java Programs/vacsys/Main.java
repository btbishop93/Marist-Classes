package vacsys;

import java.io.IOException;

class Main {
  
    public static void main(String[] args) throws IOException {
    long start = System.currentTimeMillis();
    VacSys test = new VacSys("/Users/Brenden/Documents/ADS/Advance Data Structures/Programming Assignments/Assignment 2/vacsys/test1M.csv");
    test.insert("Brenden Bishop", 20, "11530");
    //long mid = System.currentTimeMillis();
    test.remove(1000000,"/Users/Brenden/Documents/ADS/Advance Data Structures/Programming Assignments/Assignment 2/vacsys/test.csv");
    long end = System.currentTimeMillis();
    System.out.println(end - start);
    //System.out.println(end - mid);
    }
}
    
