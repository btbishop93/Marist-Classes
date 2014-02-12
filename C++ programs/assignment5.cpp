//Assignment #6
//Brenden Bishop

#include <iostream>
#include <cmath>
#include <iomanip>
#include <string>

using namespace std;

int main()
{
  string name;
  double pay;
  double Fit;			// Federal Income Tax
  double St; 			// State Tax
  double Sst;	    	// Social Security Tax
  double Md;			// Medicare Tax
  double Pen;			// Pension Plan
  double Hlth; 			// Health Insurance
  double Net; 			// Net pay
  
  
  // prompt the user to enter their name separated by space
     cout << "Please enter full name separated by a space:	" << endl;
     getline(cin, name);
	 
  // prompt user to enter their monthly paycheck amount
     cout << "Please enter your monthly paycheck amount in dollars:	" << endl;
     cin >> pay;
	 
	cout << "\n" << name << endl;
	
	//paycheck
	cout << setfill('.') << "Gross Amount: " << fixed << showpoint << setprecision(2) << setw(14) << " $" << pay << endl;
	//federal tax
	Fit = (pay * .15);
	cout << "Federal Tax: " << fixed << showpoint << setprecision(2) << setw(16) << " $ " << Fit << endl;
	//state tax
	St = (pay * .035);
	cout << "State Tax: " << fixed << showpoint << setprecision(2) << setw(18) << " $ " << St << endl;
	//Social Security tax
	Sst = (pay * .0575);
	cout << "Social Security Tax: " << fixed << showpoint << setprecision(2) << setw(8) << " $ " << Sst << endl;
	//Medicare Tax
	Md = (pay * .0275);
	cout << "Medicare/Medicaid Tax: " << fixed << showpoint << setprecision(2) << setw(7) << " $  " << Md << endl;
	//Pension Plan
	Pen = (pay * .05);
	cout << "Pension Plan: " << fixed << showpoint << setprecision(2) << setw(15) << " $ " << Pen << endl;
	//Health Insurance
	Hlth = (75.00);
	cout << "Health Insurance: " << fixed << showpoint << setprecision(2) << setw(12) << " $  " << Hlth << endl;
	//Net pay
	Net = (pay - Fit - St - Sst - Md - Pen - Hlth);
	cout << "Net Pay: " << fixed << showpoint << setprecision(2) << setw(19) << " $" << Net << endl;
	
  return 0;
}