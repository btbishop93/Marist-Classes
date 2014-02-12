//Assignment #1
//Brenden Bishop

# include <iostream>
# include <cmath>


using namespace std;
int main()
{
  double x = 7.5 , y = 14 , z = 22.4 , w = 128;
  double PI = acos(-1);
  
  //print out the ceil() or the smallest whole number greater than x.
  cout << "The ceiling of X is " << ceil(x) << endl;
  
  //continuing to print this time the floor which rounds z to the largest integer not greater than z.
        cout << "The floor of Z is " << floor(z) << endl;
  
  //exp() will print out the exponentional function of e to the "y".
        cout << "The exponential fucntion of e to the Y is " << exp(y) << endl;
        
  //the log() function will take the natural logarithm of "x" in base e.
       cout << "The log() function of X in base e is " << log(x) << endl;
        
  //the log10() function will take the natural logarithm of "w" in base 10.
       cout << "The log10() function of W in base 10 is " << log10(w) << endl;
        
  //the pow( y, x) takes y and raises it to the power x.
        cout << "The value of y ^ x is " << pow( y , x ) << endl;
  
  //the sqrt() function will take the square root of w.
       cout << "The squareroot of W is " << sqrt(w) << endl;
		
		double a = (PI/180) , b = (PI/180) , c = (PI/180);
        cout << "The sine of 30, 45, and 60 degrees respectively is " << sin(30*a)  << "   " << sin(45*b) << "   " << sin(60*c) << endl
        << "The cosine of 30, 45, and 60 degrees respectively is " << cos(30*a)  << "   " << cos(45*b) << "   " << cos(60*c) << endl
        << "The tangent of 30, 45, and 60 degrees respectively is " << tan(30*a)  << "   " << tan(45*b) << "   " << tan(60*c) << endl << endl ;
             
        return(0) ;
        
   }