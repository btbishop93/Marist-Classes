//Assignment #11
//Brenden Bishop

#include <iostream>
#include <cmath>
#include <iomanip>

using namespace std;

class Point
{
public:
	Point ( double xP = 0, double yP = 0);
	void setPoint(double xP, double yP);
	void showPoint();
	void setX(double x);
	void setY(double y);
	double getX();
	double getY();
	double distanceToOrigin();
	double distanceTo(Point p);
	void quadrant();
	bool higherThan(Point p);

private:	
	double x;
	double y;

};
	
	Point::Point(double xP, double yP)
	{
		x = xP;
		y = yP;
	}
	void Point :: setPoint(double xP, double yP)
	{
		x = xP;
                y = yP;
		
	}
        void Point :: showPoint()
	{
		cout << "( " << x << ", " << y << " )" << endl; 
	}
	void Point :: setX(double x)
	{
		this -> x = x;
		
	}
	void Point :: setY(double y)
	{
		this -> y = y;
		
	}
	double Point :: getX()
	{
		return x;
	}
	double Point :: getY()
	{
		return y;
	}
	double Point :: distanceToOrigin()
    {
		double distance = sqrt(((0 - this -> x)*(0 - this -> x)) + ((0 - this -> y)*(0 - this -> y)));
		return distance;
	}
	double Point :: distanceTo(Point p)
    {
		double distance = sqrt(((p.x - this -> x )*(p.x - this -> x )) + ((p.y - this -> y)*(p.y - this -> y)));
		return distance;
	}
	void Point :: quadrant()
	{
		if (this -> x == 0 && this -> y == 0)
		{	
		cout << "(" << this -> x << "," << this -> y << ") is the origin." << "\n";
		}
	/* check for Point on x-axis */
		else if(this -> y == 0)
		{
		cout << "(" << this -> x << "," << this -> y << ") is on the x-axis." << "\n";
		}
	/* check for Point on y-axis */
		else if(this -> x == 0)
		{
        cout << "(" << this -> x << "," << this -> y << ")is on the y axis" <<"\n";
		}
	/* check for quadrant I */
		else if(this -> x > 0 && this -> y > 0)
		{
        cout <<"("<<this -> x <<","<< this -> y <<")is in quadrant I" <<"\n";
		}
	/* check for quadrant II */
		else if(this -> x < 0 && this -> y > 0)
		{
        cout<<"("<<this -> x <<","<< this -> y <<")is in quadrant II" <<"\n";
		}
	/* check for quadrant III */
		else if(this -> x < 0 && this -> y < 0)
		{
        cout<<"("<<this -> x <<","<< this -> y <<")is in quadrant III" <<"\n";
		}
	/* check for quadrant IV */
		else
		{
        cout<<"("<<this -> x <<","<<this -> y <<")is in quadrant IV" <<"\n";
		}
	}
	bool Point :: higherThan(Point p)
	{
		if(this -> y > p.y)
			{
			return true;
			}
		else
		{
			return false;
		}
	}	

int main()
{

	Point p1(0.0,4.0);
	Point p2(-8.0,-4.0);
	Point p3(3.5,-6.0);
	Point p4(10.0,15.0);
	Point p5;
	Point origin(0.0,0.0);
	
	p5.setPoint(3.5,-6.0);
	Point p6 = p3;
	
	p2.showPoint();
	cout << "(" << p2.getX()<< ")" << endl;
	cout << "(" << p2.getY()<< ")" << endl;
	cout << "Distance from p3 to origin is " << p3.distanceToOrigin() << endl;
	cout << "Distance from p4 to p6 is " << p4.distanceTo(p6) << endl;
	p1.quadrant();
	p2.quadrant();
	p3.quadrant();
	cout << "p1 is higher than p2: " << p1.higherThan(p2)<< endl;
	cout << "p3 is higher than p3: " << p3.higherThan(p5)<< endl;
	
	return 0;
}

