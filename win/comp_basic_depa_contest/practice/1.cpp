#include <iostream>
#include <iomanip>
using namespace std;
int main()
{
	int math, eng, comp;
	double ave;
	cout << "math="; 
	cin >> math;
	cout <<"eng=";
	cin >> eng;
	cout << "comp=";
	cin >> comp;
	ave = (math + eng + comp) * 1.0 / 3;
	
	cout.setf(ios::fixed);
	cout.precision(2);
	cout << "average=" << ave << endl;
	return 0;
}
