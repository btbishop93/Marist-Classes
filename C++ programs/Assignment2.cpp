//Assignment #2
//Brenden Bishop

# include <iostream>
# include <cmath>
using namespace std;
int main()
{
  double a , b , c , root1, root2, root3, root4;
  
  // prompt the user to enter three coefficients, separated by spaces...
    cout << "Please enter any three numbers but 0, separated by spaces: ";
    cin >> a >> b >> c;
    cout << endl
      << "You entered a = " << a << ", b = " << b
      << ", c = " << c << "." << endl; 
	  
	  double discrm = ((b*b) - 4*a*c);
      
      if (discrm == 0)
      {
	  root1= (-b/(2*a));
      cout<< "There is one real root and it is "<< root1 << "." << endl;
      }
      else if (discrm > 0)
      {
		root1=(-b+sqrt(discrm))/(2*a);
		root2=(-b-sqrt(discrm))/(2*a);
		cout<<"\n There are two roots and they are "<< root1 <<" and "<< root2 << "." << endl;
      }
      else
      {
	  root3= (-b/(2*a));
	  root4= sqrt(-(discrm)) / (2*a);
      cout<< "There are no real roots just two complex " << 
	  "and imaginary numbers which are : " << root3 << " + " << root4 << 
	  " and" << root3 << " - " << root4 << endl << endl;
	  }
	 
      
	  return(0) ;
        
   }
 