#include <iostream>
#include <string>
using namespace std;
template <class T>
T SumArray(T * a, T * b) {
    T result = * a;
    for(T * i = a + 1; i < b; i++)
        result += * i;
    return result;
// 在此处补充你的代码
}
int main() {
	string array[4] = { "Tom","Jack","Mary","John"};
	cout << SumArray(array,array+4) << endl;
	int a[4] = { 1, 2, 3, 4};  //提示：1+2+3+4 = 10
	cout << SumArray(a,a+4) << endl;
	return 0;
}
