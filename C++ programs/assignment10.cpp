//Assignment #10
//Brenden Bishop

# include <iostream>
# include <cmath>
# include <string>
# include <cstring>

using namespace std;

struct Date
{
	int month;
	int day;
	int year;
};

struct Student
{
	string name;
	string ssnumber;
	Date birth_date;
	double gpa;
	int credits;
};


int main()
{
	Student * student = new Student [5];
	string search;
	string Ch;
	
	
	// student1
	
	for( int i = 0; i < 5; i++)
	{
	cout << "Enter name: " << endl;
	getline(cin, student[i].name);
	cout << "Enter Social Security Number: " << endl;
	cin >> student[i].ssnumber;
	cout << "Enter date of birth: " << endl;
	cin >> student[i].birth_date.month >> student[i].birth_date.day >> student[i].birth_date.year;
	cout << "Enter your gpa: " << endl;
	cin >> student[i].gpa;
	cout << "Enter the amount of credits you have: " << endl;
	cin >> student[i].credits;
	getline(cin, Ch);
	}
	
	// Search for SSnumber and find result or find null
	cout << "Search for record by Social Security Number: " << endl;
	cin >> search;
	cout << "Searching our records for Social Security Number: " << search << " Please wait." << endl;
	
	for(int i = 0; i < 5; i++)
	{
		if( search == student[i].ssnumber)
		{
			cout << "This Social Security Number matched 1 record: " << endl;
			cout << "Name: " << student[i].name << endl;
			cout << "Social Security Number: " << student[i].ssnumber << endl;
			cout << "Student Date of Birth: " << student[i].birth_date.month << "/ " << student[i].birth_date.day << "/ " << student[i].birth_date.year << endl;
			cout << "Student grade point average: " << student[i].gpa << endl;
			cout << "Student credits: " << student[i].credits << endl;
			i += 6;
		}
		else
		{
			if( i = 5)
				{	
					cout << "Sorry no records found by that Social Security number." << endl;
				}
		}
	} 
	
	return 0;
}
	
	
	