#include <iostream>
using namespace std;
int main()
{
	int g;
	for(int i = 0; i < 5 ; i ++){
		cout << "Enter grade: ";
		cin >> g;
		if(g < 60)
			cout << "Fail" << endl;
		else
			cout << "Pass" << endl;
	}
	return 0;
}