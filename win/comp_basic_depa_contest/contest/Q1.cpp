#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;
bool isTra(double s1, double s2, double s3)
{
	if((s1 + s2 > s3) && (s3 + s2 > s1) && (s1 + s3 > s2))
		return 1;
	return 0;
} 
int main()
{
	double s1, s2, s3;
	double perimeter = 0;
	double area = 0;
	cout <<"Enter 3 sides of the triangle: ";
	cin >> s1 >> s2 >> s3;
	if(!isTra(s1, s2, s3))
		cout << "These sides do not correspond to a valid triangle";
	else {
		perimeter = s1 + s2 + s3;
		double s = perimeter / 2;
		area = sqrt(s*(s-s1)*(s-s2)*(s-s3));
		printf("area=%.2lf;perimeter=%.2lf", area, perimeter);
	}
		
	return 0;
}