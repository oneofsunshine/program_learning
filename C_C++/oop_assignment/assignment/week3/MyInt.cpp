#include <iostream> 
using namespace std;
class MyInt 
{ 
	int nVal; 
	public: 
	MyInt( int n) { nVal = n ;}
    MyInt & operator - (int i) {
        nVal -= i;
        return * this;
    }
    friend int Inc(const MyInt mi) {
        return mi.nVal + 1;
    }// 通过友元调用nVal;
}; 
int Inc(int n) {
	return n + 1;
}
int main () { 
	int n;
	while(cin >>n) {
		MyInt objInt(n); 
		objInt-2-1-3; 
		cout << Inc(objInt);
		cout <<","; 
		objInt-2-1; 
		cout << Inc(objInt) << endl;
	}
	return 0;
}
