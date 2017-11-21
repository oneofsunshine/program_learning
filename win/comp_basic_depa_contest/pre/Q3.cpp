#include<iostream>
#include<fstream>
using namespace std;
ifstream in("input.dat");
ofstream out("output.dat");

int hare(int n, int m) {
	if(n <= m)
		return 1;
	else
		return hare(n - 1, m) + hare(n-m, m);
}

int main()
{
	int m, d;
	int hare_num;// 代表兔子数量;
	 
	in >> m >> d;
	while(!(m == 0 && d == 0)) {
		hare_num = hare(d+m,m);
		
		out << hare_num << endl;
		in >> m >> d;
	}
	return 0;
}
