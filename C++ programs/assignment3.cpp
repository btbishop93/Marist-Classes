//Assignment #3
//Brenden Bishop

#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

int main()
{
  int lowNum; 
  int highNum; 
  int sumEven;
  sumEven = 0;
  
  
  // prompt the user to enter two numbers
     cout << "Please enter a low number:	";
     cin >> lowNum;
	
     cout << "Please enter a high number:	";
     cin >> highNum;
	 
	 lowNum++;
	 
 while (lowNum < highNum )
	{
	
	// check for odd number.
	if( lowNum % 2 == 0 )
		{
		sumEven += lowNum;
		}
		else 
		{
		cout << lowNum << " ";
		}
	lowNum++;
	}
	cout << "\n The sum of all even numbers in between lowNum and highNum is " << sumEven << ".";
	
  return 0;
}