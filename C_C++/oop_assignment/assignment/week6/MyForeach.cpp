#include <iostream>
#include <string>
using namespace std;
// 在此处补充你的代码
template<class T>
void MyForeach(T a[], T * b, void (* Pi)(T))
{
    for(T * i = a;i < b; i++)
        (* Pi)(* i);
}
template<class T>
void MyForeach(T a[], T * b, void (* Pi)(T &))
{
    for(T * i = a;i < b; i++)
        (* Pi)(* i);
}
void Print(string s)
{
	cout << s;
}
void Inc(int & n)
{
	++ n;
}
string array[100];
int a[100];
int main() {
	int m,n;
	while(cin >> m >> n) {
		for(int i = 0;i < m; ++i)
			cin >> array[i];
		for(int j = 0; j < n; ++j)
			cin >> a[j];
		MyForeach(array,array+m,Print);		 
		cout << endl;
		MyForeach(a,a+n,Inc);		 
		for(int i = 0;i < n; ++i)
			cout << a[i] << ",";
		cout << endl;
	}
	return 0;
}
/*
 *输入
多组数据
每组数据第一行是两个整数 m 和 n ,都不超过 50
第二行是m个不带空格的字符串
第三行是 n个整数
输出
对每组数据
第一行输出所有输入字符串连在一起的结果
第二行输出输入中的每个整数加1的结果
样例输入
3 4
Tom Mike Jack
1 2 3 4
1 2
Peking
100 200
样例输出
TomMikeJack
2,3,4,5,
Peking
101,201,
*/
