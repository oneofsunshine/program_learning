#include <iostream>
#include<fstream>
using namespace std;
int main()
{
	int month_ping[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};// 平年每月天数; 
	int month_run[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};// 闰年每月天数; 
	
	ifstream f1("input.dat");
	ofstream f2("output.dat");
	int year, month, day, num = 0;
	//char c;
	
	f1 >> year >> month >> day;
	while((year != 0) && (month != 0) && (day != 0)) {
		if ((month < 0) || (month > 12)) {
			f2 << "month input wrong!" << endl;
			return 1;
		}
		if ((year % 400 ==0) || (year % 4 == 0 && year % 100 != 0)) {
			if (day < 0 || day > month_run[month-1]) {
				f2 << "day input wrong!" << endl;
				return 1;
			}
			for (int i = 0; i < month - 1; i ++)
				num += month_run[i];
		}
		else {
			if (day < 0 || day > month_ping[month-1]) {
				f2 << "day input wrong!" << endl;
				return 1;
			}
			for(int i = 0; i < month - 1; i ++)
				num += month_ping[i]; 
		}
		num += day;
		f2 << num << endl;
		f1 >> year >> month >> day;
		num = 0;
	}
	return 0;
}
