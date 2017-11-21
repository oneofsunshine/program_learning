#include <iostream>
using namespace std;
#define b_year  1997
#define b_month 10
#define b_day   15
int run[12] = {31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int ping[12] = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
int isLeap(int);
void daysum(int, int, int, int, int &); //b标志位，开始日期,所在月，所在年，和的引用 
void monthsum(int, int, int, int &); //开始月，结束月，所在年，和的引用 
void yearsum(int, int, int &); //开始年，结束年，和的引用 
int main()
{
	int year, month, day, sum = 0;
	cin >> year >> month >> day;
	
//	daysum 
	if(year - b_year < 1 && month - b_month < 1) { //同年同月 
		cout << "第" << day - b_day + 1 << "天" << endl;
		return 0;
	}
	else {
		daysum(1, b_day, b_month, b_year, sum);
		daysum(0, day, month, year, sum);
	}
	
//	monthsum 
	if(year - b_year < 1) { //同年 
		monthsum(b_month + 1, month, year, sum);
		cout << "第" << sum + 1 << "天" << endl;
		return 0;
	}
	else {
		monthsum(b_month + 1, 13, year, sum);
		monthsum(1, month, year, sum);
	}	
	
//	yearsum
	yearsum(b_year, year, sum);
	
	cout << "第" << sum + 1 << "天" << endl;
	return 0;
}
int isLeap(int y)
{
	if((y % 4 == 0 && y % 100 != 0) || y % 400 == 0)
		return 1;
	else
		return 0;
}
void daysum(int f, int d, int m, int y, int & sum)
{
	if(f) {
		if(m != 2) 
			sum += ping[m - 1] - d;
		else {
			if(isLeap(y))
				sum += run[m - 1] - d;
			else
				sum += ping[m - 1] - d;
		}
	}
	else
		sum += d;
}
void monthsum(int m, int e_m, int y, int & sum)
{
	for(int i = m; i < e_m; i ++) { 
		if(isLeap(y))
			sum += run[i - 1];
		else
			sum += ping[i - 1];
	}
}
void yearsum(int y, int e_y, int & sum)
{
	for(int i = y + 1; i < e_y; i ++) {
		if(isLeap(i))
			sum += 366;
		else
			sum += 365;
	}
}
