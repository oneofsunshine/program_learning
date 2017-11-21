#include<iostream>
#include <iomanip>
#define Pi 3.14
using namespace std;
int main()
{
	double r;
	cin>> r;
	double v = 4 * Pi * r * r * r / 3;
	cout<<setprecision(5)<<v;
	return 0;
}
  
