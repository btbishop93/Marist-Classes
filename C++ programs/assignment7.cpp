//Assignment #7
//Brenden Bishop

# include <iostream>
# include <cmath>
# include <string>

using namespace std;

double fahrToCelsius(double tempF)
  {
	double C = (((5.0/ 9.0) * (tempF)) - 32);
	
	return C;
  }
  double celToFahr(double tempC)
  {
	double F= (((9.0 / 5.0) * (tempC)) + 32);
	
	return F;
  }
  
int main()
{
  double tempF;
  double tempC;
  string degMode;
  double F;
  double C;
  
  
  // prompt the user to enter either an F or C for fahrenheit or celsius
    cout << "Please enter a 'f' for Fahrenheit mode or a 'c' for Celsius mode: ";
    getline(cin, degMode);
	cout << "\n";
	
	if( degMode == "f")
	{
		cout << "You have chosen Fahrenheit mode, now please enter the temperature in degrees:	";
		cin >> tempF;
		cout << "\n";
		cout<< "The Fahrenheit temperature " << tempF << " is equal to the Celsius temperature "
	<< fahrToCelsius(tempF) << ". \n";
	}
	else {
		if( degMode == "c")
		  {
		   cout << "You have chosen Celsius mode, now please enter the temperature in degrees:	";
		   cin >> tempC;
		   cout<< "\n";
		   cout<< "The Celsius temperature " << tempC << " is equal to the Fahrenheit temperature "
	<< celToFahr(tempC) << ". \n";
		}
		}
	
	
	 
      
	  return(0) ;
        
   }
 