#include <iostream>
#include <cmath>
using namespace std;
bool isT(int n)
{
	int a[4];
	int tmp = n;
	int len = 0;
	int re = 0;
	while(tmp > 0) {
		a[len] = tmp % 10;
		tmp /= 10;
		len ++;
	}
	for(int i = 0; i <= len; i ++) {
		re = re +a[i] * a[i] * a[i];
	}
	if(re == n)
		return 1;
	
	return 0;
}
int main()
{
	int m, n;
	cout <<"Input m: ";
	cin >> m;
	cout <<"Input n: ";
	cin >> n;
	for(int i = m; i < n ; i ++) {
		if(isT(i))
			cout << i << endl;
	}
	return 0;
}