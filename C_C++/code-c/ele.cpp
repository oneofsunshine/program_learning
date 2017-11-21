#include<iostream>
#define Pi 3.14159
using namespace std;
int main()
{
	int h,r;
	cin>>h>>r;
	float v = Pi * r *r * h;
	int time = 0;
	while (time * v < 20000)
		time++;
	cout<<time;
}
  
