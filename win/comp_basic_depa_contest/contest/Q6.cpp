#include <iostream>
#include <cstdio>
using namespace std;
int main()
{
	char str[10];
	cout << "Input 10 characters: ";
	cin.getline(str, 11, '\t');
	int letter = 0, blank = 0, digit = 0, oth = 0;
	for(int i = 0 ; i < 10; i ++) {
		if((str[i] >= 'a' && str[i] <= 'z') || (str[i] >= 'A' && str[i] <= 'Z')) {
			letter ++;
		}
			
		else if(str[i] == ' ' || str[i] == '\n') {
			blank ++;
		}
			
		else if(str[i] >= '0' && str[i] <= '9') {
			digit ++;
		}
			
		else
			oth ++;
	}
	cout << "letter=" << letter << ",";
	cout << "blank=" << blank << ",";
	cout << "digit=" << digit << ",";
	cout << "other=" << oth;
	return 0;
}